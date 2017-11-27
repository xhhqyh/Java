package com.common.entiy;

/**
 * 对图书表的字段进行封装
 * @author: 祁燕辉
 *
 * 2017年10月25日
 */
public class Book {
	private int bookid = 0 ;
	private String isbn = "" ;
	private String bookname = "" ;
	private int typeid = 0 ;
	private String typename = "" ;
	private String publisher = "" ;
	private String writer = "" ;
	private String picture = "" ;
	private String introduce = "" ;
	private int price = 0 ;
	private int newbook = 0 ;
	private int command = 0 ;
	private int num = 0 ; //存放排行中书的个数
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNewbook() {
		return newbook;
	}
	public void setNewbook(int newbook) {
		this.newbook = newbook;
	}
	public int getCommand() {
		return command;
	}
	public void setCommand(int command) {
		this.command = command;
	}
	
	
	
	
}
