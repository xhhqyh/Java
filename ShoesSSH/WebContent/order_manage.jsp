<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快乐买后台用户系统-订单管理</title>
	<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="shortcut icon" href="img/favicon_logo.ico" />
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="easyUI/datagrid-detailview.js"></script>

</head>
<body>
	<table id="orderTab" class="easyui-datagrid" title="订单信息" style="width:700px;height:250px"
				data-options="singleSelect:false,
							  rownumbers:true,
							  collapsible:true,
							  toolbar:'#orderToolbar',
							  striped:true, 
							  view:detailview,
							  url:'getOrder!allOrder',
							  method:'post',
							  pagination:true,
							  pageSize:10,
							  fit:true,
							  fitColumns:true,
							  pageList:[5,10,20]
							  ">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'reserveId',width:80" align="center">编号</th>
				<th data-options="field:'reserveNo',width:80" align="center">订单号</th>
				<th data-options="field:'user',width:200,formatter:forUser" align="center">账号</th>
				<th data-options="field:'recive',width:100,formatter:forRecive" align="center">收货地址</th>
				<th data-options="field:'reserveTime',width:200" align="center">下单时间</th>
				<th data-options="field:'reserveStatus',width:200,formatter:forStatus" align="center">状态</th>
				<!-- <th data-options="field:'userStatus',width:100, formatter:formatterStatus" align="center" >操作</th> -->
			</tr>
		</thead>
	</table>
	<!-- 广告管理工具条 -->
	<div id="orderToolbar" style="height:29px;line-height:29px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="deliver(0)">发货</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no',plain:true" onclick="deliver(3)">退货</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" style="margin-left:10%" onclick="queryAll()">全部订单</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(0)">未发货</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(1)">已发货</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(2)">交易成功</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(3)">退货订单</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(4)">退货成功</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="query(5)">热卖商品</a>
		
		<input class="easyui-textbox" style="margin-left:90%" type="text" id="select" name="selectOrder" data-options="prompt:'订单号',required:true,width:200"/>
		<a href="javascript:void(0)" data-options="iconCls:'icon-search',plain:true" class="easyui-linkbutton" onclick="selectOrder()">查询</a>
	</div>
</body>
<script>

//展示商品详细信息
$(function(){
	//数据表格视图
	$('#orderTab').datagrid({
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
					
					'<p><span style="font-weight: bold;">商品类型: </span>' + rowData.goods.type.typeName + '</p>' +
					'<p><span style="font-weight: bold;">描述信息: </span>' + rowData.goods.type.typeRemarks  + '</p>' +
					'</td>' +
					'</tr></table>';
					
		}
	}).datagrid('loadData');
});



	function selectOrder(){
		order=$("#select").textbox("getValue");
		if(order.length!=16){
			$.messager.show({
				title:'错误',
				msg:"您所输入的不满足订单号格式,请检查重新输入!",
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			})
		}else{
			 $("#orderTab").datagrid('reload',{
				 "order":order,
				 "query":"yes"
			 });
		}
	}
	 function forUser(value,row,index){
		var html="";
		//alert(value);
		if(value!=null){
			html=value.userAccount;
		}
		return html;
	} 
	 function forRecive(value,row,index){
			var html="";
			//alert(value);
			if(value!=null){
				html=value.reciveCity+"市"+value.reciveAddress;
			}
			return html;
		} 
	 function forStatus(value,row,index){
			var html="";
			//alert(value);
			if(value!=null){
				switch(value){//0:代发货,1:待签中,2:交易成功,3:申请退货,4:退货成功
				case 0:html="待发货";break;
				case 1:html="已发货";break;
				case 2:html="交易成功";break;
				case 3:html="申请退货";break;
				case 4:html="退货成功";break;
				}
			}
			return html;
		}
	 function queryAll(){
		 $("#orderTab").datagrid('reload',{
			 "all":"all"
		 })
	 }
	 //条件查询
	function query(data){
		 $("#orderTab").datagrid('reload',{
			 "statuss":data,
			 "query":"yes"
		 });
		/*  $.ajax({
			 url:'getOrder!getSomeOrder',
			 data:{"statuss":data},
			 dataType:'JSON',
			 type:'POST',
			 traditional:true,
			 'success':function(result){
				
			 }
		 }) */
	 } 
	
	//发货和退货
	function deliver(f){
		//获取选中项
		var rows=$("#orderTab").datagrid("getChecked");
		var str="";
		var ids=[];
		var flag=true;
		var deliver;
		var deliverd;
		if(f==0){
			deliver="发货";

		}else{
			deliver="退货";

		}
		//判断是否非空
		if(rows.length>0){
			//查看待冻结的账号里面有没有不能处理的;
			
			for(i=0;i<rows.length;i++){
				ids[i]=rows[i].reserveId;
				if(rows[i].reserveStatus!=f){
					flag=false;
				}
				
			}
			//如果有就提示用户,不能处理
			if(!flag){
				$.messager.show({
					title:'错误',
					msg:"您所勾选的订单中有些不能"+deliver,
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				})
			}else{
				//如果没有,就提示用户是否需要处理
				$.messager.confirm('确认','确认要'+deliver+'吗?',function(r){
					if(r){
						$.ajax({
							url:'getOrder!updateOrder',
							data:{"ids":ids,"status":(f+1)},//传需要处理的数组及处理方式
							dataType:'JSON',
							type:"POST",
							traditional:true,
							'success':function(result){
								var isok =result.isok;
								if(isok){
									//重新加载
									$("#orderTab").datagrid('reload');
								}
							}
						})
					}
				})

			}
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
	
</script>


</html>