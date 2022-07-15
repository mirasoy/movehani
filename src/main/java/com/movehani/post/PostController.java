package com.movehani.post;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.movehani.file.AttachFile;
import com.movehani.file.FileService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	
	@GetMapping("/post/{postSn}")
	public ModelAndView getPost(@PathVariable int postSn) {
		 ModelAndView mav = new ModelAndView();
		Optional<Post> savedpost = postService.getPost(postSn);
		if(savedpost.isPresent()) {
			mav.addObject("post",savedpost.get());
		}else {
			mav.addObject("post",new Post());
		}
		
		
		mav.setViewName("post/post");
		return mav;
	}
	
	@GetMapping("/postFile/{postSn}")
	public void getPostFile(@PathVariable int postSn , HttpServletResponse response) throws IOException {
		
		Optional<Post> savedpost = postService.getPost(postSn);;
		AttachFile file = savedpost.get().getAttachFile();
		
		try {
			byte[] files = FileUtils.readFileToByteArray(new File(file.getFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition","attachment; filename=\""+URLEncoder.encode(file.getFilename(),"UTF-8")+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			response.getOutputStream().close();
		}
	}
	
	@PostMapping("/post")
	public String updateProduct(@RequestParam("file") MultipartFile files, Post post) {
			
		if(files != null) {
			
			AttachFile saveFile = fileService.saveFile(files);
			post.setAttachFile(saveFile);
		}
		
		Post savedpost = postService.save(post);
		
		return  "redirect:/post/"+savedpost.getPostSn();
	}
	
	@DeleteMapping("/post/{postSn}")
	public String deleteProduct(@PathVariable int postSn) {
		
		postService.deletePost(postSn);
		return  "redirect:/registPage";
	}
	
	
	@GetMapping("/registPage")
	public ModelAndView registPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("post/postRegisterPage");
		return mav;
	}
	
}
