package Apo.Home.DataModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Apo.Admin.DataModel.Menu_Data;
import Apo.Hui.Db.DbHelper;
import Apo.Hui.Db.DbUtil;

/**
 * @author 小灰灰
 * @version 2017年8月1日上午9:14:42
 * 类说明:
 *		1)注册方法
*/

public class ApoHome {
	public static String sql=""; 
	
	//注册会员方法
	public static int add(String name,String pass, String trueName, String sex, String Birthday, String Address, String Tel, String Email) throws SQLException{
		Connection conn = DbUtil.getconn();

		sql = "insert into Member_Info values(sequence1.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		//编写SQL语句, 注意日期格式要进行转化
		int i = DbHelper.executeUpdate(conn, sql, name, pass, trueName, sex, Date.valueOf(Birthday), Address, Tel, Email);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//查询单一会员名
	public static int check(String username) throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select * from Member_Info where Mem_Name = '" + username + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		  
	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()){
	    	return 1;
	    }else{
	    	return 0;
	    }
	
	}
	
	//检测前台登录
	public static int Check_login(String User, String pass) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "select * from Member_Info where Mem_Name = '" + User + "' and Mem_Psw = '" + pass + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		  
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
			return 1;
		}else{
			return 0;
		}
	}
	
	//调用主页面的菜品信息
	public static ArrayList<Menu_Data> select(int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		//sql = "select * from (select m.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) m ) t where t.rn>?*6 and t.rn<=(?+1)*6";
	    sql = "select * from (select t.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) t order by t.Menu_Id) m where m.rn between ? and ?";
		ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);
	    
		//定义Menu_Data类型的集合
		ArrayList<Menu_Data> dishList = new<Menu_Data> ArrayList();
		while(rs.next()){
			Menu_Data rowDish = new Menu_Data();
			 rowDish.setMenu_Id(rs.getInt("Menu_Id"));
			 rowDish.setMenu_Name(rs.getString("Menu_Name"));
			 rowDish.setMenu_Rmaterial(rs.getString("Menu_Rmaterial"));
			 rowDish.setMenu_marketPrice(rs.getString("menu_marketPrice"));
			 rowDish.setMenu_memberPrice(rs.getString("menu_memberPrice"));
			 rowDish.setGr_Sort(rs.getString("gr_Sort"));
			 rowDish.setMenu_upPhoto(rs.getString("menu_upPhoto"));
			 rowDish.setMenu_fState(rs.getString("menu_fState"));
			 
			 dishList.add(rowDish);
		 	}
		 
			DbUtil.closeConn(conn);
		
	    return dishList; 
	}
	
	/*
	 * 前台加入餐车板块
	 * 
	 * */
	
	public static int Add_Car( String name, String Menu_Name,String Menu_memberPrice ) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
		
		//根据传过来的用户名，查询电话、地址
		sql = "select Mem_Tel,Mem_Address from Member_Info where Mem_Name = ?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name);
		
		String tel = "";
		String Address = "";
		
		while(rs.next()){
			tel = rs.getString("Mem_Tel");
			Address = rs.getString("Mem_Address");
		}
		
		if(tel == "" && Address == ""){
			return 2;
		}
		
		System.out.println(tel+name+Address+Menu_Name+Menu_memberPrice);
		//把数据插入到餐车表中
		String sql1 = "insert into Order_Car(Car_Id, Car_Mem_Name, Car_Mem_Tel, Car_Address, Car_Dish_Name, Car_Order_Num, Car_Order_Price, Car_Confirm) values(sequence_Car.Nextval, ?, ?, ?, ?, '1', ?, '0') ";
		
		int i = DbHelper.executeUpdate(conn, sql1, name, tel, Address, Menu_Name, Menu_memberPrice);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	//购物车查询
	public static ResultSet Select_Car(String name) throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select Car_Dish_Name, Car_Order_Price,count(Car_Dish_Name) num from (select * from Order_Car where Car_Mem_Name = ?) group by Car_Dish_Name, Car_Order_Price";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name);
	    
	    return rs;
	
	}
	
	//餐车中添加一道菜
	public static int Car_Add_One( String name, String Menu_Name) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
		
		//根据传过来的用户名，查询电话、地址
		sql = "select * from Order_Car where Car_Mem_Name = ? and Car_Dish_Name = ?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name, Menu_Name);
		
		String Car_Mem_Tel = "";
		String Car_Address = "";
		String Car_Order_Price = "";
		
		while(rs.next()){
			Car_Mem_Tel = rs.getString("Car_Mem_Tel");
			Car_Address = rs.getString("Car_Address");
			Car_Order_Price = rs.getString("Car_Order_Price");
		}
		
		/*System.out.println(tel+name+Address+Menu_Name+Menu_memberPrice);*/
		//把数据插入到餐车表中
		String sql1 = "insert into Order_Car(Car_Id, Car_Mem_Name, Car_Mem_Tel, Car_Address, Car_Dish_Name, Car_Order_Num, Car_Order_Price, Car_Confirm) values(sequence_Car.Nextval, ?, ?, ?, ?, '1', ?, '0') ";
		
		int i = DbHelper.executeUpdate(conn, sql1, name, Car_Mem_Tel, Car_Address, Menu_Name, Car_Order_Price);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	//餐车中删除一道菜
	public static int Car_Del_One( String name, String Menu_Name) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
		
		//根据传过来的用户名，查询电话、地址
		sql = "select min(Car_Id) Car_Id from Order_Car where Car_Mem_Name=? and Car_Dish_Name=?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name, Menu_Name);
		
		String Car_Id = "";
		
		while(rs.next()){
			Car_Id = rs.getString("Car_Id");
		}
		
		if(Car_Id == ""){
			return 2;
		}
		//把数据插入到餐车表中
		String sql1 = "delete from Order_Car where Car_Id=?";
		
		int i = DbHelper.executeUpdate(conn, sql1, Car_Id);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//餐车中删除当前用户所有菜
	public static int Car_Del_All( String name) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
		
		//清空当前用户的购物车
		String sql1 = "delete from Order_Car where Car_Mem_Name=?";
		
		int i = DbHelper.executeUpdate(conn, sql1, name);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}

	//购物车提交订单
	public static int Car_Pay_All( String name) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
		
		//根据传过来的用户名，查询电话、地址
		sql = "select * from Order_Car where Car_Mem_Name = ?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name);
		
		String Car_Id = "";
		String Car_Mem_Tel = "";
		String Car_Address = "";
		String Car_Order_Price = "";
		String Car_Mem_Name = "";
		String Car_Dish_Name = "";
		String Car_Order_Num = "";
		String Car_Time = "";
		int i=0;
		
		while(rs.next()){
			Car_Id = rs.getString("Car_Id");
			Car_Mem_Name = rs.getString("Car_Mem_Name");
			Car_Mem_Tel = rs.getString("Car_Mem_Tel");
			Car_Address = rs.getString("Car_Address");
			Car_Dish_Name = rs.getString("Car_Dish_Name");
			Car_Order_Num = rs.getString("Car_Order_Num");
			Car_Order_Price = rs.getString("Car_Order_Price");
			Car_Time = rs.getString("Car_Time");
			
			String sql1 = "insert into Order_Info(Ord_Id, Ord_Name, Ord_Tel, Ord_Address, Ord_grName, Ord_Num, Ord_Unitprice, Ord_Confirm) values(sequence_Order.Nextval, ?, ?, ?, ?, '1', ?, '已确认') ";
			System.out.println(Car_Id+" "+Car_Mem_Tel+Car_Address+Car_Order_Price+Car_Mem_Name+Car_Dish_Name+Car_Order_Num+Car_Time);
		    i = DbHelper.executeUpdate(conn, sql1, Car_Mem_Name, Car_Mem_Tel, Car_Address, Car_Dish_Name, Car_Order_Price);
		}
		
		if(i>0){
			String sql2 = "delete from Order_Car where Car_Mem_Name = ?";
			int j = DbHelper.executeUpdate(conn, sql2, name);
			if(j > 0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	//前台当前用户的订单显示
	public static ResultSet Select_Order(String name, int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		System.out.println(name+min+max);
		sql = "select * from (select t.*,rownum rn2 from (select m.*,rownum rn from Order_Info m where Ord_Name = ? order by Ord_Time desc) t) n where n.rn2 between ? and ? ";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name, min, max);
	    
	    return rs;
	}
	
	//配送信息查询
	public static ResultSet Select_Send() throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select * from Distribution";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql);
	    
	    return rs;
	}
	
	//首页销售排行榜
	public static ResultSet Select_Sale() throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select Ord_grName,count(Ord_grName) num from Order_Info group by Ord_grName order by num desc";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql);
	    
	    return rs;
	
	}
	
	//前台展示用户信息
	public static ResultSet Select_Mem(String name) throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select * from Member_Info where Mem_Name = ?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, name);
	    
	    return rs;
	
	}

	//当前用户修改
	public static int User_Update(String zhuce_name, String zhuce_pass,String TrueName, String zhuce_sex, String Birthday, String Address, String Tel, String Email) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "update Member_Info set Mem_Name = ?, Mem_Psw = ?, Mem_Trname = ?, Mem_Sex = ?, Mem_Birthday=to_date(?,'yyyy-mm-dd hh24:mi:ss'),Mem_Address=?,Mem_Tel=?,Mem_Email=? where Mem_Name = ?";
		int i = DbHelper.executeUpdate(conn, sql, zhuce_name,zhuce_pass,TrueName,zhuce_sex,Birthday,Address,Tel,Email,zhuce_name);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}	
	
	//查询一条公告
	public static ResultSet Notice_Select_One(String title) throws SQLException{
		Connection conn = DbUtil.getconn();
		sql = "select * from Notice where No_Title = ?";
		
		ResultSet rs = DbHelper.executeQuery(conn, sql, title);
	    
	    return rs;
	
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
