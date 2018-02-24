<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快乐买后台管理系统</title>
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
</head>
<!--总框架-->
<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0">
	<!--顶部-->
	<frame src="top.jsp" name="topFrame" scrolling="no" border="0" framespacing="0"/>
	<!--中间左右部分-->
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<!--左部分-->
    	<frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    	<!--右部分-->
    	<frame src="index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
  	</frameset>
</frameset>
</html>
