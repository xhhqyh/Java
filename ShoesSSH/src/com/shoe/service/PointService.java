package com.shoe.service;

import java.util.Map;

import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;

public interface PointService {
	/**
	 * 查看积分秒杀商品<p>
	 * add by liyang 2018年1月15日 下午5:02:09
	 * @param currentPage
	 * @param pageSize
	 * @param statuss 
	 * @return
	 */
	Map<String, Object> getPointShop(Integer currentPage, Integer pageSize, Integer statuss);
	/**
	 * 修改商品信息<p>
	 * add by liyang 2018年1月17日 上午11:21:18
	 * 
	 * @param status 状态
	 * @param id 
	 * @return
	 */
	boolean updateStatus(Integer status, Integer id);
	/**
	 * 删除积分秒杀商品
	 * add by liyang 2018年1月17日 下午4:14:33
	 * 
	 * @param ids[]
	 * @return
	 */
	Object deletePointByIds(Integer[] ids);
	/**
	 * 查尺寸表
	 * add by liyang 2018年1月18日 下午5:07:26
	 * 
	 * @return
	 */
	Object getSize();
	/**
	 * 查颜色表
	 * add by liyang 2018年1月18日 下午5:07:46
	 * 
	 * @return
	 */
	Object getColor();
	/**
	 * 查商品名及其ID
	 * add by liyang 2018年1月19日 上午11:24:31
	 * 
	 * @return
	 */
	Object getGoods();
	
	/**
	 * 增加或修改
	 * add by liyang 2018年1月19日 下午2:50:07
	 * 
	 * @param pointVO
	 * @return
	 */
	Object saveOrUpdate(PointVo pointVO);
	
}
