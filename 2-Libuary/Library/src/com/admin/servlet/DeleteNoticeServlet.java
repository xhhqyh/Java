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

@WebServlet("/DeleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NoticeModel noticemodel = new NoticeModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String bbsid = request.getParameter("bbsid");
		//�ѻ�ȡ��idת����int����
		int tid = Integer.valueOf(bbsid);
		
		Notice notice = new Notice();
		notice.setBbsid(tid);
		
		int i = noticemodel.deleteNotice(notice);
		
		if(i>0){
			out.write("<script>alert('ɾ���ɹ�');location='" + request.getContextPath() + "/QueryNoticeServlet';</script>");
		}else{
			out.write("<script>alert('ɾ��ʧ��');location='" + request.getContextPath() + "/QueryNoticeServlet';</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
