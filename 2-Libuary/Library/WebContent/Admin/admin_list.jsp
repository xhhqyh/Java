<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会员管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/admin_right.css"/>
</head>
<body id="background" >
	<div id="main">
		<div id="top">
			<div id="">
				<img src="${pageContext.request.contextPath}/Public/img/admin/left-top-right.gif"/>
			</div>
			<div id="title">
				<p>系统用户管理</p>
			</div>
			<div id="top_body">
				<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
			</div>
		</div>
		
		<div class="center">
			<form action="upmember.jsp" method="post">
				<table border="1" align="center" cellpadding="0" cellspacing="0" width="800px">
					<tr align="center" height="30px">
						<td colspan="11"><b>系统用户管理</b>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/Admin/add_admin.jsp">增加</a></td>
					</tr>		
					<tr>
						<th>用户ID</th>
						<th>用户名</th>
						<th>密码</th>
						<th>类型</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
					
					<c:forEach items="${adminList }" var="admin">
						<tr align="center">
					 		<td>${admin.manid }</td>
							<td>${admin.manname }</td>
							<td>${admin.manpwd }</td>
							<td>${admin.mantype }</td>
		     				<td><a href ="${pageContext.request.contextPath}/UpdateAdminServlet?manid=${admin.manid }&flag=edit" >修改</a></td>
							<td>
								<c:choose>
									<c:when test="${admin.mantype == '超级管理员' }">-</c:when>
									<c:otherwise>
										<a href = "javascript:if(confirm('确实要删除吗?'))location='${pageContext.request.contextPath}/UpdateAdminServlet?manid=${admin.manid }&flag=delete'" >删除</a>
									</c:otherwise>
								</c:choose>
							</td>
					 	</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>		
</html>