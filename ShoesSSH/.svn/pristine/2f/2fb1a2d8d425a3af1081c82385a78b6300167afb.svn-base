package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Reserve;

/**
 * <p>订单dao
 * @author 李杨
 * 
 */
public interface OrderDao {
	/**
	 * <p>查询全部订单
	 * 
	 * @param currentPage 当前页
	 * @param pageSize 页容量
	 * 
	 * @return 返回全部订单
	 * @throws Exception
	 * 
	 */
	List<Reserve> getOrder(int currentPage,int pageSize) throws Exception;
	
	/**
	 * add by liyang 2018年1月13日 下午5:28:19
	 * <p>查询总条数
	 * @return 总条数
	 * @throws Exception
	 */
	long getCount()throws Exception;
	/**
	 * 修改订单
	 * @param ids
	 * @param status
	 * @return 返回修改成功数
	 */
	String updateOrder(Integer[] ids, Integer status)throws Exception;
	
	/**
	 * 依据条件(订单状态查询部分订单)
	 * add by liyang 2018年1月15日 上午9:04:18
	 * 
	 * @param status 状态
	 * @param currentPage 当前页
	 * @param pageSize 页容量
	 * @return 返回查询结果集
	 */
	List<Reserve> getSomeOrder(int status, int currentPage, int pageSize)throws Exception;
	
	/**
	 * 依据条件(订单状态查询部分订单)
	 * add by liyang 2018年1月15日 上午9:16:26
	 * 
	 * @param status 状态
	 * @return 返回查询结果值
	 * @throws Exception
	 */
	long getSomeCount(int status) throws Exception;
	/**
	 * 查看有没有这条订单记录<p>
	 * add by liyang 2018年1月20日 下午4:17:52
	 * 
	 * @param order
	 * @return
	 */
	long getSomeCount(String order)throws Exception;
	/**
	 * 查看有没有这条订单记录<p>
	 * add by liyang 2018年1月20日 下午4:18:18
	 * 
	 * @param order
	 * @return
	 * @throws Exception
	 */
	List<Reserve> getSomeOrder(String order)throws Exception;
	
}
