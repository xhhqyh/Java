<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息展示</title>
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
					<p>用户展示</p>
				</div>
				<div id="top_body">
					<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
			
			
			<div class="center">
				<form action="#" method="post">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px">
						<tr align="center">
							<td colspan="13"><b>用户信息列表</b></td>
						</tr>
						<tr align="center">
							<th height="10%">ID</th>
							<th>用户名</th>
							<th>真实名</th>
							<th>头像</th>
							<th>性别</th>
							<th>用户等级</th>
							<th>邮箱</th>
							<th>电话</th>
							<th>住址</th>
							<th>邮编</th>
							<th>消费金额</th>
							<th>是否冻结</th>
							<th>控制</th>
						</tr>
						<c:forEach items="${userList }" var="user">
							<tr align="center">
								<td>${user.userid }</td>
								<td>${user.username }</td>
								<td>${user.truename }</td>
								<td><img alt="${user.username }" src="${pageContext.request.contextPath}${user.picture }" style="width:30px;height:30px;"></td>
								<td>${user.sex }</td>
								<td>${user.rankname }</td>
								<td>${user.email }</td>
								<td>${user.phone }</td>
								<td>${user.city }</td>
								<td>${user.postcode }</td>
								<td>${user.amount }</td>
								
								<c:choose>
									<c:when test="${user.freeze == 1}">
										<td>已冻结</td>
										<td>
											<a href="${pageContext.request.contextPath}/EditUserfreezeServlet?userid=${user.userid }&freeze=0">解冻</a>
										</td>
									</c:when>
									<c:otherwise>
										<td>未冻结</td>
										<td>
											<a href="${pageContext.request.contextPath}/EditUserfreezeServlet?userid=${user.userid }&freeze=1">冻结</a>
										</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
						<tr align="center">
							<td colspan="13">共【3】页&nbsp;<a href="">[首页]</a>&nbsp;<a href="">[首页]</a></td>
						</tr>
					</table>
				</form>
				
			</div>
		</div>
	</body>
</html>
