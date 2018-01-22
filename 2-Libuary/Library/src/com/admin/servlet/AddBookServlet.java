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


@WebServlet("/AddBookServlet")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BookModel bookmodel = new BookModel();
       
    public AddBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("picture");
		String img = "" ;
		if(part!=null && part.getSize()>0){
			String fileName = part.getSubmittedFileName();
			String path = getServletContext().getRealPath("/Public/dishimg")+File.separator+fileName;
			part.write(path);
			img = "/Public/dishimg/"+fileName ;
			System.out.println(path+"-------");
		}

		//���ձ�����
		String isbn = request.getParameter("isbn");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		String writer = request.getParameter("writer");
		String introduce = request.getParameter("introduce");
		String price = request.getParameter("price");
		String booktype = request.getParameter("booktype");
		String newbook = request.getParameter("newbook");
		String command = request.getParameter("recommend");
		
		System.out.println(isbn + " " + bookname + " " + publisher 
				+ "" + writer + ""+ introduce + "" + price + ""+ booktype + "" + newbook + "" + img);
		
		int price2 = Integer.valueOf(price);
		int booktype2 = Integer.valueOf(booktype);
		int command2 = Integer.valueOf(command);
		int newbook2 = Integer.valueOf(newbook);
		
		//���ݷ�װ
		Book book = new Book();
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
		
		//ִ�������𷽷�
		int i = bookmodel.addBook(book);
		if(i>0){
			out.write("<script>alert('��ӳɹ�');location='" + request.getContextPath() + "/AddBookQueryClassifyServlet';</script>");
		}else{
			out.write("<script>alert('���ʧ��');location='" + request.getContextPath() + "/Admin/add_book.jsp';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
