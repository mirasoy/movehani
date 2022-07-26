package com.movehani.account;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountSn;
	
	private String id;
	
	private String password;
	
	private String nickname;
	
	@ManyToOne
	private Member updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne
	private Member registUser;
	
	@CreatedDate
	private Date reignedDate;

	
}
