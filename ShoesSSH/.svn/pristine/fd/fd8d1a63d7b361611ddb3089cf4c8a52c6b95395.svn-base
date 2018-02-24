package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Brand;
/**
 * 
 * add by zrh 2018年1月13日 下午4:07:18
 * 品牌服务层接口
 *
 */
public interface BrandService {
	
	/**
	 * 查询出品牌名字
	 * @return
	 */
	 public List<Brand> getBrandName();
	 
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return 返回品牌信息
	 */
	public Map<String, Object> getBrandList(int currentPage, int pageSize);
	
	/**
	 * 添加或修改
	 * add by zrh 2018年1月13日 下午4:07:18
	 *
	 * @param brand 添加或修改的数据
	 * @return
	 */
	public Boolean addBrand(Brand brand);
	
	/**
	 * add by zrh 2018年1月13日 下午4:08:02
	 *
	 * @param brandIds 选中数据的ID集合
	 * @return
	 */
	public boolean deleteBrands(List<Integer> brandIds);
	

}
