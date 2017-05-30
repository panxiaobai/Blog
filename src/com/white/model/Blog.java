package com.white.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="blog_blog")
public class Blog {
	
	@Id//��������Ϊ����
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private String name;
	private String description;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="blog")
	private List<Essay> essays;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
