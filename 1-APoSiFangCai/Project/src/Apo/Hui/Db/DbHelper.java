package Apo.Hui.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author С�һ�
 * @version 2017��7��31������2:32:04
 * ��˵��:
 *		1)�����࣬����JDBC�Ĺ�������
*/

public class DbHelper {
	
	//����SQL����в�����ֵ
	public static void setParam(PreparedStatement ps, Object...values){
		//�ж�SQL������Ƿ񺬲�
		if(values!=null && values.length>0){
			//ѭ�����ò�����ֵ
			for(int i=0; i<values.length; i++){
				try {
					ps.setObject(i+1, values[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//ִ������ɾ����
	public static int executeUpdate(Connection conn, String sql, Object...values){
		int count=0;
		
		try {
			//��дsql���
			PreparedStatement ps = conn.prepareStatement(sql);
			//���ò�����ֵ
			setParam(ps,values);
			//ִ��SQL���
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	//ִ�в�ѯ
	public static ResultSet executeQuery(Connection conn, String sql, Object...values){
		ResultSet rs = null;
		
		try {
			//��д�ӣѣ����
			PreparedStatement ps = conn.prepareStatement(sql);
			//���ò�����ֵ
			setParam(ps, values);
			//ִ��SQL���
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}







































