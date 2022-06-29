package com.movehani.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.movehani.account.Account;

import lombok.Builder;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
public class Board {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardSn;
	
	private String title;

	private String boardStatus = "I";
	
	private String contents;
	
	private String textcolor;
	
	private String bordercolor;
	
	@ManyToOne
	private Account updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne
	private Account registUser;
	
	@CreatedDate
	private Date reignedDate;

	
	//private BoardFileEntity boardFileEntity ;   

	//private GroupEntity group;   



	
	
}
