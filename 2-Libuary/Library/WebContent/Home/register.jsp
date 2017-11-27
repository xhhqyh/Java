<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/register_login.css"/>
	</head>
	<body>
		<div class="main">
			<!--顶部-->
			<div class="top">
				<c:choose>
					<c:when test="${empty userLists}">
						<p>欢迎加入藏书阁</p>
					</c:when>
					<c:otherwise>
						<p>修改个人信息</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<!--注册-->
			<div id="zhuce">
			
				<c:choose>
					<c:when test="${empty userLists}">
						<form action="${pageContext.request.contextPath}/AddUserServlet" method="post" onSubmit="return check();" enctype="multipart/form-data">
							<h3>用户注册</h3>
							<p class="p1"><span>用户&nbsp;名：</span><input type="text" name="zhuce_name" required aria-required="true" id="user-name" class="width-250" placeholder="请输入用户名" onblur="checkUserName()" />&nbsp; <span id="nameInfo"></span></p>
							
							<p><span>密&nbsp;&nbsp;码：</span><input type="password" name="zhuce_pass" required aria-required="true" class="width-250" id="password" placeholder="请输入密码" onblur="checkPassword()"/>&nbsp; <span id="passwordInfo"></span></p>
							<p><span>确认密码：</span><input type="password" name="zhuce_repass" required aria-required="true" class="width-250" placeholder="请重新输入密码" id="repassword" onblur="checkRepassword()"/>&nbsp; <span id="repasswordInfo"></span></p>
							<p><span>真实姓名：</span><input type="text" name="TrueName" required aria-required="true" id="user-TrueName" class="width-250" placeholder="请输入真实姓名" onblur="checkUserTrueName()"/>&nbsp; <span id="TrueNameInfo"></span></p>
							<p>
								<span>性&nbsp;&nbsp;别：</span>
								<input type="radio" name="zhuce_sex" id="" value="1" checked="checked"/>男
								<input type="radio" name="zhuce_sex" id="" value="0"/>女
							</p>
							<p><span>邮政编码：</span><input type="text" class="width-250" name="postcode" id="user-post" required="required" placeholder="请输入邮编" onblur="checkPost()"/>&nbsp; <span id="birhdayInfo"></span></p>
							<p><span>家庭住址：</span><input type="text" name="Address" required="required" class="width-250" id="user-Address" placeholder="请输入家庭住址" onblur="checkUserAddress()"/>&nbsp; <span id="AddressInfo"></span></p>
							<p><span>电话号码：</span><input type="text" name="Tel" required="required" class="width-250" id="user-Tel" placeholder="请输入电话号码" onblur="checkUserTel()"/>&nbsp; <span id="TelInfo"></span></p>
							<p><span>电子邮箱：</span><input type="text" name="Email" required="required" class="width-250" id="user-Email" placeholder="请输入电子邮箱"onblur="checkUserEmail()"/>&nbsp; <span id="EmailInfo"></span></p>
							<p><span>上传头像：</span><input type="file" name="picture" id="" value="" /></p>
							<p><input type="submit" id="" class="submit" value="提交" />
							<input type="reset" name="" id="" class="submit" value="重置" /></p>
						</form>
					</c:when>
					<c:otherwise>
						<form action="${pageContext.request.contextPath}/EditUserServlet" method="post" >
							<c:forEach items="${userLists }" var="user">
								<h3>用户修改</h3>
								<p class="p1"><span>用户&nbsp;名：</span><input type="text" name="zhuce_name" value="${user.username}" required aria-required="true" id="user-name" class="width-250" placeholder="请输入用户名" />&nbsp; <span id="nameInfo"></span></p>
								
								<p><span>真实姓名：</span><input type="text" name="TrueName" value="${user.truename}" required aria-required="true" id="user-TrueName" class="width-250" placeholder="请输入真实姓名" />&nbsp; <span id="TrueNameInfo"></span></p>
								<p>
									<span>性&nbsp;&nbsp;别：</span>
									<input type="radio" name="zhuce_sex" id="" value="1" <c:if test="${user.sex == '1'}">checked="checked"</c:if>/>男
									<input type="radio" name="zhuce_sex" id="" value="0" <c:if test="${user.sex == '0'}">checked="checked"</c:if>/>女
								</p>
								<p><span>邮政编码：</span><input type="text" value="${user.postcode}" class="width-250" name="postcode" id="user-post" required="required" placeholder="请输入邮编" />&nbsp; <span id="birhdayInfo"></span></p>
								<p><span>家庭住址：</span><input type="text" value="${user.city}" name="Address" required="required" class="width-250" id="user-Address" placeholder="请输入家庭住址" />&nbsp; <span id="AddressInfo"></span></p>
								<p><span>电话号码：</span><input type="text" value="${user.phone}" name="phone" required="required" class="width-250" id="user-Tel" placeholder="请输入电话号码" />&nbsp; <span id="TelInfo"></span></p>
								<p><span>电子邮箱：</span><input type="text" value="${user.email}" name="Email" required="required" class="width-250" id="user-Email" placeholder="请输入电子邮箱"/>&nbsp; <span id="EmailInfo"></span></p>
								<input type="hidden" name="userid" value="${user.userid }" />
							</c:forEach>
							<p><input type="submit" id="" class="submit" value="提交" />
							<input type="reset" name="" id="" class="submit" value="重置" /></p>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Public/Js/check_user_register.js"></script>
</html>

