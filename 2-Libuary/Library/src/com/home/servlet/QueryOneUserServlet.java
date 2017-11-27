package com.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.UserModel;
import com.common.entiy.User;

@WebServlet("/QueryOneUserServlet")
public class QueryOneUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserModel usermodel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		System.out.println("queryoneservlet"+username);
		
		User user = new User();
		user.setUsername(username);
		
		//取得类型集合
		List<User> userLists = usermodel.queryOneUserInfo(user);
		
		for(User u : userLists){
			System.out.println(u.getUsername());
		}
		
		if(userLists != null){
			request.setAttribute("userLists", userLists);
			request.getRequestDispatcher("/Home/user.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
