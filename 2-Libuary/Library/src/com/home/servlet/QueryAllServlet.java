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
	
	//����ȫ�ֱ���
	int a = 10;     //ÿҳ����������
	int c = 1;     //��ǰҳ��
	int min = 1;   //��ѯ��Сֵ
	int max = 10;   //��ѯ���ֵ

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//ȡ�ù��漯��
		List<Notice> noticeList = noticemodel.queryNoticeInfo();
		
		//ȡ�������͵ļ���
		List<BookClassify> bookclass = bookclassifymodel.queryBookClassifyInfo();
		
		//����һ��Book���͵ļ���
		List<Book> bookList = new ArrayList<Book>();
		//ȡ�����а�bookid����
		List<Order> orderlist = ordermodel.queryBooidMax();
		for(Order o : orderlist){
			Book b = bookmodel.checkOneBookInfo(o.getBookid());
			b.setNum(o.getNumber());
			bookList.add(b);
		}
		
		/*
		 * ȡ�������鼯��
		 * */
		//�õ�������
		int count = bookmodel.allNum();
		
		
		//����ֵΪ���ֶ���ҳ
		int b = tool.page(a, count);
		//���ݲ�ͬ�������л�����ͬ��ҳ��
		String flag = request.getParameter("flag");
		
		if(flag == null){
			flag = "first";
		}
		
		if ("first".equals(flag)){                  //��ҳ
			min = 1;
			max = 10;
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
			
		List<Book> bookLists = bookmodel.queryBookInfo(min, max);
		//ȡ�����鼯��
		List<Book> newbook = bookmodel.queryNewBook();
		
		List<Car> carList = null;
		//�������ﳵ����
		double money = 0;
		int number = 0;
		if(username != null){
			//��ȡ���ﳵ����
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
			
			//��¼���ﳵ����
			request.setAttribute("carList", carList);
			request.setAttribute("money", money);
			request.setAttribute("number", number);
			
			request.setAttribute("newbook", newbook);
			//��¼������ҳ
			request.setAttribute("count", b);
			//��¼�ڼ�ҳ
			request.setAttribute("c", c);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/Home/index.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
