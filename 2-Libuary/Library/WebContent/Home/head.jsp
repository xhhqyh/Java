<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 顶部 -->
<div class="top">
	<!-- 顶部导航    -->
	<div class="top-leader">
		<div class="top-leader-content">
			<p class="top-p-1">欢迎来到藏书阁</p>
			<ul class="content-ul" id="content-ul">
				<li><a href="${pageContext.request.contextPath}/Home/index">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/QueryCarServlet">购物车</a></li>
				<li><a href="${pageContext.request.contextPath}/QueryOrderServlet">订单管理</a></li>
				<li><a href="${pageContext.request.contextPath}/QueryOneUserServlet">个人中心</a></li>
			</ul>
			
				<c:choose>
					<c:when test="${empty username}">
						<p class="top-p-2">
							<span><a href="${pageContext.request.contextPath}/Home/login.jsp">登录</a></span> |
							<span><a href="${pageContext.request.contextPath}/Home/register.jsp">注册</a></span>
						</p>
					</c:when>
					<c:otherwise>
						<p class="top-p-3">
							<span><img alt="" src="${pageContext.request.contextPath}/${picture }">${username }</span> |
							<span><a href="${pageContext.request.contextPath}/UserOutServlet">退出</a></span>
						</p>
					</c:otherwise>
				</c:choose>
				
			
		</div>
	</div>
</div><!-- 顶部div结束 -->
