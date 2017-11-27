package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Admin;
import com.common.utils.DbHuilder;

/**
 * 管理员模型层
 * @author: 祁燕辉
 *
 * 2017年10月30日
 */
public class AdminModel {
	/**
	 * 查询管理员数据
	 * @return
	 */
	public List<Admin> queryAdminInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from manager order by manid";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//定义一个Admin类型的集合
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
	 * 添加新管理员
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
	 * 删除指定管理员
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
		//定义一个Admin类型的集合
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
	 * 修改指定的会员
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
	 * 后台检测管理员登录
	 * @param admin
	 * @return 返回当前登录的管理员的类型
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

























