package com.common.entiy;

/**
 * @author Administrator
 * 封装图书类别字段
 */
public class BookClassify {
	private int typeid = 0 ;
	private String typename = "" ;
	
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
}
