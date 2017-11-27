package com.common.entiy;

/**
 * 	封装购物车表字段
 * @author: 祁燕辉
 *
 * 2017年10月28日
 */
public class Car {
	private int carid = 0;
	private int userid = 0 ;
	private int bookid = 0 ;
	private String bookname = ""; 
	private double price = 0 ;
	private int num = 0 ;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
} 
