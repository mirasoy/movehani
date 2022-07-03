package com.movehani.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
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
public class Post {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postSn;
	
	private String title;

	private String postStatus = "I";
	
	private String contents;
	
	private String textcolor;
	
	private String bordercolor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account registUser;
	
	@CreatedDate
	private Date reignedDate;

	public Post() {
		
	}

	public Post(Long postSn, String title, String postStatus, String contents, String textcolor, String bordercolor,
			Account updateUser, Date updateDate, Account registUser, Date reignedDate) {
		super();
		this.postSn = postSn;
		this.title = title;
		this.postStatus = postStatus;
		this.contents = contents;
		this.textcolor = textcolor;
		this.bordercolor = bordercolor;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.registUser = registUser;
		this.reignedDate = reignedDate;
	}
	
	
	//private postFileEntity postFileEntity ;   

	//private GroupEntity group;   



	
	
}