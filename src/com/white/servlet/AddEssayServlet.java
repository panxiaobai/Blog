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
import com.white.service.UserService;

public class AddEssayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		Essay essay=new Essay();
		essay.setTitle(req.getParameter("title"));
		essay.setDescript(req.getParameter("descrption"));
		essay.setBlog(user.getBlog());
		essay.setContent(req.getParameter("content"));
		essay.setDate(new Date());
		essay.setPraiseNum(0);
		essay.setType("public");
		EssayService.addEssay(essay);
		resp.sendRedirect("myIndex.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
