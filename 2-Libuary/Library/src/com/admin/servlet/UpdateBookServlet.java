package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.BookModel;
import com.common.entiy.Book;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookModel bookmodel = new BookModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int bookid = Integer.valueOf(request.getParameter("bookid"));
		
		Book book = new Book();
		book.setBookid(bookid);
		
		List<Book> bookList = bookmodel.checkOneBookModel(book);
		
		if(bookList != null){
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/AddBookQueryClassifyServlet").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
