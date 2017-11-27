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
import com.admin.model.OrderModel;
import com.admin.model.UserModel;
import com.common.entiy.Car;
import com.common.entiy.Order;
import com.common.entiy.User;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CarModel carmodel = new CarModel();
	private static UserModel usermodel = new UserModel();
	private static OrderModel ordermodel = new OrderModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		User user = new User();
		user.setUsername(username);
		//根据用户名查询用户信息
		List<User> userlist = usermodel.queryOneUserInfo(user);
		//用order类型对象封装数据
		Order order = new Order();
		for(User u:userlist){
			order.setUsername(u.getUsername());
			order.setTruename(u.getTruename());
			order.setPostcode(u.getPostcode());
			order.setAddress(u.getCity());
			order.setPhone(u.getPhone());
			order.setEmail(u.getEmail());
		}
		
		//执行加入订单表,返回该订单号orderid
		int orderid = ordermodel.addOrderUserInfo(order);
		
		//根据用户名查询该用户下的所有购物车信息
		List<Car> carlist = carmodel.queryOneUserCarInfo(username);
		
		int i = 0;
		Order order2 = new Order();
		for(Car c : carlist){
			order2.setOrderid(orderid);
			order2.setBookid(c.getBookid());
			order2.setPrice(c.getPrice());
			order2.setNumber(c.getNum());
			
			//执行添加到订单详细表中
			i = ordermodel.addOrderDetial(order2);
		}
		
		if(i>0){
			//根据用户名,拿到用户id
			int userid = usermodel.queryUserId(username);
			Car car = new Car();
			car.setUserid(userid);
			i = carmodel.deleteUserCarInfo(car);
		}
		
		if(i>0){
			response.sendRedirect(request.getContextPath() + "/QueryOrderServlet");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	} 
}
