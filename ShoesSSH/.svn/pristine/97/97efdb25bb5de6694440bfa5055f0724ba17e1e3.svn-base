package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Advertisement;

/**
 * 
 * add by qyh 2018年1月11日
 *
 * 广告管理服务层接口
 */
public interface AdvService {
	
	/**
	 * add by qyh 2018年1月11日
	 * 
	 * 获取广告信息
	 * @return 广告封装的实体类的集合
	 */
	public Map<String, Object> getAdvPageList(int currentPage, int pageSize);
	
	/**
	 * 新增或修改广告
	 * add by qyh 2018年1月12日
	 * @param adv 广告具体参数
	 * @throws Exception
	 */
	public boolean saveAdv(Advertisement adv);

	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @param advIds 要删除的广告Id
	 * @return
	 */
	public boolean deleteAdvByIds(List<Integer> advIds);
}
