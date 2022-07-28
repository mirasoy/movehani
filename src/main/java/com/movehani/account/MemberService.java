package com.movehani.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movehani.group.AthleticGroup;

@Service
public class MemberService {

	
	@Autowired
	MemberRepository memberRepository;
	
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}


	public Member find(Member member) {
		return memberRepository.findById(member.getSn()).get()0;
	}
	
	

	

}
