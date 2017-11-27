package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.PollModel;
import com.common.entiy.Poll;

@WebServlet("/QueryPollServlet")
public class QueryPollServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PollModel pollmodel = new PollModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//取得类型集合
		List<Poll> pollList = pollmodel.queryPollInfo();
		
		int num = 0;
		for(Poll p : pollList){
			num += p.getPollnum();
		}
		
		if(pollList != null){
			request.setAttribute("pollList", pollList);
			request.setAttribute("num", num);
			request.getRequestDispatcher("/Admin/poll.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
