package com.movehani.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public void deletePost(int postSn) 
	{
		postRepository.deleteById((long) postSn);
	}

	public Optional<Post> getPost(int postSn) {
		return postRepository.findById((long) postSn);
	}

	public Page<Post> getPostList(Pageable page) {
		return postRepository.findAll(page);
	}

	

}
