<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类型</title>
<link rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>

</head>
<body>

	<table id="type" class="easyui-datagrid" title="类型列表"
		style="width: 850px; height: 450px"
		data-options="singleSelect:false,
							  collapsible:true,
							  url:'type!getTypeList',
							  toolbar: '#typeTB',
							  method:'post',
							  pagination:true,
							  pageSize:5,
							  pageList:[5,10],
							  fit:'true',
							  fitColumns:true
							  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true" align="center"></th>
				<th data-options="field:'typeId',width:200" align="center">类型编号</th>
				<th data-options="field:'typeName',width:200" align="center">类型名称</th>
				<th data-options="field:'typeRemarks',width:200" align="center">类型备注</th>
			</tr>
		</thead>
	</table>

	<div id="typeTB" style="height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:'true',text:'新增类型'"
				onclick="addType()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:'true',text:'编辑类型'"
				onclick="updateType()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:'true',text:'删除类型'"
				onclick="deleteType()"></a>
		</div>
	</div>

	<div id="addTypes" class="easyui-dialog" title="类型"
		data-options="iconCls:'icon-save',closed: true,modal: true"
		style="width: 400px; height: 350px; padding: 10px">
		<form id="typeForm" method="post" action="type!addType">
			<table cellpadding="5">
				<tr>
					<td>类型名称:</td>
					<td><input id="typeId" type="hidden" name="type.typeId">
					<input id="typeName" class="easyui-textbox"
						name="type.typeName" data-options="required:true,width:220" />
					</td>
				</tr>
				<tr>
					<td>类型备注:</td>
					<td><input id="typeRemarks" class="easyui-textbox"
						name="type.typeRemarks" data-options="required:true,width:220" />
					</td>
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
		//新增品牌
		function addType() {
			$('#typeForm').form('clear');
			$('#addTypes').dialog('open');
		}

		//删除品牌
		function deleteType() {
			var check = $('#type').datagrid('getChecked');
			if (check.length > 0) {
				var typeIds = [];
				for (var i = 0; i < check.length; i++) {
					typeIds[i] = check[i].typeId;
				}
			}
			$.ajax({
				url : "type!deleteType",
				method : "post",
				data : {
					typeIds : typeIds
				},
				dataType : "json",
				traditional : true,
				success : function(result) {
					var isOk = result.isOk;
					if (isOk) {
						$.messager.show({
							title:'我的消息',
							msg:'删除成功',
							timeout:5000,
							showType:'slide'
						});
						$("#type").datagrid("reload");
					}
				}
			})
		}

		//修改品牌
		function updateType() {
			var check = $('#type').datagrid('getChecked');
			if (check.length != 1) {
				$.messager.alert('提示', '请选择一行数据修改');
			}
			if (check.length == 1) {
				var type = [];
				for (var i = 0; i < check.length; i++) {
					$('#typeId').val(check[0].typeId)
					$('#typeName').textbox("setValue", check[0].typeName)
					$('#typeRemarks').textbox("setValue",check[0].typeRemarks)
					$('#addTypes').dialog('open')
				}
			}

		}
		
		//表单提交
		function submitForm() {
			$('#typeForm').form('submit');
			$('#typeForm').form({
				success : function(data) {
					$('#addTypes').dialog('close');
					$.messager.show({
						title:'我的消息',
						msg:'操作成功',
						timeout:5000,
						showType:'slide'
					});
					$("#type").datagrid("load");
				}
			});
		}
		function clearForm() {
			$('#typeForm').form('clear');
		}
	</script>
</body>
</html>