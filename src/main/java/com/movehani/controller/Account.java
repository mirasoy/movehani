package com.movehani.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id @GeneratedValue 
	private Long sn;
	
	private String id;
	
	private String password;
	
}
