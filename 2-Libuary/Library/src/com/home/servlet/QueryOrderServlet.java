package com.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.OrderModel;
import com.common.entiy.Order;
import com.common.utils.Tool;

@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Tool tool = new Tool();
	private static OrderModel ordermodel = new OrderModel();
	
	//定义全局变量
	int a = 5;     //每页多少条数据
	int c = 1;     //当前页数
	int min = 1;   //查询最小值
	int max = 5;   //查询最大值

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//得到总行数
		int count = ordermodel.allNum(username);

		//返回值为共分多少页
		int b = tool.page(a, count);
		//根据不同的请求切换到不同的页面
		String flag = request.getParameter("flag");
		
		if(flag == null){
			flag = "first";
		}
		
		if ("first".equals(flag)){                  //首页
			min = 1;
			max = 5;
			c = 1;
		}else if ("shang".equals(flag)  && c > 1){  //上一页
			min = min - a;
			max = max - a;
			c = c - 1;
		}else if ("next".equals(flag) && c < b){     //下一页
			min = min + a;
			max = max + a;
			c = c + 1;
		}else if ("last".equals(flag)){             //最后一页
			min = a * (b - 1) + 1;
			max = count;
			c = b;
		}			
		
		List<Order> orderlist = ordermodel.queryOneUserOrderInfo(min, max, username);
		if(orderlist != null){
			request.setAttribute("orderlist", orderlist);
			//记录共多少页
			request.setAttribute("count", b);
			//记录第几页
			request.setAttribute("c", c);
			request.getRequestDispatcher("/Home/order.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
