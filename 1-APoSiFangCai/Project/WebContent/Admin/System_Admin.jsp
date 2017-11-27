<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
<%@ page import="Apo.Admin.DataModel.*" %>
<%@page import="java.sql.*" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>会员管理</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="../Public/css/admin_right.css"/>
</head>
<body id="background" >
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
				<p>系统用户管理</p>
			</div>
			<div id="top_body">
				<img src="../Public/img/admin/content-bg.gif" height="31px" />
			</div>
			<div>
				<img src="../Public/img/admin/nav-right-bg.gif" />
			</div>
		</div>
		
		<%
		ResultSet rs = Apo.Select_Admin();
 		 %>
		
		<div class="center">
			<form action="upmember.jsp" method="post">
				<table border="1" align="center" cellpadding="0" cellspacing="0" width="800px">
					<tr align="center" height="30px">
						<td colspan="11"><b>系统用户管理</b>&nbsp;|&nbsp;<a href="./New_Admin.jsp">增加</a></td>
					</tr>
					<tr align="center">
						<td height="10%"><b>用户ID</b></td>
						<td><b>用户名</b></td>
						<td><b>密码</b></td>
						<td><b>备注</b></td>
						<td colspan="2"></td>
					</tr>
					<%
					int i=1;
					while(rs.next()){
						if(i==1){
						 %>
				   			<tr align="center">
						 		<td><%=rs.getString("Adm_Id") %></td>
								<td><%=rs.getString("Adm_Name") %></td>
								<td><%=rs.getString("Adm_Psw") %></td>
								<td><%=rs.getString("Adm_Remark") %></td>
			     				<td><a href = "#" ><span style="color:gray;">修改</span></a></td>
								<td><a href = "javascript:if(confirm('确实要删除吗?'))location='./DataOperate/DelAdmin.jsp?Adm_Id=<%=rs.getString("Adm_Id") %>' " >删除</a></td>
							 </tr>
						<%}else{%>
							<tr align="center">
						 		<td><%=rs.getString("Adm_Id") %></td>
								<td><%=rs.getString("Adm_Name") %></td>
								<td><%=rs.getString("Adm_Psw") %></td>
								<td><%=rs.getString("Adm_Remark") %></td>
			     				<td><a href = "./UpdateAdmin.jsp?Adm_Id=<%=rs.getString("Adm_Id") %>" >修改</a></td>
								<td><a href = "javascript:if(confirm('确实要删除吗?'))location='./DataOperate/DelAdmin.jsp?Adm_Id=<%=rs.getString("Adm_Id") %>' " >删除</a></td>
						 </tr>
						<%}
						i++;	
					}%>
						
				
				</table>
			</form>
			
		</div>
	</div>
</body>		
</html>