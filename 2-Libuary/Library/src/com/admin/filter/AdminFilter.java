package com.admin.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Admin/*")
public class AdminFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) resp;
		PrintWriter out = response.getWriter();
		//设置编码
		String CONTENT_TYPE = "text/html;charset=UTF-8";
		response.setContentType(CONTENT_TYPE);
		
		// 如果是后台登录页面直接放行
		String uri = request.getRequestURI();
		if(uri!=null && uri.contains("login.jsp")){
			chain.doFilter(request, resp);
			return ;
		}
		//否则的话检查是否登录
		HttpSession session = request.getSession();
		
		
		//检测Cookie中是否有用户信息
		String manname = "";
		String manpwd = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>1){
			for(int i=0; i<cookies.length; i++){
				if("manname".equals(cookies[i].getName())){
					manname = cookies[i].getValue();
					session.setAttribute("manname", manname);
				}
				
				if("manpwd".equals(cookies[i].getName())){
					manpwd = cookies[i].getValue();
					session.setAttribute("manpwd", manpwd);
				}
			}
		}
		
		String loginName = (String )session.getAttribute("manname");
		if(loginName == null){
			//如果没有登录就跳转到登录页面或者提示页面
			out.print("<script>alert('您还没有登录,请登录');location='" + request.getContextPath() + "/Admin/login.jsp';</script>");
		}else{
			//如果已经登录就放行
			chain.doFilter(request, resp);
		}
	}

	@Override
	public void destroy() {
	}
}	
