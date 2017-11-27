<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"                                                                                                                                                                                                                                                 %>
<%@ page import="Apo.Home.DataModel.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Apo.Admin.DataModel.*" %>
<%@ page import="Apo.Hui.Db.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>订餐系统</title>
	<link rel="stylesheet" type="text/css" href="../Public/css/Home_index.css"/>
</head>
<body>
<% 
	//接收session值
	String name = (String)session.getAttribute("name");
	String Mem_Id = (String)session.getAttribute("Mem_Id");

%>

	<!--主体框架-->
	<div id="main">
		
		<!--头部-->
		<div id="top">
			<div id="top-1">
				<!--头部导航-->
				<div id="top-1-img">
					<img src="../Public/img/Home/1257477260.gif"/>
				</div>
				<div id="top-1-ul">
					<ul>
						<li><a href="./index.jsp">首页</a></li>
						<li><a href="eatcar.jsp">我的餐车</a></li>
						<li><a href="order.jsp">我的订单</a></li>
						<li><a href="User.jsp">用户中心</a></li>
						<li><a href="send.jsp">配送说明</a></li>
						<li><a href="#bottom">关于我们</a></li>
					</ul>
				</div>
				<!--登录注册-->
				<div id="top-1-ul2">
					<ul>
						<%if(Mem_Id != null && name != null){%>
							<li><p>欢迎:<a href="./login.html"><%=name %>&nbsp;</a>|</p></li>
							<li><p><a href="./DataOperate/Exit.jsp">&nbsp;退出</a></p></li>
						<%}else{%>
							<li><p><a href="./login.html"><img src="../Public/img/Home/2017-02-28_194115.jpg"/>登录&nbsp;</a>|</p></li>
							<li><p><a href="./zhuce.html">&nbsp;注册</a></p></li>
						<%} %>
					</ul>
				</div>
			</div>
			
			<!--透明模块-->
			<div id="top-2">
				<div id="top-2-1" class="top-2-same">
					<p>阿婆私房菜</p>
				</div>
				<div id="top-2-2" class="top-2-same">
					<p>让你的舌尖去旅行！</p>
				</div>
			</div>
		</div>
		
		<!--中间部分-->
			<div id="center">
				<div id="center-top">
					<p>MENU</p>
				</div>
				<div id="center-center">
					<div id="center-center-left">
					
					<%!
						//定义全局变量
						int count = 0; //表中共有多少条数据
						int a = 6;     //每页多少条数据
						int b = 0;     //共分多少页
						int c = 1;     //当前页数
						int min = 1;   //查询最小值
						int max = 6;   //查询最大值
						%>
						<%
						Connection conn = DbUtil.getconn();
						//将表中的记录数查出来放在count中
						String sql2 = " SELECT COUNT(*) count FROM Menu_Info ";
						ResultSet rs2 = DbHelper.executeQuery(conn, sql2);
						if(rs2.next()){
							count = rs2.getInt("count");
						}
						
						//计算共有多少页，不能整除就将页数加一
						if (count % a == 0 ){
							b = count / a;
						}else if (count % a != 0){
							b = count / a + 1;
						}
						
						//根据不同的请求切换到不同的页面
						String flag = request.getParameter("flag");
							if ("first".equals(flag)){                  //首页
								min = 1;
								max = 6;
								c = 1;
							}else if ("shang".equals(flag)  && c > 1){  //上一页
								min = min - a;
								max = max - a;
								c = c - 1;
							}else if ("next".equals(flag) && c < b){     //下一页
								min = min + a;
								max = max + a;
								c = c + 1;
							}else if ("last".equals(flag)){             //最后一页
								min = a * (b - 1) + 1;
								max = count;
								c = b;
								
							}

					
					//接收菜单查询结果
					ArrayList<Menu_Data> rs = ApoHome.select(min, max);
					

					for(int m=0; m< rs.size(); m++){
						   int a = (m+1)%1;
						   int b = (m+1)%2;
						   int c = (m+1)%3;
						   if(a==0 && b!=0 && c!=0){
					%>
								<!--第一排3个-->
								<div id="center-center-left-1">
									<a href="#">
										<div id="moddle-1" class="gray">
											<img src="..<%=rs.get(m).getMenu_upPhoto() %>" width="172px" height="172px"/>
											<p>市场价：<%=rs.get(m).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(m).getMenu_memberPrice() %></span></p>
											<h3><%=rs.get(m).getMenu_Name() %></h3>
											<form action="./DataOperate/Add_Car.jsp" method="post">
												<input type="hidden" name="Menu_Name" value="<%=rs.get(m).getMenu_Name() %>" />
												<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(m).getMenu_memberPrice() %>" />
												<input type="submit" class="center-input" value="加入餐车"/>
											</form>
										</div>
										<div class="hidden">
										</div>
										<div class="hidden-word">
											<p class="hidden-p1">菜品类型:<%=rs.get(m).getGr_Sort() %></p>
											<p class="hidden-p1-2">食材:</p>
											<p class="hidden-p1-2"><%=rs.get(m).getMenu_Rmaterial() %></p>
										</div>
									</a>
								</div>
							<%}else if(a==0 && b==0 && c!=0){ %>
									<div id="center-center-left-1">
										<a href="#">
											<div id="moddle-1" class="blue">
												<img src="..<%=rs.get(m).getMenu_upPhoto() %>" width="172px" height="172px"/>
												<p>市场价：<%=rs.get(m).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(m).getMenu_memberPrice() %></span></p>
												<h3><%=rs.get(m).getMenu_Name() %></h3>
												<form action="./DataOperate/Add_Car.jsp" method="post">
													<input type="hidden" name="Menu_Name" value="<%=rs.get(m).getMenu_Name() %>" />
													<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(m).getMenu_memberPrice() %>" />
													<input type="submit" class="center-input" value="加入餐车"/>
												</form>
											</div>
											<div class="hidden">
											</div>
											<div class="hidden-word">
												<p class="hidden-p1">菜品类型:<%=rs.get(m).getGr_Sort() %></p>
												<p class="hidden-p1-2">食材:</p>
												<p class="hidden-p1-2"><%=rs.get(m).getMenu_Rmaterial() %></p>
											</div>
										</a>
									</div>
							<%}else if(a==0 && b!=0 && c==0){ %>
									<div id="center-center-left-1">
										<a href="#">
											<div id="moddle-1" class="green">
												<img src="..<%=rs.get(m).getMenu_upPhoto() %>" width="172px" height="172px"/>
												<p>市场价：<%=rs.get(m).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(m).getMenu_memberPrice() %></span></p>
												<h3><%=rs.get(m).getMenu_Name() %></h3>
												<form action="./DataOperate/Add_Car.jsp" method="post">
													<input type="hidden" name="Menu_Name" value="<%=rs.get(m).getMenu_Name() %>" />
													<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(m).getMenu_memberPrice() %>" />
													<input type="submit" class="center-input" value="加入餐车"/>
												</form>
											</div>
											<div class="hidden">
											</div>
											<div class="hidden-word">
												<p class="hidden-p1">菜品类型:<%=rs.get(m).getGr_Sort() %></p>
												<p class="hidden-p1-2">食材:</p>
												<p class="hidden-p1-2"><%=rs.get(m).getMenu_Rmaterial() %></p>
											</div>
										</a>
									</div>
							<%}else{%>
								<div id="center-center-left-1">
										<a href="#">
											<div id="moddle-1" class="green">
												<img src="..<%=rs.get(m).getMenu_upPhoto() %>" width="172px" height="172px"/>
												<p>市场价：<%=rs.get(m).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(m).getMenu_memberPrice() %></span></p>
												<h3><%=rs.get(m).getMenu_Name() %></h3>
												<form action="./DataOperate/Add_Car.jsp" method="post">
													<input type="hidden" name="Menu_Name" value="<%=rs.get(m).getMenu_Name() %>" />
													<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(m).getMenu_memberPrice() %>" />
													<input type="submit" class="center-input" value="加入餐车"/>
												</form>
											</div>
											<div class="hidden">
											</div>
											<div class="hidden-word">
												<p class="hidden-p1">菜品类型:<%=rs.get(m).getGr_Sort() %></p>
												<p class="hidden-p1-2">食材:</p>
												<p class="hidden-p1-2"><%=rs.get(m).getMenu_Rmaterial() %></p>
											</div>
										</a>
									</div>
							<%} 
							}
							int pageNum = fenye.fenye("Menu_Info", 6);
							%>
						<!--第二排三个-->
						<%-- <div id="center-center-left-1" class="second">
							<a href="#">
								<div id="moddle-1" class="gray">
									<img src="..<%=rs.get(3).getMenu_upPhoto() %>"/>
									<p>市场价：<%=rs.get(3).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(3).getMenu_memberPrice() %></span></p>
									<h3><%=rs.get(3).getMenu_Name() %></h3>
									<form action="./DataOperate/Add_Car.jsp" method="post">
										<input type="hidden" name="Menu_Name" value="<%=rs.get(3).getMenu_Name() %>" />
										<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(3).getMenu_memberPrice() %>" />
										<input type="submit" class="center-input" value="加入餐车"/>
									</form>
								</div>
								<div class="hidden">
								</div>
								<div class="hidden-word">
									<p class="hidden-p1">菜品类型:<%=rs.get(3).getGr_Sort() %></p>
									<p class="hidden-p1-2">食材:</p>
									<p class="hidden-p1-2"><%=rs.get(3).getMenu_Rmaterial() %></p>
								</div>
							</a>
						</div>
						<div id="center-center-left-1" class="second">
							<a href="#">
								<div id="moddle-1" class="blue">
									<img src="..<%=rs.get(4).getMenu_upPhoto() %>"/>
									<p>市场价：<%=rs.get(4).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(4).getMenu_memberPrice() %></span></p>
									<h3><%=rs.get(4).getMenu_Name() %></h3>
									<form action="./DataOperate/Add_Car.jsp" method="post">
										<input type="hidden" name="Menu_Name" value="<%=rs.get(4).getMenu_Name() %>" />
										<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(4).getMenu_memberPrice() %>" />
										<input type="submit" class="center-input" value="加入餐车"/>
									</form>
								</div>
								<div class="hidden">
								</div>
								<div class="hidden-word">
									<p class="hidden-p1">菜品类型:<%=rs.get(4).getGr_Sort() %></p>
									<p class="hidden-p1-2">食材:</p>
									<p class="hidden-p1-2"><%=rs.get(4).getMenu_Rmaterial() %></p>
								</div>
							</a>
						</div>
						<div id="center-center-left-1" class="second">
							<a href="#">
								<div id="moddle-1" class="green">
									<img src="..<%=rs.get(5).getMenu_upPhoto() %>"/>
									<p>市场价：<%=rs.get(5).getMenu_marketPrice() %>&nbsp;会员价: <span><%=rs.get(5).getMenu_memberPrice() %></span></p>
									<h3><%=rs.get(5).getMenu_Name() %></h3>
									<form action="./DataOperate/Add_Car.jsp" method="post">
										<input type="hidden" name="Menu_Name" value="<%=rs.get(5).getMenu_Name() %>" />
										<input type="hidden" name="Menu_memberPrice" value="<%=rs.get(5).getMenu_memberPrice() %>" />
										<input type="submit" class="center-input" value="加入餐车"/>
									</form>
								</div>
								<div class="hidden">
								</div>
								<div class="hidden-word">
									<p class="hidden-p1">菜品类型:<%=rs.get(5).getGr_Sort() %></p>
									<p class="hidden-p1-2">食材:</p>
									<p class="hidden-p1-2"><%=rs.get(5).getMenu_Rmaterial() %></p>
								</div>
							</a>
						</div> --%>
					<!--分页-->
					<div id="page">
						<div class="page-ul">
							<ul>
								<li class="page-li-1 page-li-11">共<%=b %>页</li>
								<li class="page-li-1 page-li-11"><a href="index.jsp?flag=first">[首页]</a></li>
								<li class="page-li-1 page-li-11"><a href="index.jsp?flag=shang">上一页</a></li>
								<li class="page-li-1 page-li-11">第<%=c %>页</li>
								<li class="page-li-1 page-li-11"><a href="index.jsp?flag=next">下一页</a></li>
								<li class="page-li-1 page-li-11"><a href="index.jsp?flag=last">[尾页]</a></li>
							</ul>
						</div>
					</div>
				</div>
				
				<!--中间右部-->
				<div id="center-center-right">
					<!--餐厅公告-->
					
					<%
						//拿到餐厅公告查询结果集
						ResultSet Nt_rs = Apo.Notice_Select();
					%>
					
					<div id="gonggao" class="gonggao-same">
						<p>餐厅公告<a href="./Notice_List.jsp">更多>></a></p>
						<ul>
							<% 
							int i=0;
							while(Nt_rs.next()){ 
								i++;
								if(i >= 3){%>
									<li style="display:none;"><img src="../Public/img/Home/6.jpg"/><a href="Notice_Content.jsp?title=<%=Nt_rs.getString("No_Title") %>"><%=Nt_rs.getString("No_Title") %></a></li>
							<%}else{ %>
									<li><img src="../Public/img/Home/6.jpg"/><a href="Notice_Content.jsp?title=<%=Nt_rs.getString("No_Title") %>"><%=Nt_rs.getString("No_Title") %></a></li>
							<% }}%>
						</ul>
					</div>
					<!--我的餐车-->
					<%
						//拿到购物车查询结果集
						ResultSet Car_rs = ApoHome.Select_Car(name);
					%>
					
					<div id="canche" class="gonggao-same">
						<p>我的餐车<a href="eatcar.jsp">详细>></a></p>
						<table >
							<tr>
								<td><b>菜品名称</b></td>
								<td><b>单价</b></td>
								<td><b>数量</b></td>
							</tr>
							<% 
							//总价格
							int total=0;
							//总份数
							int total_num=0;
							String Car_Order_Price = "";
							String num = "";
							while(Car_rs.next()){ %>
							<tr>
								<td><%=Car_rs.getString("Car_Dish_Name") %></td>
								<td><%=Car_rs.getString("Car_Order_Price") %></td>
								<td><%=Car_rs.getString("num") %></td>
								<%
									Car_Order_Price = Car_rs.getString("Car_Order_Price");
									num = Car_rs.getString("num");
									int b = Integer.valueOf(Car_Order_Price).intValue();
									int a = Integer.valueOf(num).intValue();
									total = total + a*b;
									total_num = total_num + a;
								%>
							</tr>
							<% } %>
							<tr>
								<td>小计</td>
								<td><%=total %>元</td>
								<td><%=total_num %>份</td>
							</tr>
							<tr>
								<td>
									<a href="./DataOperate/Car_Pay_index.jsp" class="border-1px">提交</a>
									
								</td>
								<td colspan="2">
									<a href="./DataOperate/Car_Cancel_Main.jsp?Id=main" class="border-1px border-1px-1">全部取消</a>
								</td>
							</tr>
						</table>
					</div>
					<!--销售排行榜-->
					<%
						//拿到销售排行的结果
						ResultSet Sale_rs = ApoHome.Select_Sale();
					%>
					
					
					<div id="xiaoshou" class="gonggao-same">
						<p>销售排行榜</p>
						<ul>
							<%
								int n=1;
								while(Sale_rs.next()){ 
									if(n > 8){
							%>
										<li style="display:none;"><img src="../Public/img/Home/6.jpg"/><%=n %>、<span class="span1"><%=Sale_rs.getString("Ord_grName") %></span><span class="span2">已销售<%=Sale_rs.getString("num") %>份</span></li>
									<%}else{ %>
									<li><img src="../Public/img/Home/6.jpg"/><%=n %>、<span class="span1"><%=Sale_rs.getString("Ord_grName") %></span><span class="span2">已销售<%=Sale_rs.getString("num") %>份</span></li>
							<%
									}
								n++;
							} %>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<!--尾部-->
		<div id="bottom">
			<div id="bottom-1">
				<div id="bottom-1-1">
					<h1>关于我们</h1>
					<p class="bottom-1-1">小时候的味道”即便五年十年都没机会再吃，也总是会挂念着，一吃就能想起过往时的味道来。这种味觉记忆，缠绕着思乡的点滴情怀，成为人们最原始的“乡愁”。你也有“小时候的味道”吗？ </p>
					<p class="bottom-1-1"> 欢迎来到阿婆私房菜，让你重温童年妈妈的味道！</p>
					<p class="bottom-1-2">---阿婆</p>
				</div>
			</div>
		</div>
		<div id="bottom2">
			<h1>联系我们</h1>
			<hr />
			<div id="bottom2-1">
				<p class="padding-20-0">您的意见是我们前进的动力</p>
			</div>
			<div id="bottom-3">
				<div id="bottom-3-1">
					<p>&copy;阿婆私房菜|电话：0317-154862|地址:武汉软件园</p>
				</div>
				<div id="bottom-3-2">
					<!--<img src="../Public/img/Home/2017-07-17_185137.jpg"/>-->
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
