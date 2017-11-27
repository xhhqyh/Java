<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加新菜单</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/admin_right.css"/>
	</head>
	<body id="background">
		<div id="main">
			<div id="top">
				<div id="">
					<img src="${pageContext.request.contextPath}/Public/img/admin/left-top-right.gif"/>
				</div>
				<div id="title">
					<p>图书展示</p>
				</div>
				<div id="top_body">
					<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
				</div>
			</div>
			
			
			<div class="center">
				<form action="#" method="post">
					<table border="1" align="center" cellpadding="0" cellspacing="0" width="1000px">
						<tr align="center">
							<td colspan="12"><b>图书信息列表</b></td>
						</tr>
						<tr align="center">
							<th height="10%">ISBN</th>
							<th>图书名</th>
							<th>图片</th>
							<th>类型</th>
							<th>出版社</th>
							<th>作者</th>
							<th>单价</th>
							<th>是否新书</th>
							<th>是否推荐</th>
							<th>简介</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
						<c:forEach items="${bookList }" var="book">
							<tr align="center">
								<td>${book.isbn }</td>
								<td>${book.bookname }</td>
								<td><img alt="${book.bookname }" src="${pageContext.request.contextPath}${book.picture }" style="width:30px;height:30px;"></td>
								<td>${book.typename }</td>
								<td>${book.publisher }</td>
								<td>${book.writer }</td>
								<td>${book.price }</td>
								<td>
									<c:choose>
										<c:when test="${book.newbook == 1}">
											是
										</c:when>
										<c:otherwise>
											否
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test="${book.command == 1}">
											是
										</c:when>
										<c:otherwise>
											否
										</c:otherwise>
									</c:choose>
								</td>
								<td>${book.introduce }</td>
								<td><a href="${pageContext.request.contextPath}/UpdateBookServlet?bookid=${book.bookid }">修改</a></td>
								<td><a href="javascript:if(confirm('确实要删除吗?'))location='${pageContext.request.contextPath}/DeleteBookServlet?isbn=${book.isbn }'">删除</a></td>
							</tr>
						</c:forEach>
						
						<tr align="center">
							<td colspan="12">
								共【${count }】页&nbsp;
								<a href="${pageContext.request.contextPath}/QueryBookServlet?flag=first">首页</a>
								<a href="${pageContext.request.contextPath}/QueryBookServlet?flag=shang">上一页</a>
								<a href="${pageContext.request.contextPath}/QueryBookServlet?flag=next">下一页</a>
								<a href="${pageContext.request.contextPath}/QueryBookServlet?flag=last">尾页</a>
								第${c }页
							</td>
						</tr>
					</table>
				</form>
				
			</div>
		</div>
	</body>
</html>
