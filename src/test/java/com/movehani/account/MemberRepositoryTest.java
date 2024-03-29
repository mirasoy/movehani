package com.movehani.account;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.movehani.member.Member;
import com.movehani.member.MemberRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository accountRepository;
	
	@Test
	public void saveTest() {
		
		Member accout = new Member();

		accout.setEmail("test");
		accout.setPassword("test1");
		Member resultAccout =accountRepository.save(accout);
		
		
		
		assertThat(resultAccout.getNickname().equals("임시닉네임"));
		accountRepository.findAll().forEach(System.out::println);		
	}
	
	
}
