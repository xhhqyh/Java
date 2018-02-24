<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快乐买后台用户系统-用户管理</title>
	<link rel="stylesheet" type="text/css"href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="easyUI/datagrid-detailview.js"></script>

</head>
<body>
	<table id="pointTab" class="easyui-datagrid" title="积分商品信息" style="width:700px;height:250px"
							data-options="singleSelect:false,
										fit:true,
										fitColumns:true,
										pagination:true,
										striped:true, 
										url:'point!getPoint',
									    method:'get',
									    toolbar:'#pointToolbar',
									    view:detailview,
									    pageSize:10,
									    pageList:[5,10,20]">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'pShopId',width:80" align="center">编号</th>
				<th data-options="field:'goods1',width:200,formatter:forName" align="center">商品名称</th>
				<th data-options="field:'goods2',width:200,formatter:forBrandName" align="center">品牌</th>
				<th data-options="field:'pShopPoint',width:200" align="center">消耗积分</th>
				<th data-options="field:'pShopStartTime',width:200,formatter:fortime1" align="center">开始时间</th>
				<th data-options="field:'pShopEndTime',width:200,formatter:fortime2" align="center">结束时间</th>			
				<th data-options="field:'pShopStatus',width:200,formatter:forstatus" align="center">状态</th>
				<th data-options="field:'pShopStatus1',width:100, formatter:fordostatus" align="center" >操作</th>
			</tr>
		</thead>
	</table>
	<!-- 广告管理工具条 -->
	<div id="pointToolbar" style="height:29px;line-height:29px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="openWin(1)">新增</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleted()">删除</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="openWin(0)">修改</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(0)">未上架</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(1)">已上架</a>
	</div>
	
</body>

<!-- 增改div -->
	<div id="pointDialog" class="easyui-dialog" title="积分商品" data-options="iconCls:'icon-save',closed:true" style="width: 700px; height:400px; padding: 10px">
		<form id="pointForm" action="point!saveOrUpdate" method="post" enctype="multipart/form-data">
		<!-- <form id="goodsForm" action="goods!saveGoods" method="post"> -->
			<input id="pointId" type="hidden" name="pointVO.pointId">
			<table cellpadding="5" border="0px">
			<tr> 
				<td>商品名</td>
				<td>
					
	    				<input style="width: 220px" id="pointName" 
	    				class="easyui-combobox" name="pointVO.goodsId" 
	    				data-options="required:true,
										valueField:'goodsId',
										textField:'goodsName',
										url:'point!getGoods'" />
	    				
	    		</td>

			</tr>
				<tr>	
					<td>颜色:</td>
					<td><!-- <input id="pointColor" type="hidden" name="goods.type.typeId"> -->
						<input style="width: 220px" id="pointColor"
						class="easyui-combobox" name="pointVO.colorId"
						data-options="required:true,
										valueField:'colorId',
										textField:'colorName',
										url:'point!getColor'" />
					</td>
					<td>尺寸:</td>
					<td>
						<input style="width: 220px" id="pointSize"
						class="easyui-combobox" name="pointVO.sizeId"
						data-options="required:true,
									  valueField:'sizeId',
									  textField:'sizeName',
									  url:'point!getSize'" />
					</td>
			     </tr>
	    		
	    		<tr>
	    			<td>数目:</td>
	    			<td>
	    				<input id="pointCount" class="easyui-textbox" name="pointVO.pShopNum" data-options="required:true,width:220"/>
	    			</td>
	    			<td>所需积分:</td>
	    			<td>
	    				<input id="pointPoints" class="easyui-textbox" name="pointVO.pShopPoint" data-options="required:true,width:220"/>
	    			</td>
	    		</tr>

	    		<tr>
	    			<td>开始日期:</td>
	    			<td>
	    				<input id="pointOnTime" class="easyui-datetimespinner" name="pointVO.pShopStartTime" data-options="
	    						showSeconds: true,
	    						prompt: '请输入时间!',
	    						icons:[{
									iconCls:'icon-clear',
									handler: function(e){
									$(e.data.target).datetimespinner('clear');
									}
								}]"/>
	    			</td>

	    			<td>结束日期:</td>
	    			<td>
	    				<input id="pointOutTime" class="easyui-datetimespinner" name="pointVO.pShopEndTime" data-options="
	    						showSeconds: true,
	    						prompt: '请输入时间!',
	    						icons:[{
									iconCls:'icon-clear',
									handler: function(e){
									$(e.data.target).datetimespinner('clear');
									}
								}]"/>
								</td>
	   
	    		</tr>
	    		
	    	
			</table>
			
			
			<div style="text-align:center;padding:20px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
		    </div>
			
		</form>
		
	</div>




