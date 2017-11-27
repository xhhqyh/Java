<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
<%@page import="java.sql.*" %>
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
	<%}%>
	
   <div id="main">
	<div id="top">
				<div id="">
					<img src="../Public/img/admin/left-top-right.gif"/>
				</div>
				<div id="title">
					<p>修改系统用户</p>
				</div>
				<div id="top_body">
					<img src="../Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="../Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
   <%
   Connection conn = DbUtil.getconn();

	String Mem_Id = request.getParameter("Mem_Id");

	session.setAttribute("Mem_Id",Mem_Id);
	
	
	String sql = "select *from Member_Info where Mem_Id=? ";
	ResultSet rs = DbHelper.executeQuery(conn, sql, Mem_Id);
	%>

        <div class="center">
				<form action="doupmember.jsp" method="post">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px" height="100px">
						<tr align="center">
							<td colspan="10"><b>系统用户管理</b></td>
						</tr>
						<tr align="center">
							<td height="10%"><b>用户ID</b></td>
							<td><b>用户名</b></td>
							<td><b>密码</b></td>
							<td><b>真实姓名</b></td>
							<td><b>性别</b></td>
							<td ><b>生日</b></td>
							<td><b>地址</b></td>
							<td ><b>电话</b></td>
							<td><b>电子邮件</b></td>
							<td ></td>
						</tr>
						<%
						while(rs.next()){
							 %>
						   <tr align="center">
						 		<td width="5%"><%=rs.getInt("Mem_Id") %></td>
								<td><input size="3" type="text" value="<%=rs.getString("Mem_Name") %>" name="newMem_Name"></td>
								<td><input size="3" type="text" value="<%=rs.getString("Mem_Psw") %>" name="newMem_Psw"></td>
								<td><input size="3" type="text" value="<%=rs.getString("Mem_Trname") %>" name="newMem_Trname"></td>
								<%
								String sex = rs.getString("Mem_Sex");
								if(sex.equals("1")){%>
									<td width="8%"><input type="radio" value="1" name="newMem_Sex" checked="checked">男&nbsp<input type="radio" value="女" name="newMem_Sex">女</td>
								<% }else{%>
									<td width="8%"><input type="radio" value="0" name="newMem_Sex">男&nbsp<input type="radio" value="女" name="newMem_Sex" checked="checked">女</td>
								<% }%>
								<td><input size="15" type="text" value="<%=rs.getString("Mem_Birthday") %>" name="newMem_Birthday"></td>
								<td><input size="15" type="text" value="<%=rs.getString("Mem_Address") %>" name="newMem_Address"></td>
								<td><input size="7" type="text" value="<%=rs.getString("Mem_Tel") %>" name="newMem_Tel"></td>
								<td><input size="13" type="text" value="<%=rs.getString("Mem_Email") %>" name="newMem_Email"></td>
								<td width="5%"><input  type="submit" value="修改"></td>
							
						 </tr>
							<%
						 	}
						 DbUtil.closeConn(conn);
						%>
					
					</table>
				</form>


</div>


</body>
</html>