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
String Menu_Name = request.getParameter("DishName");

int i = ApoHome.Car_Del_One(name,Menu_Name);

if(i == 2){%>
	<script>alert('没有该菜品信息!!!'),location='../eatcar.jsp'</script>
<%}if(i == 1){%>
<script>location='../eatcar.jsp'</script>
<%}else{%>	
<script>alert('删除失败!'),location='../eatcar.jsp'</script>
<%} %>


</body>
</html>