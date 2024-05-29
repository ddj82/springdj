package kr.co.biz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.biz.dept.DeptService;
import kr.co.biz.dept.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dept")
public class DeptController {
	
	private final DeptService deptService;
	
	@GetMapping
	public List<Member> list() {
		List<Member> ml = deptService.findByMember();
		
		for(Member m :ml) {
			System.out.println("m: "+m);
		}
		return ml;
	}  
}
