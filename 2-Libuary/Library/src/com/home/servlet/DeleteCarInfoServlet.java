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

@WebServlet("/DeleteCarInfoServlet")
public class DeleteCarInfoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();
	private static CarModel carmodel = new CarModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		//获取用户名
		String username = (String) session.getAttribute("username");
		
		//根据用户名查询用户userid 
		int userid = usermodel.queryUserId(username);
		
		Car car = new Car();
		car.setUserid(userid);
		
		//删除该用户下的所有数据
		int i = carmodel.deleteUserCarInfo(car);
		
		if(i>0){
			response.sendRedirect(request.getContextPath() + "/Home/car.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
