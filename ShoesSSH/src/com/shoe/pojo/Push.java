package com.shoe.pojo;

/**
 * 推送管理表
 * 
 * @author 李杨
 * @param pushId
 *            Integer 编号,主键标识符
 * @param pushName
 *            String 推送名称
 * @param pushImg
 *            String 图片地址
 * @param pushStatus
 *            Integer 状态(0:无效,1:有效)
 */
public class Push {
	private Integer pushId;
	private String pushName;
	private String pushImg;
	private Integer pushStatus;

	public Integer getPushId() {
		return pushId;
	}

	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

	public String getPushName() {
		return pushName;
	}

	public void setPushName(String pushName) {
		this.pushName = pushName;
	}

	public String getPushImg() {
		return pushImg;
	}

	public void setPushImg(String pushImg) {
		this.pushImg = pushImg;
	}

	public Integer getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(Integer pushStatus) {
		this.pushStatus = pushStatus;
	}

	@Override
	public String toString() {
		return "Push [pushId=" + pushId + ", pushName=" + pushName + ", pushImg=" + pushImg + ", pushStatus="
				+ pushStatus + "]";
	}
}
