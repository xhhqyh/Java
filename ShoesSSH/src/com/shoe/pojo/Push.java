package com.shoe.pojo;

/**
 * ���͹����
 * 
 * @author ����
 * @param pushId
 *            Integer ���,������ʶ��
 * @param pushName
 *            String ��������
 * @param pushImg
 *            String ͼƬ��ַ
 * @param pushStatus
 *            Integer ״̬(0:��Ч,1:��Ч)
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
