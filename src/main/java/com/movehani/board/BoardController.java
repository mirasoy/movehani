package com.movehani.board;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movehani.account.AccountRepository;

@RestController
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@PutMapping("/board")
	public ResponseEntity updateProduct(Board board) {
			
		Board savedBoard = boardRepository.save(board);
		return new ResponseEntity(savedBoard.getTitle()+" id 상품정보수정완료", HttpStatus.OK);
	}
}
