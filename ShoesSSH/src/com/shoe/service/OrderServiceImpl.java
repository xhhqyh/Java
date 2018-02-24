package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.OrderDao;
import com.shoe.pojo.Reserve;
/**
 * <p>订单服务层
 * @author 李杨
 *
 */
@Service  
@Transactional
public class OrderServiceImpl implements OrderService {
	/**
	 * 从Spring中拿
	 */
	@Resource 
	private OrderDao orderDao;

	@Override
	public Map<String, Object> getReserve(int currentPage, int pageSize) {
		long count=0;
		Map<String, Object> maps=new HashMap<String,Object>();
		try {
			count = orderDao.getCount();
			System.out.println(count);
			List<Reserve> listOrder = orderDao.getOrder(currentPage, pageSize);
			maps.put("total",count);
			maps.put("rows", listOrder);
			System.out.println(listOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}

	@Override
	public Object updateOrder(Integer[] ids, Integer status) {
		Map<String,String> map=new HashMap<String,String>();
		try {
			map.put("isok", orderDao.updateOrder(ids,status));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> getSomeOrder(int currentPage, int pageSize,int status){
		Map<String, Object> map=new HashMap<String ,Object>();
		try {
			long someCount = orderDao.getSomeCount(status);
			List<Reserve> list = orderDao.getSomeOrder(status, currentPage, pageSize);
			map.put("total",someCount);
			map.put("rows", list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return map;
		
	}

	@Override
	public Map<String, Object> getSomeOrder(String order) {
		Map<String, Object> map=new HashMap<String ,Object>();
		try {
			long someCount = orderDao.getSomeCount(order);
			List<Reserve> list = orderDao.getSomeOrder(order);
			map.put("total",someCount);
			map.put("rows", list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return map;
		
	}
}
