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
 * ��¼����
 */
@WebFilter("*.jsp")
public class LoginExamine extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) req ;
		
		// ����Ǻ�̨��¼ҳ��ֱ�ӷ���
		String uri = request.getRequestURI();
		if(uri!=null && uri.contains("login")){
			chain.doFilter(request, resp);
			return ;
		}
		
		//����Ļ�����Ƿ��¼
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");//��session��ȡ��ǰ��¼����Ա��Ϣ
		
		if(username == null){
			//���û�е�¼����ת����¼ҳ�������ʾҳ��
			HttpServletResponse response = (HttpServletResponse) resp;
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//����Ѿ���¼�ͷ���
			chain.doFilter(request, resp);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
