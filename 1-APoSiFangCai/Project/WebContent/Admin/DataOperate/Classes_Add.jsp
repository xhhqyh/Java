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
	String ClssifyName = request.getParameter("ClassesName");
	
	int i = Apo.Add_Classes(ClssifyName);

	if(i == 1){
		%>
		<script>location='../leibie_list.jsp'</script>
	<%}else{ %>
		<script>alert('又出BUG了，添加失败！！！');location='../leibie.html'</script>
	<%} %>
</body>
</html>