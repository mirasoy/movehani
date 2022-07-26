package com.movehani.group;

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

import com.movehani.account.Member;
import com.movehani.file.AttachFile;

import lombok.Builder;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
public class AthleticGroup {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupSn;
	
	private String groupName;

	private String groupStatus = "I";
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member registUser;
	
	@CreatedDate
	@Column(updatable = false)
	private Date reignedDate;

	public AthleticGroup() {
		
	}

	public AthleticGroup(Long groupSn, String groupName, String groupStatus, Member updateUser, Date updateDate,
			Member registUser, Date reignedDate) {
		super();
		this.groupSn = groupSn;
		this.groupName = groupName;
		this.groupStatus = groupStatus;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.registUser = registUser;
		this.reignedDate = reignedDate;
	}
	
	
}
