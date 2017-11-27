<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>销售订单查询</title>
		<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="../Public/css/admin_right.css"/>
	</head>
	<body id="background">
	<% 
	//权限验证
	String trueInfo = (String)session.getAttribute("HtrueInfo");
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
					<p>销售订单查询</p>
				</div>
				<div id="top_body">
					<img src="../Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="../Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
			
			<form action="sell_select.jsp" method="post">
			<div id="find">
				<span>根据姓名查找</span>
				<input type="text" size="17" name = "find_name"/><br><br>
				<span>根据菜名查找</span>
				<input type="text" size="17" name = "find_cai"/><br><br>
				<span>根据日期查找</span>
				<input type="date"  name = "date1"/>
				<span>—</span>
				<input type="date"  name = "date2"/><br><br>
				<input type="submit" value="查询">
			</div>
			</form>
			<div class="center">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px">
						<tr align="center">
							<td colspan="11"><b>销售订单查询列表</b></td>
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
						request.setCharacterEncoding("utf-8");
						
						String name = request.getParameter("find_name");
						String cai = request.getParameter("find_cai");
						String date1 = request.getParameter("date1");
						String date2 = request.getParameter("date2");
						
						String cai2 = "%"+cai+"%";
						String name2 = "%"+name+"%";

						
						//判断页面是否有输入信息
						if((date2 !=null && date1 !=null) ||name !=null ||cai!=null){
							
							if((date2.length() !=0 && date1.length() !=0) ||name.length() !=0 ||cai.length()!=0){
							
								Connection conn = DbUtil.getconn();
							String sql = "";
							ResultSet rs;
							String d1 = date1+" 00:00:00";
							String d2 = date2+" 23:59:59";
							
							//利用页面输入的不同信息，来使用不同的查询方式
							if(name.length()!=0 && cai.length()!=0 && (date1.length()!=0 && date2.length()!=0)){
								sql = "select * from Order_Info where Ord_Name like ? and Ord_grName like ? and Ord_Time between  to_date(?,'yyyy-mm-dd hh24:mi:ss')and  to_date(?,'yyyy-mm-dd hh24:mi:ss')";
								rs = DbHelper.executeQuery(conn, sql,name2,cai2,d1,d2);
							}else if(name.length()!=0 && (date1.length()!=0 && date2.length()!=0)){
								sql = "select * from Order_Info where Ord_Name like ? and Ord_Time between  to_date(?,'yyyy-mm-dd hh24:mi:ss')and  to_date(?,'yyyy-mm-dd hh24:mi:ss')";
								rs = DbHelper.executeQuery(conn, sql,name2,d1,d2);
							}else if((date1.length()!=0 && date2.length()!=0) && cai.length()!=0){
								sql= "select * from Order_Info where Ord_grName like ? and Ord_Time between  to_date(?,'yyyy-mm-dd hh24:mi:ss')and  to_date(?,'yyyy-mm-dd hh24:mi:ss')";
								rs = DbHelper.executeQuery(conn, sql,cai2,d1,d2);
							}else if(cai.length()!=0 && name.length()!=0){
								sql = "select * from Order_Info where Ord_Name like ? and Ord_grName like ?";
								rs = DbHelper.executeQuery(conn, sql,name2,cai2);
							}else if(cai.length()!=0){
								sql= "select * from Order_Info where Ord_grName like ?";
								rs = DbHelper.executeQuery(conn, sql,cai2);
							}else if(name.length()!=0){
								sql= "select * from Order_Info where Ord_Name like ?";
								rs = DbHelper.executeQuery(conn, sql,name2);
							}else{
								sql = "select * from Order_info where Ord_Time between  to_date(?,'yyyy-mm-dd hh24:mi:ss')and  to_date(?,'yyyy-mm-dd hh24:mi:ss')";
								rs = DbHelper.executeQuery(conn, sql,d1,d2);
							}
							
							while(rs.next()){%>
								<tr align="center">
									<td><%=rs.getString("Ord_Id") %></td>
									<td><%=rs.getString("Ord_Name") %></td>
									<td><%=rs.getString("Ord_Tel") %></td>
									<td><%=rs.getString("Ord_Address") %></td>
									<td><%=rs.getString("Ord_grName") %></td>
									<td><%=rs.getString("Ord_Num") %></td>
									<td><%=rs.getString("Ord_Unitprice") %></td>
									<td><%=rs.getString("Ord_Unitprice") %></td>
									<td><%=rs.getString("Ord_Time") %></td>
									<td><%=rs.getString("Ord_Send") %></td>
									<td><%=rs.getString("Ord_Confirm") %></td>
								</tr>
						<%}
							DbUtil.closeConn(conn);
						
							}
						}
						%>
					</table>			
			</div>
		</div>
		
	</body>
</html>