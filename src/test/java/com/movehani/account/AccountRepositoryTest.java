package com.movehani.account;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void saveTest() {
		
		Account accout = new Account();
		accout.setNickname("임시닉네임");
		Account resultAccout =accountRepository.save(accout);
		
		assertThat(resultAccout.getNickname().equals("임시닉네임"));
		accountRepository.findAll().forEach(System.out::println);		
	}
	
	
}
