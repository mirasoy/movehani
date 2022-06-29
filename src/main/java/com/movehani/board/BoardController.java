package com.movehani.board;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movehani.account.AccountRepository;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/board")
	public ResponseEntity<Board> updateProduct(Board board) {
			
		Board savedBoard = boardService.save(board);
		return new ResponseEntity(savedBoard , HttpStatus.OK);
	}
}
