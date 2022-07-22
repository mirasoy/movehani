package com.movehani.group;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.PagedModel.PageMetadata;
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
import com.movehani.post.Post;
import com.movehani.post.PostService;

@Controller
public class GroupController {
	
	@Autowired
	private GruopService groupService;
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/group/{groupSn}")
	public ModelAndView getgroup(@PathVariable int groupSn) {
		ModelAndView mav = new ModelAndView();
		Optional<AthleticGroup> savedgroup = groupService.getAthleticGroup(groupSn);

		if(savedgroup.isPresent()) {
			mav.addObject("group",savedgroup.get());
		}else {
			mav.addObject("group",new AthleticGroup());
		}
		
		List<Post> postlist = postService.getPostByAthleticGroup(groupSn);
		
		mav.setViewName("group/group");
		return mav;
	}
	
	@PostMapping("/group")
	public String updateProduct(AthleticGroup group) {
			
		AthleticGroup savedgroup = groupService.save(group);
		
		return  "redirect:/group/"+savedgroup.getGroupSn();
	}
	
	@DeleteMapping("/group/{groupSn}")
	public String deleteProduct(@PathVariable int groupSn) {
		
		groupService.deletePost(groupSn);
		return  "redirect:/grouplist";
	}
	
	
	@GetMapping("/group/registPage")
	public ModelAndView registPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("group/groupRegisterPage");
		return mav;
	}
	
	@GetMapping("/grouplist")
	public ModelAndView groupList(@PageableDefault(size = 10) Pageable pageable, PagedResourcesAssembler<AthleticGroup> assembler) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("group/grouplist");
		
		PagedModel<EntityModel<AthleticGroup>> groupList= assembler.toModel(groupService.getAthleticGroupList(pageable));
		PageMetadata metadata = groupList.getMetadata();
		mav.addObject("groupList",groupList.getContent());
		mav.addObject("metadata",metadata);
		
		int totalPages = (int) metadata.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            mav.addObject("pageNumbers", pageNumbers);
        }
		
		return mav;
	}
	
}
