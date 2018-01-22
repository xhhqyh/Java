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
	
	//����ȫ�ֱ���
	int a = 5;     //ÿҳ����������
	int c = 1;     //��ǰҳ��
	int min = 1;   //��ѯ��Сֵ
	int max = 5;   //��ѯ���ֵ

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//�õ�������
		int count = ordermodel.allNum(username);

		//����ֵΪ���ֶ���ҳ
		int b = tool.page(a, count);
		//���ݲ�ͬ�������л�����ͬ��ҳ��
		String flag = request.getParameter("flag");
		
		if(flag == null){
			flag = "first";
		}
		
		if ("first".equals(flag)){                  //��ҳ
			min = 1;
			max = 5;
			c = 1;
		}else if ("shang".equals(flag)  && c > 1){  //��һҳ
			min = min - a;
			max = max - a;
			c = c - 1;
		}else if ("next".equals(flag) && c < b){     //��һҳ
			min = min + a;
			max = max + a;
			c = c + 1;
		}else if ("last".equals(flag)){             //���һҳ
			min = a * (b - 1) + 1;
			max = count;
			c = b;
		}			
		
		List<Order> orderlist = ordermodel.queryOneUserOrderInfo(min, max, username);
		if(orderlist != null){
			request.setAttribute("orderlist", orderlist);
			//��¼������ҳ
			request.setAttribute("count", b);
			//��¼�ڼ�ҳ
			request.setAttribute("c", c);
			request.getRequestDispatcher("/Home/order.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
