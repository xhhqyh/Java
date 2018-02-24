package com.shoe.pojo;

import java.util.Date;

public class GoodsTwo {
	
	private Integer goodsId;
	private Integer typeId;
	private Integer brandId;
	private String goodsNo;
	private String goodsName;
	private Double goodsNewPrice;
	private Double goodsOldPrice;
	private Date goodsDate;
	private String goodsProducer;
	private Integer goodsStyle;
	private String goodsInformation;
	private Integer goodsSnumber;
	private Double goodsDiscount;
	private Double goodsPoint;
	private Integer goodsStatus;
	private String goodsImgUrl;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(Double goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}
	public Double getGoodsOldPrice() {
		return goodsOldPrice;
	}
	public void setGoodsOldPrice(Double goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}
	public String getGoodsProducer() {
		return goodsProducer;
	}
	public void setGoodsProducer(String goodsProducer) {
		this.goodsProducer = goodsProducer;
	}
	public Integer getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(Integer goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
	public String getGoodsInformation() {
		return goodsInformation;
	}
	public void setGoodsInformation(String goodsInformation) {
		this.goodsInformation = goodsInformation;
	}
	public Integer getGoodsSnumber() {
		return goodsSnumber;
	}
	public void setGoodsSnumber(Integer goodsSnumber) {
		this.goodsSnumber = goodsSnumber;
	}
	public Double getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(Double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	public Double getGoodsPoint() {
		return goodsPoint;
	}
	public void setGoodsPoint(Double goodsPoint) {
		this.goodsPoint = goodsPoint;
	}
	public Integer getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	public String getGoodsImgUrl() {
		return goodsImgUrl;
	}
	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}
	@Override
	public String toString() {
		return "GoodsTwo [goodsId=" + goodsId + ", typeId=" + typeId + ", brandId=" + brandId + ", goodsNo=" + goodsNo
				+ ", goodsName=" + goodsName + ", goodsNewPrice=" + goodsNewPrice + ", goodsOldPrice=" + goodsOldPrice
				+ ", goodsDate=" + goodsDate + ", goodsProducer=" + goodsProducer + ", goodsStyle=" + goodsStyle
				+ ", goodsInformation=" + goodsInformation + ", goodsSnumber=" + goodsSnumber + ", goodsDiscount="
				+ goodsDiscount + ", goodsPoint=" + goodsPoint + ", goodsStatus=" + goodsStatus + ", goodsImgUrl="
				+ goodsImgUrl + "]";
	}

	
	
}
