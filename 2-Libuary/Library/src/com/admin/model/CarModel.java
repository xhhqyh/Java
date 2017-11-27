package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Car;
import com.common.utils.DbHuilder;

/**
 * ���ﳵģ��
 * @author: �����
 *
 * 2017��10��28��
 */
public class CarModel {
	
	/**
	 * ��ӹ��ﳵ
	 * @param book
	 * @return i>0�ɹ�
	 */
	public int addCar(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into buycarinfo values(my_buycarinfo.nextval,?, ?, ?, ?, 1)";
		int i = DbHuilder.executeUpdate(conn, sql, car.getUserid(), car.getBookid(), car.getBookname(), car.getPrice());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//��ѯ���ﳵ
	public List<Car> queryCarInfo(String username){
		Connection conn = DbHuilder.getConn();
		String sql = "select a.*, rownum from (select * from buycarinfo  where userid = (select userid from userinfo where username = ?)) a where rownum between 1 and 7";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		//����һ��Car���͵ļ���
		List<Car> carList = new ArrayList<Car>();
		
		try {
			while(rs.next()){
				Car car = new Car();
				car.setPrice(rs.getInt("price"));
				car.setBookname(rs.getString("bookname"));
				car.setNum(rs.getInt("num"));
				
				carList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return carList;
	}
	
	//��ѯһ��ͼ���Ƿ����
	public Car queryOneCar(Car car){
		
		Connection conn = DbHuilder.getConn();
		String sql = "select * from buycarinfo where bookname = ? and userid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, car.getBookname(), car.getUserid());
		Car car2 = new Car();
		try {
			while(rs.next()){
				car2.setNum(rs.getInt("num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}

		return car2;
	}
	
	//ִ��������һ���� 
	public int addOneNumCar(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "update buycarinfo set num=num+1 where bookname = ? and userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, car.getBookname(), car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	
	//ִ��������һ���� 
	public int deleteOneNum(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "update buycarinfo set num=num-1 where bookname = ? and userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, car.getBookname(), car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	//������������1,�û���ִ�м�һ����,��ɾ��
	public int deleteOneBook(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from buycarinfo where userid = ? and bookname = ?";
		int i = DbHuilder.executeUpdate(conn, sql,car.getUserid() , car.getBookname());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//ɾ����ǰ��¼�û��µ����й��ﳵ����
	public int deleteUserCarInfo(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from buycarinfo where userid = ? ";
		int i = DbHuilder.executeUpdate(conn, sql,car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//��ѯĳ�û������й��ﳵ��Ϣ
	public List<Car> queryOneUserCarInfo(String username){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from buycarinfo where userid = (select userid from userinfo where username = ?)";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		//����һ��Car���͵ļ���
		List<Car> carList = new ArrayList<Car>();
		
		try {
			while(rs.next()){
				Car car = new Car();
				car.setPrice(rs.getInt("price"));
				car.setBookname(rs.getString("bookname"));
				car.setNum(rs.getInt("num"));
				car.setBookid(rs.getInt("bookid"));
				car.setUserid(rs.getInt("userid"));
				
				carList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return carList;
	}
	
}

















