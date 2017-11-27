package com.home.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.admin.model.UserModel;
import com.common.entiy.User;

@WebServlet("/UpdateUserImgServlet")
@MultipartConfig
public class UpdateUserImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("picture");
		String img = "" ;
		if(part!=null && part.getSize()>0){
			String fileName = part.getSubmittedFileName();
			String path = getServletContext().getRealPath("/Public/dishimg")+File.separator+fileName;
			part.write(path);
			img = "/Public/dishimg/"+fileName ;
			//System.out.println(path+"-------");
		}
		
		if(img.length()<1){
			img = "/Public/dishimg/head.jpg";
		}
		
		//获取表单数据
		String zhuce_name = request.getParameter("zhuce_name");
		String zhuce_pass = request.getParameter("zhuce_pass");
		String TrueName = request.getParameter("TrueName");
		String zhuce_sex = request.getParameter("zhuce_sex");
		String postcode = request.getParameter("postcode");
		String Address = request.getParameter("Address");
		String Tel = request.getParameter("Tel");
		String Email = request.getParameter("Email");
		
		
		System.out.println(zhuce_name + " " + zhuce_pass + " " + TrueName + " " + zhuce_sex + " " + postcode + " " + Address + " " + Tel + " " + Email);
		
		//数据封装
		User user = new User();
		user.setUsername(zhuce_name);
		user.setPassword(zhuce_pass);
		user.setTruename(TrueName);
		user.setSex(zhuce_sex);
		user.setPostcode(postcode);
		user.setEmail(Email);
		user.setCity(Address);
		user.setPhone(Tel);
		user.setPicture(img);
		
		
		//执行添加公告方法
		int i = usermodel.addUser(user);
		if(i>0){
			out.write("<script>alert('添加成功');location='" + request.getContextPath() + "/Home/login.jsp';</script>");
		}else{
			out.write("<script>alert('添加失败');location='" + request.getContextPath() + "/Home/register.jsp';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
