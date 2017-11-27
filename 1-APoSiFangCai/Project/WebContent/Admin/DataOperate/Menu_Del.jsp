<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String Menu_Id = request.getParameter("Menu_Id");
	
	//调用删除方法
	String str = Apo.Menu_Delete(Menu_Id);
	
	if(str.equals("删除失败")){
%>
		<script>confirm('<%=str %>,请重新删除'),location='./show.jsp'</script>
	<%}else{ %>
		<script>location='../menu_message_list.jsp'</script>
	<%} %>

</body>
</html>