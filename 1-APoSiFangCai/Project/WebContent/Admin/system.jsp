<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
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
			//分页
			int pageNoInt = 0;
			String pageNo = request.getParameter("pageNo");
			if (pageNo != null && !"".equals(pageNo)) {
				pageNoInt = Integer.parseInt(pageNo);
				if (pageNoInt < 0) {
					pageNoInt = 0;
				}
			}
			
	Connection conn = DbUtil.getconn();

	
	String actionFlag = request.getParameter("actionFlag");
	
	if("delete".equals(actionFlag)){
		String Mem_Id = request.getParameter("Mem_Id");
		String deleteSQL = "delete from Member_Info where Mem_Id = ? " ;
		DbHelper.executeUpdate(conn, deleteSQL,Mem_Id);
	}
	
	String sql = " select *from (select Member_Info .*,rownum rn from Member_Info  order by Mem_Id asc)t where t.rn>?*5 and rn<=(?+1)*5 " ;
	ResultSet rs = DbHelper.executeQuery(conn, sql,pageNoInt,pageNoInt);
	 

		 %>
			
			<div class="center">
				<form action="upmember.jsp" method="post">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px">
						<tr align="center">
							<td colspan="11"><b>系统用户管理</b></td>
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
							<td colspan="2"></td>
						</tr>
						<%
						while(rs.next()){
							 %>
					   <tr align="center">
							 		<td><%=rs.getString("Mem_Id") %></td>
									<td><%=rs.getString("Mem_Name") %></td>
									<td><%=rs.getString("Mem_Psw") %></td>
									<td><%=rs.getString("Mem_Trname") %></td>
									<td>
									<%
										String sex = rs.getString("Mem_Sex");
									
										if(sex.equals("1")){
											out.print("男");
										}else{
											out.print("女");
										}
									%>
									</td>
									<td><%=rs.getString("Mem_Birthday") %></td>
									<td><%=rs.getString("Mem_Address") %></td>
									<td><%=rs.getString("Mem_Tel") %></td>
									<td><%=rs.getString("Mem_Email") %></td>
									<td><a href = "upmember.jsp?actionFlag=update&Mem_Id=<%=rs.getString("Mem_Id") %>" >修改</a></td>
									<td><a href = "javascript:if(confirm('确实要删除吗?'))location='system.jsp?actionFlag=delete&Mem_Id=<%=rs.getString("Mem_Id") %>' "  >删除</a></td>
								 </tr>
							<%
						 	}
							
							
							%>	

							<%DbUtil.closeConn(conn);%>
					
					</table>
				</form>
				
			</div>
		</div>
			
				</body>
				
</html>