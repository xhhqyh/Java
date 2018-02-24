package com.shoe.pojo;

/**
 * ����
 * 
 * @author ����
 * @param adverId
 *            Integer ���ID,������ʶ��
 * @param adverName
 *            String ��˾����
 * @param adverSalary
 *            Double �������
 * @param adverStartTime
 *            String ��ʼʱ��t_advertisement
 * @param adverEndTime
 *            String ����ʱ��
 * @param adverUrl
 *            String ���url
 * @param adverImgUrl
 *            String ͼƬurl
 * @param adverStatus
 *            Integer ���״̬(0:�ϼ�,1:δ�ϼ�)
 */
public class Advertisement {
	private Integer adverId;
	private String adverName;
	private Double adverSalary;
	private String adverStartTime;
	private String adverEndTime;
	private String adverUrl;
	private String adverImgUrl;
	private Integer adverStatus;

	public Integer getAdverId() {
		return adverId;
	}

	public void setAdverId(Integer adverId) {
		this.adverId = adverId;
	}

	public String getAdverName() {
		return adverName;
	}

	public void setAdverName(String adverName) {
		this.adverName = adverName;
	}

	public Double getAdverSalary() {
		return adverSalary;
	}

	public void setAdverSalary(Double adverSalary) {
		this.adverSalary = adverSalary;
	}

	public String getAdverStartTime() {
		return adverStartTime;
	}

	public void setAdverStartTime(String adverStartTime) {
		this.adverStartTime = adverStartTime;
	}

	public String getAdverEndTime() {
		return adverEndTime;
	}

	public void setAdverEndTime(String adverEndTime) {
		this.adverEndTime = adverEndTime;
	}

	public String getAdverUrl() {
		return adverUrl;
	}

	public void setAdverUrl(String adverUrl) {
		this.adverUrl = adverUrl;
	}

	public String getAdverImgUrl() {
		return adverImgUrl;
	}

	public void setAdverImgUrl(String adverImgUrl) {
		this.adverImgUrl = adverImgUrl;
	}

	public Integer getAdverStatus() {
		return adverStatus;
	}

	public void setAdverStatus(Integer adverStatus) {
		this.adverStatus = adverStatus;
	}

	@Override
	public String toString() {
		return "Advertisement [adverId=" + adverId + ", adverName=" + adverName + ", adverSalary=" + adverSalary
				+ ", adverStartTime=" + adverStartTime + ", adverEndTime=" + adverEndTime + ", adverUrl=" + adverUrl
				+ ", adverImgUrl=" + adverImgUrl + ", adverStatus=" + adverStatus + "]";
	}
}
