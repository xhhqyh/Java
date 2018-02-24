package com.shoe.pojo;

/**
 * 鞋子品牌表(t_brand)
 * 
 * @author 李杨
 * @param brandId
 *            Integer 品牌编号
 * @param brandName
 *            String 品牌名称
 * @param brandGender
 *            Integer 品牌性别           
 * @param brandRemarks
 *            String 品牌备注
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
