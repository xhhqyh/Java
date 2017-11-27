<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>我的订单</title>
		<link rel="stylesheet" type="text/css" href="../Public/css/login.css"/>
	</head>
	<body>
	<%
	//接收session值
	String name = (String)session.getAttribute("name");
	String Mem_Id = (String)session.getAttribute("Mem_Id");
	if(name == null && Mem_Id == null){%>
	<script>alert('您还没有登录，请登录!'),location='./login.html'</script>
	<%}%>
		<!--主体框架-->
		<div id="main">
			
			<!--头部-->
			<div id="top">
				<div id="top-1">
					<!--头部导航-->
					<div id="top-1-img">
						<img src="../Public/img/Home/1257477260.gif"/>
					</div>
					<div id="top-1-ul">
						<ul>
							<li><a href="./index.jsp">首页</a></li>
							<li><a href="eatcar.jsp">我的餐车</a></li>
							<li><a href="order.jsp">我的订单</a></li>
							<li><a href="User.jsp">用户中心</a></li>
							<li><a href="send.jsp">配送说明</a></li>
							<li><a href="index.jsp#bottom">关于我们</a></li>
						</ul>
					</div>
					<!--登录注册-->
					<div id="top-1-ul2">
						<ul>
							<%if(Mem_Id != null && name != null){%>
								<li><p>欢迎:<a href="./User.jsp"><%=name %>&nbsp;</a>|</p></li>
								<li><p><a href="./DataOperate/Exit.jsp">&nbsp;退出</a></p></li>
							<%}else{%>
								<li><p><a href="./login.html"><img src="../Public/img/Home/2017-02-28_194115.jpg"/>登录&nbsp;</a>|</p></li>
								<li><p><a href="./zhuce.html">&nbsp;注册</a></p></li>
							<%} %>
						</ul>
					</div>
				</div>
			</div>
			
			<div id="table-order">
				<%!
					//定义全局变量
					int count = 0; //表中共有多少条数据
					int a = 10;     //每页多少条数据
					int b = 0;     //共分多少页
					int c = 1;     //当前页数
					int min = 1;   //查询最小值
					int max = 5;   //查询最大值
				%>
				<%			
					Connection conn = DbUtil.getconn();
					//将表中的记录数查出来放在count中
					String sql2 = " SELECT COUNT(*) count FROM (select m.*,rownum rn from Order_Info m where Ord_Name = '" + name + "') ";
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

					
					//拿到购物车查询结果集
					ResultSet Order_rs = ApoHome.Select_Order(name,min, max);

				%>
				<table border="1" class="table-2" cellspacing="0" width="1000px">
					<tr>
						<td colspan="9">订单查询结果信息列表</td>
					</tr>
					<tr>
						<td width="60px">用户名</td>
						<td width="80px">菜品名称</td>
						<td width="50px">订购电话</td>
						<td width="80px">派送地址</td>
						<td width="40px">订购数量</td>
						<td width="40px">单价(元)</td>
						<td width="40px">合计(元)</td>
						<td width="150px">订购时间</td>
						<td width="40px">是否派送</td>
					</tr>
					<% while(Order_rs.next()){ %>
						<tr>
							<td><%=Order_rs.getString("Ord_Name") %></td>
							<td><%=Order_rs.getString("Ord_grName") %></td>
							<td><%=Order_rs.getString("Ord_Tel") %></td>
							<td><%=Order_rs.getString("Ord_Address") %></td>
							<td><%=Order_rs.getString("Ord_Num") %></td>
							<td><%=Order_rs.getString("Ord_Unitprice") %></td>
							<td><%=Order_rs.getString("Ord_Unitprice") %></td>
							<td><%=Order_rs.getString("Ord_Time") %></td>
							<td><%=Order_rs.getString("Ord_Send") %></td>
						</tr>
					<%} %>
						<tr height="40px">
							<td colspan="11" align="center">共<%=b %>页&nbsp;&nbsp;
								<a href="order.jsp?flag=first">[首页]</a>&nbsp;
								<a href="order.jsp?flag=shang">[上一页]</a>&nbsp;第<%=c %>页&nbsp;
								<a href="order.jsp?flag=next">[下一页]</a>&nbsp;
								<a href="order.jsp?flag=last">[尾页]</a>
							</td>
						</tr>
				</table>
			</div>
			
			<div id="bottom-3">
				<div id="bottom-3-1">
					<p>&copy;阿婆私房菜|电话：0317-154862|地址:武汉软件园</p>
				</div>
				<div id="bottom-3-2">
				</div>
			</div>
		</div>
	</body>
</html>