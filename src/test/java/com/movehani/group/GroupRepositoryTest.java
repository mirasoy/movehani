package com.movehani.group;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.movehani.post.PostRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupRepositoryTest {

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Test
	public void saveTest() {
		
		AthleticGroup gr = new AthleticGroup();
		gr.setGroupSn(1l);
		
		//postRepository.findByAthleticGroup(gr);
		postRepository.findByAthleticGroupGroupSn(1l);
		
	}
	
	
}
