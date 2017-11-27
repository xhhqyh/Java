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
	
	String Adm_Id = request.getParameter("Adm_Id");
	//获取类型结果集
	ResultSet rs = Apo.Select_Admin_one(Adm_Id); 
%>

<div id="main">
	<div id="top">
		<div id="">
			<img src="../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>修改管理员</p>
		</div>
		<div id="top_body">
			<img src="../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	
	<div class="center">
		<form action="./DataOperate/Update_Admin.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="500px" height="400px">
			<% while(rs.next()){ %>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="AdminName" id="" value="<%=rs.getString("Adm_Name") %>" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="AdminPass" id="" value="<%=rs.getString("Adm_Psw") %>" /></td>
				</tr>
				<tr>
					<td>备注信息:</td>
					<td><textarea name="Description" rows="10" cols="30"><%=rs.getString("Adm_Remark") %></textarea></td>
				</tr>
				
				<tr>
					<input type="hidden" name="Adm_Id" value="<%=rs.getString("Adm_Id") %>">
					<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
				</tr>
			<%} %>
			</table>
		</form>
	</div>
</div>
</body>
</html>
