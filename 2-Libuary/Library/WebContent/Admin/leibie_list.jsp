<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图书类别展示</title>
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
				<p>图书类别</p>
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
				<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px" height="200px">
					<tr align="center">
						<td colspan="4"><b>图书类别信息列表</b></td>
					</tr>
					<tr align="center">
						<th height="10%">类别ID</th>
						<th>类别名称</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
					<c:forEach items="${bkclList }" var="classify">
						<tr align="center">
							<td>${classify.typeid }</td>
							<td>${classify.typename }</td>
							<td><a href="${pageContext.request.contextPath}/UpdateBookClassifyServlet?typeid=${classify.typeid }">修改</a></td>
							<td><a href="javascript:if(confirm('确实要删除吗?'))location='${pageContext.request.contextPath}/DeleteBookClassifyServlet?typeid=${classify.typeid }'">删除</a></td>
						</tr>
					</c:forEach>
					
				</table>
			</form>
			
		</div>
	</div>
</body>
</html>
