package com.shoe.pojo;

import java.util.Date;
import java.util.Set;

/**
 * ��Ʒ������(t_goods)
 * 
 * @author ����
 * @param goodsId
 *            Integer ��Ʒid,������ʶ��
 * @param type
 *            Type,�������ͱ�(t_type)
 * @param brand
 *            Brand,����Ʒ�Ʊ�(t_brand)
 * @param goodsNo
 *            String ���к�
 * @param goodsName
 *            String ��Ʒ����
 * @param goodsOldPrice
 *            Double ��Ʒԭ��
 * @param goodsNewPrice
 *            Double ��Ʒ�ּ�
 * @param goodsDate
 *            Date ��Ʒ�ϼ�ʱ��(Ĭ��sysdate)
 * @param goodsProducer
 *            String ��Ʒ������
 * @param goodsStyle
 *            Sex ��Ʒ��ʽ(0:��,1:Ů)
 * @param goodsInformation
 *            String ��Ʒ��ϸ����
 * @param goodsSnumber
 *            Integer ��Ʒ����
 * @param goodsDiscount
 *            Double ��Ʒ�ۿ�
 * @param goodsPoint
 *            Double ������Ʒ��õĻ���
 * @param goodsStatus
 *            Integer ��Ʒ״̬(0:�ϼ�,1:�¼�)
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
	
	//���һ
	private Type type;
	private Brand brand;
	
	//һ�Զ�
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