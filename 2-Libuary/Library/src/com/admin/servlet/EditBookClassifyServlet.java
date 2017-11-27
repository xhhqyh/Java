package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.BookClassifyModel;
import com.common.entiy.BookClassify;

@WebServlet("/EditBookClassifyServlet")
public class EditBookClassifyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static BookClassifyModel bookclassifymodel = new BookClassifyModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String classifyName = request.getParameter("classifyName");
		String typeid = request.getParameter("typeid");
		
		int bcid = Integer.valueOf(typeid);
		
		BookClassify bkcl = new BookClassify();
		bkcl.setTypename(classifyName);
		bkcl.setTypeid(bcid);
		
		int i = bookclassifymodel.editBookClassify(bkcl);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryBookClassifyServlet';</script>");
		}else{
			out.write("<script>alert('ÐÞ¸ÄÊ§°Ü');location='" + request.getContextPath() + "/QueryBookClassifyServlet';</script>");
		}
	}
}
