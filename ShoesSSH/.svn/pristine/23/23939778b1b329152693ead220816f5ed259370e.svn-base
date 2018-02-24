package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Advertisement;
import com.shoe.pojo.Cooperation;

/**
 * 商务合作模型层接口
 * 
 * add by qyh 2018年1月12日 下午8:36:50
 *
 */
public interface CooperDao {
	/**
	 * add by qyh 2018年1月12日 下午8:36:50
	 * 
	 * 获取商务合作信息
	 * @return 商务合作封装的实体类的集合
	 */
	public List<Cooperation> getCooperPageList(int currentPage, int pageSize) throws Exception;
	
	/**
	 * 获取商务合作表总行数
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @return long型商务合作表总条数
	 * @throws Exception
	 */
	public long getCooperCount() throws Exception;
	
	/**
	 * 新增商务合作
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @param cooper 商务合作具体参数
	 * @throws Exception
	 */
	public void saveCooper(Cooperation cooper) throws Exception;
	
	/**
	 * 批量删除商务合作
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @param cooperIds 要删除的商务合作Id
	 * @throws Exception
	 */
	public void deleteCooperByIds(List<Integer> cooperIds) throws Exception;
}
