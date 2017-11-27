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
		//设置编码  让前一个表单页面传过来的数据不会乱码。
		request.setCharacterEncoding("utf-8");
		
		


		String Mem_Id = (String)session.getAttribute("Mem_Id");
		String newMem_Name = request.getParameter("newMem_Name");
		String newMem_Psw = request.getParameter("newMem_Psw");
		String newMem_Trname = request.getParameter("newMem_Trname");
		String newMem_Sex = request.getParameter("newMem_Sex");
		String newMem_Birthday = request.getParameter("newMem_Birthday");
		String newMem_Address = request.getParameter("newMem_Address");
		String newMem_Tel = request.getParameter("newMem_Tel");
		String newMem_Email = request.getParameter("newMem_Email");
		


			
		Connection conn = DbUtil.getconn();
		
		String sql = "update Member_Info set Mem_Name = ?, Mem_Psw = ?, Mem_Trname = ?, Mem_Sex=?,Mem_Birthday=to_date(?,'yyyy-mm-dd hh24:mi:ss'),Mem_Address=?,Mem_Tel=?,Mem_Email=? where Mem_Id = ?";
		int i = DbHelper.executeUpdate(conn, sql, newMem_Name,newMem_Psw,newMem_Trname,newMem_Sex,newMem_Birthday,newMem_Address,newMem_Tel,newMem_Email,Mem_Id);
		
		if(i>0){
			request.getRequestDispatcher("system.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("upmember.jsp").forward(request, response);
		}
		
		 DbUtil.closeConn(conn);
	%>



</body>
</html>