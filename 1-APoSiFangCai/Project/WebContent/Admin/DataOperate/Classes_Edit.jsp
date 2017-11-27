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

String Gr_Id = request.getParameter("Gr_Id");

//接收菜单查询结果
ResultSet rs = Apo.Classes_Check_One(Gr_Id);
%>



<div id="main">
	<div id="top">
		<div id="">
			<img src="../../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>修改类别</p>
		</div>
		<div id="top_body">
			<img src="../../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	
	<div class="center">
		<form action="./Classes_Upedit.jsp" method="post">
			<table align="center" cellpadding="0" cellspacing="0" width="300px" height="100">
				<% while(rs.next()){ %>
					<tr>
						<td>菜品类别:</td>
						<td><input type="text" name="ClassesName" value="<%=rs.getString("Gr_Sort") %>" /></td>
					</tr>
				<% } %>
				<tr align="center">
					<input type="hidden" value="<%=Gr_Id %>" name="Gr_Id" >
					<td colspan="2" ><input type="submit" name="" class="leibie" id="" value="修改" /></td>
				</tr>
				
			</table>
		</form>
		
	</div>
</div>
</body>
</html>