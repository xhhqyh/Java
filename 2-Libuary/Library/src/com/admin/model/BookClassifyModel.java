package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.BookClassify;
import com.common.utils.DbHuilder;

/**
 * 图书类别模型，数据处理
 * 
 * @author: 祁燕辉
 *
 * 2017年10月25日
 */
public class BookClassifyModel {
	
	/**
	 * 添加图书类型
	 * @param bkcl 
	 * @return i>0成功
	 */
	public int addBookClassify(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into booktype values(my_booktype.nextval, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, bkcl.getTypename());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * 查询图书类别
	 * @return 一个集合
	 */
	public List<BookClassify> queryBookClassifyInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from booktype";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//定义一个BookClassify类型的集合
		List<BookClassify> bkclList = new ArrayList<BookClassify>();
		
		try {
			while(rs.next()){
				BookClassify bkcl = new BookClassify();
				bkcl.setTypeid(rs.getInt("typeid"));
				bkcl.setTypename(rs.getString("typename"));
				
				bkclList.add(bkcl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return bkclList;
	}
	
	/**
	 * 删除指定的图书类型
	 * @param bkcl
	 * @return
	 */
	public int deleteBookClassifyModel(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from booktype where typeid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, bkcl.getTypeid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * 修改图书类别时，根据要修改的id查询当前类别的数据
	 * @param bkcl
	 * @return 返回BookClassify类型的集合
	 */
	public List<BookClassify> checkOneBookClassifyModel(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from booktype where typeid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, bkcl.getTypeid());
		//定义一个BookClassify类型的集合
		List<BookClassify> bkclList = new ArrayList<BookClassify>();
		
		try {
			while(rs.next()){
				BookClassify bkcs = new BookClassify();
				bkcs.setTypeid(rs.getInt("typeid"));
				bkcs.setTypename(rs.getString("typename"));
				
				bkclList.add(bkcs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return bkclList;
	}
	
	/**
	 * 修改图书
	 * @param bkcl
	 * @return i>0成功
	 */
	public int editBookClassify(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "update booktype set typename = ? where typeid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, bkcl.getTypename(), bkcl.getTypeid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
}


























