<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆快乐买后台管理系统</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="shortcut icon" href="img/favicon_logo.ico" />
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
</head>
<body style="background-color: #1C77AC;overflow: hidden;">
	<div class="logintop">
		<span>欢迎登陆快乐买后台管理系统</span>
	</div>
	
	<!--登陆框-->
	<div class="loginbody">
		<form id="loginform" method="post">
			<div class="loginbox">
				<div class="systemlogo"></div>
				<ul>
					<li><input type="text" autocomplete="off" class="loginuser" id="input-1" name="manager.managerName" placeholder="账号"/></li>
					<li><input type="password" class="loginpwd" name="manager.managerPwd" placeholder="密码" /></li>
					<li><input type="button" class="loginbtn" id="loginId" onclick="submitForm()" name="admin" value="登陆" /></li>
				</ul>
			</div>
		</form>
	</div>
	
	<!--底部-->
	<div class="loginbom">版权所有 @hpe11-第四小组</div>

	<script type="text/javascript">
		$(function(){
			//网页加载时，表单主动获取焦点
			$("#input-1").focus();
			
			$('#loginform').form({
				url:'manager!loginManager',
				onSubmit:function(){
				var isValid = $(this).form('validate');
				    if(!isValid){
					    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
					}
					return isValid;
				},
				success:function(result){
					result = $.parseJSON(result);
					if (result.msg=="success") {
				    	window.location.href='main.jsp';
			    	}else{
			    	    alert(1);
			    	    $.messager.show({
							title:'提示',
							msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+result.msg+'</div></div>',
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
			    	}
				}   		  
			});    	  
		});
		//点击登陆
		function submitForm(){
			$('#loginform').submit();
		}  
		
		//回车登录
		function enterlogin(){
			if (event.keyCode == 13){
		       	event.returnValue=false;
		       	event.cancel = true;
		       	$('#loginform').submit();
		   	}
		}
	</script>
</body>
</html>