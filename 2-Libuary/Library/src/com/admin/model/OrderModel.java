package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Order;
import com.common.utils.DbHuilder;

/**
 * ��������ģ�Ͳ�
 * @author: �����
 *
 * 2017��10��29��
 */
public class OrderModel {
	
	/**
	 * ��Ӷ�����Ϣ
	 * @param order
	 * @return ���ظ���ӵĶ���orderid
	 */
	public int addOrderUserInfo(Order order){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into orderinfo values(my_orderinfo.nextval,?, ?, ?, ?, ?, ?, sysdate, 0)";
		int i = DbHuilder.executeUpdate(conn, sql, order.getUsername(), order.getTruename(), order.getAddress(), order.getPostcode(), order.getPhone(), order.getEmail());
		if(i>0){
			sql = "select max(orderid) a from orderinfo";
			ResultSet rs2 = DbHuilder.executeQuery(conn, sql);
			try {
				while(rs2.next()){
					i = rs2.getInt("a");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ��ӵ�������ϸ����
	 * @param order
	 * @return
	 */
	public int addOrderDetial(Order order){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into orderDetail values(my_orderDetail.nextval,?, ?, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, order.getOrderid(), order.getBookid(), order.getPrice(), order.getNumber());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//��ѯ���е�������
	public int allNum(String username){
		int count = 0; //��¼���й��ж���������
		Connection conn = DbHuilder.getConn();
		//�����еļ�¼�����������count��
		String sql = " SELECT COUNT(*) count FROM orderinfo where username = ?";
		ResultSet rs2 = DbHuilder.executeQuery(conn, sql, username);
		try {
			if(rs2.next()){
				count = rs2.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	/**
	 * ��ѯһ���û��Ķ�����Ϣ
	 * @param min
	 * @param max
	 * @param username
	 * @return
	 */
	public List<Order> queryOneUserOrderInfo(int min, int max, String username){
		Connection conn = DbHuilder.getConn();

		String sql = "select * from  (select o.*,rownum rn from orderinfo o where username = ?) a,"
				+ " (select orderid, sum(price*num) col from orderDetail group by orderid) b "
				+ "where a.orderid = b.orderid and a.rn between ? and ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username, min, max);
		//����һ��Book���͵ļ���
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			while(rs.next()){
				Order order = new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setUsername(rs.getString("username"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setOrderdate(rs.getString("orderdate"));
				order.setEnfore(rs.getInt("enfore"));
				order.setMoney(rs.getInt("col"));
				
				orderList.add(order);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return orderList;
	}
	
	
	/**
	 * ���а��ѯ
	 * @return
	 */
	public List<Order> queryBooidMax(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from (select a.*, rownum rn from (select bookid, sum(num) col from orderDetail group by bookid order by col desc ) a) b where b.rn between 1 and 7";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��Book���͵ļ���
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			while(rs.next()){
				Order order = new Order();
				order.setBookid(rs.getInt("bookid"));
				order.setNumber(rs.getInt("col"));
				orderList.add(order);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return orderList;
	}
	
	/**
	 * ��ѯ�ܶ�����Ϣ
	 * @param min
	 * @param max
	 * @param username
	 * @return
	 */
	public List<Order> queryUserOrderInfo(int min, int max){
		Connection conn = DbHuilder.getConn();

		String sql = "select * from  (select o.*,rownum rn from orderinfo o) a,"
				+ " (select orderid, sum(price*num) col from orderDetail group by orderid) b "
				+ "where a.orderid = b.orderid and a.rn between ? and ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, min, max);
		//����һ��Book���͵ļ���
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			while(rs.next()){
				Order order = new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setUsername(rs.getString("username"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setOrderdate(rs.getString("orderdate"));
				order.setEnfore(rs.getInt("enfore"));
				order.setMoney(rs.getInt("col"));
				
				orderList.add(order);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return orderList;
	}
	
	//��ѯ���е�������
	public int allOrderNum(){
		int count = 0; //��¼���й��ж���������
		Connection conn = DbHuilder.getConn();
		//�����еļ�¼�����������count��
		String sql = " SELECT COUNT(*) count FROM orderinfo";
		ResultSet rs2 = DbHuilder.executeQuery(conn, sql);
		try {
			if(rs2.next()){
				count = rs2.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	/**
	 * �޸Ķ���״̬
	 * @param user
	 * @return
	 */
	public int editOrderFreeze(int orderid2){
		Connection conn = DbHuilder.getConn();
		String sql = "update orderinfo set enfore=1 where orderid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, orderid2);
		DbHuilder.colseConn(conn);
		return i;
	}
}
























