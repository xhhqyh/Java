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

/**
 * @author Administrator
 *	���ͼ�����
 */

@WebServlet("/AddBookClassifyServlet")
public class AddBookClassifyServlet extends HttpServlet{
	
	/**
	 * 
	 */
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
		
		//��ȡ������
		String classifyName = request.getParameter("classifyName");
		//���ݷ�װ
		BookClassify bkcl = new BookClassify();
		bkcl.setTypename(classifyName);
		//ִ�������𷽷�
		int i = bookclassifymodel.addBookClassify(bkcl);
		if(i>0){
			out.write("<script>alert('��ӳɹ�');location='" + request.getContextPath() + "/Admin/leibie.jsp';</script>");
		}else{
			out.write("<script>alert('���ʧ��');location='" + request.getContextPath() + "/Admin/leibie.jsp';</script>");
		}
	}
	
}





























