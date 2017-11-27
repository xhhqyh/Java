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
    String No_Title = request.getParameter("title");
	
	//调用删除方法
	int i = Apo.Notice_Delete(No_Title);
	
	if(i == 1){%>
		<script>location='../Notice_list.jsp'</script>
	<%}else{ %>
		<script>alert('删除失败!!!');location='../Notice_list.jsp'</script>
	<%} %>

</body>
</html>