<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新类别</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/admin_right.css"/>
</head>
<body id="background">
	<div id="main">
		<div id="top">
			<div id="">
				<img src="${pageContext.request.contextPath}/Public/img/admin/left-top-right.gif"/>
			</div>
			<div id="title">
				<p>投票结果查看</p>
			</div>
			<div id="top_body">
				<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
			</div>
		</div>
		
		<div class="center poll">
			<p class="poll-p1">投票结果查看</p>
			<hr />
			
			<c:forEach items="${pollList }" var="poll">
				<div class="poll-1">
					<p class="poll-p2">${poll.pollname }:</p>
					<p class="poll-p3" style="width: ${poll.pollnum*500/num }px;"></p>
					<p class="poll-p2 poll-p4"><fmt:formatNumber type="number" value="${poll.pollnum/num*100 }" pattern="0.00" maxFractionDigits="2"></fmt:formatNumber>%</p>	
				</div>
			</c:forEach>
			
			<div class="poll-ul">
				<ul>
					<c:forEach items="${pollList }" var="poll">
						<li>${poll.pollname }:${poll.pollnum }票</li>
					</c:forEach>
				</ul>
				<p>总票数:${num }票</p>
			</div>
			
		</div>
	</div>
</body>
</html>

