package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Type;

/**
 * 类型持久存
 * add by zrh 2018年1月13日 下午4:30:48
 *
 */
public interface TypeDao {
	/**
	 * 
	 * @param type
	 * @return 返回鞋子总数量
	 */
	public long getTypeCount() throws Exception;

	/**
	 * @param type
	 * @return 返回鞋子所有信息
	 */
	public List<Type> getTypeInfo(int currentPage, int pageSize) throws Exception;

	/**
	 * 
	 * 添加或修改
	 * @param type
	 * @throws Exception
	 */
	public void addType(Type type) throws Exception;
	
	/**
	 * 获得所有鞋子所有类型
	 * @return
	 * @throws Exception
	 */
	public List<Type> getTypeName() throws Exception;

	
	/**
	 * 删除
	 *
	 * @param typeIds
	 * @throws Exception
	 */
	public void deleteType(List<Integer> typeIds) throws Exception;
}
