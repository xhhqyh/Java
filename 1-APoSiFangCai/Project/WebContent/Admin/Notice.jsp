<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../Public/css/all.css" />
<link rel="stylesheet" type="text/css" href="../Public/css/context.css" />
<title>添加公告</title>
</head>
<body id="background">
<% 
	//权限验证
	String username = (String)session.getAttribute("username");
	String AdminId = (String)session.getAttribute("AdminId");
	if(AdminId == null && username == null){%>
		<script>alert('您还没有登录，请登录!'),location='./login.jsp'</script>
	<%}%>
<div id="body">
	<div id="top">
		<div>
			<img src="../Public/img/admin/left-top-right.gif" />
		</div>
		<div id="title">
			<p>添加公告</p>
		</div>
		<div id="top_body">
			<img src="../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	<div id="middle">
		<br /> <br />
			<form action="./DataOperate/Notice_Add.jsp" method="post">
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr>
						<td class="left">公告标题：</td>
						<td class="right"><input type="text" name="title" /></td>
					</tr>
					<tr>
						<td class="left">公告内容：</td>
						<td class="right"><textarea name="content" rows="10" cols="30"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" /></td>
					</tr>
				</table>
			</form>
		<br /> <br />
	</div>
</div>
</body>
</html>