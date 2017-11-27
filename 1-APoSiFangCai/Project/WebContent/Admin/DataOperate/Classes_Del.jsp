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
    String Gr_Id = request.getParameter("Gr_Id");
	
	//调用删除方法
	int i = Apo.Classes_Delete(Gr_Id);
	
	if(i == 1){%>
		<script>location='../leibie_list.jsp'</script>
	<%}else{ %>
		<script>alert('删除失败!')location='../leibie_list.jsp'</script>
	<%} %>

</body>
</html>