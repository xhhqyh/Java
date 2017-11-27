package com.common.entiy;

/**
 * 封装管理员表字段
 * @author: 祁燕辉
 *
 * 2017年10月30日
 */
public class Admin {
	private int manid = 0;
	private String manname = "" ;
	private String manpwd = "" ;
	private String mantype = "" ;
	
	public int getManid() {
		return manid;
	}
	public void setManid(int manid) {
		this.manid = manid;
	}
	public String getManname() {
		return manname;
	}
	public void setManname(String manname) {
		this.manname = manname;
	}
	public String getManpwd() {
		return manpwd;
	}
	public void setManpwd(String manpwd) {
		this.manpwd = manpwd;
	}
	public String getMantype() {
		return mantype;
	}
	public void setMantype(String mantype) {
		this.mantype = mantype;
	}
	
	
}
