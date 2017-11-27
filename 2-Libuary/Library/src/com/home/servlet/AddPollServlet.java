package com.home.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.PollModel;
import com.common.entiy.Poll;

@WebServlet("/AddPollServlet")
public class AddPollServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PollModel pollmodel = new PollModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		
		//获取表单数据
		String pollname = request.getParameter("poll");
		//数据封装
		Poll poll = new Poll();
		poll.setPollname(pollname);
		
		//取得结果
		int i = pollmodel.addPoll(poll);
		
		if(i>0){
			out.print("<script>alert('投票成功');location='" + request.getContextPath() + "/Home/index';</script>");
		}else{
			out.print("<script>alert('投票失败');location='" + request.getContextPath() + "/Home/index';</script>");
		}
	}
}
