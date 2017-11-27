<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/register_login.css"/>
	</head>
	<body>
		<div class="main">
			<!--顶部-->
			<div class="top">
				<p>欢迎登录藏书阁</p>
			</div>
			
			<!--注册-->
			<div id="zhuce">
				<form action="${pageContext.request.contextPath}/CheckUserLoginServlet" method="post" onSubmit="return check();">
					<h3 class="set-h3">用户登录</h3>
					<p class="p1"><span>用户名：</span><input type="text" name="username" class="width-250" required aria-required="true" id="user-name" placeholder="请输入用户名" value="" onblur="checkUserName()"/>&nbsp;<span id="nameInfo"></span></p>
					<p><span>密&nbsp;码：</span><input type="password" name="password" class="width-250" required aria-required="true" id="password" placeholder="请输入密码" value="" onblur="checkPassword()"/>&nbsp;<span id="passwordInfo"></span></p>
					<p><input type="submit" name="" id="" class="submit" value="登录" />
					<input type="reset" name="" id="" class="submit" value="重置" /></p>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Public/Js/Login_Admin.js"></script>
</html>













