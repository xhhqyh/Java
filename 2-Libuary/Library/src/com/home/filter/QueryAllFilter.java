package com.home.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QueryAllFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter doFilter...");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) res;
		PrintWriter out = response.getWriter();
		//���ñ���
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);

		//����Ļ�����Ƿ��¼
		HttpSession session = request.getSession();
		
		String username = (String )session.getAttribute("username");
		
		if(username == null){
			//���û�е�¼����ת����¼ҳ�������ʾҳ��
			out.print("<script>alert('����û�е�¼,���¼');location='" + request.getContextPath() + "/Home/login.jsp';</script>");
		}else{
			//����Ѿ���¼�ͷ���
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}




























