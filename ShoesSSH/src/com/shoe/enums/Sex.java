package com.shoe.enums;
/**
 * �Ա�ö��
 * @author ����
 * @param MAN �� 0
 * @param WOMAN Ů 1
 */
public enum Sex {
	MAN(0,"��"),WOMAN(1,"Ů");
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
