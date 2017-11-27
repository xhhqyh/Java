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
		
		//连接数据库
		public static Connection getConn(){
			Connection conn = null;
			
			try {
				//1、加载驱动
				Class.forName(DRIVER);
				
				//2、通过驱动管理器获取连接
				conn = DriverManager.getConnection(URL, USER, PWD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//设置参数值
		public static void setParam(PreparedStatement ps, Object...values){
			//判断sql语句中是否含参
			if(values != null && values.length>0){
				//循环设置参数值
				for(int i=0; i<values.length; i++){
					try {
						//设置参数值
						ps.setObject(i+1, values[i]);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//执行增、删、改
		public static int executeUpdate(Connection conn, String sql, Object...values){
			int count = 0;
			PreparedStatement ps = null;
			
			try {
				//编写sql语句
		        ps = conn.prepareStatement(sql);
				
				//设置参数值
				setParam(ps, values);
				
				//执行sql语句
				count = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return count;
		}
		
		//执行查询语句
		public static ResultSet executeQuery(Connection conn, String sql, Object...values){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			try {
				//编写sql语句
				ps = conn.prepareStatement(sql);
				
				//设置参数值
				setParam(ps, values);
				
				//执行sql语句
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		//释放连接
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
