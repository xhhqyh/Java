<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告列表</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/login.css"/>
</head>
<body>

<%
//接收session值
String name = (String)session.getAttribute("name");
String Mem_Id = (String)session.getAttribute("Mem_Id");


	//拿到餐厅公告查询结果集
	ResultSet Nt_rs = Apo.Notice_Select();
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
	
	<div id="notice">
			<h3>公告列表</h3>
			<% while(Nt_rs.next()){ %>
				<p class="send-p"><a href="Notice_Content.jsp?title=<%=Nt_rs.getString("No_Title") %>"><%=Nt_rs.getString("No_Title") %></a><span class="notice-time"><%=Nt_rs.getString("No_time") %></span></p>
			<%} %>
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
