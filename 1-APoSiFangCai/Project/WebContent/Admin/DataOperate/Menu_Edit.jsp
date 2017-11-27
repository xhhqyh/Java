<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新菜单</title>
	<link rel="stylesheet" type="text/css" href="../../Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="../../Public/css/admin_right.css"/>
</head>
<body id="background">
<%
	//设置编码
	//request.setCharacterEncoding("utf-8");
	
	String Menu_Id = request.getParameter("Menu_Id");
	
	//接收菜单查询结果
	ArrayList<Menu_Data> result = Apo.Menu_Check_One(Menu_Id);

%>

<div id="main">
	<div id="top">
		<div id="">
			<img src="../../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>修改菜品</p>
		</div>
		<div id="top_body">
			<img src="../../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	
	<div class="center">
		<form action="../../UpMenuServlet" enctype="multipart/form-data" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="500px" height="400px">
				<tr>
					<td>菜品名称:</td>
					<td><input type="text" name="DishName" id="" value="<%=result.get(0).getMenu_Name() %>" /></td>
				</tr>
				<tr>
					<td>原料:</td>
					<td><input type="text" name="Material" id="" value="<%=result.get(0).getMenu_Rmaterial() %>" /></td>
				</tr>
				<tr>
					<td>市场价格:</td>
					<td><input type="text" name="MarketPrice" id="" value="<%=result.get(0).getMenu_marketPrice() %>" /></td>
				</tr>
				<tr>
					<td>会员价格:</td>
					<td><input type="text" name="MemberPrice" id="" value="<%=result.get(0).getMenu_memberPrice() %>" /></td>
				</tr>
				<tr>
					<td>说明:</td>
					<td><textarea name="Description" rows="10" cols="30"><%=result.get(0).getMenu_fState() %></textarea></td>
				</tr>
				<tr>
					<td>菜品类别:</td>
					<td>
						<select name="Clssify">
							<option value="<%=result.get(0).getMenu_Gr_Id() %>" selected="selected"><%=result.get(0).getGr_Sort() %></option>
							<option value="1">蒸菜</option>
							<option value="2">凉菜</option>
							<option value="3">烧菜</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>图片:</td>
					<td><img src="../..<%=result.get(0).getMenu_upPhoto() %>" width="30px" height="30px"/><input type="file" name="dish_img" id="" value="" /></td>
				</tr>
				<tr>
					<input type="hidden" value="<%=Menu_Id %>" name="Menu_Id">
					<td colspan="2"><input type="submit" name="" id="" value="提交查询" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>
