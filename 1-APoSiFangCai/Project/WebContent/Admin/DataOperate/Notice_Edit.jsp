<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../Public/css/all.css" />
<link rel="stylesheet" type="text/css" href="../../Public/css/context.css" />
<title>添加公告</title>
</head>
<body id="background">

<%
//设置编码
request.setCharacterEncoding("utf-8");

String title = request.getParameter("title");

//接收菜单查询结果
ResultSet rs = Apo.Notice_Check_One(title);

%>

<div id="body">
	<div id="top">
		<div>
			<img src="../../Public/img/admin/left-top-right.gif" />
		</div>
		<div id="title">
			<p>修改公告</p>
		</div>
		<div id="top_body">
			<img src="../../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	<div id="middle">
		<br /> <br />
			<form action="./Notice_Update.jsp" method="post">
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<% while(rs.next()){ %>
						<tr>
							<td class="left">公告标题：</td>
							<td class="right"><input type="text" name="uptitle" value="<%=rs.getString("No_Title") %>" /></td>
						</tr>
						<tr>
							<td class="left">公告内容：</td>
							<td class="right"><textarea name="upcontent" rows="10" cols="30"><%=rs.getString("No_Message") %></textarea></td>
						</tr>
						<input type="hidden" name="No_Id" value="<%=rs.getInt("No_Id") %>">
					<% } %>
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