package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Brand;
/**
 * 品牌持久层
 * add by zrh 2018年1月12日
 *   
 */
public interface BrandDao {
	
	/**
	 * 获得所有鞋子所有品牌
	 * @return
	 * @throws Exception
	 */
	public List<Brand> getBrandName() throws Exception;
	
	/**
	 * 
	 * @return 返回品牌总数量
	 */
	public long getBrandCount() throws Exception;
	
	/**
	 * @param currentPage
	 * @param pageSize
	 * @return 返回品牌所有信息
	 */
	public List<Brand> getBrandInfo(int currentPage, int pageSize)throws Exception; 
	
	/**
	 *  添加或修改
	 * @param brand
	 */
	public void addBrand(Brand brand)throws Exception; 
	
	/**
	 * 删除
	 * @param brands 选中数据的总数
	 * @return 返回品牌总数量
	 */
	public void deleteBrand(List<Integer> brandIds)throws Exception; 
	
}
