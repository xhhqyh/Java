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
		//设置编码
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);

		//否则的话检查是否登录
		HttpSession session = request.getSession();
		
		String username = (String )session.getAttribute("username");
		
		if(username == null){
			//如果没有登录就跳转到登录页面或者提示页面
			out.print("<script>alert('您还没有登录,请登录');location='" + request.getContextPath() + "/Home/login.jsp';</script>");
		}else{
			//如果已经登录就放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}




























