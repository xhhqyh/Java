<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<title>柱形图</title>
</head>
<body>
<div>
	<div id="main" style="width: 800px;height:600px;display: inline-block;"></div>
	<div id="main1"  style="width: 380px;height:400px;display: inline-block; position:relative;top:-140px;"></div>
</div>
<script type="text/javascript">


    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart1 = echarts.init(document.getElementById('main1'));
    
    myChart.setOption ({
    	    color: ['#3398DB','#909'],
    	    tooltip : {
    	        trigger: 'axis',
    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    legend: {
    	        data: ['男鞋', '女鞋']
    	    },
    	    grid: {    	     
    	        containLabel: true
    	    },
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : ['01','02','03','04','05','06','07','08','09','10','11','12'],    	        
    	            axisTick: {
    	                alignWithLabel: true
    	            } 
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'男鞋',
    	            type:'bar',
    	            barGap: 0,
    	            data:[]
    	        },
    	        {
    	            name:'女鞋',
    	            type:'bar',
    	            barGap: 0,
    	            data:[]
    	        }
    	    ]
    	});
    
  
    // 获取数据
    $.get('echarts!getEchartSex').done(function (data) {
		
		myChart.hideLoading();
		// 填入数据
	    myChart.setOption({	    	
	       /*  xAxis: {
	            data: data.legendData
	        },  */
	        series: [{
	        	
	            data: data.seriseData
	        },{
	        	
	        	data: data.seriseData1
	        }]
	    });
	});  
   
    //圆形    
    myChart1.setOption({
	    title : {
	        text: '好乐买鞋子商城统计',
	        subtext: '好乐买您的家',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: []
	    },
	    series: [{
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
	});
	
	
	
	 
    // 处理点击事件并且跳转到相应的百度搜索页面
    myChart.on('click', function(params){ 
    	
    	myChart1.showLoading();
    	$.get('echarts!getEchartsType?month='+params.name).done(function (data) {    		
    		myChart1.hideLoading();
    		// 填入数据
    	    myChart1.setOption({
    	    	legend: {
    	            data: data.legendData
    	        },
    	        series: [{
    	            data: data.seriseData
    	        }]
    	    });
    	});
    });  
</script>
</body>
</html>