<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登录页面</title>
		<link rel="stylesheet" type="text/css" href="../Public/css/admin_style.css"/>
	</head>
	<body>
		<!--主体框架-->
		<div id="main">
			<div id="top">
				
			</div>
			<div id="center">
				<div id="center-left">
					<div id="left">
						<img src="../Public/img/admin/logo.png"/>
						<p class="left-p1">
							<img src="../Public/img/admin/icon-mail2.gif"/><span>客户服务邮箱：</span>
							<a href="">admin@apsfc.com</a>
						</p>
						<p>
							<img src="../Public/img/admin/icon-phone.gif"/><span>客户服务电话：</span>
							<a href="">0317-666666</a>
						</p>
						<div id="left-bottom">
							<p class="p2"><img src="../Public/img/admin/icon-demo.gif"/><a href="#">使用说明</a></p>
							<p class="p3"><img src="../Public/img/admin/icon-login-seaver.gif"/><a href="#">在线客服</a></p>
						</div>
					</div>
				</div>
				
				<div id="center-right">
					<div id="right">
						<h4>网上订餐后台管理</h4>
						<form action="./LoginHandel.jsp" method="post" onSubmit="return check();">
							<p class="p1"><span>用户名：</span><input type="text" name="username" class="width-250" required aria-required="true" id="user-name" placeholder="请输入用户名" value="" onblur="checkUserName()"/>&nbsp;<span id="nameInfo"></span></p>
							<p><span>密&nbsp;码：</span><input type="password" name="password" class="width-250" required aria-required="true" id="password" placeholder="请输入密码" value="" onblur="checkPassword()"/>&nbsp;<span id="passwordInfo"></span></p>
							<p class="p4">
								<%
									String msg = (String) request.getAttribute("error_msg");
									if(msg!=null){
										out.print(msg);
									}
									
								%>
							</p>
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
	<script type="text/javascript" src="../Public/Js/Login_Admin.js"></script>
</html>