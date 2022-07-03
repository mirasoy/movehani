package com.movehani.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/post/{postSn}")
	public ModelAndView getPost(@PathVariable int postSn) {
		 ModelAndView mav = new ModelAndView();
		Optional<Post> savedpost = postService.getPost(postSn);
		mav.addObject("post",savedpost.get());
		mav.setViewName("post");
		return mav;
		
	}
	
	
	
	@PostMapping("/post")
	public ResponseEntity<Post> updateProduct(@RequestBody Post post) {
			
		Post savedpost = postService.save(post);
		return new ResponseEntity<Post>(savedpost , HttpStatus.OK);
	}
	
	@DeleteMapping("/post")
	public String deleteProduct(@RequestBody Post post) {
		
		postService.deletePost(post);
		return "삭제완료";
	}
}