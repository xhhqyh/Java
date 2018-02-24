package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.EchartsSex;

/**
 * 
 * add by wyh 2018年1月17<p>
 * 商品销量报表 
 *
 */
public interface EchartsDao {
     
	/**
	 * add by wyh 2018年1月17
	 * @param reserve
	 * @return 返回 男鞋 月份   数量
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtSex()throws Exception;
	/**
	 * add by wyh 2018年1月18
	 * @param reserve
	 * @return 返回 女鞋 月份   数量
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtSexWomen()throws Exception;
	
	/**
	 * 
	 * @return 返回 X 轴数据
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtLengd()throws Exception;
	
	/**
	 * 
	 * @param month
	 * @return 根据月份来查询各个类别鞋子信息
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtType(String month)throws Exception;
	
}
