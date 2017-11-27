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
	//获取类型结果集
	ResultSet rs = Apo.Classes_Select_Menu(); 
%>

<div id="main">
	<div id="top">
		<div id="">
			<img src="../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>添加菜品</p>
		</div>
		<div id="top_body">
			<img src="../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	
	<div class="center">
		<form action="../TestServlet" enctype="multipart/form-data" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="500px" height="400px">
				<tr>
					<td>菜品名称:</td>
					<td><input type="text" name="DishName" id="" value="" /></td>
				</tr>
				<tr>
					<td>原料:</td>
					<td><input type="text" name="Material" id="" value="" /></td>
				</tr>
				<tr>
					<td>市场价格:</td>
					<td><input type="text" name="MarketPrice" id="" value="" /></td>
				</tr>
				<tr>
					<td>会员价格:</td>
					<td><input type="text" name="MemberPrice" id="" value="" /></td>
				</tr>
				<tr>
					<td>说明:</td>
					<td><textarea name="Description" rows="10" cols="30"></textarea></td>
				</tr>
				<tr>
					<td>菜品类别:</td>
					<td>
						<select name="Clssify">
						<%
						int i=0;
						while(rs.next()){ 

						%>
							<option value="<%=rs.getString("Gr_Id") %>"><%=rs.getString("Gr_Sort") %></option>
						<% }%>
						</select>
					</td>
				</tr>
				<tr>
					<td>上传图片:</td>
					<td><input type="file" name="dish_img" id="" value="" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="" id="" value="添加" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>
