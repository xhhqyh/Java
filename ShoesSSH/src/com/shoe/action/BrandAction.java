package com.shoe.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.shoe.framework.BaseAction;
import com.shoe.pojo.Brand;
import com.shoe.service.BrandService;
import com.shoe.service.CustomizeService;
import com.shoe.service.GoodsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Ʒ�ƹ���
 * add by zrh 2018��1��13�� ����3:59:38
 *
 */
public class BrandAction extends BaseAction{
	// װ��ʵ��
	@Resource
	private BrandService brandService;
	@Resource 
	private GoodsService goodsService;
	@Resource 
	private CustomizeService customizeService;
	
	private Brand brand;
	private List<Integer> brandIds;

	/**
	 * ��ȡƷ���б�
	 * add by zrh 2018��1��13�� ����3:58:28
	 * @return json�ַ���
	 */
	public String getBrandList() {
		Map<String, Object> dataBrand = brandService.getBrandList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataBrand);
		return returnResult(datas);
	}
	
	/**
	 * 
	 * @return ������ƷƷ������
	 * @throws UnsupportedEncodingException 
	 */
	public String getBrandName() throws UnsupportedEncodingException{
		List<Brand> brandList = brandService.getBrandName();
		JSONArray datas = JSONArray.fromObject(brandList);
		return returnResult(datas);
		
	}

	/**
	 * ��ӻ��޸�
	 * add by zrh 2018��1��13�� ����3:58:21
	 * @return json�ַ���
	 */
	public String addBrand() {
		Boolean isOk = brandService.addBrand(brand);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);

	}

	/**
	 *  ɾ��
	 * add by zrh 2018��1��13�� ����3:58:36
	 *
	 * @parpam brandIds ѡ�����ݵļ���
	 * @return json�ַ���
	 * @throws UnsupportedEncodingException
	 */
	public String deleteBrand() throws UnsupportedEncodingException {
		boolean isOk = brandService.deleteBrands(brandIds);
		if(isOk){
			//ɾ���ɹ������޸������Ʒ��Ϣ
			boolean isOks = goodsService.updateGoodsBrand(brandIds);
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
			boolean isOks = customizeService.updateGoodsBrand(brandIds);
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


	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public List<Integer> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Integer> brandIds) {
		this.brandIds = brandIds;
	}

}
