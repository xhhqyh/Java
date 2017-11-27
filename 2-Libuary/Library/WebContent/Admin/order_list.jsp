<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加新菜单</title>
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
					<p>订单展示</p>
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
							<td colspan="12"><b>订单信息列表</b></td>
						</tr>
						<tr align="center">
							<th height="10%">订单号</th>
							<th>用户名</th>
							<th>订购电话</th>
							<th>派送地址</th>
							<th>合计(元)</th>
							<th>订购时间</th>
							<th>订单状态</th>
							<th>执行</th>
						</tr>
						<c:forEach items="${orderlist }" var="order">
							<tr align="center">
								<td>${order.orderid }</td>
								<td>${order.username }</td>
								<td>${order.phone }</td>
								<td>${order.address }</td>
								<td>${order.money }</td>
								<td>${order.orderdate }</td>
								<td>
									<c:choose>
										<c:when test="${order.enfore == 1 }">
											<p>已发货</p>
										</c:when>
										<c:otherwise>
											<p>未处理</p>
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test="${order.enfore == 0 }">
											<p><a href="${pageContext.request.contextPath}/EditOrderStatusServlet?orderid=${order.orderid}">执行</a></p>
										</c:when>
										<c:otherwise>
											<p>-</p>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						<tr align="center">
							<td colspan="12">
								共${count }页&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/QueryOrderAdminServlet?flag=first">[首页]</a>&nbsp;
								<a href="${pageContext.request.contextPath}/QueryOrderAdminServlet?flag=shang">[上一页]</a>&nbsp;第${c }页&nbsp;
								<a href="${pageContext.request.contextPath}/QueryOrderAdminServlet?flag=next">[下一页]</a>&nbsp;
								<a href="${pageContext.request.contextPath}/QueryOrderAdminServlet?flag=last">[尾页]</a>
										
							</td>
						</tr>
					</table>
				</form>
				
			</div>
		</div>
	</body>
</html>
