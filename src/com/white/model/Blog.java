package com.white.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="blog_blog")
public class Blog {
	
	@Id//声明此列为主键
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String description;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="blog",fetch=FetchType.EAGER)
	private List<Essay> essays;
	
	
	
	public Blog(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Essay> getEssays() {
		return essays;
	}
	public void setEssays(List<Essay> essays) {
		this.essays = essays;
	}
	
	
	
}
