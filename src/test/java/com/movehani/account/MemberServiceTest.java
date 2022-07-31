package com.movehani.account;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.movehani.member.Member;
import com.movehani.member.MemberRepository;
import com.movehani.member.MemberService;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void saveTest() {
		
		Member accout = new Member();

		accout.setEmail("test");
		accout.setPassword("test1");
		Member resultAccout =memberService.save(accout);
		
		
	}
	
	
}
