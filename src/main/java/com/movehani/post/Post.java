package com.movehani.post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.movehani.account.Account;
import com.movehani.file.AttachFile;
import com.movehani.group.AthleticGroup;

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
	
	@OneToOne
	private AttachFile attachFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account registUser;
	
	@CreatedDate
	@Column(updatable = false)
	private Date reignedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private AthleticGroup athleticGroup;
	
	public Post() {
		
	}

	public Post(Long postSn, String title, String postStatus, String contents, AttachFile attachFile,
			Account updateUser, Date updateDate, Account registUser, Date reignedDate, AthleticGroup group) {
		super();
		this.postSn = postSn;
		this.title = title;
		this.postStatus = postStatus;
		this.contents = contents;
		this.attachFile = attachFile;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.registUser = registUser;
		this.reignedDate = reignedDate;
		this.athleticGroup = group;
	}
	
	
}
