package com.home.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.UserModel;
import com.common.entiy.User;

@WebServlet("/CheckUserLoginServlet")
public class CheckUserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();

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
		
		//��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " + password);
		
		//���ݷ�װ
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//ȡ�ý��
		int i = usermodel.queryUserFreeze(username);
		if(i==1){
			out.print("<script>alert('�����˻��ѱ�����');location='" + request.getContextPath() + "/Home/login.jsp';</script>");
		}else{
			String str = usermodel.checkUser(user);
			
			if(str!=null && str.length()>0){
				session.setAttribute("picture", str);
				session.setAttribute("username", username);
				out.write("<script>location='" + request.getContextPath() + "/Home/index';</script>");
			}else{
				out.write("<script>alert('��¼ʧ��');location='" + request.getContextPath() + "/Home/login.jsp';</script>");
			}
		}
		
		
	}
}
