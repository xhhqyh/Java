<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	request.setCharacterEncoding("UTF-8");

	//接收表单数据
	String AdminName = request.getParameter("AdminName");
	String AdminPass = request.getParameter("AdminPass");
	String Description = request.getParameter("Description");
	
	int i = Apo.Add_Admin(AdminName, AdminPass, Description);

	if(i == 1){
		%>
		<script>location='../System_Admin.jsp'</script>
	<%}else{ %>
		<script>alert('又出BUG了，添加失败！！！');location='../System_Admin.jsp'</script>
	<%} %>
</body>
</html>