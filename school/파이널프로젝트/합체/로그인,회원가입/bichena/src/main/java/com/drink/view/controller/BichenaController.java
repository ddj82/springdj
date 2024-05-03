package com.drink.view.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drink.ko.user.UsersService;
import com.drink.ko.user.UsersVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BichenaController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public final String IMPORT_TOKEN_URL = "https://api.iamport.kr/users/getToken";
	public final String IMPORT_PAYMENTINFO_URL = "https://api.iamport.kr/payments/find/";
	public final String IMPORT_PAYMENTLIST_URL = "https://api.iamport.kr/payments/status/all";
	public final String IMPORT_CANCEL_URL = "https://api.iamport.kr/payments/cancel";
	public final String IMPORT_PREPARE_URL = "https://api.iamport.kr/payments/prepare";
	public final String IMPORT_CERTIFICATION_URL = "https://api.iamport.kr/certifications";

	// "아임포트 Rest Api key로 설정";
	public final String KEY = "5332741436286106";
	// "아임포트 Rest Api Secret로 설정";
	public final String SECRET = "xGMw5WNK4QaCvoXJtVwSp7VWp2HtteV0RPzVrRvMfNGe6GfLsRyaBM3GlRLdF93YHnAHea1XgPZu4Yj1";
	// 아임포트 가맹점 식별코드 값
	public final String IMPORT_ID = "imp70405420";

	@RequestMapping("/insertUser.ko")
	public String insertUser(UsersVO vo) {
		usersService.insertUser(vo);
		return "/WEB-INF/join/success.jsp";
	}

	@RequestMapping("/checkId.ko")
	@ResponseBody
	public int checkId(UsersVO vo) {
		int count = 0;
		if (usersService.checkId(vo.getU_id()) == null) {
			count = 0;
		} else {
			count = 1;
		}
		return count;
	}

	@RequestMapping("/terms.ko")
	public String terms(UsersVO vo) {
		return "/WEB-INF/join/terms.jsp";
	}

	@RequestMapping("/insertPage.ko")
	public String insertPage(UsersVO vo) {
		return "/WEB-INF/join/insert.jsp";
	}

	@RequestMapping("/requestCertPage.ko")
	public String certPage(UsersVO vo) {
		return "/WEB-INF/join/requestCert.jsp";
	}

	// 아임포트 인증(토큰)을 받아주는 함수
	public String getImportToken() {
		String result = "";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(IMPORT_TOKEN_URL);
		Map<String, String> m = new HashMap<String, String>();
		m.put("imp_key", KEY);
		m.put("imp_secret", SECRET);
		try {
			post.setEntity(new UrlEncodedFormEntity(convertParameter(m)));
			HttpResponse res = client.execute(post);
			ObjectMapper mapper = new ObjectMapper();
			String body = EntityUtils.toString(res.getEntity());
			JsonNode rootNode = mapper.readTree(body);
			JsonNode resNode = rootNode.get("response");
			result = resNode.get("access_token").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Map을 사용해서 Http요청 파라미터를 만들어 주는 함수 private
	List<NameValuePair> convertParameter(Map<String, String> paramMap) {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		Set<Entry<String, String>> entries = paramMap.entrySet();
		for (Entry<String, String> entry : entries) {
			paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return paramList;
	}

	@RequestMapping(value = "/cer.ko", method = RequestMethod.POST)
	@ResponseBody
	public Object certification(HttpServletRequest request) throws IOException {
		String imp_uid = request.getParameter("imp_uid");
		String token = getImportToken();
		Map<String, String> map = new HashMap<String, String>();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(IMPORT_CERTIFICATION_URL + "/" + imp_uid);
		get.setHeader("Authorization", token);

		HttpResponse res = client.execute(get);
		ObjectMapper mapper = new ObjectMapper();
		String body = EntityUtils.toString(res.getEntity());
		JsonNode rootNode = mapper.readTree(body);
		JsonNode resNode = rootNode.get("response");

		if (resNode.asText().equals("null")) {
			System.out.println("내역이 없습니다.");
			map.put("msg", "인증 과정 중 오류 발생");
		} else {
			map.put("imp_uid", resNode.get("imp_uid").asText());
			map.put("name", resNode.get("name").asText());
			map.put("birth", resNode.get("birthday").asText());
			map.put("phone", resNode.get("phone").asText());
		}

		return map;
	}

	// 나의 정보
	@RequestMapping("/userInfo.ko")
	public String viewMypage(HttpSession session, Model model) {
		String selId = (String) session.getAttribute("userID");
		
		model.addAttribute("users", usersService.selectOne(selId));
		return "/WEB-INF/login/userMyInfo.jsp";
	}

	// 비밀번호 재확인 후 내 정보 진입
	@RequestMapping("/reconPw.ko")
	@ResponseBody
	public int reconfirmPw(@RequestParam("u_pw") String pw, HttpSession session) {
		String id = (String) session.getAttribute("userID");
		int count = 0;

		if (usersService.checkPw(pw, id) != null) {
			count = 1;
		} else {
			count = 0;
		}
		
		return count;
	}

	// 회원 정보 수정
	@RequestMapping("/upInfo.ko")
	public String updateUser(UsersVO vo, Model model) {
		System.out.println("정보수정: " + vo);
		usersService.updateUser(vo);
		model.addAttribute("user", vo);
		return "userMyInfo.jsp";
	}

	// 회원계정 삭제
	@ResponseBody
	@RequestMapping("/delUser.ko")
	public String quitMem(HttpSession session) throws Exception {
		System.out.println("회원 탈퇴 컨트롤러");
		UsersVO vo = (UsersVO) session.getAttribute("user");
		usersService.deleteUser(vo);
		session.invalidate();
		return "success";
	}

	// 닉네임 중복체크
	@ResponseBody
	@RequestMapping("/checkNick.ko")
	public int checkNick(UsersVO vo) throws Exception {
		int count = 0;
		if (usersService.checkNick(vo.getU_nick()) == null) {
			System.out.println("닉 중복 : " + usersService.checkNick(vo.getU_nick()));
			count = 0;
		} else {
			System.out.println("닉 중복 : " + usersService.checkNick(vo.getU_nick()));
			count = 1;
		}
		return count;
	}

}
