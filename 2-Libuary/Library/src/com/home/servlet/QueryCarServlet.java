package com.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.CarModel;
import com.common.entiy.Car;

@WebServlet("/QueryCarServlet")
public class QueryCarServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CarModel carmodel = new CarModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		List<Car> carList = null;
		//遍历购物车数据
		double money = 0;
		int number = 0;
		if(username != null){
			System.out.println("执行3");
			//获取购物车数据
			carList = carmodel.queryCarInfo(username);
			for(Car car : carList){
				money +=car.getPrice()*car.getNum();
				number += car.getNum();
			}
		}
		
		if(carList != null){
			//记录购物车数据
			System.out.println("执行4");
			request.setAttribute("carList", carList);
			request.setAttribute("money", money);
			request.setAttribute("number", number);
			System.out.println("执行5");
			request.getRequestDispatcher("/Home/car.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Home/car.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
