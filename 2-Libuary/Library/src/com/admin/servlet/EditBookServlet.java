package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.admin.model.BookModel;
import com.common.entiy.Book;

@WebServlet("/EditBookServlet")
@MultipartConfig
public class EditBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookModel bookmodel = new BookModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//接收表单数据
		String isbn = request.getParameter("isbn");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		String writer = request.getParameter("writer");
		String introduce = request.getParameter("introduce");
		String price = request.getParameter("price");
		String booktype = request.getParameter("booktype");
		String newbook = request.getParameter("newbook");
		String command = request.getParameter("recommend");
		String bookid = request.getParameter("bookid");
		
		Part part = request.getPart("picture");
		String img = "" ;
		if(part!=null && part.getSize()>0){
			String fileName = part.getSubmittedFileName();
			String path = getServletContext().getRealPath("/Public/dishimg")+File.separator+fileName;
			part.write(path);
			img = "/Public/dishimg/"+fileName ;
			//System.out.println(path+"-------");
		}
		
		int price2 = Integer.valueOf(price);
		int booktype2 = Integer.valueOf(booktype);
		int command2 = Integer.valueOf(command);
		int newbook2 = Integer.valueOf(newbook);
		int bookid2 = Integer.valueOf(bookid);

		//数据封装
		Book book = new Book();
		book.setBookid(bookid2);
		book.setIsbn(isbn);
		book.setBookname(bookname);
		book.setPublisher(publisher);
		book.setWriter(writer);
		book.setIntroduce(introduce);
		book.setPrice(price2);
		book.setTypeid(booktype2);
		book.setCommand(command2);
		book.setNewbook(newbook2);
		book.setPicture(img);
		
		int i = bookmodel.editBook(book);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryBookServlet';</script>");
		}else{
			out.write("<script>alert('修改失败');location='" + request.getContextPath() + "/QueryBookServlet';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
