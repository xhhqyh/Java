package com.home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.CarModel;
import com.admin.model.UserModel;
import com.common.entiy.Car;

@WebServlet("/EditCarServlet")
public class EditCarServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CarModel carmodel = new CarModel();
	private static UserModel usermodel = new UserModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String operate = request.getParameter("operate");
		String bookname = request.getParameter("bookname");
		
		//根据用户名查询用户userid
		int userid = usermodel.queryUserId(username);
		
		Car car = new Car();
		car.setBookname(bookname);
		car.setUserid(userid);
	
		int i = 0;
		if("add".equals(operate)){
			//执行数量加一操作
			i = carmodel.addOneNumCar(car);
		}else{
			//执行数量减一操作,先判断数据库中该书的个数,如果是1就删除
			Car car2 = carmodel.queryOneCar(car);
			if(car2.getNum() == 1){
				i = carmodel.deleteOneBook(car);
			}else{
				i = carmodel.deleteOneNum(car);
			}
		}
		
		System.out.println("执行1");
		if(i>0){
			System.out.println("执行2");
			response.sendRedirect(request.getContextPath() + "/QueryCarServlet");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
