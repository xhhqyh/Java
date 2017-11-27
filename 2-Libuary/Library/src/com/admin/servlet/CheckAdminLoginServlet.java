package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.AdminModel;
import com.common.entiy.Admin;

@WebServlet("/CheckAdminLoginServlet")
public class CheckAdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AdminModel adminmodel = new AdminModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//获取表单数据
		String manname = request.getParameter("manname");
		String manpwd = request.getParameter("manpwd");
		String isLogin = request.getParameter("isLogin");
		
		System.out.println(manname + " " + manpwd);
		
		//数据封装
		Admin admin = new Admin();
		admin.setManname(manname);
		admin.setManpwd(manpwd);
		
		//取得结果
		String mantype = adminmodel.checkAdminLogin(admin);
		
		if(mantype!=null && mantype.length()>0){
			//设置COOKIE
			if("y".equals(isLogin)){
				Cookie nameCookie = new Cookie("manname", manname);
				Cookie pwdCookie = new Cookie("manpwd", manpwd);
				nameCookie.setMaxAge(60*1);
				pwdCookie.setMaxAge(60*1);
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
			}
			
			session.setAttribute("manname", manname);
			session.setAttribute("mantype", mantype);
			out.write("<script>location='" + request.getContextPath() + "/Admin/manage.jsp';</script>");
		}else{
			out.print("<script>alert('登录失败');location='" + request.getContextPath() + "/Admin/login.jsp';</script>");
		}
	}
}















