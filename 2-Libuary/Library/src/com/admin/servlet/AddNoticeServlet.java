package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.NoticeModel;
import com.common.entiy.Notice;

@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NoticeModel noticemodel = new NoticeModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡ������
		String bbshead = request.getParameter("bbshead");
		String bbstext = request.getParameter("bbstext");
		
		//���ݷ�װ
		Notice notice = new Notice();
		notice.setBbshead(bbshead);
		notice.setBbstext(bbstext);
		
		//ִ����ӹ��淽��
		int i = noticemodel.addNotice(notice);
		if(i>0){
			out.write("<script>alert('��ӳɹ�');location='" + request.getContextPath() + "/Admin/add_notice.jsp';</script>");
		}else{
			out.write("<script>alert('���ʧ��');location='" + request.getContextPath() + "/Admin/add_notice.jsp';</script>");
		}
	}
	
}


















