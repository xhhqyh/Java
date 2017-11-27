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

@WebServlet("/EditNoticeServlet")
public class EditNoticeServlet extends HttpServlet {
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
		
		//获取表单数据
		String bbshead = request.getParameter("bbshead");
		String bbstext = request.getParameter("bbstext");
		String bbsid = request.getParameter("bbsid");
		
		int bbsid2 = Integer.valueOf(bbsid);
		
		//数据封装
		Notice notice = new Notice();
		notice.setBbshead(bbshead);
		notice.setBbstext(bbstext);
		notice.setBbsid(bbsid2);
		
		//执行添加公告方法
		int i = noticemodel.editNotice(notice);
		if(i>0){
			out.write("<script>location='" + request.getContextPath() + "/QueryNoticeServlet';</script>");
		}else{
			out.write("<script>alert('修改失败');location='" + request.getContextPath() + "/QueryNoticeServlet';</script>");
		}
	}
}	
