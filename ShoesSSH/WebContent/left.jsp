<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快乐买后台-左菜单</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="shortcut icon" href="img/favicon_logo.ico" />
<script type="text/javascript" src="easyUI/jquery.min.js"></script>	
</script>
<script type="text/javascript">
	$(function(){
		//加载当前登录用户的权限菜单
		InitLeftMenu();
	})
	/* 得到左侧的菜单------------------------------------------------------------------------------------- */
	function InitLeftMenu() {
	    /* 请求 getMenuByRoleId 得到role角色的菜单拼接到div*/
	    $.ajax({
		   type: "POST",
		   url: "menu!getMenuByRoleId",
		   dataType : "json",
		   success: function(data){
				var menulist = "";
				for(var i=0; i<data.menus.length; i++){
					menulist += "<dd>";
					menulist += "<div class='title'><span><img src='img/leftico02.png' /></span>"+data.menus[i].menuname+"</div><ul class='menuson'>";
					if(data.menus[i].menus){
						for(var j=0; j<data.menus[i].menus.length; j++){
							menulist += "<li><cite></cite><a href='" + data.menus[i].menus[j].url + "' target='rightFrame'>" + data.menus[i].menus[j].menuname + "</a></li>";
						}
					}
					menulist += "</ul></dd>";
				}
				//添加到相应的dom节点中
				$("#leftMenuInfo").append(menulist);
				
				//导航切换
				$(".menuson li").click(function(){
					$(".menuson li.active").removeClass("active")
					$(this).addClass("active");
				});
				
				//实现滑动效果
				$('.title').click(function(){
					var $ul = $(this).next('ul');
					$('dd').find('ul').slideUp();
					if($ul.is(':visible')){
						$(this).next('ul').slideUp();
					}else{
						$(this).next('ul').slideDown();
					}
				});
		    }
		});
	}
</script>
</head>
<body style="background:#f0f9fd;">
	<!--左边菜单栏顶部-->
	<div class="lefttop">
		<span></span>
		<p>功能菜单</p>
	</div>
	<dl class="leftmenu" id="leftMenuInfo"></dl>
</body>
</html>