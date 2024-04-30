package com.drink.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.drink.ko.UsersService;
import com.drink.ko.UsersVO;

@SessionAttributes("user")
@Controller
public class LoginController {
	@Autowired
	UsersService usersService;

//	@Autowired
//	private MailSendService mailService;
	
	@RequestMapping("/login.ko")
	public String login(UsersVO vo, Model model) {

		System.out.println("여기까지 진입 성공");
		UsersVO user = usersService.loginSelectOne(vo);
		if (user != null) {
			model.addAttribute("user", user);
			return "/index.jsp";
		} else {
			return "/login.jsp?error=1";
		}

	}
	
	@RequestMapping("/logout.ko")
	public String logout(HttpSession session, SessionStatus sessionStatus) {
		System.out.println("logout.do 메서드를 탔습니다.");
		sessionStatus.setComplete();
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
//	@RequestMapping("/idFind.ko")
//	@ResponseBody
//	public UsersVO idFind(UsersVO vo , @RequestParam(value="menu", defaultValue="", required=false)String menu,Model model) {
//		System.out.println("@RequestParam으로 받은 menu : "+menu);
//		System.out.println("vo.getPhon : "+vo.getU_tel());
//	    System.out.println("idFind 컨트롤러를 탔습니다.");
//	    System.out.println("UsersVO vo.getEmail : "+vo.getU_email());
//	    if(menu != null && menu.equals("email")) {
//	    	return usersService.idFindEmail(vo);
//	    }else if(menu != null && menu.equals("phon")) {
//	    	return usersService.idFindPhon(vo);
//	    }else {
//	    	return null;
//	    }
//	       
//	}
//	
//	@RequestMapping("/pwFind.ko")
//	@ResponseBody
//	public UsersVO pwFind(UsersVO vo) {
//		System.out.println("pwFind 메서드를 탔습니다. : "+vo.getU_id());
//		int i = usersService.pwFind(vo);
//		System.out.println("i : "+i);
//		if(i == 0) {
//			System.out.println("해당 id가 없습니다..");
//		}else if(i > 0) {
//			System.out.println("해당 id가 있습니다..");
//			UsersVO vovo = usersService.pwFindStart(vo);
//			System.out.println("UsersVO vovo : "+vovo.getU_pw());
//			return usersService.pwFindStart(vo);
//		}
//		return null;
//	}
//	
//	@RequestMapping("/mailCheck.ko")
//	@ResponseBody
//	public String mailCheck(@RequestParam(value="email", defaultValue="", required=false)String email) {
//		System.out.println("이메일 인증 요청이 들어옴!");
//		System.out.println("이메일 인증 이메일1 : " + email);
//		return mailService.joinEmail(email);
//	}

}
