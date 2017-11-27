<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %> 
<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>全部销售信息</title>
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
					<p>全部销售信息</p>
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
							<td colspan="11"><b>销售订单信息列表</b></td>
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
						<%!
							//定义全局变量
							int count = 0; //表中共有多少条数据
							int a = 5;     //每页多少条数据
							int b = 0;     //共分多少页
							int c = 1;     //当前页数
							int min = 1;   //查询最小值
							int max = 5;   //查询最大值
							%>
							<%
							Connection conn = DbUtil.getconn();
							//将表中的记录数查出来放在count中
							String sql2 = " SELECT COUNT(*) count FROM Order_Info ";
							ResultSet rs2 = DbHelper.executeQuery(conn, sql2);
							if(rs2.next()){
								count = rs2.getInt("count");
							}
							
							//计算共有多少页，不能整除就将页数加一
							if (count % a == 0 ){
								b = count / a;
							}else if (count % a != 0){
								b = count / a + 1;
							}
							
							//根据不同的请求切换到不同的页面
							String flag = request.getParameter("flag");
								if ("first".equals(flag)){                  //首页
									min = 1;
									max = 5;
									c = 1;
								}else if ("shang".equals(flag)  && c > 1){  //上一页
									min = min - a;
									max = max - a;
									c = c - 1;
								}else if ("next".equals(flag) && c < b){     //下一页
									min = min + a;
									max = max + a;
									c = c + 1;
								}else if ("last".equals(flag)){             //最后一页
									min = a * (b - 1) + 1;
									max = count;
									c = b;
									
								}

						
							String sql = "select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn between ? and ?";
							
							ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);
							
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
					
							
							%>	
							<tr height="40px">
								<td colspan="11" align="center">共<%=b %>页&nbsp;&nbsp;
									<a href="sell_all_info.jsp?flag=first">[首页]</a>&nbsp;
									<a href="sell_all_info.jsp?flag=shang">[上一页]</a>&nbsp;第<%=c %>页&nbsp;
									<a href="sell_all_info.jsp?flag=next">[下一页]</a>&nbsp;
									<a href="sell_all_info.jsp?flag=last">[尾页]</a>
								</td>
							</tr>
							
							<%
							DbUtil.closeConn(conn);
						%>
					</table>
				</form>
				
			</div>
		</div>
	</body>
</html>