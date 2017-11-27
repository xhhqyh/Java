<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>
<%@ page import="Apo.Hui.Db.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//设置编码
	request.setCharacterEncoding("utf-8");
	
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	out.println(title + " " + content);
	
	int i = Apo.Add_Notice(title, content);
	if(i == 1){
		%>
		<script>location='../Notice_list.jsp'</script>
	<%}else{ %>
		<script>alert('又出BUG了，添加失败！！！');location='../Notice.jsp'</script>
	<%} %>
</body>
</html>