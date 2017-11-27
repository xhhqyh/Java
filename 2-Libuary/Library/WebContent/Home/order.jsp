<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>订单管理页面</title>
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
					<div class="booklist2">
						<div id="table-order">
		
							<table border="1" class="table-2" cellspacing="0" width="1000px">
								<tr>
									<td colspan="10">订单查询结果信息列表</td>
								</tr>
								<tr>
									<td width="40px">订单号</td>
									<td width="40px">用户名</td>
									<td width="40px">订购电话</td>
									<td width="80px">派送地址</td>
									<td width="40px">合计(元)</td>
									<td width="150px">订购时间</td>
									<td width="40px">订单状态</td>
								</tr>
								
								<c:forEach items="${orderlist }" var="order">
									<tr>
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
									</tr>
								</c:forEach>
									<tr height="40px">
										<td colspan="11" align="center">共${count }页&nbsp;&nbsp;
											<a href="${pageContext.request.contextPath}/QueryOrderServlet?flag=first">[首页]</a>&nbsp;
											<a href="${pageContext.request.contextPath}/QueryOrderServlet?flag=shang">[上一页]</a>&nbsp;第${c }页&nbsp;
											<a href="${pageContext.request.contextPath}/QueryOrderServlet?flag=next">[下一页]</a>&nbsp;
											<a href="${pageContext.request.contextPath}/QueryOrderServlet?flag=last">[尾页]</a>
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
