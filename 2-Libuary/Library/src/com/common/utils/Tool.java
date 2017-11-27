package com.common.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tool {
	
	//计算分多少页
	public int page(int num, int count){
		int pagenum = 0; //共分多少页
		
		//计算共有多少页，不能整除就将页数加一
		if (count % num == 0 ){
			pagenum = count / num;
		}else if (count % num != 0){
			pagenum = count / num + 1;
		}
		
		return pagenum;
	}
	
	//查询表中的总数据
	public int allNum(String tablename){
		int count = 0; //记录表中共有多少条数据
		Connection conn = DbHuilder.getConn();
		//将表中的记录数查出来放在count中
		String sql = " SELECT COUNT(*) count FROM ? ";
		ResultSet rs2 = DbHuilder.executeQuery(conn, sql, tablename);
		try {
			if(rs2.next()){
				count = rs2.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}













