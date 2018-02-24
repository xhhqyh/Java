package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.shoe.service.OrderService;

import net.sf.json.JSONObject;

/**
 * <p>
 * 处理订单
 * 
 * @author 李杨
 *
 */
public class OrderAction extends ActionSupport {

	/**
	 * 注入User服务类
	 * 
	 * @see OrderService
	 */
	@Resource
	private OrderService orderService;
	/**
	 * 通过get方法注入一个io流
	 */
	private InputStream data;

	public InputStream getData() {
		return data;
	}
	
	/**
	 * <p>
	 * 通过get方法注入行数rows 页数page 改变的状态status 查询的状态statuss
	 */
	private Integer[] ids;
	private Integer status;
	private Integer rows;
	private Integer page;
	private Integer statuss;
	private String query;    //当query="yes"时,表示是条件
	private String order;
	private String all;

	/**
	 * 查询全部订单
	 * 
	 * @return
	 */
	public String allOrder() {
		Object objs=null;
		if(order==null){
			if(query==null||"all".equals(all)){ 
				
				objs = orderService.getReserve(page, rows);
			}else if("yes".equals(query)){
				//条件查询
				objs=orderService.getSomeOrder(page, rows, statuss);
			}
		}else{
			//订单号索引查询订单
			objs=orderService.getSomeOrder(order);
			
		}
		
		
		try {
			System.out.println(objs);
			data = new ByteArrayInputStream(JSONObject.fromObject(objs).toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	/**
	 * 修改订单
	 * 
	 * @return
	 */
	public String updateOrder() {
	
		try {
			data = new ByteArrayInputStream(JSONObject.fromObject(orderService.updateOrder(ids, status)).toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "success";
	}


	/**
	 * 部分订单处理
	 * add by liyang 2018年1月15日 上午9:32:34
	 * 
	 * @return
	 */
	public String getSomeOrder() {
		try {
			data = new ByteArrayInputStream(
					JSONObject.fromObject(orderService.getSomeOrder(page, rows, statuss)).toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getStatuss() {
		return statuss;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
