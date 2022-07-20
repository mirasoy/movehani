package com.movehani.group;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GruopService {
	
	@Autowired
	GroupRepository groupRepository;

	public AthleticGroup save(AthleticGroup post) {
		return groupRepository.save(post);
	}

	public void deletePost(int postSn) 
	{
		groupRepository.deleteById((long) postSn);
	}

	public Optional<AthleticGroup> getPost(int postSn) {
		return groupRepository.findById((long) postSn);
	}

	public Page<AthleticGroup> getPostList(Pageable page) {
		return groupRepository.findAll(page);
	}

	

}
