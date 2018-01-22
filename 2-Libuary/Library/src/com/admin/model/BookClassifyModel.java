package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.BookClassify;
import com.common.utils.DbHuilder;

/**
 * ͼ�����ģ�ͣ����ݴ���
 * 
 * @author: �����
 *
 * 2017��10��25��
 */
public class BookClassifyModel {
	
	/**
	 * ���ͼ������
	 * @param bkcl 
	 * @return i>0�ɹ�
	 */
	public int addBookClassify(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into booktype values(my_booktype.nextval, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, bkcl.getTypename());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ��ѯͼ�����
	 * @return һ������
	 */
	public List<BookClassify> queryBookClassifyInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from booktype";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��BookClassify���͵ļ���
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
	 * ɾ��ָ����ͼ������
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
	 * �޸�ͼ�����ʱ������Ҫ�޸ĵ�id��ѯ��ǰ��������
	 * @param bkcl
	 * @return ����BookClassify���͵ļ���
	 */
	public List<BookClassify> checkOneBookClassifyModel(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from booktype where typeid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, bkcl.getTypeid());
		//����һ��BookClassify���͵ļ���
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
	 * �޸�ͼ��
	 * @param bkcl
	 * @return i>0�ɹ�
	 */
	public int editBookClassify(BookClassify bkcl){
		Connection conn = DbHuilder.getConn();
		String sql = "update booktype set typename = ? where typeid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, bkcl.getTypename(), bkcl.getTypeid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
}


























