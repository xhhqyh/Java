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
<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/login.css"/>
</head>
<body>
<%
	//接收session值
	String name = (String)session.getAttribute("name");
	String Mem_Id = (String)session.getAttribute("Mem_Id");
	if(name == null && Mem_Id == null){%>
	<script>alert('您还没有登录，请登录!'),location='./login.html'</script>
<%  }

	//拿到购物车查询结果集
	ResultSet User_rs = ApoHome.Select_Mem(name);
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
		
		<!--注册-->
		<div id="zhuce">
			<form action="./DataOperate/User_Upedit.jsp" method="post">
				<h3>用户修改</h3>
				<% while(User_rs.next()){ %>
					<p class="p1"><span>用户&nbsp;名：</span><input type="text" name="zhuce_name" required="required" id="btn" value="<%=User_rs.getString("Mem_Name") %>" class="width-250"/></p>
					<p><span>密&nbsp;&nbsp;码：</span><input type="text" name="zhuce_pass" required="required" class="width-250" value="<%=User_rs.getString("Mem_Psw") %>"/></p>
					<p><span>确认密码：</span><input type="text" name="zhuce_repass" required="required" class="width-250" value="<%=User_rs.getString("Mem_Psw") %>"/></p>
					<p><span>真实姓名：</span><input type="text" name="TrueName" required="required" class="width-250" value="<%=User_rs.getString("Mem_Trname") %>"/></p>
					<p>
						<span>性&nbsp;&nbsp;别：</span>
						<%
						String sex = User_rs.getString("Mem_Sex");
						
						if(sex.equals("1")){ %>
							<input type="radio" name="zhuce_sex" id="" value="1" checked="checked"/>男
							<input type="radio" name="zhuce_sex" id="" value="0"/>女
						<%}else{ %>
							<input type="radio" name="zhuce_sex" id="" value="1"/>男
							<input type="radio" name="zhuce_sex" id="" value="0" checked="checked"/>女
						<%} %>
					</p>
					<p><span>生&nbsp;&nbsp;日：</span><input type="text" class="width-250" name="Birthday" required="required" value="<%=User_rs.getString("Mem_Birthday") %>"/></p>
					<p><span>家庭住址：</span><input type="text" name="Address" required="required" class="width-250" id="" value="<%=User_rs.getString("Mem_Address") %>"/></p>
					<p><span>电话号码：</span><input type="text" name="Tel" required="required" class="width-250" id="" value="<%=User_rs.getString("Mem_Tel") %>"/></p>
					<p><span>电子邮箱：</span><input type="text" name="Email" required="required" class="width-250" id="" value="<%=User_rs.getString("Mem_Email") %>"/></p>
					<p><input type="submit" id="" class="submit" value="修改" />
					<input type="reset" name="" id="" class="submit" value="重置" /></p>
				<%} %>
			</form>
			
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