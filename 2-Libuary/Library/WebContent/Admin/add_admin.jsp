<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加管理员</title>
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
					<p>添加管理员</p>
				</c:when>
				<c:otherwise>
					<p>修改管理员</p>
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
		<c:when test="${empty adminlist}">
			<div class="center">
				<form action="${pageContext.request.contextPath}/AddAdminServlet" method="post" onSubmit="return check();">
					<table border="1" cellpadding="0" cellspacing="0" width="800px" height="400px">
						<tr>
							<td width="100px">用户名:</td>
							<td><input type="text" name="AdminName" required aria-required="true" id="user-name" placeholder="请输入用户名" value="" onblur="checkUserName()"/>&nbsp;<span id="nameInfo"></span></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" name="AdminPass" required aria-required="true" id="password" placeholder="请输入密码" value="" onblur="checkPassword()"/>&nbsp;<span id="passwordInfo"></span></td>
						</tr>
						<tr>
							<td>重复密码:</td>
							<td><input type="password" name="ReAdminPass" required aria-required="true" id="repassword" placeholder="请重复输入密码" value=""  onblur="checkRepassword()" />&nbsp;<span id="repasswordInfo"></span></td>
						</tr>
						<tr>
							<td>会员类型:</td>
							<td>
								<input type="radio" name="admintype" value="内容管理员" checked="checked" />内容管理员
								<input type="radio" name="admintype" value="会员管理员" />会员管理员
							</td>
						</tr>
						
						<tr>
							<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
						</tr>
					</table>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div class="center">
				<form action="${pageContext.request.contextPath}/EditAdminServlet" method="post" onSubmit="return check();">
					<table border="1" cellpadding="0" cellspacing="0" width="800px" height="400px">
						<tr>
							<td width="100px">用户名:</td>
							<td><input type="text" name="AdminName" required aria-required="true" id="user-name" placeholder="请输入用户名" value="${adminlist[0].manname }" onblur="checkUserName()"/>&nbsp;<span id="nameInfo"></span></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="text" name="AdminPass" required aria-required="true" id="password" placeholder="请输入密码" value="${adminlist[0].manpwd }" onblur="checkPassword()"/>&nbsp;<span id="passwordInfo"></span></td>
						</tr>
						<tr>
							<td>重复密码:</td>
							<td><input type="text" name="ReAdminPass" required aria-required="true" id="repassword" placeholder="请重复输入密码" value="${adminlist[0].manpwd }"  onblur="checkRepassword()" />&nbsp;<span id="repasswordInfo"></span></td>
						</tr>
						<tr>
							<td>会员类型:</td>
							<td>
								<input type="radio" name="admintype" value="内容管理员" <c:if test="${adminlist[0].mantype == '内容管理员' }"> checked="checked"</c:if> />内容管理员
								<input type="radio" name="admintype" value="会员管理员" <c:if test="${adminlist[0].mantype == '会员管理员' }"> checked="checked"</c:if> />会员管理员
							</td>
						</tr>
							<input type="hidden" name="manid" value="${adminlist[0].manid }" />
						<tr>
							<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
						</tr>
					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	
	
	
</div>
</body>
<script type="text/javascript" src="../Public/Js/Add_Admin.js"></script>
</html>
