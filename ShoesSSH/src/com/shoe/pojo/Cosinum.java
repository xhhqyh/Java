package com.shoe.pojo;

/**
 * ������ɫ���ߴ硢����
 * @author Administrator
 *
 */
public class Cosinum {
	private Integer sizeName;
	private String colorName;
	private Integer stockNum;
	public Integer getSizeName() {
		return sizeName;
	}
	public void setSizeName(Integer sizeName) {
		this.sizeName = sizeName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Integer getStockNum() {
		return stockNum;
	}
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	
	@Override
	public String toString() {
		return "Cosinum [ sizeName=" + sizeName + ", colorName="
				+ colorName + ", stockNum=" + stockNum + "]";
	}
}
