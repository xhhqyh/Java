package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;
/**
 * 定制鞋 业务层
 * add by zrh 2018年1月17日 上午11:24:18
 *
 */
public interface CustomizeService {
	/**
	 * 定制鞋列表
	 * add by zrh 2018年1月17日 上午11:24:36
	 *
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> getCustomizeList(int currentPage, int pageSize,String customizeCards);
	
	/**
	 * 添加定制鞋
	 * add by zrh 2018年1月17日 下午4:10:08
	 *
	 * @param customize
	 * @return
	 */
	public boolean addCustomize(Customize customize);
	
	/**
	 * 删除定制鞋
	 * add by zrh 2018年1月17日 下午4:11:05
	 *
	 * @param customizeIds
	 * @return
	 */
	public boolean deleteCustomize(List<Integer> customizeIds);
	
	/**
	 * 查询鞋子尺寸
	 * add by zrh 2018年1月18日 下午4:03:49
	 *
	 * @return
	 */
	public List<Size> getSizeName();
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * 删除类型时  修改相关商品的类型
	 */
	public boolean updateGoodsType(List<Integer> typeId);
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * 删除品牌时  修改相关商品的品牌
	 */
	public boolean updateGoodsBrand(List<Integer> brandId);
	
}
