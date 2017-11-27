package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.User;
import com.common.utils.DbHuilder;

/**
 * �û�ģ�Ͳ� ,���ݴ���
 * @author: �����
 *
 * 2017��10��26��
 */
public class UserModel {
	
	/**
	 * ��ѯ�û���Ϣ
	 * @return ����һ��User���͵ļ���
	 */
	public List<User> queryUserInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from userinfo uo, userrank uk where uo.rankid = uk.rankid";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��User���͵ļ���
		List<User> userList = new ArrayList<User>();
		
		try {
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setTruename(rs.getString("truename"));
				user.setPassword(rs.getString("password"));
				user.setCity(rs.getString("city"));
				user.setSex(rs.getString("sex"));
				user.setPicture(rs.getString("picture"));
				user.setPostcode(rs.getString("postcode"));
				user.setRankid(rs.getInt("rankid"));
				user.setAmount(rs.getInt("amount"));
				user.setPhone(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setFreeze(rs.getInt("freeze"));
				user.setRankname(rs.getString("rankname"));
				
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return userList;
	}
	
	/**
	 * �޸��û�װ̬
	 * @param user
	 * @return i>0 �ɹ�
	 */
	public int editUserFreeze(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "update userinfo set freeze = ? where userid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, user.getFreeze(), user.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int addUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into userinfo values(my_userinfo.nextval, ?, ?��?, ?, ?, ?, ?, (select rankid from userrank where rankname = '��ͨ��Ա'), 0, ?, ?, 0)";
		int i = DbHuilder.executeUpdate(conn, sql, user.getUsername(), user.getTruename(), user.getPassword(), user.getCity(), user.getSex(), user.getPicture(), user.getPostcode(), user.getPhone(), user.getEmail());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ǰ̨����û���¼
	 * @param user
	 * @return
	 */
	public String checkUser(User user){
		String str = "";
		Connection conn = DbHuilder.getConn();
		String sql = "select picture from userinfo where username = ? and password = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, user.getUsername(), user.getPassword());
		
		try {
			while(rs.next()){
				str = rs.getString("picture");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return str;
	}
	
	/**
	 * ��ѯһ���û�����Ϣ
	 * @param user
	 * @return ����һ��User���͵ļ���
	 */
	public List<User> queryOneUserInfo(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from userinfo uo, userrank uk where uo.rankid = uk.rankid and username = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, user.getUsername());
		//����һ��User���͵ļ���
		List<User> userList = new ArrayList<User>();
		
		try {
			while(rs.next()){
				User user2 = new User();
				user2.setUserid(rs.getInt("userid"));
				user2.setUsername(rs.getString("username"));
				user2.setTruename(rs.getString("truename"));
				user2.setPassword(rs.getString("password"));
				user2.setCity(rs.getString("city"));
				user2.setSex(rs.getString("sex"));
				user2.setPicture(rs.getString("picture"));
				user2.setPostcode(rs.getString("postcode"));
				user2.setRankid(rs.getInt("rankid"));
				user2.setAmount(rs.getInt("amount"));
				user2.setPhone(rs.getString("tel"));
				user2.setEmail(rs.getString("email"));
				user2.setFreeze(rs.getInt("freeze"));
				user2.setRankname(rs.getString("rankname"));
				
				userList.add(user2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return userList;
	}
	
	
	/**
	 * �޸��û�������Ϣ
	 * @param user
	 * @return
	 */
	public int editUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "update userinfo set username=?, truename=?, city=?, sex=?, postcode=?, tel=?, email=? where userid = ?";	
		int i = DbHuilder.executeUpdate(conn, sql, user.getUsername(), user.getTruename(), user.getCity(), user.getSex(), user.getPostcode(), user.getPhone(), user.getEmail(), user.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * �����û�����ѯ�û�userid
	 * @param username
	 * @return
	 */
	public int queryUserId(String username){
		int userid = 0;
		Connection conn = DbHuilder.getConn();
		String sql = "select userid from userinfo where username = ? ";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		
		try {
			while(rs.next()){
				userid = rs.getInt("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return userid;
	}
	
	/**
	 * �����û�����ѯ�û�״̬
	 * @param username
	 * @return
	 */
	public int queryUserFreeze(String username){
		int freeze = 0;
		Connection conn = DbHuilder.getConn();
		String sql = "select freeze from userinfo where username = ? ";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		
		try {
			while(rs.next()){
				freeze = rs.getInt("freeze");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return freeze;
	}
	
}


































