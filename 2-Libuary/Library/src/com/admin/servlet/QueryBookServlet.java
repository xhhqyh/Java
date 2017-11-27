package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.BookModel;
import com.common.entiy.Book;
import com.common.utils.Tool;

@WebServlet("/QueryBookServlet")
public class QueryBookServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookModel bookmodel = new BookModel();
	private static Tool tool = new Tool();
	
	//定义全局变量
	int a = 5;     //每页多少条数据
	int c = 1;     //当前页数
	int min = 1;   //查询最小值
	int max = 5;   //查询最大值

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		//得到总行数
		int count = bookmodel.allNum();
		//返回值为共分多少页
		int b = tool.page(a, count);
		//根据不同的请求切换到不同的页面
		String flag = request.getParameter("flag");
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
		//取得类型集合
		List<Book> bookList = bookmodel.queryBookInfo(min, max);
		
		if(bookList != null){
			request.setAttribute("bookList", bookList);
			//记录共多少页
			request.setAttribute("count", b);
			//记录第几页
			request.setAttribute("c", c);
			request.getRequestDispatcher("/Admin/book_list.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
