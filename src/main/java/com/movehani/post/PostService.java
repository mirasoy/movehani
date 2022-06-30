package com.movehani.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public void deletePost(Post post) {
		postRepository.delete(post);
	}

	public Post getPost(int postSn) {
		return postRepository.findById((long) postSn).get();
	}
	

}
