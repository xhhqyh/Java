package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.BookClassifyModel;
import com.common.entiy.BookClassify;

@WebServlet("/AddBookQueryClassifyServlet")
public class AddBookQueryClassifyServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookClassifyModel bookclassifymodel = new BookClassifyModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//取得类型集合
		List<BookClassify> bkclList = bookclassifymodel.queryBookClassifyInfo();
		
		if(bkclList != null){
			request.setAttribute("bkclList", bkclList);
			request.getRequestDispatcher("/Admin/add_book.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
