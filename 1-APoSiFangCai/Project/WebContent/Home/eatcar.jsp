<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
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
						<li><p><a href="./login.html">登录&nbsp;</a>|</p></li>
						<li><p><a href="./zhuce.html">&nbsp;注册</a></p></li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
	
	<%
		//拿到购物车查询结果集
		ResultSet Car_rs = ApoHome.Select_Car(name);
	%>
	
	<div id="table-car">
		<h3>我的订餐信息列表</h3>
		<table border="1" cellspacing="0">
			<tr height="50px">
				<td width="25%">菜品名称</td>
				<td width="25%">单价</td>
				<td width="25%">数量</td>
				<td width="25%">操作</td>
			</tr>
			<%
			//总价格
				int total=0;
				//总份数
				int total_num=0;
				String Car_Order_Price = "";
				String num = "";
				while(Car_rs.next()){ 
			%>
			<tr height="25px">
				<td><%=Car_rs.getString("Car_Dish_Name") %></td>
				<td><%=Car_rs.getString("Car_Order_Price") %></td>
				<td><%=Car_rs.getString("num") %></td>
				<td>
					<a href="./DataOperate/Car_Order_Add.jsp?DishName=<%=Car_rs.getString("Car_Dish_Name") %>"><img src="../Public/img/Home/11.jpg"/></a>
					<a href="./DataOperate/Car_Order_Del.jsp?DishName=<%=Car_rs.getString("Car_Dish_Name") %>"><img src="../Public/img/Home/12.jpg"/></a>
				</td>
				<%
					Car_Order_Price = Car_rs.getString("Car_Order_Price");
					num = Car_rs.getString("num");
					int b = Integer.valueOf(Car_Order_Price).intValue();
					int a = Integer.valueOf(num).intValue();
					total = total + a*b;
					total_num = total_num + a;
				%>
			</tr>
			<%} %>
			
			<tr height="30px">
				<td colspan="4">小计：共<%=total %>元&nbsp;共：【<%=total_num %>】份</td>
			</tr>
			<tr>
				<td colspan="4">
					<a href="./DataOperate/Car_Pay_eat.jsp" class="border-1px">买单</a>&nbsp;
					<a href="./DataOperate/Car_Cancel.jsp" class="border-1px">全部取消</a>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="bottom-3">
			<div id="bottom-3-1">
				<p>&copy;阿婆私房菜|电话：0317-154862|地址:武汉软件园</p>
			</div>
			<div id="bottom-3-2">
				<!--<img src="../Public/img/Home/2017-07-17_185137.jpg"/>-->
				</div>
			</div>
	</div>
</body>
</html>
