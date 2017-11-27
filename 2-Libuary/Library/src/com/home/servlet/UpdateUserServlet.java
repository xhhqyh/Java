package com.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.UserModel;
import com.common.entiy.User;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		System.out.println(username);
		
		User user = new User();
		user.setUsername(username);
		
		//取得类型集合
		List<User> userLists = usermodel.queryOneUserInfo(user);
		
		if(userLists != null){
			request.setAttribute("userLists", userLists);
			request.getRequestDispatcher("/Home/register.jsp").forward(request, response);
		}else{
			System.out.println("空");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
