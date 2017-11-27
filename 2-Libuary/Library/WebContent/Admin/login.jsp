<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登录页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/admin_style.css"/>
	</head>
	<body>
		<!--主体框架-->
		<div id="main">
			<div id="top">
				
			</div>
			<div id="center">
				<div id="center-left">
					<div id="left">
						<img class="left-img1" src="${pageContext.request.contextPath}/Public/img/admin/banner.jpg"/>
					</div>
				</div>
				
				<div id="center-right">
					<div id="right">
						<h4>藏书阁后台管理</h4>
						<form action="${pageContext.request.contextPath}/CheckAdminLoginServlet" method="post">
							<p><span>管理员：</span><input type="text" name="manname" id="" value="" /></p>
							<p><span>密&nbsp;码：</span><input type="password" name="manpwd" id="" value="" /></p>
							<p class="p4"><input type="checkbox" name="isLogin" id="" value="y" /><span>自动登录</span></p>
							<p class="p5">
								<input type="submit" name="" id="" value="提交" />
								<input type="reset" name="" id="" class="margin-left-30" value="重置" />
							</p>
						</form>
					</div>
				</div>
			</div>
			<!--底部-->
			<div id="bottom-1">
				<p>Copyright © 2015-2020</p>
			</div>
		</div>
	</body>
</html>
