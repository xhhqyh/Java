<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快乐买后台管理系统-合作管理</title>
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
	<table id="cooperTab" class="easyui-datagrid" title="商务合作列表" style="width:700px;height:250px"
				data-options="singleSelect:false,
							  rownumbers:true,
							  collapsible:true,
							  toolbar:'#cooperToolbar',
							  url:'cooper!getCooperPageList',
							  method:'get',
							  pagination:true,
							  pageSize:10,
							  fit:true,
							  fitColumns:true,
							  pageList:[2,3,4,5,10]
							  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'coId',width:100" align="center">合作编号</th>
				<th data-options="field:'coName',width:200" align="center">合作名称</th>
				<th data-options="field:'cpImgUrl',width:100,formatter:formatCooperImg" align="center">合作图片</th>
				<th data-options="field:'coUrl',width:300" align="center">合作网址</th>
			</tr>
		</thead>
	</table>
	<!-- 商务合作工具条 -->
	<div id="cooperToolbar" style="height:29px;line-height:29px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(1)">新增商务</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(2)">修改商务</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteCooperById()">删除商务</a>
	</div>
	
	<!-- 增加商务合作 -->
	<div id="cooperDialog" class="easyui-dialog" title="新增商务合作" data-options="iconCls:'icon-save',closed:true" style="width:340px;height:340px;padding:10px">
		 <form id="cooperForm" action="cooper!saveCooper" method="post" enctype="multipart/form-data">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>广告公司:</td>
	    			<td>
	    				<input id="coId" type="hidden" name="cooper.coId">
	    				<input id="coName" class="easyui-textbox" type="text" name="cooper.coName" data-options="required:true" style="width:220px"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>广告网址:</td>
	    			<td><input id="coUrl" class="easyui-textbox" type="text" name="cooper.coUrl" data-options="required:true" style="width:220px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>广告图片:</td>
	    			<td><input id="cpImgUrl" data-options="buttonText:'选择图片'" class="easyui-filebox" type="text" name="files" data-options="required:true" style="width:220px"></input></td>
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
		function formatCooperImg(value,row,index){
			var html;
			if(value != null){
				html="<img src='" + value + "' style='width:50px;height:30px;'/>"	
			}else{
				html="没有图片";
			}
			return html;
		}

		//打开新增商务合作弹框
		function openWin(flag){
			$('#cooperForm').form('clear');
			if(flag != 1){
				var chkRows = $("#cooperTab").datagrid("getChecked");
				if(chkRows.length == 1){
					$("#coId").val(chkRows[0].coId);
					$("#coName").textbox("setValue", chkRows[0].coName);
					$("#coUrl").textbox("setValue", chkRows[0].coUrl);
					
					$('#cooperDialog').dialog('open');
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
				$('#cooperDialog').dialog('open')
			}
		}
		
		//添加或修改商务合作提交数据
		function submitForm(){
			$('#cooperForm').form({    
			    success:function(data){    
			    	$('#cooperDialog').dialog('close');
					$("#cooperTab").datagrid("load");
			    }    
			});   
			$('#cooperForm').form('submit');
		}
		
		//删除指定商务合作
		function deleteCooperById(){
			//判断是否有选中
			var rows = $("#cooperTab").datagrid("getChecked");
			if(rows.length > 0){
				var cooperIds = [];
				for(var i=0; i<rows.length; i++){
					cooperIds[i] = rows[i].coId;
				}
				$.messager.confirm('确认', '您确定要删除吗?', function(r){
					//r是是否确认删除的返回值，是(true),否(false)
					if(r){
						$.ajax({
							url:'cooper!deleteCooperByIds',
							data:{cooperIds:cooperIds},
							dataType:'JSON',
							type:'POST',
							traditional:true,
							'success':function(result){
								var isOk = result.isOk;
								if(isOk){
									//刷新
									$('#cooperTab').datagrid('reload'); 
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
			$('#cooperForm').form('clear');
		}

	</script>
</body>
</html>






















