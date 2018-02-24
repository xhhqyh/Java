package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Advertisement;

/**
 * 
 * add by qyh 2018年1月11日
 * 
 * 广告管理模型层接口
 *
 */
public interface AdvDao {
	/**
	 * add by qyh 2018年1月11日
	 * 
	 * 获取广告信息
	 * @return 广告封装的实体类的集合
	 */
	public List<Advertisement> getAdvPageList(int currentPage, int pageSize) throws Exception;
	
	/**
	 * 获取广告表总行数
	 * add by qyh 2018年1月11日
	 * @return long型广告表总条数
	 * @throws Exception
	 */
	public long getAdvCount() throws Exception;
	
	/**
	 * 新增广告
	 * add by qyh 2018年1月12日
	 * @param adv 广告具体参数
	 * @throws Exception
	 */
	public void saveAdv(Advertisement adv) throws Exception;
	
	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @param advIds 要删除的广告Id
	 * @throws Exception
	 */
	public void deleteAdvByIds(List<Integer> advIds) throws Exception;
}














