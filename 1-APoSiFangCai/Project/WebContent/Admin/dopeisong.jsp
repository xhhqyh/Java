<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Apo.Hui.Db.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String newDis_Atime1=request.getParameter("newDis_Atime1");
String newDis_Atime2=request.getParameter("newDis_Atime2");
String newDis_Dtime1=request.getParameter("newDis_Dtime1");
String newDis_Dtime2=request.getParameter("newDis_Dtime2");
String newDis_Tel=request.getParameter("newDis_Tel");
String newDis_People=request.getParameter("newDis_People");
String newDis_Remark=request.getParameter("newDis_Remark");

Connection conn = DbUtil.getconn();

String sql = "update Distribution set Dis_Atime1=?,Dis_Atime2=?,Dis_Dtime1=?,Dis_Dtime2=?,Dis_Tel = ?, Dis_People=?,Dis_Remark=? ";
int i = DbHelper.executeUpdate(conn, sql,newDis_Atime1,newDis_Atime2,newDis_Dtime1,newDis_Dtime2,newDis_Tel,newDis_People,newDis_Remark);

if(i>0){
	request.getRequestDispatcher("peisong.jsp").forward(request, response);
}else{
	out.print("修改失败，请返回配送说明页面");%>
	
	<a href="peisong.jsp">返回配送说明页面</a>
	 
	<%
	
}

 DbUtil.closeConn(conn);


%>







</body>
</html>