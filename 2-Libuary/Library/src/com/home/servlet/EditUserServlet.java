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

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//获取表单数据
		String zhuce_name = request.getParameter("zhuce_name");
		String TrueName = request.getParameter("TrueName");
		String zhuce_sex = request.getParameter("zhuce_sex");
		String postcode = request.getParameter("postcode");
		String Address = request.getParameter("Address");
		String phone = request.getParameter("phone");
		String Email = request.getParameter("Email");
		String userid = request.getParameter("userid");
		System.out.println(userid+"----");
		System.out.println(zhuce_name);
		
		int userid2 = Integer.valueOf(userid);
		
		System.out.println(zhuce_name + " " + " " + TrueName + " " + zhuce_sex + " " + postcode + " " + Address + " " + phone + " " + Email);
		
		//数据封装
		User user = new User();
		user.setUsername(zhuce_name);
		user.setTruename(TrueName);
		user.setSex(zhuce_sex);
		user.setPostcode(postcode);
		user.setEmail(Email);
		user.setCity(Address);
		user.setPhone(phone);
		user.setUserid(userid2);
		
		
		//执行修改用户方法
		int i = usermodel.editUser(user);
		if(i>0){
			session.setAttribute("username", zhuce_name);
			out.print("<script>alert('修改成功');location='" + request.getContextPath() + "/QueryOneUserServlet';</script>");
		}else{
			out.print("<script>alert('修改失败');location='" + request.getContextPath() + "/UpdateUserServlet?username="+ zhuce_name +"';</script>");
		}
	}
}
