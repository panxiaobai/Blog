package com.white.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="blog_admin")
public class Admin {
	
	@Id//声明此列为主键
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	private String password;
	
	
	
	
	public Admin(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
