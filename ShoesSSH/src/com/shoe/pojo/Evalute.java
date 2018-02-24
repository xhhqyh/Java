package com.shoe.pojo;

import java.util.Date;

/**
 * ���۱�
 * 
 * @author ����
 * @param evaluteId
 *            Integer ����ID,������ʶ��
 * @param user
 *            User ���,�����û���(t_user)
 * @param goods
 *            Goods ���,������Ʒ��Ϣ��(t_goods)
 * @param evaluteInformation
 *            String ������ϸ
 * @param evaluteTime
 *            String ����ʱ��,Ĭ��sysdate
 * @param evaluteContent
 *            String �ظ�����
 * @param evaluteStatus
 *            Integer ����״̬;(0:δ����1:�Ѵ���2:����)
 * @param manager
 *            Manager ���,���ӹ���Ա��(t_manager)
 * @param evaluteChoice
 *            Integer ����or��ѯ (0:���� ;1:��ѯ)
 * @param evaluteLevel
 *            Integer �����Ǽ�
 */
public class Evalute {
	private Integer evaluteId;	
	private String evaluteInformation;
	private Date evaluteTime;
	private String evaluteContent;
	private Integer evaluteStatus;	
	private Integer evaluteChoice;
	private Integer evaluteLevel;
	private User user;
	private GoodsTwo goods;
	private ManagerVO manager;
	public Integer getEvaluteId() {
		return evaluteId;
	}
	public void setEvaluteId(Integer evaluteId) {
		this.evaluteId = evaluteId;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
	public GoodsTwo getGoods() {
		return goods;
	}
	public void setGoods(GoodsTwo goods) {
		this.goods = goods;
	}
	public ManagerVO getManager() {
		return manager;
	}
	public void setManager(ManagerVO manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Evalute [evaluteId=" + evaluteId + ", evaluteInformation=" + evaluteInformation + ", evaluteTime="
				+ evaluteTime + ", evaluteContent=" + evaluteContent + ", evaluteStatus=" + evaluteStatus
				+ ", evaluteChoice=" + evaluteChoice + ", evaluteLevel=" + evaluteLevel + "]";
	}
	
}
