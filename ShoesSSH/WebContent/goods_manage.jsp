<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品信息</title>
	<link rel="stylesheet" type="text/css"href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="easyUI/datagrid-detailview.js"></script>
	<script type="text/javascript" src="easyUI/datagrid-cellediting.js"></script>
	<style>
		a {text-decoration:none;color:#000;}
		a:hover {color:red;}
		input {
			border:1px solid;
		}
	</style>
</head>
<body>
	<!-- 数据表格展示商品详细信息 -->
	<table id="goodsDg" class="easyui-datagrid" title="商品信息" style="width:800px;height:250px;text-align: center;"
			data-options="singleSelect:false,fit:true,fitColumns:true,pagination:true,striped:true, url:'goods!getGoodsInfo',
						  method:'get',toolbar:'#goodsToolbar',view:detailview,pageSize:20,pageList:[1, 2, 3,5,10,20]">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true,width:30,align:'center'"></th>
				<th data-options="field:'goodsId',width:80,align:'center'">商品编号</th>
				<th data-options="field:'goodsName',width:120,align:'center'">商品名称</th>
				<th data-options="field:'goodsOldPrice',width:100,align:'center'">商品原价</th>
				<th data-options="field:'goodsNewPrice',width:100,align:'center'">商品现价</th>
				<th data-options="field:'goodsDate',width:80,align:'center'">上市时间</th>
			</tr>
		</thead>
	</table>
	
   <!-- 工具条 -->
	<div id="goodsToolbar">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(1)">新增商品</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="openWin(2)">修改商品</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteGoodById()">删除商品</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="importExcel()">Excel导入</a>
		
	</div>
	<!-- 增改div -->
	<div id="goodsDialog" class="easyui-dialog" title="商品信息操作" data-options="iconCls:'icon-save',closed:true" style="width: 700px; height: 600px; padding: 10px">
		<form id="goodsForm" method="post" enctype="multipart/form-data">
			<table cellpadding="5" border="1px">
				<tr>
	    			<td>鞋子名字:</td>
	    			<td>
	    				<input id="goodsName" class="easyui-validatebox" name="goods.goodsName" style="width:216px" data-options="required:true,validType:'minLength[2]'"/>
	    			</td>
	    			<td>鞋子序列号:</td>
	    			<td>
	    				<input id="goodsNo" class="easyui-validatebox" name="goods.goodsNo" style="width:216px" data-options="required:true,validType:'noLength[5]'"/>
	    			</td>
	    		</tr>
				<tr>
					<td>鞋子类型:</td>
					<td><input id="goodsId" type="hidden" name="goods.goodsId">
						<input style="width: 220px" editable="false" id="typeId"
						class="easyui-combobox" name="goods.type.typeId"
						data-options="valueField:'typeId',textField:'typeName',url:'type!getTypeName'" />
					</td>
					<td>品牌名字:</td>
					<td>
						<input style="width: 220px" id="brandId" editable="false"
						class="easyui-combobox" name="goods.brand.brandId"
						data-options="valueField:'brandId',textField:'brandName',url:'brand!getBrandName'" />
					</td>
			     </tr>
	    		
	    		<tr>
	    			<td>商品原价:</td>
	    			<td>
	    				<input id="goodsOldPrice" class="easyui-validatebox" name="goods.goodsOldPrice" style="width:216px" data-options="required:true,validType:'priceVar'"/>
	    			</td>
	    			<td>商品积分:</td>
	    			<td>
	    				<input id="goodsPoint" class="easyui-validatebox" name="goods.goodsPoint" style="width:216px" data-options="required:true,validType:'pointVar'"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>生产商:</td>
	    			<td>
	    				<input id="goodsProducer" class="easyui-validatebox" name="goods.goodsProducer" style="width:216px" data-options="required:true,validType:'producerVar[5]'"/>
	    			</td>
	    			<td>男女款式:</td>
	    			<td>
	    				<input id="goodsStyle" name="goods.goodsStyle" editable="false" class="easyui-combobox" style="width: 220px;" data-options="panelHeight:50,
																	valueField: 'label',
																	textField: 'value',
																	data: [{
																		label: '1',
																		value: '女'
																	},{
																		label: '0',
																		value: '男'
																	}]" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>商品详细信息:</td>
	    			<td>
	    				<input id="goodsInformation" class="easyui-validatebox" name="goods.goodsInformation" style="width:216px" data-options="required:true,validType:'producerVar[5]'"/>
	    			</td>
	    			<td>商品销量:</td>
	    			<td>
	    				<input id="goodsSnumber" class="easyui-validatebox" name="goods.goodsSnumber" style="width:216px" data-options="required:true,validType:'countVar'"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>商品折扣:</td>
	    			<td>
	    				<input id="goodsDiscount" class="easyui-validatebox" name="goods.goodsDiscount" style="width:216px" data-options="required:true,validType:'discountVar'"/>
	    			</td>
	    			<td>上架时间:</td>
	    			<td>
	    				<input id="goodsDate" name="goods.goodsDate" data-options="required:true,width:220"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>商品状态:</td>
	    			<td>
	    				<input id="goodsStatus" name="goods.goodsStatus" editable="false" class="easyui-combobox" style="width: 220px;" data-options="panelHeight:50,
																	valueField: 'label',
																	textField: 'value',
																	data: [{
																		label: '1',
																		value: '上架'
																	},{
																		label: '0',
																		value: '不上架'
																	}]" />
	    			</td>
	    			<td>商品图片:</td>
	    			<td>
	    				<input id="goodsImgUrl" data-options="buttonText:'选择图片'" class="easyui-filebox" type="text" name="files" data-options="required:true" style="width:220px"></input>
	    			</td>
	    		</tr>   
	    		<tr>
	    			<td>商品描述图片:</td>
	    			<td>
	    				<input id="adverImgUrl" data-options="buttonText:'选择多张图片'" multiple="multiple" class="easyui-filebox" type="text" name="manyfiles" data-options="required:true" style="width:220px"></input>
	    			</td>
	    			<td></td>
	    			<td>
	    			</td>
	    		</tr>
			</table>
			
			<!-- 修改商品信息时，展示商品图片 -->
			<div id="goodsImg" title="" data-options="" style="padding: 10px;display:none;">
				<table cellspacing="0" border="1px" style="" id="imgTab">
					<tr id="imgTr0"></tr>
				</table>
			</div>
			
			<!-- 库存信息填写表 -->
			<table id="dg" class="easyui-datagrid" title="新加库存" style="width:646px;height:auto"
			data-options="
						iconCls: 'icon-edit',
						singleSelect: true,
						toolbar: '#tb',
						method: 'get',
						onClickCell: onClickCell,
						onEndEdit: onEndEdit
					">
				<thead>
					<tr>
						<th data-options="field:'sizeName',width:240,align:'center',
								formatter:function(value,row){
									return row.sizeName;
								},
								editor:{
									type:'combobox',
									options:{
										valueField:'sizeName',
										textField:'sizeName',
										method:'get',
										url:'goods!getSize',
										required:true
									}
								}">尺寸</th>
						<th data-options="field:'colorName',width:240,align:'center',
								formatter:function(value,row){
									return row.colorName;
								},
								editor:{
									type:'combobox',
									options:{
										valueField:'colorName',
										textField:'colorName',
										method:'get',
										url:'goods!getColor',
										required:true
									}
								}">颜色</th>
						<th data-options="field:'stockNum',width:160,align:'center',editor:'numberbox'">数量</th>
					</tr>
				</thead>
			</table>
			<div id="tb" style="height:auto">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加一行</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除一行</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤回</a>
			</div>
			<div style="text-align:center;padding:20px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
		    </div>
		</form>
	</div>	
	
	<!-- Excel导入 -->
	<div id="excelId" class="easyui-dialog" title="Excel导入" data-options="iconCls:'icon-save',closed:true" style="width:340px;height:200px;padding:10px">
		 <form id="excelForm" action="goods!importExcel" method="post" enctype="multipart/form-data">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Excel导入:</td>
	    			<td>
	    				<input class="easyui-filebox" name="excelFile" data-options="buttonText:'选择Excel文件'" style="width:200px">	
	    			</td>
	    		</tr>
	    		<tr>
	    			<td></td>
	    			<td>
	    				<span style="color: red">${error}</span></p>
	    			</td>
	    		</tr>
			</table>
		</form>
		<div style="text-align:center;padding:20px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">导入</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	</div>
	
	<script type="text/javascript">
		//EasyUI表单验证，数据长度大于2个字符,小于8个字符
		$.extend($.fn.validatebox.defaults.rules, {    
		    minLength: {    
		        validator: function(value, param){    
		            return value.length >= param[0] && value.length <= param[0]*4;    
		        },    
		        message: '长度大于2个字符,小于8个字符'   
		    },
		    //鞋子序列号表单验证
		    noLength: {
		    	validator: function(value, param){    
		            return value.length >= param[0] && value.length <= param[0]*4;    
		        },    
		        message: '序列号长度大于5个字符,小于20个字符'  
		    },
			//商品原价表单验证
			priceVar: {
				validator: function(value){    
		            return value > 0 && value <100000;    
		        },    
		        message: '商品原价不能为负,小于10000,数字'
			},
			//商品积分验证
			pointVar: {
				validator: function(value){    
		            return value > 0 && value <100000;    
		        },    
		        message: '商品积分不能为负,小于10000,数字'
			},
		    //验证生产商家、商品描述
		    producerVar: {    
		        validator: function(value, param){    
		            return value.length >= param[0] && value.length <= param[0]*10;    
		        },    
		        message: '大于5个字符,小于50个字符'   
		    },
		    //验证商品销量
		    countVar: {    
		        validator: function(value){    
		            return value > 0 && value.length <= 10000;    
		        },    
		        message: '商品销量大于0,小于10000,数字'   
		    },
		    //验证商品折扣
		    discountVar: {    
		        validator: function(value){    
		            return value > 0 && value.length < 10;    
		        },    
		        message: '商品折扣在1-9之间'   
		    },
		
					
		});  
		
		//商品上架时间处理：必须大于当前时间
		$("#goodsDate").datebox().datebox('calendar').calendar({
			validator:function(date){
				var now = new Date();
				var d1 = new Date(now.getFullYear(),now.getMonth(), now.getDate());
				var d2 = new Date(now.getFullYear()+1,now.getMonth(), now.getDate());
				return d1<=date && date<=d2;
			}
		});
	
		/* 表格的行编辑js代码 */
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
					if (ed){
						($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
					}
					editIndex = index;
				} else {
					setTimeout(function(){
						$('#dg').datagrid('selectRow', editIndex);
					},0);
				}
			}
		}
		function onEndEdit(index, row){
			var ed1 = $(this).datagrid('getEditor', {
				index: index,
				field: 'sizeName'
			});
			var ed2 = $(this).datagrid('getEditor', {
				index: index,
				field: 'colorName'
			});
			row.sizeName = $(ed1.target).combobox('getText');
			row.colorName = $(ed2.target).combobox('getText');

		}
		
		//新增加一行
		function append(){
			if (endEditing()){
				//appendRow 追加一个新行,新行将被添加到最后的位置。 
				$('#dg').datagrid('appendRow',{});
				editIndex = $('#dg').datagrid('getRows').length-1;
				$('#dg').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		//删除当前行
		function removeit(){
			if (editIndex == undefined){return}
			$('#dg').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		//保存
		function accept(){
			if (endEditing()){
				$('#dg').datagrid('acceptChanges');
			}
		}
		
		//回撤
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
	
		//展示商品详细信息
		$(function(){
			//数据表格视图
			$('#goodsDg').datagrid({"total":"20",
				//告诉表格如何渲染详细视图
				detailFormatter: function(rowIndex, rowData){
					//处理状态
					var status=rowData.goodsStatus == 0? "已下架" : "已上架";
					//处理品牌
					var brands=rowData.brand.brandName == '未设置品牌'? '<span style="color:red;">未设置品牌</span>' : rowData.brand.brandName;
					//处理类型
					var types=rowData.type.typeName == '未添加类型'? '<span style="color:red;">未添加类型</span>' : rowData.type.typeName;
					//展开视图样式
					//debugger;
					return '<table style="padding:10px 0;"><tr>' +
							'<td style="border:0;padding-left:25px;;padding-right:25px;">'+
							'<img style="height: 116px;width: 124px;" alt="图片以损坏" src="'+rowData.goodsImgUrl+'"/>'+
							'</td>' + 
							'<td style="border:0;padding-right:25px">'+
							'<p><span style="font-weight: bold;">商品编号: </span>' + rowData.goodsId + '</p>' +
							'<p><span style="font-weight: bold;">商品名称: </span>' + rowData.goodsName + '</p>' +
							'<p><span style="font-weight: bold;">品牌名称: </span>' + rowData.brand.brandName+ '</p>' +
							'</td>' +
							'<td style="border:0;padding-right:25px">' +
							'<p><span style="font-weight: bold;">生产商: </span>' + rowData.goodsProducer + '</p>' +
							'<p><span style="font-weight: bold;">商品原价: </span>' + rowData.goodsOldPrice + '</p>' +
							'<p><span style="font-weight: bold;">商品现价: </span>' + rowData.goodsNewPrice + '</p>' +
							'</td>' +
							'<td style="border:0;padding-right:25px">' +
							'<p><span style="font-weight: bold;">卖出次数: </span>' + rowData.goodsSnumber + '</p>' +
							'<p><span style="font-weight: bold;">商品类型: </span>' + rowData.type.typeName+ '</p>' +
							'<p><span style="font-weight: bold;">商品可得积分: </span>' + rowData.goodsPoint + '</p>' +
							'</td>' +
							'<td style="border:0;padding-right:25px">' +
							'<p><span style="font-weight: bold;">商品状态: </span>' + status + '</p>' +
							'<p><span style="font-weight: bold;">上市时间: </span>' + rowData.goodsDate + '</p>' +
							'<p><span style="font-weight: bold;">相关信息: </span>' + rowData.goodsInformation + '</p>' +
							'</td>' +
							'</tr></table>';
				}
			});
			/* }).datagrid('loadData');  //原来写法 */
		});

		//获得类型名字
		function formatType(value, row, index) {
			if (value != null) {
				return value.typeName;
			} else {
				return '无';
			}
		}
		//获得品牌名字
		function formatBrand(value, row, index) {
			if (value != null) {
				return value.brandName;
			} else {
				return '无';
			}
		}

		//根据商品副图片id，删除指定图片
		function deleteImg(imgId, tdindex, index){
			var id = imgId;
			$.ajax({
				type:"get",
				url:"goods!deleteImgByImgid",
				data:{imgId:id},
				dataType:'JSON',
				success:function(msg){
					$("#imgTr"+index+" #td"+tdindex).remove();
				}
			});
		}
		 
		var url = "";
		//打开增改div
		function openWin(flag) {
			//清除原有内容
			$('#goodsForm').form('clear');
			if (flag != 1) {
				url = "goods!updateGoods";
				var chkRows = $("#goodsDg").datagrid("getChecked");
				if (chkRows.length == 1 ) {
					$("#dg").datagrid("options").url="goods!getStockInfoByGoodsid?goodsId="+chkRows[0].goodsId+"";
					$("#dg").datagrid('load');
					$("#goodsId").val(chkRows[0].goodsId);
					$("#typeId").combobox("setValue", chkRows[0].type.typeId);
					$("#brandId").combobox("setValue", chkRows[0].brand.brandId);					
					$("#goodsNo").val(chkRows[0].goodsNo);
					$("#goodsName").val(chkRows[0].goodsName);
					$("#goodsOldPrice").val(chkRows[0].goodsOldPrice);
					//$("#goodsNewPrice").textbox("setValue",chkRows[0].goodsNewPrice);
					$("#goodsDate").datebox("setValue",chkRows[0].goodsDate);
					$("#goodsProducer").val(chkRows[0].goodsProducer);
					$("#goodsStyle").combobox("setValue",chkRows[0].goodsStyle);
				    $("#goodsInformation").val(chkRows[0].goodsInformation);
					$("#goodsSnumber").val(chkRows[0].goodsSnumber);	
					$("#goodsDiscount").val(chkRows[0].goodsDiscount);
					$("#goodsPoint").val(chkRows[0].goodsPoint);
					$("#goodsStatus").combobox("setValue",chkRows[0].goodsStatus);
					//定义一个div变量
					var index=0;
					var tdindex=0;
					$("#goodsImg").css("display","block");
					//清空图片展示表格中的内容
					$("#imgTr"+index).html("");
					//遍历商品副图片
					for(var i=0; i<chkRows[0].imgs.length; i++){
						//获取tr下的td个数
						var num = $("#imgTr"+index+" td").size();
						var html = "<td id='td"+tdindex+"'>"
								+ "<img src='"+chkRows[0].imgs[i].imgUrl+"' style='width:100px;height:100px;display:block;'/>"
								+ "<a href='javascript:void(0)' onclick='deleteImg("+chkRows[0].imgs[i].imgId+","+tdindex+","+index+")' style='display:inline-block;margin-left:40px;margin-top:5px;'>删除</a>"
								+ "</td>";
						tdindex = tdindex + 1;
						if(num > 5){
							html = "<tr>" + html + "</tr>";
							index = index + 1;
							$("#imgTab").append(html);
						}else{
							$("#imgTr"+index).append(html);
						}
					}
					//打开修改模态框
					$('#goodsDialog').dialog('open');
				} else {
					$.messager.show({
						title : '注意',
						msg : '请选择单行进行修改',
						showType : 'slide',
						timeout : 2000,
						style : {
							right : '',
							top : document.body.scrollTop + document.documentElement.scrollTop,
							bottom : ''
						}
					});
				}
			} else {
				url = "goods!saveGoods";
				//新增时清空图片展示
				$("#goodsImg").css("display","none");
				//清空表格数据
				$('#dg').datagrid('loadData',{total:0,rows:[]})
				$('#goodsDialog').dialog('open');
			}
		}

		//提交表单
		function submitForm() {
			$('#goodsForm').form('submit', {   
				url:url,
				onSubmit: function(param){    
					var tablerows = $('#dg').datagrid('getRows');
					//js对象转json格式
					var params = JSON.stringify(tablerows);
					param.params = params;  
					
					var isValid = $(this).form('validate');
					if (!isValid){
						$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
					}
					return isValid;	// 返回false终止表单提交

			    },   
			    success:function(data){    
			    	$('#goodsDialog').dialog('close');
					$("#goodsDg").datagrid("load");
			    }    
			});  
		}
		
		//删除指定商品信息
		function deleteGoodById(){
			//获取所有选择的行
			var chkRows = $("#goodsDg").datagrid("getChecked");			
			if (chkRows.length > 0) {
				alert("确定要删除");
				//获取所有选中的ID				
				var goodsIds =[];
				for (var i = 0; i < chkRows.length; i++) {
					goodsIds[i] = chkRows[i].goodsId; 					
				}
				$.ajax({
					url : "goods!deleteGoodById",
					method : "get",
					data : {
						goodsIds : goodsIds
					},
					dataType : "json",
					traditional:true,
					success : function(result) {
						var isOk = result.isOk;
						//如果删除成功进行刷新
						if (isOk) {
							$("#goodsDg").datagrid("reload");
						}else {
							$.messager.show({
								title : '注意',
								msg : '删除失败',
								showType : 'slide',
								timeout : 2000,
								style : {
									right : '',
									top : document.body.scrollTop + document.documentElement.scrollTop,
									bottom : ''
								}
							});
						}
					}
				});
			}else {
				$.messager.show({
					title : '注意',
					msg : '请选择删除的数据',
					showType : 'slide',
					timeout : 2000,
					style : {
						right : '',
						top : document.body.scrollTop + document.documentElement.scrollTop,
						bottom : ''
					}
				});
			}
		}
		
		//Excel导入
		function importExcel(){
			$('#excelId').dialog('open');
			
		}
	</script>
</body>
</html>