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

int i = ApoHome.Car_Del_All(name);

if(i == 1){%>
<script>location='../eatcar.jsp'</script>
<%}else{%>	
<script>alert('删除失败!'),location='../eatcar.jsp'</script>
<%}%>

</body>
</html>