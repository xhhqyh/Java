<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>顶部</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="../Public/css/top.css"/>
</head>
<body>
<% 
	//权限验证
	String username = (String)session.getAttribute("username");
	String AdminId = (String)session.getAttribute("AdminId");
	if(AdminId == null && username == null){%>
		<script>alert('您还没有登录，请登录!'),location='./login.html'</script>
	<%}%>

	<div id="main">
		<div id="main-img">
			<img src="../Public/img/admin/logo.gif"/>
		</div>
		<div id="main-p">
			<p>管理员：<%=username %>您好，欢迎使用本后台管理系统</p>
		</div>
		<div id="out">
			<a href="Exit.jsp" target="_top"><img src="../Public/img/admin/out.gif"/></a>
		</div>
	</div>
</body>
</html>
