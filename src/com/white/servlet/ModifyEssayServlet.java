package com.white.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.white.model.Essay;
import com.white.model.User;
import com.white.service.EssayService;

public class ModifyEssayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		
		Essay essay=(Essay)session.getAttribute("modifyessay");
		essay.setTitle(req.getParameter("title"));
		essay.setDescript(req.getParameter("descrption"));
		essay.setContent(req.getParameter("content"));
		essay.setDate(new Date());
		//essay.setPraiseNum(0);
		essay.setType("public");
		EssayService.modifyEssay(essay);
		resp.sendRedirect("myIndex.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
