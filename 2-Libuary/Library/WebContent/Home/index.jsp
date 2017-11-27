<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>图书商城主页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Public/css/index_style.css"/>
</head>
<body>
	<!-- 主体结构 -->
	<div class="main">
	${flag }---
		<!-- 包含顶部 -->
		<jsp:include page="head.jsp"/>

		<!-- 中间部分 -->
		<div class="center">
			<!-- 图书展示 -->
			<div class="center-left">
				<!-- 新书列表 -->
				<div class="left-new">
					<p class="left-p1"><span>新到特价书精选</span></p>
					<div class="newbook">
						<ul>
							<c:forEach items="${newbook }"  var="newbook" step="1" >
								<li>
									<p>${newbook.bookname }</p>
									<p class="left-p2">${newbook.writer }</p>
									<p class="left-p3">￥${newbook.price }</p>
									<p class="left-p4"><a href="${pageContext.request.contextPath}/AddCarServlet?bookid=${newbook.bookid }&flag=${flag }">加入购物车</a></p>
									<img src="${pageContext.request.contextPath}${newbook.picture }" alt="" />
								</li>
							</c:forEach>
						</ul>
					</div>
				</div><!-- 新书列表结束 -->
				
				<!-- 书籍展示 -->
				<div class="book">
					<p class="left-p1">图书展示</p>
					<div class="booklist">
						<ul>
							<c:forEach items="${bookLists }" var="book" >
								<li>
									<div class="bookimg">
										<img src="${pageContext.request.contextPath}${book.picture }"/>
										<p>${book.bookname }</p>
										<p class="left-p2">${book.writer }</p>
										<p class="left-p3">￥${book.price }</p>
										<p class="left-p5"><a href="${pageContext.request.contextPath}/AddCarServlet?bookid=${book.bookid }&flag=${flag}">加入购物车</a></p>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div><!--书籍展示结束-->
				<!--分页-->
				<div class="page">
					<ul>
						<li><a href="${pageContext.request.contextPath}/Home/index?flag=first">首页</a></li>
						<li>第${c }页</li>
						<li><a href="${pageContext.request.contextPath}/Home/index?flag=shang">上一页</a></li>
						<li><a href="${pageContext.request.contextPath}/Home/index?flag=next">下一页</a></li>
						<li><a href="${pageContext.request.contextPath}/Home/index?flag=last">尾页</a></li>
						<li>共${count }页</li>
					</ul>
				</div>
			</div>
			<!-- 排行展示 -->
			<div class="center-right">
				<!-- 公告 -->
				<div class="notice">
					<p>公告展示</p>
					<ul>
						<c:forEach items="${noticeList }" var="notice">
							<li><img src="${pageContext.request.contextPath}/Public/img/admin/to.gif" alt="" /><a href="">${notice.bbshead }</a><span>${notice.intime }</span></li>
						</c:forEach>
					</ul>
				</div>
				
				<!-- 购物车 -->
				<div class="salecar">
					<p>购物车<a href="${pageContext.request.contextPath}/QueryCarServlet">更多>></a></p>
					<table border="1px" cellspacing="0px" cellpadding="0px" width="284px">
						<tr>
							<th>书名</th>
							<th>单价</th>
							<th>数量</th>
						</tr>
						
						<c:forEach items="${carList }" var="car">
							<tr align="center">
								<td>${car.bookname }</td>
								<td>${car.price }</td>
								<td>${car.num }</td>
							</tr>
						</c:forEach>
						<tr align="center">
							<td>小计:</td>
							<td>${money }元</td>
							<td>共${number }本</td>
						</tr>
					</table>
				</div>
				
				<!-- 销售排行 -->
				<div class="saletop">
					<p>销售排行</p>
					<ul>
						<c:forEach items="${bookList }" var="book">
							<li><a href=""><span>${book.num }></span>${book.bookname }<span class="author">作者:${book.writer }</span></a></li>
						</c:forEach>
					</ul>
				</div>
			
				<!-- 投票 -->
				<div class="poll">
					<p class="poll-p1">网上调查</p>
					<p class="poll-p2">您需要哪方面书籍:</p>
					<form action="${pageContext.request.contextPath}/AddPollServlet" method="post">
						<c:forEach items="${bookclass }" var="bs">
							<p><input type="radio" name="poll" id="poll" value="${bs.typename }" />${bs.typename }</p>
						</c:forEach>
						<input type="submit" class="input-1" value="投票"/>
					</form>
				</div>
			</div>
		</div><!--中间部分结束-->
		
		<!-- 动态加载底部 -->
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>










