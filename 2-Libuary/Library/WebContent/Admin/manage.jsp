<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台主框体</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/all.css"/>
</head>
<!--后台展示框架-->
<frameset rows="64px, *" noresize="noresize" >
	<!--顶部-->
	<frame src="top.jsp" scrolling="no"/>
	<!--底部-->
	<frameset cols="200px, *" noresize="noresize">
		<!--左部菜单-->
		<frame src="menu.jsp"/>
		<!--右部菜单-->
		<frame src="welcome.jsp" name="right"/>
	</frameset>
</frameset>
</html>
