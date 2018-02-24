package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.EvaluteDao;
import com.shoe.pojo.Evalute;
import com.shoe.pojo.EvaluteTwo;
import com.shoe.pojo.Goods;

/**
 * 
 * add by wyh 2018年1月13<p>
 * 评论或咨询服务层接口实现类
 *
 */
@Service  
@Transactional
public class EvaluteServiceImpl implements EvaluteService {
    
	//数据层装配
	@Resource
	private EvaluteDao evaluteDao;
	
	/**
	 * 获取所有咨询信息
	 */
	@Override
	public Map<String, Object> getEvaluteInfo(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		//获取总数量		
		try {
			long evaCount = evaluteDao.getCount();
			//获取查询的数据
			List<Evalute> evaList = evaluteDao.getEvaluteInfo(currentPage, pageSize);
			data.put("total", evaCount);
			data.put("rows", evaList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return data;
	}
    /**
     * 根据条件返回咨询信息
     */
	@Override
	public Map<String, Object> getEvaluteInfo(int currentPage, int pageSize, int stauts) {
		Map<String, Object> data = new HashMap<String, Object>();
		//获取总数量		
		try {
			long evaCount = evaluteDao.getCount();
			//获取查询的数据
			List<Evalute> evaList = evaluteDao.getEvaluteInfo(currentPage, pageSize,stauts);
			data.put("total", evaCount);
			data.put("rows", evaList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return data;
	}
	/**
	 * 回复咨询
	 */
	@Override
	public boolean saveEvalute(EvaluteTwo evalute) {
		boolean isOk = true;
		try {
			evaluteDao.saveEvalute(evalute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}
    /**
     * 获取所有评论信息
     */
	@Override
	public Map<String, Object> getCommentInfo(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		//获取总数量		
		try {
			long evaCount = evaluteDao.getCount();
			//获取查询的数据
			List<Evalute> evaList = evaluteDao.getCommentInfo(currentPage, pageSize);
			data.put("total", evaCount);
			data.put("rows", evaList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return data;
	}
	/**
	 * 根据条件返回评论信息
	 */
	@Override
	public Map<String, Object> getCommentInfo(int currentPage, int pageSize, int stauts) {
		Map<String, Object> data = new HashMap<String, Object>();
		//获取总数量		
		try {
			long evaCount = evaluteDao.getCount();
			//获取查询的数据
			List<Evalute> evaList = evaluteDao.getCommentInfo(currentPage, pageSize,stauts);
			data.put("total", evaCount);
			data.put("rows", evaList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return data;
	}
	/**
	 * 返回未回复信息数量
	 */
	@Override
	public long getEvaluteCount() {
		long count = 0;
		try {
			count = evaluteDao.getEvaluteCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	

}
