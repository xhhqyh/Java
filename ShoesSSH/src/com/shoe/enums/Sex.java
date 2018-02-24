package com.shoe.enums;
/**
 * 性别枚举
 * @author 李杨
 * @param MAN 男 0
 * @param WOMAN 女 1
 */
public enum Sex {
	MAN(0,"男"),WOMAN(1,"女");
	private Integer no;
	private String sex;
	Sex(Integer no,String sex){
		this.no=no;
		this.sex=sex;
	}
	public Integer getNo() {		
		return no;
	}
	public String getSex() {
		return sex;
	}
	
}
