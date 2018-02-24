package com.shoe.pojo;

import java.util.Date;

/**
 * 评价表
 * 
 * @author 李杨
 * @param evaluteId
 *            Integer 评价ID,主键标识符
 * @param user
 *            User 外键,链接用户表(t_user)
 * @param goods
 *            Goods 外键,链接商品信息表(t_goods)
 * @param evaluteInformation
 *            String 问题详细
 * @param evaluteTime
 *            String 提问时间,默认sysdate
 * @param evaluteContent
 *            String 回复内容
 * @param evaluteStatus
 *            Integer 评价状态;(0:未处理1:已处理2:撤销)
 * @param manager
 *            Manager 外键,链接管理员表(t_manager)
 * @param evaluteChoice
 *            Integer 评价or咨询 (0:评价 ;1:咨询)
 * @param evaluteLevel
 *            Integer 评价星级
 */
public class EvaluteTwo {
	private Integer evaluteId;
	private Integer userId;
	private Integer goodsId;
	private String evaluteInformation;
	private Date evaluteTime;
	private String evaluteContent;
	private Integer evaluteStatus;
	private Integer managerId;
	private Integer evaluteChoice;
	private Integer evaluteLevel;
	public Integer getEvaluteId() {
		return evaluteId;
	}
	public void setEvaluteId(Integer evaluteId) {
		this.evaluteId = evaluteId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getEvaluteInformation() {
		return evaluteInformation;
	}
	public void setEvaluteInformation(String evaluteInformation) {
		this.evaluteInformation = evaluteInformation;
	}
	
	public Date getEvaluteTime() {
		return evaluteTime;
	}
	public void setEvaluteTime(Date evaluteTime) {
		this.evaluteTime = evaluteTime;
	}
	public String getEvaluteContent() {
		return evaluteContent;
	}
	public void setEvaluteContent(String evaluteContent) {
		this.evaluteContent = evaluteContent;
	}
	public Integer getEvaluteStatus() {
		return evaluteStatus;
	}
	public void setEvaluteStatus(Integer evaluteStatus) {
		this.evaluteStatus = evaluteStatus;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getEvaluteChoice() {
		return evaluteChoice;
	}
	public void setEvaluteChoice(Integer evaluteChoice) {
		this.evaluteChoice = evaluteChoice;
	}
	public Integer getEvaluteLevel() {
		return evaluteLevel;
	}
	public void setEvaluteLevel(Integer evaluteLevel) {
		this.evaluteLevel = evaluteLevel;
	}
	@Override
	public String toString() {
		return "EvaluteTwo [evaluteId=" + evaluteId + ", userId=" + userId + ", goodsId=" + goodsId
				+ ", evaluteInformation=" + evaluteInformation + ", evaluteTime=" + evaluteTime + ", evaluteContent="
				+ evaluteContent + ", evaluteStatus=" + evaluteStatus + ", managerId=" + managerId + ", evaluteChoice="
				+ evaluteChoice + ", evaluteLevel=" + evaluteLevel + "]";
	}	
	
}
