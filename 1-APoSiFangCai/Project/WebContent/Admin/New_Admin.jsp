<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新菜单</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="../Public/css/admin_right.css"/>
</head>
<body id="background">
<% 
	//权限验证
	String username = (String)session.getAttribute("username");
	String AdminId = (String)session.getAttribute("AdminId");
	if(AdminId == null && username == null){%>
		<script>alert('您还没有登录，请登录!'),location='./login.jsp'</script>
<%  }

%>

<div id="main">
	<div id="top">
		<div id="">
			<img src="../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>添加管理员</p>
		</div>
		<div id="top_body">
			<img src="../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	
	<div class="center">
		<form action="./DataOperate/Add_Admin.jsp" method="post" onSubmit="return check();">
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
					<td>备注信息:</td>
					<td><textarea name="Description" rows="10" id="user-Address" required aria-required="true" cols="30" onblur="CheckContent()"></textarea><span id="AddressInfo">&nbsp;</span></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
<script type="text/javascript" src="../Public/Js/Add_Admin.js"></script>
</html>
