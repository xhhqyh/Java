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
 * ���͹���
 * add by zrh 2018��1��13�� ����3:49:49
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
	 * ��ȡ������Ϣ
	 * add by zrh 2018��1��13�� ����3:50:14
	 * @return json�ַ���
	 */
	public String getTypeList() {
		Map<String, Object> dataType = typeService.getTypeList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataType);
		return returnResult(datas);
	}
	
	/**
     * �����Ʒ��������
     * @return
     * @throws UnsupportedEncodingException 
     */
	public String getTypeName () throws UnsupportedEncodingException{
		List<Type> typeList = typeService.getTypeName();		
		JSONArray datas = JSONArray.fromObject(typeList);
		return returnResult(datas);
	}

	
	/**
	 * ������ͻ��޸�
	 * add by zrh 2018��1��13�� ����3:46:14
	 *
	 * @return json�ַ���
	 */
	public String addType() {
		Boolean isOk = typeService.addType(type);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}

	/**
	 * ɾ��
	 * add by zrh 2018��1��13�� ����3:47:51
	 * @return json�ַ���
	 * @throws UnsupportedEncodingException
	 */
	public String deleteType() throws UnsupportedEncodingException {
		boolean isOk = typeService.deleteTypes(typeIds);		
		if(isOk){
			//ɾ���ɹ������޸������Ʒ��Ϣ
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
			//ɾ���ɹ������޸���ض�����Ʒ��Ϣ
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
