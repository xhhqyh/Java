package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;

/**
 * 定制鞋 
 * add by zrh 2018年1月17日 上午11:07:19
 *  持久层
 */
public interface CustomizeDao {
	/**
	 * 查询总行数
	 * add by zrh 2018年1月17日 上午11:10:31
	 *
	 * @throws Exception
	 */
	public long getCount() throws Exception;
	
	/**
	 * 定制鞋信息
	 * add by zrh 2018年1月17日 上午11:10:45
	 *
	 * @param curentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Customize> getCustomizeInfo(int currentPage,int pageSize,String customizeCards) throws Exception;
	
	/**
	 * 添加或修改定制鞋
	 * add by zrh 2018年1月17日 上午11:12:13
	 *
	 * @param customize
	 * @throws Exception
	 */
	public void addCustomize(Customize customize)throws Exception;
	
	/**
	 * 删除
	 * add by zrh 2018年1月17日 下午3:50:27
	 *
	 * @param customizeIds
	 * @throws Exception
	 */
	public void deleteCustomize(List<Integer> customizeIds) throws Exception;
	
	/**
	 * 查询鞋子尺寸
	 * add by zrh 2018年1月18日 下午3:58:12
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize() throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * @throws Exception
	 * 删除类型时  修改相关定制商品的类型
	 */
	public void updateGoodsType(List<Integer> typeId) throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * @throws Exception
	 * 删除品牌时  修改相关定制商品的品牌
	 */
	public void updateGoodsBrand(List<Integer> brandId) throws Exception;
	
}
