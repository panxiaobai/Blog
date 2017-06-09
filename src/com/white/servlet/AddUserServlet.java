package com.white.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.white.model.Blog;
import com.white.model.User;
import com.white.service.UserService;

public class AddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		User user=new User();
		user.setName(req.getParameter("name"));
		System.out.println(req.getParameter("name"));
		user.setDescription(req.getParameter("description"));
		user.setPassword(req.getParameter("password"));
		user.setUsername(req.getParameter("username"));
		Blog blog=new Blog();
		blog.setUser(user);
		blog.setDescription(req.getParameter("blogdes"));
		blog.setName(req.getParameter("blogname"));
		UserService.register(user, blog);
		resp.sendRedirect("signIn.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
