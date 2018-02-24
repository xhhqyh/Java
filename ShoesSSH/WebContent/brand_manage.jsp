<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>

</head>
<body>

	<table id="brand" class="easyui-datagrid" title="品牌列表"
		style="width: 850px; height: 450px"
		data-options="singleSelect:false,
							  collapsible:true,
							  url:'brand!getBrandList',
							  toolbar: '#brandTB',
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
				<th data-options="field:'brandId',width:200" align="center">品牌编号</th>
				<th data-options="field:'brandName',width:200" align="center">品牌名称</th>
				<th
					data-options="field:'brandGender',width:200,formatter:fammterSex" align="center">品牌性别</th>
				<th data-options="field:'brandRemarks',width:200" align="center">品牌备注</th>
			</tr>
		</thead>
	</table>

	<div id="brandTB" style="height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:'true',text:'新增品牌'"
				onclick="addBrand()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:'true',text:'编辑品牌'"
				onclick="updateBrand()"></a> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:'true',text:'删除品牌'"
				onclick="deleteBrand()"></a>
		</div>
	</div>

	<div id="addBrand" class="easyui-dialog" title="新增品牌"
		data-options="iconCls:'icon-save',closed: true,modal: true"
		style="width: 400px; height: 350px; padding: 10px">
		<form id="brandForm" method="post" action="brand!addBrand">
			<table cellpadding="5">
				<tr>
					<td>品牌名称:</td>
					<td><input id="brandId" type="hidden" name="brand.brandId">
						<input id="brandName" class="easyui-textbox"
						name="brand.brandName" data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>品牌性别:</td>
					<td><select id="brandGender" class="easyui-combobox"
						name="brand.brandGender" data-options="panelHeight:50" style="width: 200px;">
							<option value="0">男</option>
							<option value="1">女</option>
					</select> <!--  <input id="radio" type="radio" value="0" name="brand.brandGender"/>男<input id="radio" type="radio" value="1" name="brand.brandGender"/>女 -->
					</td>
				</tr>
				<tr>
					<td>品牌备注:</td>
					<td><input id="brandRemarks" class="easyui-textbox"
						name="brand.brandRemarks" data-options="required:true,width:220" />
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
		//性别转化
		function fammterSex(value) {
			if (value == 0) {
				return "男";
			} else {
				return "女";
			}
			return "男女";
		}

		//新增品牌
		function addBrand() {
			$('#brandForm').form('clear');
			$('#addBrand').dialog('open');
		}

		//删除品牌
		function deleteBrand() {
			var check = $('#brand').datagrid('getChecked');
			if (check.length > 0) {
				var brandIds = [];
				for (var i = 0; i < check.length; i++) {
					brandIds[i] = check[i].brandId;
				}
			}
			$.ajax({
				url : "brand!deleteBrand",
				method : "post",
				data : {
					brandIds : brandIds
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
						$("#brand").datagrid("reload");
					}
				}
			})
		}

		//修改品牌
		function updateBrand() {
			var check = $('#brand').datagrid('getChecked');
			if (check.length != 1) {
				$.messager.alert('提示', '请选择一行数据修改');
			}
			if (check.length == 1) {
				var brand = [];
				for (var i = 0; i < check.length; i++) {
					$('#brandId').val(check[0].brandId)
					$('#brandName').textbox("setValue", check[0].brandName)
					$('#brandGender').combobox("setValue", check[0].brandGender)
					$('#brandRemarks').textbox("setValue",check[0].brandRemarks)
					$('#addBrand').dialog('open')
				}
			}

		}

		function submitForm() {
			var check = $('#brand').datagrid('getChecked');
			$('#brandForm').form('submit');
			$('#brandForm').form({
				success : function(data) {
					$('#addBrand').dialog('close');
					$.messager.show({
						title : '我的消息',
						msg : '操作成功',
						timeout : 5000,
						showType : 'slide'
					});
					$("#brand").datagrid("load");
				}
			});
		}
		function clearForm() {
			$('#brandForm').form('clear');
		}
	</script>
</body>
</html>