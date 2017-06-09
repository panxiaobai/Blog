package com.white.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.white.model.User;
import com.white.service.UserService;

public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		User u=UserService.login(user);
		if(u!=null){
			session.setAttribute("user", u);
			System.out.println("OK");
			resp.sendRedirect("myIndex.jsp");
		}else{
			System.out.println("Error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
