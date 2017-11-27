<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../Public/css/all.css" />
<link rel="stylesheet" type="text/css" href="../Public/css/context.css" />
<title>公告信息列表</title>
</head>
<body id="background">
<div id="body">
<% 
	//权限验证
	String username = (String)session.getAttribute("username");
	String AdminId = (String)session.getAttribute("AdminId");
	if(AdminId == null && username == null){%>
		<script>alert('您还没有登录，请登录!'),location='./login.jsp'</script>
<%  }
//获取类型结果集
ResultSet rs = Apo.Notice_Select(); 

%>
	<div id="top">
		<div>
			<img src="../Public/img/admin/left-top-right.gif" />
		</div>
		<div id="title">
			<p>公告信息</p>
		</div>
		<div id="top_body">
			<img src="../Public/img/admin/content-bg.gif" height="31px" />
		</div>
		<div>
			<img src="../Public/img/admin/nav-right-bg.gif" />
		</div>
	</div>
	
	<div id="middle">
		<br/>
		<br/>
		<table align="center" border="1" cellspacing="0" cellpadding="0">
			<tr class="head">
				<td colspan="11">公告信息列表</td>
			</tr>
			<tr class="head">
				<td>标题</td>
				<td>内容</td>
				<td>发布时间</td>
				<td colspan="2"></td>
			</tr>
			<%while(rs.next()){%>
				<tr height="25px">
					<td><%=rs.getString("No_Title") %></td>
					<td><%=rs.getString("No_Message") %></td>
					<td><%=rs.getString("No_time") %></td>
					<td width="5%">
					<a href="./DataOperate/Notice_Edit.jsp?title=<%=rs.getString("No_Title")%>">修改</a></td>
					<td width="5%">
					<a href="javascript:if(confirm('确定要删除吗？'))location ='./DataOperate/Notice_Del.jsp?title=<%=rs.getString("No_Title")%>'">删除</a></td>
				</tr>
			<% }%>				
		</table>
		<br/>
		<br/>
	</div>
</div>
</body>
</html>