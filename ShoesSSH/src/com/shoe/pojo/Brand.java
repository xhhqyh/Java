package com.shoe.pojo;

/**
 * Ь��Ʒ�Ʊ�(t_brand)
 * 
 * @author ����
 * @param brandId
 *            Integer Ʒ�Ʊ��
 * @param brandName
 *            String Ʒ������
 * @param brandGender
 *            Integer Ʒ���Ա�           
 * @param brandRemarks
 *            String Ʒ�Ʊ�ע
 */
public class Brand {
	private Integer brandId;
	private String brandName;
	private Integer brandGender;
	private String brandRemarks;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getBrandGender() {
		return brandGender;
	}
	public void setBrandGender(Integer brandGender) {
		this.brandGender = brandGender;
	}
	public String getBrandRemarks() {
		return brandRemarks;
	}
	public void setBrandRemarks(String brandRemarks) {
		this.brandRemarks = brandRemarks;
	}
	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandGender=" + brandGender
				+ ", brandRemarks=" + brandRemarks + "]";
	}
	

}
