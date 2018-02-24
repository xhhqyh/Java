<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送管理</title>
<link rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
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

	<table id="push" class="easyui-datagrid" title="推送管理"
		style="width: 1250px; height: 450px"
		data-options="singleSelect:false,
							  collapsible:true,
							  url:'push!getPushList',
							  toolbar: '#pushTB',
							  method:'post',
							  pagination:true,
							  pageSize:5,
							  pageList:[5,10],
							  fit:'true',
							  rownumbers:true,
							  sortOrder : 'asc',
							  fitColumns : true
							  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true" align="center"></th>
				<th data-options="field:'pushId',width:300,hidden:true"
					align="center">编号</th>
				<th data-options="field:'pushName',width:300" align="center">推送名称</th>
				<th data-options="field:'pushImg',width:300,formatter:operation"
					align="center">图片地址</th>
				<th data-options="field:'pushStatus',width:300,formatter:formatters"
					align="center">状态</th>
			</tr>
		</thead>
	</table>

	<div id="pushTB" style="height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:'true',text:'新增推送'"
				onclick="addPush()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:'true',text:'编辑推送'"
				onclick="updatePush()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:'true',text:'删除推送'"
				onclick="deletePush()"></a>
		</div>
	</div>

	<div id="addPush" class="easyui-dialog" title="推送"
		data-options="iconCls:'icon-save',closed: true,modal: true"
		style="width: 400px; height: 350px; padding: 10px">
		<form id="pushForm" method="post" action="push!addPush" enctype="multipart/form-data">
			<table cellpadding="5">
				<tr>
					<td>推送名称:</td>
					<td><input id="pushId" type="hidden" name="push.pushId">
						<input id="pushName" class="easyui-textbox" name="push.pushName"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>图片地址:</td>
					<td><input id="pushImg" data-options="buttonText:'选择图片'"
						class="easyui-filebox" type="text" name="files"
						data-options="required:true" style="width: 220px"></input></td>
				</tr>
				<tr>
					<td>状态:</td>
					<td><select id="pushStatus" class="easyui-combobox"
						name="push.pushStatus" data-options="panelHeight:50"
						style="width: 200px;">
							<option value="1">有效</option>
							<option value="0">已失效</option>
					</select></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">保存</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">清空</a>
		</div>
	</div>


		
	<script>
		//渲染推送状态
		function formatters(value, row) {
			if (value == 1) {
				return "正常"
			}
			if (value == 0) {
				return "已失效"
			}
		}

		//	渲染图片路径
		function operation(value, row, index) {
			var html;
			if(value != null){
				html="<img src='" + value + "' style='width:50px;height:30px;'/>"	
			}else{
				html="没有图片";
			}
			return html;
		}

		//阻止冒泡事件
		function refresh(event) {
			if (event && event.stopPropagation) {
				event.stopPropagation();
			} else {
				window.event.cancelBubble = true;
			}
		};

		//新增推送
		function addPush() {
			$('#addPush').dialog('open');
		}

		//修改推送
		function updatePush() {
			var check = $('#push').datagrid('getChecked');
			if (check.length != 1) {
				$.messager.alert('提示', '请选择一行数据修改');
			}
			if (check.length == 1) {
				for (var i = 0; i < check.length; i++) {
					$('#pushId').val(check[0].pushId)
					$('#pushName').textbox("setValue", check[0].pushName)
					$('#pushStatus').combobox("setValue", check[0].pushStatus)
					$('#addPush').dialog('open')
				}
			}

		}

		//删除品牌
		function deletePush() {
			var check = $('#push').datagrid('getChecked');
			if (check.length > 0) {
				var pushIds = [];
				for (var i = 0; i < check.length; i++) {
					pushIds[i] = check[i].pushId;
				}
			}
			$.ajax({
				url : "push!deletePush",
				method : "post",
				data : {
					pushIds : pushIds
				},
				dataType : "json",
				traditional : true,
				success : function(result) {
					var isOk = result.isOk;
					if (isOk) {
						$.messager.show({
							title : '我的消息',
							msg : '删除成功',
							timeout : 5000,
							showType : 'slide'
						});
						$("#push").datagrid("reload");
					}
				}
			})
		}

		//表单提交
		function submitForm() {
			$('#pushForm').form('submit');
			$('#pushForm').form({
				success : function(data) {
					$('#addPush').dialog('close');
					$.messager.show({
						title : '我的消息',
						msg : '操作成功',
						timeout : 5000,
						showType : 'slide'
					});
					$("#push").datagrid("load");
				}
			});
		}
		function clearForm() {
			$('#pushForm').form('clear');
		}
	</script>
</body>
</html>