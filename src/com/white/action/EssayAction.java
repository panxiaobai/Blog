package com.white.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.white.model.Essay;
import com.white.model.User;
import com.white.service.EssayService;

public class EssayAction extends ActionSupport{
	private String title;
	private String descrption;
	private String content;
	private String type;
	private String essayId;
	
	public String addEssay(){
		ActionContext context = ActionContext.getContext(); 
		Map session=context.getSession();
		User user=(User)session.get("user");
		Essay essay=new Essay();
		essay.setTitle(title);
		essay.setDescript(descrption);
		essay.setBlog(user.getBlog());
		essay.setContent(content);
		essay.setDate(new Date());
		essay.setPraiseNum(0);
		essay.setType("public");
		if(EssayService.addEssay(essay)){
			return "AddEssaySuccess";
		}else{
			return "AddEssayFailure";
		}
	}
	
	public String modifyEssay(){
		ActionContext context = ActionContext.getContext(); 
		Map session=context.getSession();
		Essay essay=(Essay)session.get("modifyessay");
		essay.setTitle(title);
		essay.setDescript(descrption);
		essay.setContent(content);
		essay.setDate(new Date());
		essay.setPraiseNum(0);
		essay.setType("public");
		if(EssayService.modifyEssay(essay)){
			return "ModifyEssaySuccess";
		}else{
			return "ModifyEssayFailure";
		}
	}
	
	public String deleteEssay(){
		int id=Integer.valueOf(essayId);
		Essay essay=new Essay();
		essay.setId(id);
		if(EssayService.deleteEssay(essay)){
			return "DeleteEssaySuccess";
		}else{
			return "DeleteEssayFailure";
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEssayId() {
		return essayId;
	}

	public void setEssayId(String essayId) {
		this.essayId = essayId;
	}
	
	
	

}
