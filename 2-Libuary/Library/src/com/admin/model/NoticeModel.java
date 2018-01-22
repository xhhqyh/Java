package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Notice;
import com.common.utils.DbHuilder;

/**
 * �����ģ�Ͳ㣬���ݴ���
 * @author: �����
 *
 * 2017��10��26��
 */
public class NoticeModel {

	/**
	 * ��ӹ���
	 * @param notice
	 * @return i>0�ɹ�
	 */
	public int addNotice(Notice notice){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into bbs(bbsid, bbshead, bbstext) values(my_bbs.nextval, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, notice.getBbshead(), notice.getBbstext() );
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ��ѯ����
	 * @return һ��Notice���͵ļ���
	 */
	public List<Notice> queryNoticeInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from bbs";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��Notice���͵ļ���
		List<Notice> noticeList = new ArrayList<Notice>();
		
		try {
			while(rs.next()){
				Notice notice = new Notice();
				notice.setBbsid(rs.getInt("bbsid"));
				notice.setBbshead(rs.getString("bbshead"));
				notice.setBbstext(rs.getString("bbstext"));
				String str = rs.getString("intime");
				String [] arr = str.split("\\s+");
				notice.setIntime(arr[0]);
				
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return noticeList;
	}
	
	/**
	 * ɾ��ָ���Ĺ���
	 * @param notice
	 * @return
	 */
	public int deleteNotice(Notice notice){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from bbs where bbsid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, notice.getBbsid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	/**
	 * ��ѯҪ�޸ĵ�һ���������Ϣ
	 * @param notice
	 * @return ����һ��Notice���͵ļ���
	 */
	public List<Notice> checkOneNoticeModel(Notice notice){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from bbs where bbsid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, notice.getBbsid());
		//����һ��Notice���͵ļ���
		List<Notice> noticeList = new ArrayList<Notice>();
		
		try {
			while(rs.next()){
				Notice notice2 = new Notice();
				notice2.setBbsid(rs.getInt("bbsid"));
				notice2.setBbshead(rs.getString("bbshead"));
				notice2.setBbstext(rs.getString("bbstext"));
				String str = rs.getString("intime");
				String [] arr = str.split("\\s+");
				notice2.setIntime(arr[0]);
				
				noticeList.add(notice2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return noticeList;
	}
	
	
	public int editNotice(Notice notice){
		Connection conn = DbHuilder.getConn();
		String sql = "update bbs set bbshead=?, bbstext=?, intime=sysdate where bbsid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, notice.getBbshead(), notice.getBbstext(), notice.getBbsid());
		DbHuilder.colseConn(conn);
		return i;
	}
}


























