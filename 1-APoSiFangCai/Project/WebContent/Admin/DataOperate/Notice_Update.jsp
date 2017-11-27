<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="java.util.*" %>
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
	String uptitle = request.getParameter("uptitle");
	String upcontent = request.getParameter("upcontent");
	
	String No_Id = request.getParameter("No_Id");
	
	int i = Apo.Notice_Update(No_Id, uptitle, upcontent);
	
	if(i == 1){%>
		<script>location='../Notice_list.jsp'</script>
	<%}else{ %>
		<script>alert('修改失败!!!');location='../Notice_list.jsp'</script>
	<%} %>
</body>
</html>