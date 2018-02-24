package com.shoe.pojo;

/**
 * 购物车(t_shoppingcar)
 * 
 * @author 李杨
 * @param shopId
 *            Integer 编号,主键标识符
 * @param goodsId
 *            Integer 商品ID,外键,链接商品信息表(t_goods)
 * @param shopNum
 *            Integer 加入购物车数量
 * @param userId
 *            Integer 用户ID,外键,链接用户信息表(t_user)
 * @param shopStatus
 *            Integer 状态(0:未付款,1:已提交)
 * @param shopType
 *            Integer 积分商品标示(0:不是,1:是)
 */
public class ShoppingCar {
	private Integer shopId;
	private Integer goodsId;
	private Integer shopNum;
	private Integer userId;
	private Integer shopStatus;
	private Integer shopType;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getShopNum() {
		return shopNum;
	}

	public void setShopNum(Integer shopNum) {
		this.shopNum = shopNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	@Override
	public String toString() {
		return "ShoppingCar [shopId=" + shopId + ", goodsId=" + goodsId + ", shopNum=" + shopNum + ", userId=" + userId
				+ ", shopStatus=" + shopStatus + ", shopType=" + shopType + "]";
	}
}
