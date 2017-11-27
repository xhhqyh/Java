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

//通过session接收当前登录的用户信息
String name = (String)session.getAttribute("name");
String Mem_Id = (String)session.getAttribute("Mem_Id");

//接收点击加入餐车后的提交信息
String Menu_Name = request.getParameter("Menu_Name");
String Menu_memberPrice = request.getParameter("Menu_memberPrice");


int i = ApoHome.Add_Car(name,Menu_Name,Menu_memberPrice);

if(i == 2){%>
	<script>alert('您还没有登录!'),location='../index.jsp#center-top'</script>
<%}else if(i == 1){%>
<script>location='../index.jsp#center-top'</script>
<%}else{%>	
<script>alert('添加失败!'),location='../index.jsp'</script>
<%} %>
	
</body>
</html>