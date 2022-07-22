package com.movehani.group;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movehani.post.Post;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupControllerTest {

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MockMvc mvc;

	private static final String BASE_URL = "";

	//@Test
	@DisplayName("저장 테스트")
	void save_test() throws Exception {

		Post newBoard = Post.builder().title("타이틀_").build();
		String body = mapper.writeValueAsString(newBoard);
		System.err.println(body);
		mvc.perform(post(BASE_URL + "/post").content(body).contentType(MediaType.APPLICATION_JSON) // 보내는 데이터의 타입을 명시
		).andDo(print()).andExpect(status().isOk());
	}

	//@Test
	@DisplayName("삭제 테스트")
	void delete_test() throws Exception {

		Post deleteBoard = Post.builder().postSn(19l).build();
		String deleteBody = mapper.writeValueAsString(deleteBoard);
		mvc.perform(delete(BASE_URL + "/post").content(deleteBody).contentType(MediaType.APPLICATION_JSON) // 보내는 데이터의
		).andDo(print()).andExpect(status().isOk());
		
	}
	
	//@Test
	@DisplayName("불러오기 테스트")
	void get_test() throws Exception {
		
		mvc.perform(get(BASE_URL + "/post/1")).andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	@DisplayName("불러오기 테스트")
	void getList_test() throws Exception {
		
		mvc.perform(get(BASE_URL + "/postlist")).andDo(print()).andExpect(status().isOk());
		
	}
}