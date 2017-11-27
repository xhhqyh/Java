package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.UserModel;
import com.common.entiy.User;

@WebServlet("/EditUserfreezeServlet")
public class EditUserfreezeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取表单数据
		String userid = request.getParameter("userid");
		String freeze = request.getParameter("freeze");
		
		int userid2 = Integer.valueOf(userid);
		int freeze2 = Integer.valueOf(freeze);
		
		//数据封装
		User user = new User();
		user.setUserid(userid2);
		user.setFreeze(freeze2);
		
		//执行修改用户状态的方法
		int i = usermodel.editUserFreeze(user);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryUserServlet';</script>");
		}else{
			out.write("<script>alert('修改失败');location='" + request.getContextPath() + "/QueryUserServlet';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
