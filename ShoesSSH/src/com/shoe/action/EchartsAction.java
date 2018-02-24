package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.shoe.pojo.EchartsSex;
import com.shoe.service.EchartsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * add by wyh 2018年1月17
 * <p>
 * 报表控制层
 *
 */
public class EchartsAction {

	// 装配服务层
	@Resource
	private EchartsService echartsService;

	/**
	 * 通过get方法注入一个io流
	 */
	private InputStream returnData;

	private String month;
	
	

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public InputStream getReturnData() {
		return returnData;
	}

	/**
	 * add by wyh 2018年1月16 返回订单商品名字已经订单数量
	 */
	public String getEchartSex() throws UnsupportedEncodingException {

		// 获取 男鞋商品名字与销量
		List<EchartsSex> echar = null;
		echar = echartsService.getEchartSex();
		// 获取 男鞋商品名字与销量
		List<EchartsSex> echarWomen = null;
		echarWomen = echartsService.getEchartSexWomen();
		// 获得X轴数据
		List<EchartsSex> lengd = null;
		lengd = echartsService.getEchartLengd();
		// 定义 JSONObject 来添加 value name属性
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONObject obj4 = new JSONObject();
		JSONObject obj5 = new JSONObject();
		JSONObject obj6 = new JSONObject();
		JSONObject obj7 = new JSONObject();
		JSONObject obj8 = new JSONObject();
		JSONObject obj9 = new JSONObject();
		JSONObject obj10 = new JSONObject();
		JSONObject obj11 = new JSONObject();
		JSONObject obj12 = new JSONObject();
		//女鞋子
		JSONObject obj2b = new JSONObject();
		JSONObject obj3b = new JSONObject();
		JSONObject obj4b = new JSONObject();
		JSONObject obj5b = new JSONObject();
		JSONObject obj6b = new JSONObject();
		JSONObject obj7b = new JSONObject();
		JSONObject obj8b = new JSONObject();
		JSONObject obj9b = new JSONObject();
		JSONObject obj10b = new JSONObject();
		JSONObject obj11b = new JSONObject();
		JSONObject obj12b = new JSONObject();
		// 定义数组来接受添加后的 obj 或接受商品名
		Object arr[] = {"0","0","0","0","0","0","0","0","0","0","0","0"};
		Object arr2[] = {"0","0","0","0","0","0","0","0","0","0","0","0"};
		JSONArray arr1 = new JSONArray();
		// 循环接受男鞋数据
		for (EchartsSex g : echar) {			
				if(g.getGoodsDate().equals("01")) {	
					obj.put("value", g.getGoodsSnumber());
					obj.put("name", g.getGoodsStyle());
					arr[0] = obj;
				}
				if(g.getGoodsDate().equals("02")) {	
					obj2.put("value", g.getGoodsSnumber());
					obj2.put("name", g.getGoodsStyle());
					arr[1] = obj2;
				}				
				if (g.getGoodsDate().equals("03")) {
					obj3.put("value", g.getGoodsSnumber());
					obj3.put("name", g.getGoodsStyle());
					arr[2] = obj3;
				}
				if (g.getGoodsDate().equals("04")) {
					obj4.put("value", g.getGoodsSnumber());
					obj4.put("name", g.getGoodsStyle());
					arr[3] = obj4;
				}
				if (g.getGoodsDate().equals("05")) {
					obj5.put("value", g.getGoodsSnumber());
					obj5.put("name", g.getGoodsStyle());
					arr[4] = obj5;
				}
				if (g.getGoodsDate().equals("06")) {
					obj6.put("value", g.getGoodsSnumber());
					obj6.put("name", g.getGoodsStyle());
					arr[5] = obj6;
				}
				if (g.getGoodsDate().equals("07")) {
					obj7.put("value", g.getGoodsSnumber());
					obj7.put("name", g.getGoodsStyle());
					arr[6] = obj7;
				}
				if (g.getGoodsDate().equals("08")) {
					obj8.put("value", g.getGoodsSnumber());
					obj8.put("name", g.getGoodsStyle());
					arr[7] = obj8;
				}
				if (g.getGoodsDate().equals("09")) {
					obj9.put("value", g.getGoodsSnumber());
					obj9.put("name", g.getGoodsStyle());
					arr[8] = obj9;
				}
				if (g.getGoodsDate().equals("10")) {
					obj10.put("value", g.getGoodsSnumber());
					obj10.put("name", g.getGoodsStyle());
					arr[9] = obj10;
				}
				if (g.getGoodsDate().equals("11")) {
					obj11.put("value", g.getGoodsSnumber());
					obj11.put("name", g.getGoodsStyle());
					arr[10] = obj11;
				}
				if (g.getGoodsDate().equals("12")) {
					obj12.put("value", g.getGoodsSnumber());
					obj.put("name", g.getGoodsStyle());
					arr[11] = obj12;
				}
		}
		// 循环接受女鞋数据
		for (EchartsSex g : echarWomen) {
			if(g.getGoodsDate().equals("01")) {	
				obj1.put("value", g.getGoodsSnumber());
				obj1.put("name", g.getGoodsStyle());
				arr2[0] = obj1;
			}
			if(g.getGoodsDate().equals("02")) {	
				obj2b.put("value", g.getGoodsSnumber());
				obj2b.put("name", g.getGoodsStyle());
				arr2[1] = obj2b;
			}				
			if (g.getGoodsDate().equals("03")) {
				obj3b.put("value", g.getGoodsSnumber());
				obj3b.put("name", g.getGoodsStyle());
				arr2[2] = obj3b;
			}
			if (g.getGoodsDate().equals("04")) {
				obj4b.put("value", g.getGoodsSnumber());
				obj4b.put("name", g.getGoodsStyle());
				arr2[3] = obj4b;
			}
			if (g.getGoodsDate().equals("05")) {
				obj5b.put("value", g.getGoodsSnumber());
				obj5b.put("name", g.getGoodsStyle());
				arr2[4] = obj5b;
			}
			if (g.getGoodsDate().equals("06")) {
				obj6b.put("value", g.getGoodsSnumber());
				obj6b.put("name", g.getGoodsStyle());
				arr2[5] = obj6b;
			}
			if (g.getGoodsDate().equals("07")) {
				obj7b.put("value", g.getGoodsSnumber());
				obj7b.put("name", g.getGoodsStyle());
				arr2[6] = obj7b;
			}
			if (g.getGoodsDate().equals("08")) {
				obj8b.put("value", g.getGoodsSnumber());
				obj8b.put("name", g.getGoodsStyle());
				arr2[7] = obj8b;
			}
			if (g.getGoodsDate().equals("09")) {
				obj9b.put("value", g.getGoodsSnumber());
				obj9b.put("name", g.getGoodsStyle());
				arr2[8] = obj9b;
			}
			if (g.getGoodsDate().equals("10")) {
				obj10b.put("value", g.getGoodsSnumber());
				obj10b.put("name", g.getGoodsStyle());
				arr2[9] = obj10b;
			}
			if (g.getGoodsDate().equals("11")) {
				obj11b.put("value", g.getGoodsSnumber());
				obj11b.put("name", g.getGoodsStyle());
				arr2[10] = obj11b;
			}
			if (g.getGoodsDate().equals("12")) {
				obj12b.put("value", g.getGoodsSnumber());
				obj12b.put("name", g.getGoodsStyle());
				arr2[11] = obj12b;
			}
		}
		// 循环接受X轴数据
		for (EchartsSex len : lengd) {
			// 数组接受
			arr1.add(len.getGoodsDate());

		}
		// 设置seriseData 值
		JSONObject Data = new JSONObject();
		Data.put("seriseData", arr);
		Data.put("seriseData1", arr2);
		// 设置legendData 值
		JSONArray key = arr1;
		Data.put("legendData", key);

		returnData = new ByteArrayInputStream(Data.toString().getBytes("utf-8"));
		return "success";
	}
	
	/**
	 * add by wyh 2018年1月18
	 *  根据月份返回各个类别鞋子信息
	 */
	public String getEchartsType() throws UnsupportedEncodingException {      
		// 获取商品名字与销量
		List<EchartsSex> echar = null;
		echar = echartsService.getEchartType(month);		
		// 定义 JSONObject 来添加 value name属性
		JSONObject obj = new JSONObject();
		// 定义数组来接受添加后的 obj 或接受商品名
		JSONArray arr = new JSONArray();
		JSONArray arr1 = new JSONArray();
		// 循环接受数据
		for (EchartsSex g : echar) {
			// 添加Vlue name 属性
			obj.put("value", g.getGoodsSnumber());
			obj.put("name",g.getTypeName());
			arr.add(obj);
			// 获取商品名字
			arr1.add(g.getTypeName());			
		}
		// 设置seriseData 值
		JSONObject Data = new JSONObject();
		Data.put("seriseData", arr);
		// 设置legendData 值
		JSONArray key = arr1;
		Data.put("legendData", key);
		returnData = new ByteArrayInputStream(Data.toString().getBytes("utf-8"));
		return "success";
	}

}
