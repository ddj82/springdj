package com.drink.view;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.drink.ko.OrderService;
import com.drink.ko.OrderVO;
import com.drink.ko.ProdRevService;
import com.drink.ko.ProdRevVO;
import com.drink.ko.ProdService;
import com.drink.ko.ProdVO;
import com.drink.ko.QnaService;
import com.drink.ko.QnaVO;

@Controller
public class BichenaController {
	@Autowired
	ProdService prodService;
	@Autowired 
	ProdRevService prodRevService;
	@Autowired
	QnaService qnaService;
	@Autowired
	OrderService orderService;
	
	String realPath = "C:/swork/bichena/src/main/webapp/img/";
	
	@RequestMapping("/myPage.ko")
	public String myPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int u_no = (int) session.getAttribute("userNO");
		List<OrderVO> myOrderList = orderService.myOrderList(u_no);
		System.out.println(myOrderList);
		model.addAttribute("myOrderList", myOrderList);
		return "/WEB-INF/user/myPageMain.jsp";
	}
	
	@GetMapping("myOrderDetail.ko")
	public String myOrderDetail(@RequestParam(value="o_no") String o_no, Model model) {
		OrderVO myOrderDetail = orderService.myOrderDetail(o_no);
		model.addAttribute("myOrderDetail", myOrderDetail);
		return "/WEB-INF/user/myOrderDetail.jsp";
	} 

	@GetMapping("/prodList.ko")
	public String prodList(Model model) {
		List<ProdVO> prodList = prodService.prodList();
		model.addAttribute("prodList", prodList);
		return "/WEB-INF/user/prodView.jsp";
	}
	
	@GetMapping("/prodOne.ko")
	public String prodOne(@RequestParam(value="p_no") String p_no, Model model) {
		ProdVO prodOne = prodService.prodOne(p_no);
		model.addAttribute("prodOne", prodOne);
		return "/WEB-INF/user/prodOneView.jsp";
	}
	
	@PostMapping("/prodOneRev.ko")
	@ResponseBody
	public Object prodOneNotice(@RequestParam(value="p_no") String p_no, Model model) {
		List<ProdRevVO> prodOneRev = prodRevService.prodOneRev(p_no);
		model.addAttribute("prodNotice", prodOneRev);
		
		Map<String, Object> prodOneRevMap = new HashMap<>();
		prodOneRevMap.put("code", "OK");
		prodOneRevMap.put("prodOneRev", prodOneRev);
		return prodOneRevMap;
	}
	
	@PostMapping("/prodRevInsert.ko")
	public String prodRevInsert(ProdRevVO vo, @RequestParam(value="o_no") String o_no) throws IllegalStateException, IOException {
		System.out.println(vo);
		MultipartFile uploadFile = vo.getUploadFile();
		realPath += "imgRev/";
		File f = new File(realPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		if (!uploadFile.isEmpty()) {
			vo.setPr_img(uploadFile.getOriginalFilename());
			//실질적으로 파일이 설정한 경로에 업로드 되는 지점
			uploadFile.transferTo(new File(realPath + vo.getPr_img()));
		}
		
		int cnt = prodRevService.prodRevInsert(vo);
		
		if (cnt > 0) {
			System.out.println("등록완료");
			return "orderRevchk.ko";
		} else {
			System.out.println("등록실패");
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/orderRevchk.ko")
	public String orderRevchk(OrderVO vo) {
		int cnt = orderService.orderRevchk(vo);
		System.out.println(vo);
		
		if (cnt > 0) {
			System.out.println("변경완료");
			return "myPage.ko";
		} else {
			System.out.println("변경실패");
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/qnaList.ko")
	public String qnaList(Model model) {
		List<QnaVO> qnaList = qnaService.qnaList();
		model.addAttribute("qnaList", qnaList);
		return "/WEB-INF/user/qna.jsp";
	}
	
	@GetMapping("/qnaView.ko")
	public String qnaView(@RequestParam(value="q_no") String q_no, Model model) {
		QnaVO qnaView = qnaService.qnaView(q_no);
		model.addAttribute("qnaView", qnaView);
		return "/WEB-INF/user/qnaView.jsp";
	}
	
	@PostMapping("/qnaAcontent.ko")
	public String qnaAcontent(QnaVO vo) {
		int cnt = qnaService.qnaAcontent(vo);
		
		if (cnt > 0) {
			System.out.println("답변완료");
			return "qnaState.ko?q_no=" + vo.getQ_no();
		} else {
			System.out.println("답변실패");
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/qnaState.ko")
	public String qnaState(QnaVO vo) {
		vo.setQ_state("답변완료");
		int cnt = qnaService.qnaState(vo);
		
		if (cnt > 0) {
			System.out.println("상태변경완료");
		}
		return "qnaList.ko";
	}
	
	@GetMapping("/qnaDelete.ko")
	public String qnaDelete(@RequestParam(value="q_no") String q_no) {
		int cnt = qnaService.qnaDelete(q_no);
		
		if (cnt > 0) {
			System.out.println("삭제완료");
			return "qnaList.ko";
		} else {
			System.out.println("삭제실패");
			return "redirect:/index.jsp";
		}
	}
	
	@GetMapping("/qnaInsertbtn.ko")
	public String qnaInsertbtn() {
		return "/WEB-INF/user/qnaInsert.jsp";
	}
	
	@PostMapping("/qnaInsert.ko")
	public String qnaInsert(QnaVO vo) throws IllegalStateException, IOException {
		System.out.println(vo);
		MultipartFile uploadFile = vo.getUploadFile();
		realPath += "imgQna/";
		File f = new File(realPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		if (!uploadFile.isEmpty()) {
			vo.setQ_img(uploadFile.getOriginalFilename());
			//실질적으로 파일이 설정한 경로에 업로드 되는 지점
			uploadFile.transferTo(new File(realPath + vo.getQ_img()));
		}
		
		int cnt = qnaService.qnaInsert(vo);
		
		if (cnt > 0) {
			System.out.println("등록완료");
			return "qnaList.ko";
		} else {
			System.out.println("등록실패");
			return "redirect:/index.jsp";
		}
	}
	
}
