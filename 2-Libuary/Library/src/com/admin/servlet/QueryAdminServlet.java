package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.AdminModel;
import com.common.entiy.Admin;

@WebServlet("/QueryAdminServlet")
public class QueryAdminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AdminModel adminmodel = new AdminModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//取得类型集合
		List<Admin> adminList = adminmodel.queryAdminInfo();
		
		if(adminList != null){
			request.setAttribute("adminList", adminList);
			request.getRequestDispatcher("/Admin/admin_list.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
