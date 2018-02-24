package com.shoe.dao;

import java.util.List;


import com.shoe.pojo.Evalute;
import com.shoe.pojo.EvaluteTwo;
import com.shoe.pojo.GoodsTwo;
/**
 * 
 * add by wyh 2018年1月13<p>
 * 评价数据层接口
 *
 *
 */
public interface EvaluteDao {

	/**
	 * 返回咨询或评论总数量
	 * @return
	 * @throws Exception
	 */
	public long getCount() throws Exception; 
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return 返回咨询信息
	 * @throws Exception
	 */
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize)throws Exception;
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param stauts
	 * @return 根据条件返回查询信息
	 * @throws Exception
	 */
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize,int stauts)throws Exception;
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return 返回评价信息
	 * @throws Exception
	 */
	public List<Evalute> getCommentInfo(int currentPage, int pageSize)throws Exception;
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param stauts
	 * @return 根据条件返回评论信息
	 * @throws Exception
	 */
	public List<Evalute> getCommentInfo(int currentPage, int pageSize,int stauts)throws Exception;
	
	/**
	 * 回复咨询 评论
	 * @param evalute
	 * @throws Exception
	 */
	public void saveEvalute(EvaluteTwo evalute) throws Exception; 
	
	/**
	 * 
	 * @return 查询未回复的信息数量
	 * @throws Exception
	 */
	public long getEvaluteCount() throws Exception;  
	
	                                                                                        
}
