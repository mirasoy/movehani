package com.movehani.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public ModelAndView login(Member member) {
		ModelAndView mav = new ModelAndView();
		Member findMember =  memberService.find(member.getEmail());
		
		if(findMember != null) {
			if(findMember.getPassword().equals(member.getPassword())) {
				mav.addObject("member", findMember);
			}
		}
		
		mav.setViewName("member/login");
		return mav;
				
	}
	
	@GetMapping("/member/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	
}
