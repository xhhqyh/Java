<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* 处理后台登录数据 */
	//设置编码
	request.setCharacterEncoding("utf-8");
	//接收表单数据
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String str = "1";
	//执行查询语句	
	int result = Apo.selectAdmin(username, password);
	
	if(result == 1){%>
		<% 
			session.setAttribute("username", username); 
			session.setAttribute("AdminId", str); 
			request.setAttribute("error_msg", null);
		%>
		<script>alert('欢迎超级管理员:<%=username %>登录'),location='./manage.jsp'</script>
	<% }else{
			request.setAttribute("error_msg", "*您的帐号或密码有误！！！");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
 } %>
	































</body>
</html>