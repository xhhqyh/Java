package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.BookModel;
import com.common.entiy.Book;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookModel bookmodel = new BookModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String isbn = request.getParameter("isbn");
		
		Book book = new Book();
		book.setIsbn(isbn);
		int i = bookmodel.deleteBookModel(book);
		
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryBookServlet';</script>");
		}else{
			out.write("<script>alert('É¾³ýÊ§°Ü');location='" + request.getContextPath() + "/QueryBookServlet';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
