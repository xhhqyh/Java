package com.shoe.pojo;

/**
 * ����(t_stock)
 * 
 * @author ����
 * @param stockId
 *            Integer ���ID,������ʶ��
 * @param goodsId
 *            Integer ��ƷID,���������Ʒ��(t_goods)
 * @param csId 
 * 			  Integer ��ɫ�ߴ�����
 * @param stockNum
 *            Integer �������
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
