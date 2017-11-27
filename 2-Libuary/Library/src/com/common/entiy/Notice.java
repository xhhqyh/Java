package com.common.entiy;

/**
 * 封装公告表字段
 * @author: 祁燕辉
 *
 * 2017年10月26日
 */
public class Notice {
	private int bbsid = 0 ;
	private String bbshead = "" ;
	private String bbstext = "" ;
	private String intime = "" ;
	
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}
	public String getBbshead() {
		return bbshead;
	}
	public void setBbshead(String bbshead) {
		this.bbshead = bbshead;
	}
	public String getBbstext() {
		return bbstext;
	}
	public void setBbstext(String bbstext) {
		this.bbstext = bbstext;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	
	
}
