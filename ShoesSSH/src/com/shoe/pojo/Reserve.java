package com.shoe.pojo;

/**
 * ������(t_reserve)
 * 
 * @author ����
 *
 * @param reserveId
 *            Integer �������,������ʶ��
 * @param goods
 *            Goods ��Ʒ��Ϣ
 *            @see Goods ��Ʒ
 * @param user
 *            User �û���Ϣ 
 *            @see User �ͻ�
 * @param recive
 *            Recive �ջ���Ϣ
 *            @see Recive �ջ���ַ
 * @param reserveTime
 *            String �µ�ʱ��,(Ĭ��sysdate)
 * @param reserveStatus
 *            Integer ״̬(0:������,1:��ǩ��,2:���׳ɹ�,3:�����˻�,4:�˻��ɹ�)
 * @param reserveNum
 *            Integer ������Ʒ����
 * @param reserveType
 *            Integer ������Ʒ��ʾ(0:����,1:��) )
 */
public class Reserve {
	private Integer reserveId;
	private Goods goods;
	private User user;
	private Recive recive;
	private String reserveTime;
	private Integer reserveStatus;
	private Integer reserveNum;
	private Integer reserveType;
	private String reserveNo;
	
	public Integer getReserveId() {
		return reserveId;
	}
	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Recive getRecive() {
		return recive;
	}
	public void setRecive(Recive recive) {
		this.recive = recive;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public Integer getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(Integer reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public Integer getReserveNum() {
		return reserveNum;
	}
	public void setReserveNum(Integer reserveNum) {
		this.reserveNum = reserveNum;
	}
	public Integer getReserveType() {
		return reserveType;
	}
	public void setReserveType(Integer reserveType) {
		this.reserveType = reserveType;
	}
	public String getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	@Override
	public String toString() {
		return "Reserve [reserveId=" + reserveId + ", reserveTime=" + reserveTime + ", reserveStatus=" + reserveStatus
				+ ", reserveNum=" + reserveNum + ", reserveType=" + reserveType + ", reserveNo=" + reserveNo + "]";
	}
	

}