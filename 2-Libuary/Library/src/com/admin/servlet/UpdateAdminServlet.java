package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.AdminModel;
import com.common.entiy.Admin;

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AdminModel adminmodel = new AdminModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取标记
		String flag = request.getParameter("flag");
		
		int manid = Integer.valueOf(request.getParameter("manid"));
		
		Admin admin = new Admin();
		admin.setManid(manid);
		
		if("delete".equals(flag)){
			int i = adminmodel.deleteAdmin(admin);
			
			if(i>0){
				out.write("<script>location='" + request.getContextPath() + "/QueryAdminServlet';</script>");
			}else{
				out.write("<script>alert('删除失败');location='" + request.getContextPath() + "/QueryAdminServlet';</script>");
			}
		}else{
			List<Admin> adminlist = adminmodel.queryOneAdmin(admin);
			if(adminlist != null){
				request.setAttribute("adminlist", adminlist);
				request.getRequestDispatcher("/Admin/add_admin.jsp").forward(request, response);
			}
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
