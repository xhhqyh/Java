<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>购物车页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/home_other.css"/>
	</head>
	<body>
		<!-- 主体结构 -->
		<div class="main">
			<!-- 包含顶部 -->
			<jsp:include page="head.jsp"/>
			
			<!--中间部分-->
			<div class="center">
				<div class="content">
					<div class="booklist">
						<div id="table-car">
							<h3>我的购书信息列表</h3>
							<table border="1" cellspacing="0">
								<tr height="50px">
									<td width="25%">菜品名称</td>
									<td width="25%">单价</td>
									<td width="25%">数量</td>
									<td width="25%">操作</td>
								</tr>
								
								<c:forEach items="${carList }" var="car">
									<tr height="25px">
										<td>${car.bookname }</td>
										<td>${car.price }</td>
										<td>${car.num }</td>
										<td>
											<a href="${pageContext.request.contextPath}/EditCarServlet?operate=add&bookname=${car.bookname }"><img src="${pageContext.request.contextPath}/Public/img/home/11.jpg"/></a>
											<a href="${pageContext.request.contextPath}/EditCarServlet?operate=delete&bookname=${car.bookname }"><img src="${pageContext.request.contextPath}/Public/img/home/12.jpg"/></a>
										</td>
									</tr>
								</c:forEach>
								<tr height="30px">
									<td colspan="4">小计：共<c:if test="${empty money}" >0</c:if> ${money }元&nbsp;共：【<c:if test="${empty money}" >0</c:if>${number }】本</td>
								</tr>
								<tr>
									<td colspan="4">
										<a href="${pageContext.request.contextPath}/AddOrderServlet" class="border-1px">买单</a>&nbsp;
										<a href="${pageContext.request.contextPath}/DeleteCarInfoServlet" class="border-1px">全部取消</a>
									</td>
								</tr>
							</table>
						</div>
						
					</div>
				</div>
			</div>
			<!-- 动态加载底部 -->
			<jsp:include page="footer.jsp"/>
		</div>
		
	</body>
</html>
