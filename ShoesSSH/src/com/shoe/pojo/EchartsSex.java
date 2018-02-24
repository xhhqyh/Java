package com.shoe.pojo;

public class EchartsSex {

	private String goodsDate;
	private Integer goodsStyle;
	private String typeName;
	private long goodsSnumber;

	public EchartsSex() {
		super();

	}
    /**
     * ��ѯX���·�
     * @param goodsDate
     * @param goodsSnumber
     */
	public EchartsSex(String goodsDate, long goodsSnumber) {
		super();
		this.goodsDate = goodsDate;
		this.goodsSnumber = goodsSnumber;
	}
    /**
     * ��ѯ��ŮЬ����
     * @param goodsDate
     * @param typeName
     * @param goodsSnumber
     */
	public EchartsSex(String goodsDate, String typeName, long goodsSnumber) {
		super();
		this.goodsDate = goodsDate;
		this.typeName = typeName;
		this.goodsSnumber = goodsSnumber;
	}
    /**
     * ��ѯ��Ӧ�·�Ь���������
     * @param goodsDate
     * @param goodsStyle
     * @param goodsSnumber
     */
	public EchartsSex(String goodsDate, Integer goodsStyle, long goodsSnumber) {
		super();
		this.goodsDate = goodsDate;
		this.goodsStyle = goodsStyle;
		this.goodsSnumber = goodsSnumber;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getGoodsDate() {
		return goodsDate;
	}

	public void setGoodsDate(String goodsDate) {
		this.goodsDate = goodsDate;
	}

	public Integer getGoodsStyle() {
		return goodsStyle;
	}

	public void setGoodsStyle(Integer goodsStyle) {
		this.goodsStyle = goodsStyle;
	}

	public long getGoodsSnumber() {
		return goodsSnumber;
	}

	public void setGoodsSnumber(long goodsSnumber) {
		this.goodsSnumber = goodsSnumber;
	}
	@Override
	public String toString() {
		return "EchartsSex [goodsDate=" + goodsDate + ", goodsStyle=" + goodsStyle + ", typeName=" + typeName
				+ ", goodsSnumber=" + goodsSnumber + "]";
	}

	

}
