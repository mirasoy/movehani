package com.movehani.post;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movehani.account.AccountRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/post/{postSn}")
	public ResponseEntity<Post> getPost(@PathVariable int postSn) {
		Post savedpost = postService.getPost(postSn);
		return new ResponseEntity(savedpost , HttpStatus.OK);
	}
	
	
	
	@PostMapping("/post")
	public ResponseEntity<Post> updateProduct(@RequestBody Post post) {
			
		Post savedpost = postService.save(post);
		return new ResponseEntity(savedpost , HttpStatus.OK);
	}
	
	@DeleteMapping("/post")
	public String deleteProduct(@RequestBody Post post) {
		
		postService.deletePost(post);
		return "삭제완료";
	}
}
