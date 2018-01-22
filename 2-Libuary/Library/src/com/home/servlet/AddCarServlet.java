package com.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.BookModel;
import com.admin.model.CarModel;
import com.admin.model.UserModel;
import com.common.entiy.Book;
import com.common.entiy.Car;

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();
	private static BookModel bookmodel = new BookModel();
	private static CarModel carmodel = new CarModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		//��ȡ����
		int bookid = Integer.valueOf(request.getParameter("bookid"));
		//��ȡ�û���
		String username = (String) session.getAttribute("username");
		
		//�����û�����ѯ�û�userid 
		int userid = usermodel.queryUserId(username);
		
		//����ͼ��bookid��ȡͼ��۸��ͼ����
		Book book = new Book();
		book.setBookid(bookid);
		List<Book> bookList = bookmodel.checkOneBookModel(book);
		
		String bookname = "";
		double price = 0;
		for(Book b:bookList){
			bookname = b.getBookname();
			price = b.getPrice();
		}
		
		//���ݷ�װ
		Car car = new Car();
		car.setBookid(bookid);
		car.setUserid(userid);
		car.setPrice(price);
		car.setBookname(bookname);
		
		//��ѯ��ͼ���Ƿ����,��������,��ִ�м�һ����
		Car car2 = carmodel.queryOneCar(car);
		int i = 0;
		if(car2.getNum()>0){
			i = carmodel.addOneNumCar(car);
		}else{
			i = carmodel.addCar(car);
		}
		
		if(i>0){
			response.sendRedirect(request.getContextPath() + "/Home/index");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}

















