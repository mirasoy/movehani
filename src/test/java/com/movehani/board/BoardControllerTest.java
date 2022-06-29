package com.movehani.board;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


	@SpringBootTest
	@AutoConfigureMockMvc
	class BoardControllerTest {

	    @Autowired
	    ObjectMapper mapper;

	    @Autowired
	    MockMvc mvc;

	    private static final String BASE_URL = "";

	    @Test
	    @DisplayName("저장 테스트")
	    void save_test() throws Exception {
	        //given
//	        String title = "Test title";
//	        String content = "Test content";
//	        String author = "gorany";
//	        //when
//	        /**
//	         * Object를 JSON으로 변환
//	         * */
//	        String body = mapper.writeValueAsString(
//	            PostsSaveRequestDto.builder().author(author).content(content).title(title).build()
//	        );
	        //then
	    	
	    	
	    	String body = mapper.writeValueAsString(Board.builder().title("타이틀").build());
	    	System.err.println(body);
	        mvc.perform(post(BASE_URL + "/board")
	        		.content(body)
	                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
	            )
	        	.andDo(print())
	            .andExpect(status().isOk());
	    }
	}