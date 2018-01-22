package com.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHuilder {

		private final static String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
		private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		private final static String USER = "scott";
		private final static String PWD = "tiger";
		
		//�������ݿ�
		public static Connection getConn(){
			Connection conn = null;
			
			try {
				//1����������
				Class.forName(DRIVER);
				
				//2��ͨ��������������ȡ����
				conn = DriverManager.getConnection(URL, USER, PWD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//���ò���ֵ
		public static void setParam(PreparedStatement ps, Object...values){
			//�ж�sql������Ƿ񺬲�
			if(values != null && values.length>0){
				//ѭ�����ò���ֵ
				for(int i=0; i<values.length; i++){
					try {
						//���ò���ֵ
						ps.setObject(i+1, values[i]);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//ִ������ɾ����
		public static int executeUpdate(Connection conn, String sql, Object...values){
			int count = 0;
			PreparedStatement ps = null;
			
			try {
				//��дsql���
		        ps = conn.prepareStatement(sql);
				
				//���ò���ֵ
				setParam(ps, values);
				
				//ִ��sql���
				count = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return count;
		}
		
		//ִ�в�ѯ���
		public static ResultSet executeQuery(Connection conn, String sql, Object...values){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			try {
				//��дsql���
				ps = conn.prepareStatement(sql);
				
				//���ò���ֵ
				setParam(ps, values);
				
				//ִ��sql���
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		//�ͷ�����
		public static void colseConn(Connection conn){
			
				try {
					if(conn != null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
	
}
