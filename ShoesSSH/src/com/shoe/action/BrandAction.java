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
 * 品牌管理
 * add by zrh 2018年1月13日 下午3:59:38
 *
 */
public class BrandAction extends BaseAction{
	// 装配实例
	@Resource
	private BrandService brandService;
	@Resource 
	private GoodsService goodsService;
	@Resource 
	private CustomizeService customizeService;
	
	private Brand brand;
	private List<Integer> brandIds;

	/**
	 * 获取品牌列表
	 * add by zrh 2018年1月13日 下午3:58:28
	 * @return json字符串
	 */
	public String getBrandList() {
		Map<String, Object> dataBrand = brandService.getBrandList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataBrand);
		return returnResult(datas);
	}
	
	/**
	 * 
	 * @return 返回商品品牌名字
	 * @throws UnsupportedEncodingException 
	 */
	public String getBrandName() throws UnsupportedEncodingException{
		List<Brand> brandList = brandService.getBrandName();
		JSONArray datas = JSONArray.fromObject(brandList);
		return returnResult(datas);
		
	}

	/**
	 * 添加或修改
	 * add by zrh 2018年1月13日 下午3:58:21
	 * @return json字符串
	 */
	public String addBrand() {
		Boolean isOk = brandService.addBrand(brand);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);

	}

	/**
	 *  删除
	 * add by zrh 2018年1月13日 下午3:58:36
	 *
	 * @parpam brandIds 选中数据的集合
	 * @return json字符串
	 * @throws UnsupportedEncodingException
	 */
	public String deleteBrand() throws UnsupportedEncodingException {
		boolean isOk = brandService.deleteBrands(brandIds);
		if(isOk){
			//删除成功后级联修改相关商品信息
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
			//删除成功后级联修改相关定制商品信息
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
