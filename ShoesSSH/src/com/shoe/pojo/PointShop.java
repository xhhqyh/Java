package com.shoe.pojo;

import java.util.Date;

/**
 * 积分兑换表(t_pointshop)
 * 
 * @author 李杨
 * @param pShopId
 *            Integer 编号ID,主键标识符
 * @param goods
 *            Goods 商品信息
 * @param pShopPoint
 *            Double 消耗积分
 * @param pShopStartTime
 *            String 开始时间
 * @param pShopEndTime
 *            String 结束时间
 * @param pShopNum
 *            Integer 数量
 * @param Color
 *            colorId 颜色表
 * @param Size 
 * 			  sizeId 尺寸表
 * @param pShopStatus
 *            Integer 状态(0:无效,1:有效)
 */
public class PointShop {
	private Integer pShopId;
	private Goods goods;
	private Double pShopPoint;
	private Date pShopStartTime;
	private Date pShopEndTime;
	private Integer pShopNum;
	private Color color;
	private Size size;
	private Integer pShopStatus;
	public Integer getpShopId() {
		return pShopId;
	}
	public void setpShopId(Integer pShopId) {
		this.pShopId = pShopId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Double getpShopPoint() {
		return pShopPoint;
	}
	public void setpShopPoint(Double pShopPoint) {
		this.pShopPoint = pShopPoint;
	}
	public Date getpShopStartTime() {
		return pShopStartTime;
	}
	public void setpShopStartTime(Date pShopStartTime) {
		this.pShopStartTime = pShopStartTime;
	}
	public Date getpShopEndTime() {
		return pShopEndTime;
	}
	public void setpShopEndTime(Date pShopEndTime) {
		this.pShopEndTime = pShopEndTime;
	}
	public Integer getpShopNum() {
		return pShopNum;
	}
	public void setpShopNum(Integer pShopNum) {
		this.pShopNum = pShopNum;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Integer getpShopStatus() {
		return pShopStatus;
	}
	public void setpShopStatus(Integer pShopStatus) {
		this.pShopStatus = pShopStatus;
	}
	@Override
	public String toString() {
		return "PointShop [pShopId=" + pShopId + ", pShopPoint=" + pShopPoint + ", pShopStartTime=" + pShopStartTime
				+ ", pShopEndTime=" + pShopEndTime + ", pShopNum=" + pShopNum + ", pShopStatus=" + pShopStatus + "]";
	}
	
}
