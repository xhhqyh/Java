<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
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
	<%}

	Connection conn = DbUtil.getconn();


	String sql = " select * from Distribution" ;
	ResultSet rs = DbHelper.executeQuery(conn, sql);
	 

		 %>
	 <div id="main">
			<div id="top">
				<div id="">
					<img src="../Public/img/admin/left-top-right.gif"/>
				</div>
				<div id="title">
					<p>配送说明</p>
				</div>
				<div id="top_body">
					<img src="../Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="../Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
			
			<div class="center">
				<form action="dopeisong.jsp" method="post">
			<table  align="center" cellspaceing="0" cellpadding="0"  width="700px" height="350px">
			   <caption><font size="5"><b>配送说明</b></font></caption>
			   <%
			   while(rs.next()){
				   
			  
			   %>
			   <tr>
			       <td align="left" width="12%">午餐时间：</td>
			       <td><input type="time" value="<%=rs.getString("Dis_Atime1") %>" name="newDis_Atime1">--
			       <input type="time" value="<%=rs.getString("Dis_Atime2") %>" name="newDis_Atime2">
			       </td>
			   </tr>
			   <tr>
			       <td align="left" width="12%">晚餐时间：</td>
			        <td><input type="time" value="<%=rs.getString("Dis_Dtime1") %>" name="newDis_Dtime1">--
			            <input type="time" value="<%=rs.getString("Dis_Dtime2") %>" name="newDis_Dtime2">
			       </td>
			   </tr>
			   <tr>
			       <td align="left" width="12%">联系电话：</td>
			       <td><input type="text" value="<%=rs.getString("Dis_Tel") %>" name="newDis_Tel">
			       </td>
			    </tr>
			     <tr>
			       <td align="left" width="12%">联系人： </td>
			       <td><input type="text" value="<%=rs.getString("Dis_People") %>" name="newDis_People">
			       </td>
			   </tr>
			   <tr>
			       <td align="left" width="12%" height="100px">备注：</td>
			       <td><textarea cols="50" rows="4" name="newDis_Remark"><%=rs.getString("Dis_Remark") %></textarea>
			       </td>
			   </tr>
			  <tr>
			       <td colspan="2" height="20px" align="center"><input type="submit" value="修改配送说明" ></td>
			      
			   </tr>
			 
			   <%}
			   DbUtil.closeConn(conn);%> 
			</table>
				</form>
			
			
			
			
			
			
			
			
			


</body>
</html>