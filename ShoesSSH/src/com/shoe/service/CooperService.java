package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Cooperation;

/**
 * 商务合作服务层接口
 * add by qyh 2018年1月12日 下午8:46:50
 *
 */
public interface CooperService {
	/**
	 * add by qyh 2018年1月12日 下午8:46:50
	 * 
	 * 获取商务合作信息
	 * @return 商务合作封装的实体类的集合
	 */
	public Map<String, Object> getCooperPageList(int currentPage, int pageSize);
	
	/**
	 * 新增或修改商务合作
	 * add by qyh 2018年1月12日 下午8:46:50
	 * @param cooper 商务合作具体参数
	 * @throws Exception
	 */
	public boolean saveCooper(Cooperation cooper);

	/**
	 * 批量删除商务合作
	 * add by qyh 2018年1月12日 下午8:46:50
	 * @param cooperIds 要删除的商务合作Id
	 * @return
	 */
	public boolean deleteCooperByIds(List<Integer> cooperIds);
}
