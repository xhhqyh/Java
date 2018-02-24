package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Push;

/**
 * 推送管理
 * add by zrh 2018年1月15日 上午9:33:53
 *
 */
public interface PushService {
	/**
	 * 返回推送总信息
	 * add by zrh 2018年1月15日 上午9:36:17
	 *
	 * @param currnetPage
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> getPushList(int currnetPage,int pageSize);
	
	/**
	 * 删除
	 * add by zrh 2018年1月15日 下午3:08:43
	 *
	 * @param pushIds
	 * @return
	 */
	public Boolean deletePushList(List<Integer> pushIds);
	
	/**
	 * 添加或修改
	 * add by zrh 2018年1月15日 下午3:08:52
	 *
	 * @param push
	 * @return
	 */
	public Boolean addPush(Push push);
}
