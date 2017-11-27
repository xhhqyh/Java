<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>公告列表</title>
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
					<p>公告展示</p>
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
							<td colspan="12"><b>公告信息列表</b></td>
						</tr>
						<tr>
							<th height="10%">ID</th>
							<th>标题</th>
							<th>内容</th>
							<th>时间</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
						<c:forEach items="${noticeList }" var="notice">
							<tr align="center">
								<td>${notice.bbsid }</td>
								<td>${notice.bbshead }</td>
								<td>${notice.bbstext }</td>
								<td>${notice.intime }</td>
								<td><a href="${pageContext.request.contextPath}/UpdateNoticeServlet?bbsid=${notice.bbsid }">修改</a></td>
								<td><a href="javascript:if(confirm('确实要删除吗?'))location='${pageContext.request.contextPath}/DeleteNoticeServlet?bbsid=${notice.bbsid }'">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
