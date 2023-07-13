package ssg.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value ="login.do")
	public String login() {
		System.out.println("MemberController login() " + new Date());
		return "login";
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController regi() " + new Date());
		return "regi";
	}
	
	@ResponseBody // Ajax는 꼭 써줘야한다!
	@PostMapping("idcheck.do")
	public String idcheck(String id) {
		System.out.println("MemberController regi() " + new Date());
		
		boolean isS = service.idcheck(id);
		String msg = "YES";
		if(isS == true) {
			msg = "NO";
		}
		return msg;
	}
	@PostMapping("regiAf.do")
	public String regiAf(MemberDto mem, Model model) {		// 보내줄때는 모델이 항상 필요하다
		System.out.println("MemberController regiAf() " + new Date());
			
		boolean isS = service.addmember(mem);
		String message = "MEMBER_YES";
		if(isS == false) {
			message = "MEMBER_NO";		// 코드를 줄여보자.
		}
		model.addAttribute("message", message);
		return "message";
	}
	
	@PostMapping("loginAf.do")//HttpServletRequest request // request가 들어온다! model과 사용법이 같다.
	public String login(MemberDto mem, Model model, HttpServletRequest request) {		// 보내줄때는 모델이 항상 필요하다
		System.out.println("MemberController login() " + new Date());
			
		MemberDto dto = service.login(mem);
		String loginmsg = "LOGIN_NO";
		if(dto != null ) {
			request.getSession().setAttribute("login", dto); 	// session에 저장***
			loginmsg = "LOGIN_YES";		
		}
		model.addAttribute("loginmsg", loginmsg);
		return "message";
	}
}
