package com.shoe.pojo;

/**
 * 库存表(t_stock)
 * 
 * @author 李杨
 * @param stockId
 *            Integer 库存ID,主键标识符
 * @param goodsId
 *            Integer 商品ID,外键链接商品表(t_goods)
 * @param csId 
 * 			  Integer 颜色尺寸表外键
 * @param stockNum
 *            Integer 库存数量
 */
public class Stock {
	private Integer stockId;
	private Integer goodsId;
	private String colorName;
	private Integer sizeName;
	private Integer stockNum;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Integer getSizeName() {
		return sizeName;
	}

	public void setSizeName(Integer sizeName) {
		this.sizeName = sizeName;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", goodsId=" + goodsId + ", colorName=" + colorName + ", sizeName="
				+ sizeName + ", stockNum=" + stockNum + "]";
	}

}
