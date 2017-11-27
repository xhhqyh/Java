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

@WebServlet("/DeleteBookClassifyServlet")
public class DeleteBookClassifyServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookClassifyModel bookclassifymodel = new BookClassifyModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String typeid = request.getParameter("typeid");
		//把获取的id转化成int类型
		int tid = Integer.valueOf(typeid);
		
		BookClassify bkcl = new BookClassify();
		bkcl.setTypeid(tid);
		
		int i = bookclassifymodel.deleteBookClassifyModel(bkcl);
		
		if(i>0){
			out.write("<script>alert('删除成功');location='" + request.getContextPath() + "/QueryBookClassifyServlet';</script>");
		}else{
			out.write("<script>alert('删除失败');location='" + request.getContextPath() + "/QueryBookClassifyServlet';</script>");
		}
		
		
		
		System.out.println(tid);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}








