package com.shoe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.shoe.framework.BaseAction;
import com.shoe.pojo.Type;
import com.shoe.service.CustomizeService;
import com.shoe.service.GoodsService;
import com.shoe.service.TypeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 类型管理
 * add by zrh 2018年1月13日 下午3:49:49
 *
 */
public class TypeAction extends BaseAction{
	@Resource
	private TypeService typeService;
	@Resource 
	private GoodsService goodsService;
	@Resource 
	private CustomizeService customizeService;
	
	private Type type;
	private List<Integer> typeIds;
	
	/**
	 * 获取类型信息
	 * add by zrh 2018年1月13日 下午3:50:14
	 * @return json字符串
	 */
	public String getTypeList() {
		Map<String, Object> dataType = typeService.getTypeList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataType);
		return returnResult(datas);
	}
	
	/**
     * 获得商品类型名字
     * @return
     * @throws UnsupportedEncodingException 
     */
	public String getTypeName () throws UnsupportedEncodingException{
		List<Type> typeList = typeService.getTypeName();		
		JSONArray datas = JSONArray.fromObject(typeList);
		return returnResult(datas);
	}

	
	/**
	 * 添加类型或修改
	 * add by zrh 2018年1月13日 下午3:46:14
	 *
	 * @return json字符串
	 */
	public String addType() {
		Boolean isOk = typeService.addType(type);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}

	/**
	 * 删除
	 * add by zrh 2018年1月13日 下午3:47:51
	 * @return json字符串
	 * @throws UnsupportedEncodingException
	 */
	public String deleteType() throws UnsupportedEncodingException {
		boolean isOk = typeService.deleteTypes(typeIds);		
		if(isOk){
			//删除成功后级联修改相关商品信息
			boolean isOks = goodsService.updateGoodsType(typeIds);
			if(isOks){
				isOk = true;
			}else{
				isOk = false;
			}
		}else{
			isOk = false;
		}	
		if(isOk){
			//删除成功后级联修改相关定制商品信息
			boolean isOks = customizeService.updateGoodsType(typeIds);
			if(isOks){
				isOk = true;
			}else{
				isOk = false;
			}
		}else{
			isOk = false;
		}
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Integer> getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(List<Integer> typeIds) {
		this.typeIds = typeIds;
	}
	
	
}
