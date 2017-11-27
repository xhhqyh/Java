package com.common.entiy;


/**
 * 完成对投票表字段封装
 * @author: 祁燕辉
 *
 * 2017年10月25日
 */
public class Poll {
	private int pollid = 0 ;
	private String pollname = "" ;
	private int pollnum = 0 ;
	
	public int getPollid() {
		return pollid;
	}
	public void setPollid(int pollid) {
		this.pollid = pollid;
	}
	public String getPollname() {
		return pollname;
	}
	public void setPollname(String pollname) {
		this.pollname = pollname;
	}
	public int getPollnum() {
		return pollnum;
	}
	public void setPollnum(int pollnum) {
		this.pollnum = pollnum;
	}
	
	
}
