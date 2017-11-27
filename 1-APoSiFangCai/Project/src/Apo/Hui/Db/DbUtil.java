package Apo.Hui.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接
 * @author 小灰灰
 * 2017/07/31 14：25
 */

public class DbUtil {
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String USER = "scott";
	private static String PASSWORD = "tiger";

	
	//链接数据库函数
	public static Connection getconn(){
		Connection conn=null;
		
		try {
			//1.加载驱动
			Class.forName(DRIVER);
			
			//2.通过驱动管理器获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库的连接
	public static void closeConn(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}





































