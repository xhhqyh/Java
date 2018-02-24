<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论信息</title>
<link rel="stylesheet" type="text/css"href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<!-- <script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script> -->
</head>
<body>
	<table id="evaluteDg" class="easyui-datagrid" title="评论信息"
		style="width: 1570px; height: 770px"
		data-options="singleSelect:false,
						  collapsible:true,
						  toolbar: '#evaluteToolbar',
						  url:'evalute!getCommentInfo',
						  method:'get',
						  fit:true,
						  fitColumns:true,
						  pagination:true,
						  pageSize:10,
						  pageList:[2,3,4,5,6,7,8,9,10]">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'evaluteId',width:80,align:'center'">编号</th>
				<th
					data-options="field:'user',width:210,align:'center',formatter:formatUser">用户名字</th>
				<th
					data-options="field:'goods',width:210,align:'center',formatter:formatGoods">鞋子名字</th>
				<th data-options="field:'evaluteInformation',width:210,align:'center'">评论问题</th>
				<th data-options="field:'evaluteTime',width:200,align:'center'">评论时间</th>
				<th data-options="field:'evaluteLevel',width:220,align:'center',formatter:formaTevaluteLevel">评论星级</th>
				<th data-options="field:'evaluteStatus',width:220,align:'center',formatter:formatDo">处理</th>
			</tr>
		</thead>
	</table>  
	<!-- 头部文件 -->
	<div id="evaluteToolbar">	
		<a href="#" class="easyui-linkbutton"data-options="iconCls:'icon-search',plain:true" onclick="query(2)">全部咨询</a>
		<a href="#" class="easyui-linkbutton"data-options="iconCls:'icon-search',plain:true" onclick="query(0)">未回复</a>
		<a href="#" class="easyui-linkbutton"data-options="iconCls:'icon-search',plain:true" onclick="query(1)">已回复</a>
		
	</div>
	<!-- 增改div -->
	<div id="evaluteDialog" class="easyui-dialog" title="回复信息操作"
		data-options="iconCls:'icon-save',closed:true"
		style="width: 500px; height: 600px; padding: 10px">
		<form id="evaluteForm" action="evalute!saveEvalute" method="get">
			<table cellpadding="5">
				<tr>
					<td>用户名字:</td>
					<td>
					     
					     <input id="evaluteIds" type="hidden" name="evalute.evaluteId">
					     <!-- 用户ID -->
					     <input id="userId" type="hidden" name="evalute.userId">
					     <input id="userName" readOnly="readonly" class="easyui-textbox"  data-options="required:true,width:220"/>						
					</td>
			     </tr>
			     <tr>		
					<td>鞋子名字:</td>
					<td>
					    <input id="goodsId" type="hidden" name="evalute.goodsId">
						<input id="goodsName" readOnly="readonly" class="easyui-textbox"  data-options="required:true,width:220"/>
					</td>					
				</tr>
				<tr>
	    			<td>买家评论:</td>
	    			<td>
	    				<input id="evaluteInformation" readOnly="readonly" name="evalute.evaluteInformation" class="easyui-textbox" data-options="required:true,width:220"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>评论时间:</td>
	    			<td>
	    				<input id="evaluteTime" readOnly="readonly" name="evalute.evaluteTime" class="easyui-textbox" data-options="width:220"/>
	    			</td>
	    		</tr>	    		
	    		<tr>
	    			<td>评论星级:</td>
	    			<td>
	    			    <!-- 评论星级 -->
	    				<input id="evaluteLevels" type="hidden" name="evalute.evaluteLevel"/>
	    				<input id="evaluteLevel" readOnly="readonly"   class="easyui-textbox" data-options="required:true,width:220"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>客服回复:</td>
	    			<td>
	    				<input id="evaluteContent" class="easyui-textbox" name="evalute.evaluteContent" data-options="required:true,width:220"/>
	    				<!-- 咨询状态 0未处理 1 已处理 -->
	    				<input id="evaluteStatus" type="hidden" name="evalute.evaluteStatus"/>
	    				<!-- 管理员ID -->
	    				<input id="managerId" type="hidden" name="evalute.managerId"/>
	    				<!-- 评价 -->
	    				<input id="evaluteChoice" type="hidden" name="evalute.evaluteChoice"/>	    				
	    			</td>
	    		</tr>		    		    				
			</table>
		</form>	
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">保存</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">清除</a>
		</div>
	</div>
	<script type="text/javascript">	
		//获得类型名字
		function formatUser(value, row, index) {
			if (value != null) {
				return value.userName;
			} else {
				return '无';
			}
		}
		//获得品牌名字
		function formatGoods(value, row, index) {
			if (value != null) {
				return value.goodsName;
			} else {
				return '无';
			}
		}
		//判断鞋子款式
		function formaTevaluteLevel(value, row, index) {
			if(value != null && value == 1){
				return "★☆☆☆☆";
			}else if(value == 2){
				return "★★☆☆☆";
			}else if(value == 3){
				return "★★★☆☆";
			}else if(value == 4){
				return "★★★★☆";
			}else if(value == 5){
				return "★★★★★";
			}else{
				return "无评论星级";
			}
			
		}
		//回复评论信息
		function formatDo(value, row, index) {
			if (value != null && value == 0) {
				return '<a href="#"  onclick="openWin()">回复评论</a>';
			} else{
				return '<font color="red">已回复</font>';
			}
		}	
		//条件查询
		function query(data){
			 $("#evaluteDg").datagrid('reload',{
				 "status":data,
				 "query":"search"
			 });
		}
		//打开增改div
		function openWin() {						
				var chkRows = $("#evaluteDg").datagrid("getChecked");				  
					$("#evaluteIds").val(chkRows[0].evaluteId);
					$("#userId").val(chkRows[0].user.userId);
					$("#userName").textbox("setValue",chkRows[0].user.userName);
					$("#goodsId").val(chkRows[0].goods.goodsId);
					$("#goodsName").textbox("setValue",chkRows[0].goods.goodsName);					
					$("#evaluteInformation").textbox("setValue",chkRows[0].evaluteInformation);
					$("#evaluteTime").textbox("setValue",chkRows[0].evaluteTime);
					$("#evaluteContent").textbox("setValue",chkRows[0].evaluteContent);						
					$("#evaluteStatus").val(1);					
					$("#managerId").val(chkRows[0].manager.managerId);					
					$("#evaluteChoice").val(chkRows[0].evaluteChoice);
					$("#evaluteLevels").val(chkRows[0].evaluteLevel);
					if(chkRows[0].evaluteLevel == 1){
						$("#evaluteLevel").textbox("setValue","★☆☆☆☆");
					}else if(chkRows[0].evaluteLevel == 2){
						$("#evaluteLevel").textbox("setValue","★★☆☆☆");
					}else if(chkRows[0].evaluteLevel == 3){
						$("#evaluteLevel").textbox("setValue","★★★☆☆");
					}else if(chkRows[0].evaluteLevel == 4){
						$("#evaluteLevel").textbox("setValue","★★★★☆");
					}else if(chkRows[0].evaluteLevel == 5){
						$("#evaluteLevel").textbox("setValue","★★★★★");
					}else{
						$("#evaluteLevel").textbox("setValue","无评论星级");
					}
															
					$('#evaluteDialog').dialog('open')		
		}
		
		function submitForm() {
			$('#evaluteForm').form({
				success : function(data) {
					$('#evaluteDialog').dialog('close');
					$("#evaluteDg").datagrid("load");
				}
			});
			$('#evaluteForm').form('submit');
		}		
	</script>




</body>
</html>