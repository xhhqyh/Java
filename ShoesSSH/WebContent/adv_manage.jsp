<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快乐买后台管理系统-广告管理</title>
	<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		.datagrid-header-row,.datagrid-row {
		    height: 40px;
		}
		.l-btn {
			  text-decoration: none;
			  display: inline-block;
			  overflow: hidden;
			  margin: 0;
			  padding: 0;
			  width:80px;
			  height:30px;
			  cursor: pointer;
			  outline: none;
			  text-align: center;
			  vertical-align: middle;
			  line-height: normal;
			  /* background:#4667A2; */
		}
		
		.l-btn-text {
		  display: inline-block;
		  vertical-align: top;
		  width: auto;
		  line-height: 30px;
		  font-size: 12px;
		  padding: 0;
		  margin: 0 4px;
		}
	</style>
</head>
<body>
	<table id="advTab" class="easyui-datagrid" title="广告列表" style="width:700px;height:250px"
				data-options="singleSelect:false,
							  rownumbers:true,
							  collapsible:true,
							  toolbar:'#advToolbar',
							  url:'adv!getAdvPageList',
							  method:'get',
							  pagination:true,
							  pageSize:5,
							  fit:true,
							  fitColumns:true,
							  pageList:[2,3,4,5]
							  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'adverId',width:80" align="center">广告编号</th>
				<th data-options="field:'adverName',width:200" align="center">广告公司</th>
				<th data-options="field:'adverImgUrl',width:100,formatter:formatImg" align="center">广告图片</th>
				<th data-options="field:'adverEndTime',width:200" align="center">广告开始时间</th>
				<th data-options="field:'adverEndTime',width:200" align="center">广告结束时间</th>
				<th data-options="field:'adverUrl',width:260" align="center">广告网址</th>
				<th data-options="field:'adverSalary',width:100" align="center">广告收入</th>
			</tr>
		</thead>
	</table>
	<!-- 广告管理工具条 -->
	<div id="advToolbar" style="height:29px;line-height:29px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(1)">新增广告</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(2)">修改广告</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteAdvById()">删除广告</a>
	</div>
	
	<!-- 增加广告 -->
	<div id="advDialog" class="easyui-dialog" title="新增广告" data-options="iconCls:'icon-save',closed:true" style="width:340px;height:340px;padding:10px">
		 <form id="advForm" action="adv!saveAdv" method="post" enctype="multipart/form-data">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>广告公司:</td>
	    			<td>
	    				<input id="adverId" type="hidden" name="adv.adverId">
	    				<input id="adverName" class="easyui-textbox" type="text" name="adv.adverName" data-options="required:true" style="width:220px"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>广告网址:</td>
	    			<td><input id="adverUrl" class="easyui-textbox" type="text" name="adv.adverUrl" data-options="required:true" style="width:220px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>开始时间:</td>
	    			<td><input id="adverStartTime" name="adv.adverStartTime" data-options="required:true" style="width:220px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>结束时间:</td>
	    			<td><input id="adverEndTime" class="easyui-datebox" type="text" name="adv.adverEndTime" data-options="required:true" style="width:220px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>广告图片:</td>
	    			<td><input id="adverImgUrl" data-options="buttonText:'选择图片'" class="easyui-filebox" type="text" name="files" data-options="required:true" style="width:220px"></input></td>
	    		</tr>
			</table>
		</form>
		<div style="text-align:center;padding:20px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	</div>
	
	<script type="text/javascript">
	
		//获取级联对象的属性值
		function formatImg(value,row,index){
			var html;
			if(value != null){
				html="<img src='" + value + "' style='width:50px;height:30px;'/>"	
			}else{
				html="没有图片";
			}
			return html;
		}
		
		//广告开始时间处理：当前时间-->一年后可选
		$("#adverStartTime").datebox().datebox('calendar').calendar({
			validator:function(date){
				var now = new Date();
				var d1 = new Date(now.getFullYear(),now.getMonth(), now.getDate());
				var d2 = new Date(now.getFullYear()+1,now.getMonth(), now.getDate());
				return d1<=date && date<=d2;
			}
		});
		   
		
		//广告结束时间处理：必须大于开始时间
		$("#adverEndTime").datebox().datebox('calendar').calendar({
			validator:function(date){
				var now = new Date();
				var d1 = new Date(now.getFullYear(),now.getMonth(), now.getDate());
				return d1<=date;
			}
		});
		
		
		/* $("#adverEndTime").blur(function(){
			var d1 = $("#adverStartTime").datebox('getValue');
			var d2 = $("#adverEndTime").datebox('getValue');
			var start = new Date(d1);
			var end = new Date(d2);
			if(start > end){
				$.messager.show({
					title:'注意',
					msg:'结束时间不能小于开始时间',
					showType:'slide',
					timeout:2000,
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
				$('#adverEndTime').form('clear');
			}
		}); */
		

		//打开新增广告弹框
		function openWin(flag){
			$('#advForm').form('clear');
			if(flag != 1){
				var chkRows = $("#advTab").datagrid("getChecked");
				if(chkRows.length == 1){
					$("#adverId").val(chkRows[0].adverId);
					$("#adverName").textbox("setValue", chkRows[0].adverName);
					$("#adverUrl").textbox("setValue", chkRows[0].adverUrl);
					$("#adverStartTime").textbox("setValue", chkRows[0].adverStartTime);
					$("#adverEndTime").textbox("setValue", chkRows[0].adverEndTime);
					
					$('#advDialog').dialog('open');
				}else{
					$.messager.show({
						title:'注意',
						msg:'请选择单行进行修改',
						showType:'slide',
						timeout:2000,
						style:{
							right:'',
							top:document.body.scrollTop+document.documentElement.scrollTop,
							bottom:''
						}
					});
				}
			}else{
				$('#advDialog').dialog('open')
			}
		}
		
		//添加或修改广告提交数据
		function submitForm(){
			$('#advForm').form({    
			    success:function(data){    
			    	$('#advDialog').dialog('close');
					$("#advTab").datagrid("load");
			    }    
			});   
			$('#advForm').form('submit');
		}
		
		//删除指定广告
		function deleteAdvById(){
			//判断是否有选中
			var rows = $("#advTab").datagrid("getChecked");
			if(rows.length > 0){
				var advIds = [];
				for(var i=0; i<rows.length; i++){
					advIds[i] = rows[i].adverId;
				}
				$.messager.confirm('确认', '您确定要删除吗?', function(r){
					//r是是否确认删除的返回值，是(true),否(false)
					if(r){
						$.ajax({
							url:'adv!deleteAdvByIds',
							data:{advIds:advIds},
							dataType:'JSON',
							type:'POST',
							traditional:true,
							'success':function(result){
								var isOk = result.isOk;
								if(isOk){
									//刷新
									$('#advTab').datagrid('reload'); 
								}
							}
						});
					}
				});
			}else{	
				//在有下角弹出消息提示
				$.messager.show({
					title:'提示',
					msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>请选择至少一条数据</div></div>',
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});	
			}
		}
		
		//重置表单数据
		function clearForm(){
			$('#advForm').form('clear');
		}

	</script>
</body>
</html>






















