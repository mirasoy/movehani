package com.movehani.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movehani.group.AthleticGroup;
import com.movehani.group.GruopService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberjoin")
	public ModelAndView registPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/join");
		return mav;
	}
	
	@PostMapping("/member")
	public String joinMember(Member member) {
			
		memberService.save(member);
		
		return  "redirect:/postlist";
	}
	
	@PostMapping("/member/login")
	public String login(Member member) {
		
		Member member = memberService.find(member);
		
		return  "redirect:/postlist";
	}
	
	@GetMapping("/member/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	
}
