<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新公告</title>
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
				<c:choose>
					<c:when test="${empty noticeList}">
						<p>添加公告</p>
					</c:when>
					<c:otherwise>
						<p>修改公告</p>
					</c:otherwise>
				</c:choose>
				
			</div>
			<div id="top_body">
				<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
			</div>
		</div>
		
		<c:choose>
			<c:when test="${empty noticeList}">
				<div class="center">
					<form action="${pageContext.request.contextPath}/AddNoticeServlet" method="post">
						<table align="center" cellpadding="0" cellspacing="0" width="500px" height="300px">
							<tr>
								<td>标题:</td>
								<td><input type="text" name="bbshead" id="" value="" /></td>
							</tr>
							<tr>
								<td>内容:</td>
								<td><textarea name="bbstext" rows="10" cols="50"></textarea></td>
							</tr>
							<tr align="center">
								<td colspan="2" ><input type="submit" name="" class="leibie" id="" value="提交" /></td>
							</tr>
						</table>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="center">
					<form action="${pageContext.request.contextPath}/EditNoticeServlet" method="post">
						<table align="center" cellpadding="0" cellspacing="0" width="500px" height="300px">
							<c:forEach items="${noticeList }" var="notice">
								<tr>
									<td>标题:</td>
									<td>
										<input type="text" name="bbshead" id="" value="${notice.bbshead }" />
										<input type="hidden" name="bbsid" value="${notice.bbsid }">
									</td>
								</tr>
								<tr>
									<td>内容:</td>
									<td><textarea name="bbstext" rows="10" cols="50">${notice.bbstext }</textarea></td>
								</tr>
							</c:forEach>
							<tr align="center">
								<td colspan="2" ><input type="submit" name="" class="leibie" id="" value="提交" /></td>
							</tr>
						</table>
					</form>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
















