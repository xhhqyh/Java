package com.shoe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoe.pojo.Manager;
/**
 * add by wyh 2018-1-22
 * @author wyh
 * 登录拦截
 */
@WebFilter("*.jsp")
public class LoginExamine extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) req ;
		
		// 如果是后台登录页面直接放行
		String uri = request.getRequestURI();
		if(uri!=null && uri.contains("login")){
			chain.doFilter(request, resp);
			return ;
		}
		
		//否则的话检查是否登录
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");//从session获取当前登录管理员信息
		
		if(username == null){
			//如果没有登录就跳转到登录页面或者提示页面
			HttpServletResponse response = (HttpServletResponse) resp;
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//如果已经登录就放行
			chain.doFilter(request, resp);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
