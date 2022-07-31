package com.movehani.member;

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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	
	private String email;
	
	private String password;
	
	private String nickname;
	
	@LastModifiedDate
	private Date updateDate;
	
	@CreatedDate
	private Date reignedDate;


	
}
