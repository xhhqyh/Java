<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>顶部</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/top.css"/>
	</head>
	<body>
		<div id="main">
			<div id="main-img">
				<img src="${pageContext.request.contextPath}/Public/img/admin/logo.gif"/>
			</div>
			<div id="main-p">
				<p>管理员：${manname }您好，欢迎使用本后台管理系统</p>
			</div>
			<div id="out">
				<a href="${pageContext.request.contextPath}/Home/index" target="_blank"><span style="color:#FFF;font-size:14px;margin-right:200px;">站点首页</span></a>
				<a href="${pageContext.request.contextPath}/AdminOutServlet" target="_top"><img src="${pageContext.request.contextPath}/Public/img/admin/out.gif"/></a>
			</div>
		</div>
	</body>
</html>
