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
					<div class="user">
						<!--用户信息-->
						<c:forEach items="${userLists }" var="user">
							<div class="user-1">
								<h3>用户信息</h3>
								<p class="user-p1"><img src="${pageContext.request.contextPath}${user.picture}"/><a href="${pageContext.request.contextPath}/UpdateUserImgServlet?userid=${user.userid }">修改头像</a></p>
								<p class="p1"><span>用户&nbsp;名：${user.username}</span></p>
								<p><span>真实姓名：${user.truename}</span></p>
								<p><span>用户等级：${user.rankname}</span></p>
								<p>
									<span>性&nbsp;&nbsp;别：
										<c:choose>
											<c:when test="${user.sex == '1'}">男</c:when>
											<c:otherwise>女</c:otherwise>
										</c:choose>
									</span>
								</p>
								<p><span>邮政编码：${user.postcode}</span></p>
								<p><span>家庭住址：${user.city}</span></p>
								<p><span>电话号码：${user.phone}</span></p>
								<p><span>电子邮箱：${user.email}</span></p>
								<p><a href="${pageContext.request.contextPath}/UpdateUserServlet?username=${user.username}" class="edit-user">修改信息</a></p>
								
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- 动态加载底部 -->
			<jsp:include page="footer.jsp"/>
		</div>
		
	</body>
</html>
