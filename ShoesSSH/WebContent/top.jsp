<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快乐买后台管理系统-顶部</title>
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
</head>
<body style="background:url(img/topbg.png) repeat-x">
	<!--logo-->
	<div class="topleft">
		<a href="main.html" target="_parent"><img src="img/img14.png"/><span>快乐买后台管理系统</span></a>
	</div>
	
	<ul>
		<li></li>
	</ul>
	
	<!--右部-->
	<div class="topright">
		<div class="user">
			<span>${manager.managerName}</span>
			<i>消息</i>
			<b>${count}</b>
		</div>
		<div class="exit">
			<a href="javascript:void(0);" onclick="loginout()">退出</a>
		</div>
	</div>
<script type="text/javascript">
   function loginout(){
	   $.ajax({		 
		   url:"manager!getLoginOut",
			type:"POST",
			dataType : "json",
			'success':function(data){
				var isOk = data.isOk;
				if (isOk){
					//跳到登录页面
					 window.parent.parent.location.href = "login.jsp";	
				}					
			}
	   });
   } 
</script>	
</body>
</html>
