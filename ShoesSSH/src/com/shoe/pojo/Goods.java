package com.shoe.pojo;

import java.util.Date;
import java.util.Set;

/**
 * 商品管理表(t_goods)
 * 
 * @author 李杨
 * @param goodsId
 *            Integer 商品id,主键标识符
 * @param type
 *            Type,链接类型表(t_type)
 * @param brand
 *            Brand,链接品牌表(t_brand)
 * @param goodsNo
 *            String 序列号
 * @param goodsName
 *            String 商品名称
 * @param goodsOldPrice
 *            Double 商品原价
 * @param goodsNewPrice
 *            Double 商品现价
 * @param goodsDate
 *            Date 商品上架时间(默认sysdate)
 * @param goodsProducer
 *            String 商品生产商
 * @param goodsStyle
 *            Sex 商品款式(0:男,1:女)
 * @param goodsInformation
 *            String 商品详细参数
 * @param goodsSnumber
 *            Integer 商品销量
 * @param goodsDiscount
 *            Double 商品折扣
 * @param goodsPoint
 *            Double 购买商品获得的积分
 * @param goodsStatus
 *            Integer 商品状态(0:上架,1:下架)
 */
public class Goods {
	private Integer goodsId;	
	private String goodsNo;
	private String goodsName;
	private Double goodsOldPrice;
	private Double goodsNewPrice;
	private Date goodsDate;
	private String goodsProducer;
	private Integer goodsStyle;
	private String goodsInformation;
	private Integer goodsSnumber;
	private Double goodsDiscount;
	private Double goodsPoint;
	private Integer goodsStatus;
	private String goodsImgUrl;
	private Integer goodsDel;
	
	//多对一
	private Type type;
	private Brand brand;
	
	//一对多
	private Set<Img> imgs;
	private Set<Stock> stocks;
	
	public Goods() {
		super();
	}
	
	public Goods(Integer goodsId, String goodsName) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
	}

	public Integer getGoodsDel() {
		return goodsDel;
	}

	public void setGoodsDel(Integer goodsDel) {
		this.goodsDel = goodsDel;
	}

	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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

	public Double getGoodsOldPrice() {
		return goodsOldPrice;
	}
	public void setGoodsOldPrice(Double goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}
	public Double getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(Double goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Set<Img> getImgs() {
		return imgs;
	}
	public void setImgs(Set<Img> imgs) {
		this.imgs = imgs;
	}
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	public String getGoodsImgUrl() {
		return goodsImgUrl;
	}
	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsOldPrice="
				+ goodsOldPrice + ", goodsNewPrice=" + goodsNewPrice + ", goodsDate=" + goodsDate + ", goodsProducer="
				+ goodsProducer + ", goodsStyle=" + goodsStyle + ", goodsInformation=" + goodsInformation
				+ ", goodsSnumber=" + goodsSnumber + ", goodsDiscount=" + goodsDiscount + ", goodsPoint=" + goodsPoint
				+ ", goodsStatus=" + goodsStatus + ", goodsImgUrl=" + goodsImgUrl + ", type=" + type + ", brand="
				+ brand + "]";
	}
	
}