<script>


	//处理状态
	function forstatus(value,row,index){
		return value==0?"未上架":"已上架";
	}
	//操作
	function fordostatus(value,row,index){
		var html=row.pShopStatus==0?'上架':'下架';
		var id=row.pShopId;
		
		var status=row.pShopStatus==0?1:0;
		return "<a href='#' onclick='dochange("+row.pShopId+","+status+")'>"+html+"</a>";
	}
	function dochange(id,status){
		var html=status==1?'上架':'下架';
		$.messager.confirm('确认','确认要'+html+'吗?',function(r){
			if(r){
				$.ajax({
					url:'point!updatestatus',
					data:{"status":status
						,"id":id},
					dataType:'JSON',
					type:"POST",
					traditional:true,
					success:function(result){
						var isok=result.isok;
						//alert(isok);
						if(isok){
							$.messager.show({
								title : '注意',
								msg : html+'成功',
								showType : 'slide',
								timeout : 2000,
								style : {
									right : '',
									top : document.body.scrollTop
											+ document.documentElement.scrollTop,
									bottom : ''
								}
							});
							$("#pointTab").datagrid('reload');
						}
					}
				})
			}
		})
		
	}
//处理时间

	function fortime1(value,row,index){
		return date(value);
	}
	function fortime2(value,row,index){
		return date(value);
	}
	//转换时间
	 function date(value,text){
		var theYear=value.year+1900;
		var theMonth=normalize(value.month+1);
		var theDay=normalize(value.day);
		var theHour=normalize(value.hours);
		
		var theMinutes=normalize(value.minutes);
		var theSeconds=normalize(value.seconds);
		var theDate="";
		if(text==1){
			theDate=theYear+"-"+theMonth+"-"+theDay
		}else if(text==2){
			theDate=theHour+":"+theMinutes+":"+theSeconds;
		}else{
			theDate=theYear+"-"+theMonth+"-"+theDay+" "+theHour+":"+theMinutes+":"+theSeconds;
		}
		
		return theDate;
	 }
	//规范时间格式
	 function normalize(data){
		 if(data<10){
			 return "0"+data;
		 }else{
			 return ""+data;
		 }
	 }
	//处理列	 
	function forName(value,row,index){
		return row.goods.goodsName;
	}
	function forBrandName(value,row,index){
		return row.goods.brand.brandName;
	}
	
