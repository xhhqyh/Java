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
	
	//����ȫ�ֱ���
	int a = 5;     //ÿҳ����������
	int c = 1;     //��ǰҳ��
	int min = 1;   //��ѯ��Сֵ
	int max = 5;   //��ѯ���ֵ

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		//�õ�������
		int count = bookmodel.allNum();
		//����ֵΪ���ֶ���ҳ
		int b = tool.page(a, count);
		//���ݲ�ͬ�������л�����ͬ��ҳ��
		String flag = request.getParameter("flag");
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
		//ȡ�����ͼ���
		List<Book> bookList = bookmodel.queryBookInfo(min, max);
		
		if(bookList != null){
			request.setAttribute("bookList", bookList);
			//��¼������ҳ
			request.setAttribute("count", b);
			//��¼�ڼ�ҳ
			request.setAttribute("c", c);
			request.getRequestDispatcher("/Admin/book_list.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
