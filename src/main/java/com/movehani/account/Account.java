package com.movehani.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
public class Account {

	@Id @GeneratedValue
	private Long sn;
	
	private String id;
	
	private String password;
	
	private String nickname;
	
	@ManyToOne
	private Account updateUser;
	
	@LastModifiedDate
	private Date updateDate;
	
	@ManyToOne
	private Account registUser;
	
	@CreatedDate
	private Date reignedDate;

	public Long getSn() {
		return sn;
	}

	public void setSn(Long sn) {
		this.sn = sn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Account getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Account updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Account getRegistUser() {
		return registUser;
	}

	public void setRegistUser(Account registUser) {
		this.registUser = registUser;
	}

	public Date getReignedDate() {
		return reignedDate;
	}

	public void setReignedDate(Date reignedDate) {
		this.reignedDate = reignedDate;
	}

	
}
