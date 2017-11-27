<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>配送说明</title>
		<link rel="stylesheet" type="text/css" href="../Public/css/login.css"/>
	</head>
	<body>
	<%
		//接收session值
		String name = (String)session.getAttribute("name");
		String Mem_Id = (String)session.getAttribute("Mem_Id");
	%>
	
	
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
			 ResultSet Car_rs = ApoHome.Select_Send(); 
		%>
			

			
			<div id="send">
				<h3>配送指南</h3>
				<% while(Car_rs.next()){ %>
					<p class="send-p">午餐时间:<span><%=Car_rs.getString("Dis_Atime1") %>~<%=Car_rs.getString("Dis_Atime2") %></span></p>
					<p class="send-p">晚餐时间:<span><%=Car_rs.getString("Dis_Dtime1") %>~<%=Car_rs.getString("Dis_Dtime2") %></span></p>
					<p class="send-p">联系电话:<span><%=Car_rs.getString("Dis_Tel") %></span></p>
					<p class="send-p">联系人:<span><%=Car_rs.getString("Dis_People") %></span></p>
					<p class="send-p">注:<span> 本店支持支付宝、微信、QQ、各种银行卡付款，同时支持货到付款（自备零钱），谢谢合作！</span></p>
					<p class="send-p"><%=Car_rs.getString("Dis_Remark") %></p>
				<% } %>
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
</html>>