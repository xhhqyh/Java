package Apo.Hui.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 小灰灰
 * @version 2017年7月31日下午2:32:04
 * 类说明:
 *		1)帮助类，处理JDBC的公共操作
*/

public class DbHelper {
	
	//设置SQL语句中参数的值
	public static void setParam(PreparedStatement ps, Object...values){
		//判断SQL语句中是否含参
		if(values!=null && values.length>0){
			//循环设置参数的值
			for(int i=0; i<values.length; i++){
				try {
					ps.setObject(i+1, values[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//执行增、删、改
	public static int executeUpdate(Connection conn, String sql, Object...values){
		int count=0;
		
		try {
			//编写sql语句
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数的值
			setParam(ps,values);
			//执行SQL语句
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	//执行查询
	public static ResultSet executeQuery(Connection conn, String sql, Object...values){
		ResultSet rs = null;
		
		try {
			//编写ＳＱＬ语句
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数的值
			setParam(ps, values);
			//执行SQL语句
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}







































