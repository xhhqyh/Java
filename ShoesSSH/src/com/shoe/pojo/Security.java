package com.shoe.pojo;

/**
 * �ܱ���
 * 
 * @author ����
 * @param securityId
 *            Integer �ܱ�����
 * @param securityQuestion
 *            String �ܱ�������Ϣ
 */
public class Security {
	private Integer securityId;
	private String securityQuestion;

	public Integer getSecurityId() {
		return securityId;
	}

	public void setSecurityId(Integer securityId) {
		this.securityId = securityId;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	@Override
	public String toString() {
		return "Security [securityId=" + securityId + ", securityQuestion=" + securityQuestion + "]";
	}

}
