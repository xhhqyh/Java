package com.shoe.pojo;

/**
 * 颜色尺寸表封装类
 * add by qyh 2018年1月15日 下午3:51:53
 *
 */
public class ColorSize {
	private Integer cs_id;
	private double cs_size ;
	private String cs_color ;
	
	public Integer getCs_id() {
		return cs_id;
	}
	public void setCs_id(Integer cs_id) {
		this.cs_id = cs_id;
	}
	public double getCs_size() {
		return cs_size;
	}
	public void setCs_size(double cs_size) {
		this.cs_size = cs_size;
	}
	public String getCs_color() {
		return cs_color;
	}
	public void setCs_color(String cs_color) {
		this.cs_color = cs_color;
	}
	@Override
	public String toString() {
		return "ColorSize [cs_id=" + cs_id + ", cs_size=" + cs_size + ", cs_color=" + cs_color + "]";
	}
	
	
}
