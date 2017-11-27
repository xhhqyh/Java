<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="Apo.Hui.Db.*" %> 
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>本日销售</title>
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
					<p>本日销售</p>
				</div>
				<div id="top_body">
					<img src="../Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="../Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
			
			
						<div class="center">
				<form action="#" method="post">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px">
						<tr align="center">
							<td colspan="11"><b>今日销售列表</b></td>
						</tr>
						<tr align="center">
							<td height="10%"><b>用户ID</b></td>
							<td><b>用户姓名</b></td>
							<td><b>联系方式</b></td>
							<td><b>家庭住址</b></td>
							<td><b>菜品名称</b></td>
							<td><b>订购数量</b></td>
							<td><b>单价</b></td>
							<td><b>合计</b></td>
							<td><b>订购时间</b></td>
							<td><b>是否派送</b></td>
							<td><b>确认订单</b></td>
						</tr>
						<% 
							Connection conn = DbUtil.getconn();
						
							//利用java代码获取当前系统时间默认显示为年-月-日
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							String date1 = df.format(new Date());
							out.print("今天是  "+date1);
						
							String d1 = date1+" 00:00:00";
							String d2 = date1+" 23:59:59";
	
							String sql = "select * from Order_info where Ord_Time between  to_date(?,'yyyy-mm-dd hh24:mi:ss')and  to_date(?,'yyyy-mm-dd hh24:mi:ss')";
							ResultSet rs = DbHelper.executeQuery(conn, sql,d1,d2);
							
							
							
							
							while(rs.next()){%>
								<tr align="center">
									<td><%=rs.getString("Ord_Id") %></td>
									<td><%=rs.getString("Ord_Name") %></td>
									<td><%=rs.getString("Ord_Tel") %></td>
									<td><%=rs.getString("Ord_Address") %></td>
									<td><%=rs.getString("Ord_grName") %></td>
									<td><%=rs.getString("Ord_Num") %></td>
									<td><%=rs.getString("Ord_Unitprice") %></td>
									<td>0</td>
									<td><%=rs.getString("Ord_Time") %></td>
									<td><%=rs.getString("Ord_Send") %></td>
									<td><%=rs.getString("Ord_Confirm") %></td>
								</tr>
						<%}
						DbUtil.closeConn(conn);
						%>
						
					</table>
				</form>
				
			</div>
		</div>
	</body>
</html>