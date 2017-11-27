<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>左边菜单栏</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="../Public/css/admin_menu.css"/>
</head>
<body id="background">
	<div id="menu">
		<ul>
			<li class="menu-top"><b>图书管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/AddBookQueryClassifyServlet" target="right">发布新书</a></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryBookServlet" target="right">查看图书</a></li>
				</ul>
			</li>
			<li class="menu-top"><b>图书类别管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="leibie.jsp" target="right">添加新类别</a></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryBookClassifyServlet" target="right">图书类别列表</a></li>
				</ul>
			</li>
			<li class="menu-top"><b>公告管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="add_notice.jsp" target="right">添加新公告</a></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryNoticeServlet" target="right">公告信息列表</a></li>
				</ul>
			</li>
			<li class="menu-top"><b>投票管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryPollServlet" target="right">查看投票结果</a></li>
				</ul>
			</li>
			<li class="menu-top"><b>销售订单管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryOrderAdminServlet" target="right">销售订单信息列表</a></li>
				</ul>
			</li>
			<li class="menu-top"><b>用户管理</b>
				<ul>
					<li class="menu-img"><img src="../Public/img/admin/menu_topline.gif"/></li>
					<li class="menu-li"><a href="${pageContext.request.contextPath}/QueryUserServlet" target="right">用户信息列表</a></li>
				</ul>
			</li>
			<c:if test="${mantype == '超级管理员' }">
				<li class="menu-top">
					<a href="${pageContext.request.contextPath}/QueryAdminServlet" target="right"><b>系统用户管理</b></a>
				</li>
			</c:if>
			
		</ul>
	</div>
</body>
</html>
