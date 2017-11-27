package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Car;
import com.common.utils.DbHuilder;

/**
 * 购物车模型
 * @author: 祁燕辉
 *
 * 2017年10月28日
 */
public class CarModel {
	
	/**
	 * 添加购物车
	 * @param book
	 * @return i>0成功
	 */
	public int addCar(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into buycarinfo values(my_buycarinfo.nextval,?, ?, ?, ?, 1)";
		int i = DbHuilder.executeUpdate(conn, sql, car.getUserid(), car.getBookid(), car.getBookname(), car.getPrice());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//查询购物车
	public List<Car> queryCarInfo(String username){
		Connection conn = DbHuilder.getConn();
		String sql = "select a.*, rownum from (select * from buycarinfo  where userid = (select userid from userinfo where username = ?)) a where rownum between 1 and 7";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		//定义一个Car类型的集合
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
	
	//查询一本图书是否购买过
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
	
	//执行数量加一操作 
	public int addOneNumCar(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "update buycarinfo set num=num+1 where bookname = ? and userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, car.getBookname(), car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	
	//执行数量减一操作 
	public int deleteOneNum(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "update buycarinfo set num=num-1 where bookname = ? and userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, car.getBookname(), car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	//如果书的数量是1,用户在执行减一操作,则删除
	public int deleteOneBook(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from buycarinfo where userid = ? and bookname = ?";
		int i = DbHuilder.executeUpdate(conn, sql,car.getUserid() , car.getBookname());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//删除当前登录用户下的所有购物车数据
	public int deleteUserCarInfo(Car car){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from buycarinfo where userid = ? ";
		int i = DbHuilder.executeUpdate(conn, sql,car.getUserid());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//查询某用户的所有购物车信息
	public List<Car> queryOneUserCarInfo(String username){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from buycarinfo where userid = (select userid from userinfo where username = ?)";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, username);
		//定义一个Car类型的集合
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

















