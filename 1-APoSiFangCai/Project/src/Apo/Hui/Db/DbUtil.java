package Apo.Hui.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�����
 * @author С�һ�
 * 2017/07/31 14��25
 */

public class DbUtil {
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String USER = "scott";
	private static String PASSWORD = "tiger";

	
	//�������ݿ⺯��
	public static Connection getconn(){
		Connection conn=null;
		
		try {
			//1.��������
			Class.forName(DRIVER);
			
			//2.ͨ��������������ȡ����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ر����ݿ������
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





































