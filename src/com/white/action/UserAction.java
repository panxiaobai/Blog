package com.white.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.white.model.Blog;
import com.white.model.User;
import com.white.service.UserService;

public class UserAction extends ActionSupport{
	private String name;
	private String description;
	private String username;
	private String password;
	private String blogdes;
	private String blogname;
	
	public String signin(){
		ActionContext context = ActionContext.getContext(); 
		Map session=context.getSession();
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		User u=UserService.login(user);
		if(u!=null){
			session.put("user", u);
			return "SigninSuccess";
		}else{
			return "SigninFailure";
		}
	}
	
	public String signup(){
		User user=new User();
		user.setName(name);
		user.setDescription(description);
		user.setPassword(password);
		user.setUsername(username);
		Blog blog=new Blog();
		blog.setUser(user);
		blog.setDescription(blogdes);
		blog.setName(blogname);
		if(UserService.register(user, blog)){
			return "SignupSuccess";
		}else{
			return "SignupFailure";
		}
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

	public String getBlogdes() {
		return blogdes;
	}

	public void setBlogdes(String blogdes) {
		this.blogdes = blogdes;
	}

	public String getBlogname() {
		return blogname;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	
	
	
}
