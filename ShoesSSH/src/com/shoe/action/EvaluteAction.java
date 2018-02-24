package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.shoe.framework.BaseAction;
import com.shoe.framework.DateJsonValueProcessor;
import com.shoe.pojo.EvaluteTwo;
import com.shoe.service.EvaluteService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * add by wyh 2018年1月13
 * <p>
 * 评论或咨询控制层
 *
 */
public class EvaluteAction extends BaseAction {

	// 装配服务层
	@Resource
	private EvaluteService evaluteService;

	private EvaluteTwo evalute;
	// 条件查询
	private String query;
	private Integer status;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public EvaluteTwo getEvalute() {
		return evalute;
	}

	public void setEvalute(EvaluteTwo evalute) {
		this.evalute = evalute;
	}

	/**
	 * 
	 * @return 获取所有咨询信息  && 根据条件返回评论信息
	 * @throws UnsupportedEncodingException
	 */
	public String getEvaluteInfo() throws UnsupportedEncodingException {
		Map<String, Object> evaluteInfo = null;
		if (query == null) {
			evaluteInfo = evaluteService.getEvaluteInfo(page, rows);
		} else if ("search".equals(query)) {
			// 对传过来的status进行判断
			evaluteInfo = evaluteService.getEvaluteInfo(page, rows, status);
		}
		return returnHandleDateRe(evaluteInfo);
	}

	/**
	 * 回复咨询
	 * 
	 * @return 返回处理结果
	 * @throws UnsupportedEncodingException
	 */
	public String saveEvalute() throws UnsupportedEncodingException {

		boolean isOk = evaluteService.saveEvalute(evalute);
		JSONObject datas = JSONObject.fromObject(isOk);
		returnData = new ByteArrayInputStream(datas.toString().getBytes("utf-8"));
		return "success";
	}

	/**
	 * 
	 * @return 获取所有评论信息  && 根据条件返回评论信息
	 * @throws UnsupportedEncodingException
	 */
	public String getCommentInfo() throws UnsupportedEncodingException {
		Map<String, Object> evaluteInfo = null;
		if (query == null) {
			evaluteInfo = evaluteService.getCommentInfo(page, rows);
		} else if ("search".equals(query)) {
			evaluteInfo = evaluteService.getCommentInfo(page, rows, status);
		}
		JSONObject datas = JSONObject.fromObject(evaluteInfo);
		JsonConfig jf = new JsonConfig();
		jf.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jf.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		returnData = new ByteArrayInputStream(datas.fromObject(evaluteInfo,jf).toString().getBytes("utf-8"));
		return "success";
	}

}
