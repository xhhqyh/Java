package com.shoe.enums;

/**
 * ����ö��
 * add by qyh 2018��1��12�� ����11:04:24
 *
 */
public enum Num {
	PRICE(0,5);
	private Integer no;
	private Integer num;
	Num(Integer no,Integer num){
		this.no=no;
		this.num=num;
	}
	public Integer getNo() {		
		return no;
	}
	public Integer getNum() {
		return num;
	}
}
