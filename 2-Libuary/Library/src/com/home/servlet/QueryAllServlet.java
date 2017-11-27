package com.home.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.BookClassifyModel;
import com.admin.model.BookModel;
import com.admin.model.CarModel;
import com.admin.model.NoticeModel;
import com.admin.model.OrderModel;
import com.common.entiy.Book;
import com.common.entiy.BookClassify;
import com.common.entiy.Car;
import com.common.entiy.Notice;
import com.common.entiy.Order;
import com.common.utils.Tool;

@WebServlet("/Home/index")
public class QueryAllServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NoticeModel noticemodel = new NoticeModel();
	private static BookModel bookmodel = new BookModel();
	private static Tool tool = new Tool();
	private static CarModel carmodel = new CarModel();
	private static OrderModel ordermodel = new OrderModel();
	private static BookClassifyModel bookclassifymodel = new BookClassifyModel();
	
	//定义全局变量
	int a = 10;     //每页多少条数据
	int c = 1;     //当前页数
	int min = 1;   //查询最小值
	int max = 10;   //查询最大值

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//取得公告集合
		List<Notice> noticeList = noticemodel.queryNoticeInfo();
		
		//取得书类型的集合
		List<BookClassify> bookclass = bookclassifymodel.queryBookClassifyInfo();
		
		//定义一个Book类型的集合
		List<Book> bookList = new ArrayList<Book>();
		//取得排行榜bookid集合
		List<Order> orderlist = ordermodel.queryBooidMax();
		for(Order o : orderlist){
			Book b = bookmodel.checkOneBookInfo(o.getBookid());
			b.setNum(o.getNumber());
			bookList.add(b);
		}
		
		/*
		 * 取得所有书集合
		 * */
		//得到总行数
		int count = bookmodel.allNum();
		
		
		//返回值为共分多少页
		int b = tool.page(a, count);
		//根据不同的请求切换到不同的页面
		String flag = request.getParameter("flag");
		
		if(flag == null){
			flag = "first";
		}
		
		if ("first".equals(flag)){                  //首页
			min = 1;
			max = 10;
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
			
		List<Book> bookLists = bookmodel.queryBookInfo(min, max);
		//取得新书集合
		List<Book> newbook = bookmodel.queryNewBook();
		
		List<Car> carList = null;
		//遍历购物车数据
		double money = 0;
		int number = 0;
		if(username != null){
			//获取购物车数据
			carList = carmodel.queryCarInfo(username);
			for(Car car : carList){
				money +=car.getPrice()*car.getNum();
				number += car.getNum();
			}
		}

		if(noticeList != null){
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("bookLists", bookLists);
			request.setAttribute("bookList", bookList);
			request.setAttribute("bookclass", bookclass);
			
			//记录购物车数据
			request.setAttribute("carList", carList);
			request.setAttribute("money", money);
			request.setAttribute("number", number);
			
			request.setAttribute("newbook", newbook);
			//记录共多少页
			request.setAttribute("count", b);
			//记录第几页
			request.setAttribute("c", c);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/Home/index.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
