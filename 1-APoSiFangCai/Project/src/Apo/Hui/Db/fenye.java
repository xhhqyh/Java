package Apo.Hui.Db;

import java.sql.Connection;
import Apo.Hui.Db.DbHelper;
import Apo.Hui.Db.DbUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fenye {
	
	public static int fenye(String tableName, int num){
		Connection conn = DbUtil.getconn();
		String sql = "select count(*) total from "+tableName;
		ResultSet rs = DbHelper.executeQuery(conn, sql);
		try{
			rs.next();
		}catch (SQLException el) {
			el.printStackTrace();
		}
		int ws=0;
		try{
			ws = rs.getInt("total");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		int i = ws%num;
		if(i>0){
			return(ws/num + 1);
		}else{
			return(ws/num);
		}
	}

}
