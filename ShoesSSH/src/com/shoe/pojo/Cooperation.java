package com.shoe.pojo;

/**
 * 链接表
 * 
 * @author 李杨
 * @param coId
 *            Integer 编号,主键标识符
 * @param coName
 *            String 链接名称
 * @param coUrl
 *            String 链接url
 * @param coImgUrl
 *            String 链接图片url
 * @param coStatus
 *            Integer 状态(0:无效,1:有效)
 */
public class Cooperation {
	private Integer coId;
	private String coName; 
	private String coUrl;
	private String cpImgUrl;
	private Integer coStatus;
	public Integer getCoId() {
		return coId;
	}
	public void setCoId(Integer coId) {
		this.coId = coId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoUrl() {
		return coUrl;
	}
	public void setCoUrl(String coUrl) {
		this.coUrl = coUrl;
	}
	public String getCpImgUrl() {
		return cpImgUrl;
	}
	public void setCpImgUrl(String cpImgUrl) {
		this.cpImgUrl = cpImgUrl;
	}
	public Integer getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(Integer coStatus) {
		this.coStatus = coStatus;
	}
	@Override
	public String toString() {
		return "Cooperation [coId=" + coId + ", coName=" + coName + ", coUrl=" + coUrl + ", cpImgUrl=" + cpImgUrl
				+ ", coStatus=" + coStatus + "]";
	}
}
