package com.shoe.service;

import java.util.Map;

import com.shoe.pojo.EvaluteTwo;
import com.shoe.pojo.GoodsTwo;

/**
 * 
 * add by wyh 2018年1月13<p>
 * 咨询或评论服务层接口
 *
 */
public interface EvaluteService {
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return 返回咨询信息
	 */
	public Map<String, Object> getEvaluteInfo(int currentPage, int pageSize);
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param stauts
	 * @return 根据条件返回咨询信息
	 */
	public Map<String, Object> getEvaluteInfo(int currentPage, int pageSize,int stauts);
    /**
     * 
     * @param currentPage
     * @param pageSize
     * @return 返回评论信息
     */
	public Map<String, Object> getCommentInfo(int currentPage, int pageSize);
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param stauts
	 * @return 根据条件返回评论信息
	 */
	public Map<String, Object> getCommentInfo(int currentPage, int pageSize,int stauts);
	/**
	 * 回复咨询
	 * @param evalute
	 * @return
	 */
	public boolean saveEvalute(EvaluteTwo evalute);
	
	/**
	 * 
	 * @return 回复未回复信息数量
	 */
	public long getEvaluteCount();
}
