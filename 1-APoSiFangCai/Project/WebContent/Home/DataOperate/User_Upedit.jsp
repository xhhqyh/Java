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

//接收session值
String name = (String)session.getAttribute("name");
String Mem_Id = (String)session.getAttribute("Mem_Id");

//获取注册表单数据
String zhuce_name = request.getParameter("zhuce_name");
String zhuce_pass = request.getParameter("zhuce_pass");
String zhuce_repass = request.getParameter("zhuce_repass");
String TrueName = request.getParameter("TrueName");
String zhuce_sex = request.getParameter("zhuce_sex");
String Birthday = request.getParameter("Birthday");
String Address = request.getParameter("Address");
String Tel = request.getParameter("Tel");
String Email = request.getParameter("Email");

//1、判断密码是否相等
if(zhuce_pass.equals(zhuce_repass)){
	//判断用户名是否注册过
	if(!zhuce_name.equals(name)){
		int j = ApoHome.check(zhuce_name);
		//2、判断用户名是否被注册
		if(j == 1){%>
			<script>alert('此用户名已经被注册，请重新输入!'),location='../User_Edit.jsp'</script>
		<%}else{
			//调用注册方法
			int i = ApoHome.User_Update(zhuce_name, zhuce_pass, TrueName, zhuce_sex, Birthday, Address, Tel, Email);
			
			//3、判断是否注册成功
			if(i == 1){%>
				<script>location='../User.jsp'</script>
			<%}else{%>	
				<script>alert('修改失败!'),location='../User_Edit.jsp'</script>
			<%} 
			
			
		}
		
	}else{
		//调用修改方法
		int i = ApoHome.User_Update(zhuce_name, zhuce_pass, TrueName, zhuce_sex, Birthday, Address, Tel, Email);
			//3、判断是否注册成功
			if(i == 1){%>
				<script>alert('修改成功!'),location='../User.jsp'</script>
			<%}else{%>	
				<script>alert('修改失败!'),location='../User_Edit.jsp'</script>
			<%}
	}
}else{%>
	<script>alert('两次输入的密码不一样,请重新输入!'),location='../User_Edit.jsp'</script>
<%}%>