//展示商品详细信息
 $(function(){
	//数据表格视图
	$('#pointTab').datagrid({
		//告诉表格如何渲染详细视图
		detailFormatter: function(rowIndex, rowData){
			//处理状态
			var style=rowData.goods.goodsStyle==0?'男':'女';
			var status=rowData.goods.goodsStatus==0?'在售':'未出售';
			//展开视图样式
			//debugger;
			return '<table style="padding:10px 0;"><tr>' +
					'<td style="border:0;padding-left:25px;;padding-right:25px;">'+
					'<img style="height: 116px;width: 124px;" alt="图片以损坏" src="'+rowData.goods.goodsImgUrl+'"/>'+
					'</td>' + 
					'<td style="border:0;padding-right:25px">'+
					'<p><span style="font-weight: bold;">商品编号: </span>' + rowData.goods.goodsId + '</p>' +
					'<p><span style="font-weight: bold;">商品名称: </span>' + rowData.goods.goodsNo + '</p>' +
					'<p><span style="font-weight: bold;">品牌名称: </span>' + rowData.goods.goodsInformation+ '</p>' +
					'</td>' +
					'<td style="border:0;padding-right:25px">' +
					'<p><span style="font-weight: bold;">生产商: </span>' + rowData.goods.goodsProducer + '</p>' +
					'<p><span style="font-weight: bold;">商品原价: </span>' + rowData.goods.goodsOldPrice + '</p>' +
					'<p><span style="font-weight: bold;">商品现价: </span>' + rowData.goods.goodsNewPrice + '</p>' +
					'</td>' +
					'<td style="border:0;padding-right:25px">' +
					'<p><span style="font-weight: bold;">卖出次数: </span>' + rowData.goods.goodsSnumber + '</p>' +
					'<p><span style="font-weight: bold;">商品类型: </span>' + style+ '</p>' +
					'<p><span style="font-weight: bold;">商品可得积分: </span>' + rowData.goods.goodsPoint + '</p>' +
					'</td>' +
					'<td style="border:0;padding-right:25px">' +
					'<p><span style="font-weight: bold;">商品状态: </span>' + status + '</p>' +
					'<p><span style="font-weight: bold;">上市时间: </span>' + date(rowData.goods.goodsDate) + '</p>' +
					'<p><span style="font-weight: bold;">相关信息: </span>' + rowData.goods.goodsInformation + '</p>' +
					'</td>' +
					'<td style="border:0;padding-right:25px">' +
					'<p><span style="font-weight: bold;">颜色: </span>' + rowData.color.colorName + '</p>' +
					'<p><span style="font-weight: bold;">商品类型: </span>' + rowData.goods.type.typeName + '</p>' +
					'<p><span style="font-weight: bold;">描述信息: </span>' + rowData.goods.type.typeRemarks  + '</p>' +
					'</td>' +
					'</tr></table>';
					
		}
	}).datagrid('loadData');
});
 
 
 
 

	//打开增改div
	function openWin(flag) {//pointDialog
		//清除原有内容
		//alert(flag);
		$('#pointForm').form('clear');
		if (flag != 1) {
			var chkRows = $("#pointTab").datagrid("getChecked");
			
			if (chkRows.length == 1 ) {	
				$("#pointId").val(chkRows[0].pShopId);
				$("#pointName").combobox("setValue", chkRows[0].goods.goodsId);	
				$("#pointColor").combobox("setValue", chkRows[0].color.colorId);					
				$("#pointSize").combobox("setValue",chkRows[0].size.sizeId);
				$("#pointCount").textbox("setValue",chkRows[0].pShopNum);
				$("#pointPoints").textbox("setValue",chkRows[0].pShopPoint);
				
				$("#pointOnTime").textbox("setValue",date(chkRows[0].pShopStartTime));
				
				/* $("#pointOnTime").datetimebox().datetimebox('calendar').calendar({
					validator : function(date){
						
					}
				}) */
				
				/* $("#pointOnTimehms").textbox("setValue",date(chkRows[0].pShopStartTime,2)); */
				
				$("#pointOutTime").textbox("setValue",date(chkRows[0].pShopEndTime));
				
				/* $("#pointOutTimehms").textbox("setValue",date(chkRows[0].pShopEndTime)); */
				$('#pointDialog').dialog('open')
			} else {
				$.messager.show({
					title : '注意',
					msg : '请选择单行进行修改',
					showType : 'slide',
					timeout : 2000,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
				});
			}
		} else {
			$("#pointId").val(0);
			$('#pointDialog').dialog('open')
		}

	}
	
	//提交表单
	function submitForm() {
		$('#pointForm').form('submit', {    
			 onSubmit: function(){    
				 
		    },    
		    success:function(data){  
		    	var data = JSON.parse(data);
		    	$('#pointDialog').dialog('close');
				$("#pointTab").datagrid("load");
				
				if(data.isok){
					alert("成功!");
				}else{
					alert("失败!");
				}
				
		    }    
		});  
	}



	 //条件查询
	function query(data){
		 $("#pointTab").datagrid('reload',{
			 "statuss":data
		 });
	 } 
	
	//删除积分商品
	function deleted(){
		//获取选中项
		var rows=$("#pointTab").datagrid("getChecked");
		var ids=[];
		//判断是否非空
		if(rows.length>0){			
				//提示用户是否需要处理
				
		for(i=0;i<rows.length;i++){	
			ids[i]=rows[i].pShopId;
		}
			$.messager.confirm('确认','确认要删除吗?',function(r){
				if(r){
					$.ajax({
						url:'point!deletePoint',
						data:{"ids":ids},//传需要处理的数组及处理方式
						dataType:'JSON',
						type:"POST",
						traditional:true,
						'success':function(result){
							var isok =result.isok;
							if(isok){
								//重新加载
								$("#pointTab").datagrid('reload');
							}
						}
					})
				}
			})

		}else{
			$.messager.show({
				title:'错误',
				msg:"请至少选择一条订单",
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			})
		}
		
		
		//alert(rows);
	
	}
	
</script>


</html>