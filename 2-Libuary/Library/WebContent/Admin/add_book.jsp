<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发布新书</title>
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
				<c:choose>
					<c:when test="${empty bookList}">
						<p>发布新书</p>
					</c:when>
					<c:otherwise>
						<p>修改图书</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="top_body">
				<img src="${pageContext.request.contextPath}/Public/img/admin/content-bg.gif" height="31px" />
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/Public/img/admin/nav-right-bg.gif" />
			</div>
		</div>

		<!-- 判断bookList是否为空，为空表示添加图书，非空修改图书 -->
		<c:choose>
			<c:when test="${empty bookList}">
				<div class="center">
					<form action="${pageContext.request.contextPath}/AddBookServlet" method="post" enctype="multipart/form-data">
						<table border="1" cellpadding="0" cellspacing="0" width="500px" height="400px">
							<tr>
								<td>ISBN:</td>
								<td><input type="text" name="isbn" id="" value="" /></td>
							</tr>
							<tr>
								<td>图书名:</td>
								<td><input type="text" name="bookname" id="" value="" /></td>
							</tr>
							<tr>
								<td>出版社名称:</td>
								<td><input type="text" name="publisher" id="" value="" /></td>
							</tr>
							<tr>
								<td>图书作者:</td>
								<td><input type="text" name="writer" id="" value="" /></td>
							</tr>
							<tr>
								<td>图书单价:</td>
								<td><input type="text" name="price" id="" value="" /></td>
							</tr>
							<tr>
								<td>图书简介:</td>
								<td><textarea name="introduce" rows="5" cols="30"></textarea></td>
							</tr>
							<tr>
								<td>图书类型:</td>
								<td>
									<select name="booktype">
										<c:forEach items="${bkclList }" var="bkcl" >
											<option value="${bkcl.typeid}">${bkcl.typename}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>上传图片:</td>
								<td><input type="file" name="picture" id="" value="" /></td>
							</tr>
							<tr>
								<td>是否标记为新书:
									<input type="radio" name="newbook" id="" value="1" checked="checked"/>是
									<input type="radio" name="newbook" id="" value="0" />否	
								</td>
								<td>是否标记为推荐:
									<input type="radio" name="recommend" id="" value="1" checked="checked" />是
									<input type="radio" name="recommend" id="" value="0" />否
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
							</tr>
						</table>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="center">
					<form action="${pageContext.request.contextPath}/EditBookServlet" method="post" enctype="multipart/form-data">
						<table border="1" cellpadding="0" cellspacing="0" width="500px" height="400px">
						
							<c:forEach items="${bookList }" var="book">
								<tr>
									<td>ISBN:</td>
									<td>
										<input type="text" name="isbn" id="" value="${book.isbn }" />
										<input type="hidden" name="bookid" value="${book.bookid }">
									</td>
								</tr>
								<tr>
									<td>图书名:</td>
									<td><input type="text" name="bookname" id="" value="${book.bookname }" /></td>
								</tr>
								<tr>
									<td>出版社名称:</td>
									<td><input type="text" name="publisher" id="" value="${book.publisher }" /></td>
								</tr>
								<tr>
									<td>图书作者:</td>
									<td><input type="text" name="writer" id="" value="${book.writer }" /></td>
								</tr>
								<tr>
									<td>图书单价:</td>
									<td><input type="text" name="price" id="" value="${book.price }" /></td>
								</tr>
								<tr>
									<td>图书简介:</td>
									<td><textarea name="introduce" rows="5" cols="30">${book.introduce }</textarea></td>
								</tr>
								<tr>
									<td>图书类型:</td>
									<td>
										<select name="booktype">
											<option value="${book.typeid}">${book.typename}</option>
											<c:forEach items="${bkclList }" var="bkcl" >
												<option value="${bkcl.typeid}">${bkcl.typename}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>上传图片:</td>
									<td>
										<img alt="${book.bookname }" src="${pageContext.request.contextPath}${book.picture }" style="width:30px;height:30px;">
										<input type="file" name="picture" id="" value="" />
									</td>
								</tr>
								<tr>
									<td>是否标记为新书:
										<c:choose>
											<c:when test="${book.newbook == 1}">
												<input type="radio" name="newbook" id="" value="1" checked="checked"/>是
												<input type="radio" name="newbook" id="" value="0" />否	
											</c:when>
											<c:otherwise>
												<input type="radio" name="newbook" id="" value="1" />是
												<input type="radio" name="newbook" id="" value="0" checked="checked" />否	
											</c:otherwise>
										</c:choose>
									</td>
									<td>是否标记为推荐:
										<c:choose>
											<c:when test="${book.newbook == 1}">
												<input type="radio" name="recommend" id="" value="1" checked="checked" />是
												<input type="radio" name="recommend" id="" value="0" />否	
											</c:when>
											<c:otherwise>
												<input type="radio" name="recommend" id="" value="1" />是
												<input type="radio" name="recommend" id="" value="0" checked="checked" />否	
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" name="" id="" value="提交" /></td>
								</tr>
							</c:forEach>
						</table>
					</form>
					
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
