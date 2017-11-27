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
	String ClassesName = request.getParameter("ClassesName");
	String Gr_Id = request.getParameter("Gr_Id");
	
	int i = Apo.Classes_Update(Gr_Id, ClassesName);
	
	if(i == 1){%>
		<script>location='../leibie_list.jsp'</script>
	<%}else{ %>
		<script>alert('修改失败!!!');location='../leibie_list.jsp'</script>
	<%} %>
</body>
</html>