package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.AdminModel;
import com.common.entiy.Admin;

@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AdminModel adminmodel = new AdminModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡ������
		String AdminName = request.getParameter("AdminName");
		String AdminPass = request.getParameter("AdminPass");
		String admintype = request.getParameter("admintype");
		
		
		//���ݷ�װ
		Admin admin = new Admin();
		admin.setManname(AdminName);
		admin.setManpwd(AdminPass);
		admin.setMantype(admintype);
		
		//ִ����ӹ��淽��
		int i = adminmodel.addAdmin(admin);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryAdminServlet';</script>");
		}else{
			out.write("<script>alert('���ʧ��');location='" + request.getContextPath() + "/QueryAdminServlet';</script>");
		}
	}
}























