package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminOutServlet")
public class AdminOutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("manname", null);
		session.setAttribute("mantype", null);
		
		//Çå¿ÕCookie
		Cookie nameCookie = new Cookie("manname", null);
		Cookie pwdCookie = new Cookie("manpwd", null);
		nameCookie.setMaxAge(0);
		pwdCookie.setMaxAge(0);
		response.addCookie(nameCookie);
		response.addCookie(pwdCookie);
		
		response.sendRedirect(request.getContextPath() + "/Admin/login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
