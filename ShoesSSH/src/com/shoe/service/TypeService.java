package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Type;
/**
 *  类型
 * add by zrh 2018年1月13日 下午4:35:36
 *
 */
public interface TypeService {
	
	/**
	 * 查询出类型名字
	 * @return
	 */
	 public List<Type> getTypeName();
	 
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return 返回类型信息
	 */
	public Map<String, Object> getTypeList(int currentPage, int pageSize);
	
	/**
	 * 添加或修改
	 * @param type
	 */
	public Boolean addType(Type type);
	
	/**
	 * 删除
	 *
	 * @param typeIds
	 * @return
	 */
	public boolean deleteTypes(List<Integer> typeIds);
	
}
