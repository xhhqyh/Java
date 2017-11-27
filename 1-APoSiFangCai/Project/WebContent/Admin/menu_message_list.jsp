<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Hui.Db.*" %> 
<%@ page import="Apo.Admin.DataModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<%}%>
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
String sql2 = " SELECT COUNT(*) count FROM Menu_Info ";
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


//String sql = "select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn between ? and ?";

//ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);


	//接收菜单查询结果
	ArrayList<Menu_Data> rs = Apo.select(min, max);
%>



<div id="main">
	<div id="top">
		<div id="">
			<img src="../Public/img/admin/left-top-right.gif"/>
		</div>
		<div id="title">
			<p>添加菜品</p>
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
					<td colspan="12"><b>菜单信息列表</b></td>
				</tr>
				<tr align="center">
					<td><b>编号</b></td>
					<td height="10%"><b>菜单名称</b></td>
					<td><b>展示图片</b></td>
					<td><b>原料</b></td>
					<td><b>类型</b></td>
					<td><b>说明</b></td>
					<td><b>市场价格</b></td>
					<td><b>市场价销售数量</b></td>
					<td><b>会员单价</b></td>
					<td><b>会员价销售数量</b></td>
					<td colspan="3"></td>
				</tr>
				<% for(int i=0; i<rs.size();i++){ %>
					<tr align="center">
						<td><%=rs.get(i).getMenu_Id() %></td>
						<td><%=rs.get(i).getMenu_Name() %></td>
						<td><img src="..<%=rs.get(i).getMenu_upPhoto() %>" width="30px" height="30px"/></td>
						<td><%=rs.get(i).getMenu_Rmaterial() %></td>
						<td><%=rs.get(i).getGr_Sort() %></td>
						<td><%=rs.get(i).getMenu_fState() %></td>
						<td><%=rs.get(i).getMenu_marketPrice() %></td>
						<td>0</td>
						<td><%=rs.get(i).getMenu_memberPrice() %></td>
						<td>0</td>
						<td><a href="./DataOperate/Menu_Edit.jsp?Menu_Id=<%=rs.get(i).getMenu_Id() %>">修改</a></td>
						<td><a href="javascript:if(confirm('确实要删除吗?'))location='./DataOperate/Menu_Del.jsp?Menu_Id=<%=rs.get(i).getMenu_Id() %>' ">删除</a></td>
					</tr>
				<% } %>
				<tr align="center">
					<td colspan="12" align="center">共<%=b %>页&nbsp;&nbsp;
						<a href="menu_message_list.jsp?flag=first">[首页]</a>&nbsp;
						<a href="menu_message_list.jsp?flag=shang">[上一页]</a>&nbsp;第<%=c %>页&nbsp;
						<a href="menu_message_list.jsp?flag=next">[下一页]</a>&nbsp;
						<a href="menu_message_list.jsp?flag=last">[尾页]</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>
