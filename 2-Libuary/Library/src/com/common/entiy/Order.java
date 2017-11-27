package com.common.entiy;

/**
 * 封装订单表字段
 * @author: 祁燕辉
 *
 * 2017年10月29日
 */

public class Order {
	private int orderid = 0 ;
	private String username = "" ;
	private String truename = "" ;
	private String address = "" ;
	private String postcode = "" ;
	private long tel = 0 ;
	private String phone = "";
	private String email = "" ;
	private String orderdate = "" ;
	private int enfore = 0 ;
	private double money = 0 ;
	private int detid = 0 ;
	private int bookid = 0 ;
	private double price = 0 ;
	private int number = 0 ;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public int getDetid() {
		return detid;
	}
	public void setDetid(int detid) {
		this.detid = detid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getEnfore() {
		return enfore;
	}
	public void setEnfore(int enfore) {
		this.enfore = enfore;
	}
}
