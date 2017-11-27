package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.OrderModel;

@WebServlet("/EditOrderStatusServlet")
public class EditOrderStatusServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static OrderModel ordermodel = new OrderModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取表单数据
		String orderid = request.getParameter("orderid");
		
		int orderid2 = Integer.valueOf(orderid);
		
		//执行修改用户状态的方法
		int i = ordermodel.editOrderFreeze(orderid2);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryOrderAdminServlet';</script>");
		}else{
			out.write("<script>alert('修改失败');location='" + request.getContextPath() + "/QueryUserServlet';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
