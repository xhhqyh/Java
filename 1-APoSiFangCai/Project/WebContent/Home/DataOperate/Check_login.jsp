<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//设置编码
request.setCharacterEncoding("utf-8");
//获取注册表单数据
String username = request.getParameter("username");
String password = request.getParameter("password");

String str = "1";
//执行查询语句	
int result = ApoHome.Check_login(username, password);

if(result == 1){%>
	<% 
	session.setAttribute("name", username); 
	session.setAttribute("Mem_Id", str); 
	%>
	<script>alert('欢迎:<%=username %>登录'),location='../index.jsp'</script>
<% }else{%>
	<script>alert('登录失败，您输入的信息有误,请重新输入!'),location='../login.html'</script>
<% } %>




</body>
</html>