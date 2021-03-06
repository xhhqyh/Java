package com.shoe.service;

import java.util.Map;

/**
 * <p>订单服务
 * @author 李杨
 *
 */
public interface OrderService {
	/**
	 * <p>查询全部订单
	 * @param currentPage 当前页码
	 * @param pageSize 页容量
	 * @return Map
	 */
	Map<String,Object> getReserve(int currentPage, int pageSize);
	/**
	 * <p>修改订单信息
	 * @param ids 待修改的订单
	 * @param status 待改变的状态
	 * @return 结果 isok 如果是true,表示可以,如果false,就不可以
	 */
	Object updateOrder(Integer[] ids, Integer status);
	/**
	 * <p>条件查询订单的处理<p>
	 * add by liyang 2018年1月15日 上午9:19:15
	 * 
	 * @param currentPage 当前页码
	 * @param pageSize 页容量
	 * @param status 待查询的状态
	 * @return 返回map集,可以直接封装成easyUI的参数
	 */
	Map<String, Object> getSomeOrder(int currentPage, int pageSize, int status);
	/**
	 *  订单查询<p>
	 * add by liyang 2018年1月20日 下午4:15:50
	 * 
	 * @param order
	 * @return
	 */
	Map<String, Object> getSomeOrder(String order);
}
