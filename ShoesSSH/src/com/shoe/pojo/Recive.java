package com.shoe.pojo;

/**
 * 收货信息表(t_recive)
 * 
 * @author 李杨
 * @param reciveId
 *            Integer 收货信息ID,主键标识符
 * @param reciveName
 *            String 收货人姓名
 * @param reciveCity
 *            String 收货地区
 * @param reciveAddress
 *            String 收货街道地址
 * @param recivePost
 *            Integer 邮政编码
 * @param reciveTel
 *            String 收货人手机号
 * @param reciveStatus
 *            Integer 收货状态,(0:未收货,1:已收货)
 * @param userId
 *            Integer 用户ID,外键,链接用户表(t_user)
 */
public class Recive {
	private Integer reciveId;
	private String reciveName;
	private String reciveCity;
	private String reciveAddress;
	private Integer recivePost;
	private String reciveTel;
	private Integer reciveStatus;
	private Integer userId;

	public Integer getReciveId() {
		return reciveId;
	}

	public void setReciveId(Integer reciveId) {
		this.reciveId = reciveId;
	}

	public String getReciveName() {
		return reciveName;
	}

	public void setReciveName(String reciveName) {
		this.reciveName = reciveName;
	}

	public String getReciveCity() {
		return reciveCity;
	}

	public void setReciveCity(String reciveCity) {
		this.reciveCity = reciveCity;
	}

	public String getReciveAddress() {
		return reciveAddress;
	}

	public void setReciveAddress(String reciveAddress) {
		this.reciveAddress = reciveAddress;
	}

	public Integer getRecivePost() {
		return recivePost;
	}

	public void setRecivePost(Integer recivePost) {
		this.recivePost = recivePost;
	}

	public String getReciveTel() {
		return reciveTel;
	}

	public void setReciveTel(String reciveTel) {
		this.reciveTel = reciveTel;
	}

	public Integer getReciveStatus() {
		return reciveStatus;
	}

	public void setReciveStatus(Integer reciveStatus) {
		this.reciveStatus = reciveStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Recive [reciveId=" + reciveId + ", reciveName=" + reciveName + ", reciveCity=" + reciveCity
				+ ", reciveAddress=" + reciveAddress + ", recivePost=" + recivePost + ", reciveTel=" + reciveTel
				+ ", reciveStatus=" + reciveStatus + ", userId=" + userId + "]";
	}
}
