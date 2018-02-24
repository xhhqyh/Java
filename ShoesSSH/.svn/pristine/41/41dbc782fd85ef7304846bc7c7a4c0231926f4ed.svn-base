package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Push;

/**
 * 推送管理
 * add by zrh 2018年1月15日 上午9:14:19
 *
 */
public interface PushDao {
	/**
	 * 返回总行数
	 * add by zrh 2018年1月15日 上午9:18:37
	 *
	 * @return
	 * @throws Exception
	 */
	public long getPushCount() throws Exception;
	
	/**
	 * 返回推送图的信息
	 * add by zrh 2018年1月15日 上午9:19:17
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Push> getPushList(int currentPage,int pageSize) throws Exception;
	
	/**
	 * 删除
	 * add by zrh 2018年1月15日 下午2:59:48
	 *
	 * @param pushIds
	 * @throws Exception
	 */
	public void deletePushIds(List<Integer> pushIds) throws Exception;
	
	/**
	 * 添加或修改
	 * add by zrh 2018年1月15日 下午3:03:50
	 *
	 * @param push
	 * @throws Exception
	 */
	public void addPush(Push push) throws Exception;
}
