package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Admin;
import com.common.utils.DbHuilder;

/**
 * ����Աģ�Ͳ�
 * @author: �����
 *
 * 2017��10��30��
 */
public class AdminModel {
	/**
	 * ��ѯ����Ա����
	 * @return
	 */
	public List<Admin> queryAdminInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from manager order by manid";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��Admin���͵ļ���
		List<Admin> adminList = new ArrayList<Admin>();
		
		try {
			while(rs.next()){
				Admin admin = new Admin();
				admin.setManid(rs.getInt("manid"));
				admin.setManname(rs.getString("manname"));
				admin.setManpwd(rs.getString("manpwd"));
				admin.setMantype(rs.getString("mantype"));
				
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return adminList;
	}
	
	/**
	 * ����¹���Ա
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin admin){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into manager values(my_manager.nextval, ?, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, admin.getManname(), admin.getManpwd(), admin.getMantype());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	/**
	 * ɾ��ָ������Ա
	 * @param notice
	 * @return
	 */
	public int deleteAdmin(Admin admin){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from manager where manid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, admin.getManid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	public List<Admin> queryOneAdmin(Admin admin2){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from manager where manid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, admin2.getManid());
		//����һ��Admin���͵ļ���
		List<Admin> adminList = new ArrayList<Admin>();
		
		try {
			while(rs.next()){
				Admin admin = new Admin();
				admin.setManid(rs.getInt("manid"));
				admin.setManname(rs.getString("manname"));
				admin.setManpwd(rs.getString("manpwd"));
				admin.setMantype(rs.getString("mantype"));
				
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return adminList;
	}
	
	/**
	 * �޸�ָ���Ļ�Ա
	 * @param admin
	 * @return
	 */
	public int editAdmin(Admin admin){
		Connection conn = DbHuilder.getConn();
		String sql = "update manager set manname=?, manpwd=?, mantype=? where manid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, admin.getManname(), admin.getManpwd(), admin.getMantype(), admin.getManid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	/**
	 * ��̨������Ա��¼
	 * @param admin
	 * @return ���ص�ǰ��¼�Ĺ���Ա������
	 */
	public String checkAdminLogin(Admin admin){
		String str = "";
		Connection conn = DbHuilder.getConn();
		String sql = "select mantype from manager where manname = ? and manpwd = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, admin.getManname(), admin.getManpwd());
		
		try {
			while(rs.next()){
				str = rs.getString("mantype");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return str;
	}
	
}

























