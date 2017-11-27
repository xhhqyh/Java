package com.common.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tool {
	
	//����ֶ���ҳ
	public int page(int num, int count){
		int pagenum = 0; //���ֶ���ҳ
		
		//���㹲�ж���ҳ�����������ͽ�ҳ����һ
		if (count % num == 0 ){
			pagenum = count / num;
		}else if (count % num != 0){
			pagenum = count / num + 1;
		}
		
		return pagenum;
	}
	
	//��ѯ���е�������
	public int allNum(String tablename){
		int count = 0; //��¼���й��ж���������
		Connection conn = DbHuilder.getConn();
		//�����еļ�¼�����������count��
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













