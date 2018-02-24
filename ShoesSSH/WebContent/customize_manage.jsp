<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定制鞋</title>
<link rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="customize" class="easyui-datagrid" title="定制鞋信息"
		style="width: 1570px; height: 770px"
		data-options="singleSelect:false,
				      rownumbers:true,
					  collapsible:true,
					  toolbar: '#customizeToolbar',
					  url:'customize!getCustomizeInfo',
					  method:'get',
					  pagination:true,
					  pageSize:5,
					  pageList:[5,10,15,20],
					  fit:true,
					  fitColumns : true
					  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'customizeId',width:80,align:'center',hidden:'true'">定制编号</th>
				<th data-options="field:'type',width:210,align:'center',formatter:type">定制类型</th>
				<th data-options="field:'brand',width:210,align:'center',formatter:brand">定制品牌</th>
				<th data-options="field:'customizeStyle',width:210,align:'center'">品牌款式</th>
				<th data-options="field:'customizeName',width:210,align:'center'">定制名称</th>
				<th data-options="field:'customizePrice',width:210,align:'center'">定制价格</th>
				<th data-options="field:'size',width:210,align:'center',formatter:size">产品尺码</th>
				<th data-options="field:'customizeCard',width:210,align:'center'">产品序号</th>
				<th data-options="field:'customizeNum',width:210,align:'center'">部件个数</th>
				<th data-options="field:'customizeMessage',width:210,align:'center'">部件信息</th>
				<th data-options="field:'customizeMinute',width:210,align:'center'">详细信息</th>
			</tr>
		</thead>
	</table>
	<!-- 头部文件 -->
	<div id="customizeToolbar">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addCust()">新增定制</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updateCust()">修改定制</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteCust()">删除定制</a>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="easyui-textbox" type="text" id="customizeCards" name="customizeCards" 
			data-options="prompt:'产品序号',width:150,height:20"/>
		<a href="javascript:void(0)" data-options="iconCls:'icon-search',plain:true" class="easyui-linkbutton" onclick="selectCard()">查询</a>
	</div>
	
	<div id="customizeDialog" class="easyui-dialog" title="定制鞋操作" data-options="closed:true"
		style="width: 400px; height: 460px;">=
		<form id="customizeForm" action="customize!addCustomize" method="get"
			style="padding-left:55px;padding-top:10px">
			<table cellpadding="5">
				<tr>
					<td>定制类型:</td>
					<td><input id="customizeId" type="hidden" name="customize.customizeId"> 
					<input style="width: 200px" id="typeId" class="easyui-combobox" name="customize.type.typeId"
						data-options="valueField:'typeId',textField:'typeName',url:'type!getTypeName',limitToList:true,panelMaxHeight:'60px',prompt:'请选择下拉框中的内容'" />
					</td>
				</tr>
				<tr>
					<td>定制品牌:</td>
					<td><input style="width: 200px" id="brandId"
						class="easyui-combobox" name="customize.brand.brandId"
						data-options="valueField:'brandId',textField:'brandName',url:'brand!getBrandName',limitToList:true,panelMaxHeight:'60px',prompt:'请选择下拉框中的内容'" />
					</td>
				</tr>
				<tr>
					<td>品牌款式:</td>
					<td><input id="customizeStyle" class="easyui-textbox"
						name="customize.customizeStyle" style="width: 200px"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>定制名称:</td>
					<td><input id="name" class="easyui-textbox"
						name="customize.customizeName" style="width: 200px"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>定制价格:</td>
					<td><input id="price" class="easyui-textbox"
						name="customize.customizePrice" style="width: 200px"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td> 产品尺码:</td>
					<td><input style="width: 200px" id="sizeId"
						class="easyui-combobox" name="customize.size.sizeId"
						data-options="valueField:'sizeId',textField:'sizeName',url:'customize!getSizeName',limitToList:true,panelMaxHeight:'60px',prompt:'请选择下拉框中的内容'" />
					</td>
				</tr>
				<!-- <tr>
					<td>产品序号:</td>
					<td><input id="card" class="easyui-textbox"
						name="customize.customizeCard"
						data-options="required:true,width:220" /></td>
				</tr> -->
				<tr>
					<td>部件个数:</td>
					<td><input id="customizeNum" class="easyui-textbox"
						name="customize.customizeNum" style="width: 200px"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>部件信息:</td>
					<td><input id="customizeMessage" class="easyui-textbox"
						name="customize.customizeMessage" style="width: 200px"
						data-options="required:true,width:220" /></td>
				</tr>
				<tr>
					<td>详细信息:</td>
					<td><input id="customizeMinute" class="easyui-textbox"
						name="customize.customizeMinute" style="width: 200px"
						data-options="required:true,width:220"/></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding-top: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">保存</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
				href="javascript:void(0)" class="easyui-linkbutton"
				onclick="clearForm()">清空</a>
		</div>

		<script>
		
		//模糊查询
		function selectCard(){
			var customizeCards = $('#customizeCards').textbox('getValue');
			//渲染选中行的颜色
			$('#customize').datagrid({
				rowStyler: function(index,row){
					if (row.customizeCard==customizeCards){
						return 'background-color:#6293BB;color:#fff;';
					}
				}
			});
			//重新加载datagrid
			$('#customize').datagrid('reload',{'customizeCards':customizeCards});
		}
		
		
		//添加
			function addCust() {
				$('#customizeForm').form('clear');
				$('#customizeDialog').dialog('open');
			}
			
		//修改
			function updateCust() {
				var check = $('#customize').datagrid('getChecked');
				 if (check.length != 1) {
					$.messager.alert('提示', '请选择一行数据修改');
				} 
				 if (check.length == 1) {
					for (var i = 0; i < check.length; i++) {
						$('#customizeId').val(check[0].customizeId)
						$('#typeId').combobox("setValues",[ check[0].type.typeId ])
						$('#brandId').combobox("setValues",[ check[0].brand.brandId ])
						$('#price').textbox("setValue",check[0].customizePrice)
						$('#name').textbox("setValue",check[0].customizeName)
						$('#customizeStyle').textbox("setValue", check[0].customizeStyle);
						$('#card').textbox("setValue", check[0].customizeCard);
						$('#sizeId').combobox("setValues",[ check[0].size.sizeId ])
						$('#customizeNum').textbox("setValue",check[0].customizeNum)
						$('#customizeMessage').textbox("setValue",check[0].customizeMessage)
						$('#customizeMinute').textbox("setValue",check[0].customizeMinute)
						$('#customizeDialog').dialog('open')
					}
				} 
			}

			//表单提交
			function submitForm() {
				var check = $('#customize').datagrid('getChecked');
				$('#customizeForm').form('submit');
				$('#customizeForm').form({
					success : function(data) {
						$('#customizeDialog').dialog('close');
						$.messager.show({
							title : '我的消息',
							msg : '操作成功',
							timeout : 5000,
							showType : 'slide'
						});
						$("#customize").datagrid("load");
					}
				});
			}

			//清除
			function clearForm() {
				$('#customizeForm').form('clear');
			}

			//删除
			function deleteCust() {
				var check = $('#customize').datagrid('getChecked');
				if (check.length > 0) {
					var customizeIds = [];
					for (var i = 0; i < check.length; i++) {
						customizeIds[i] = check[i].customizeId;
					}
				}
				$.ajax({
					url : "customize!deleteCustomize",
					method : "post",
					data : {customizeIds : customizeIds},
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
							$("#customize").datagrid("reload");
						}
					}
				})
			}

			//鞋子类型
			function type(value, row, index) {
				if (value.typeId == 0) {
					return '<span style="color:red;">'+value.typeName+'</span>';
				} else {
					return value.typeName;
				}
			}
			
			//鞋子品牌
			function brand(value, row, index) {
				if (value.brandId == 0) {
					return '<span style="color:red;">'+value.brandName+'</span>';
				} else {
					return value.brandName;
				}
			}
			
			//鞋子品牌性别
			function sex(value, row, index) {
				if (row.genderId == 1) {
					return '女款';
				}
				if(row.genderId == 0){
					return '男款';
				}
				if(row.genderId == 2){
					return '男女款';
				}
			}


			//鞋子尺码
			function size(value, row, index) {
				if (row.size.sizeName != null) {
					return row.size.sizeName;
				} else {
					return '无';
				}
			}
		</script>
</body>
</html>