package Apo.Admin.DataModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Apo.Hui.Db.DbHelper;
import Apo.Hui.Db.DbUtil;

/**
 * @author 小灰灰
 * @version 2017年7月31日下午3:06:16
 * 类说明:
 * 
*/


public class Apo {
	public static String sql=""; 
	
	//后台登录验证管理员信息查询数据库
	public static int selectAdmin(String name, String pass) throws SQLException{
		//连接数据库
		Connection conn = DbUtil.getconn();
	    //查询SQL语句
		sql = "select * from Admin_Info where Adm_Name = ? and Adm_Psw = ?";
		//执行SQL语句，并接收返回值
		ResultSet rs = DbHelper.executeQuery(conn, sql, name, pass);
		if(rs.next()){
			return 1;  //成功
		}else{
			return 0;  //失败
		}
	}
	
	
	/**
	 * @author Administrator
	 *	菜单表数据处理
	 */
	
	//后台添加菜单方法
	public static int Add_Menu(String DishName,String Material, String MarketPrice, String MemberPrice, String Clssify, String Description, String img) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Menu_Info values(sequence2.nextval, ?, ?, ?, ?, ?, ?, ?)";
		//编写SQL语句, 注意日期格式要进行转化
		int i = DbHelper.executeUpdate(conn, sql, DishName, Material, MarketPrice, MemberPrice, Clssify, Description, img);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//调用后台的菜品信息
	public static ArrayList<Menu_Data> select(int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    //sql = "select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id";
		sql = " select * from (select t.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) t order by t.Menu_Id) m where m.rn between ? and ?";
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
	
	//后台菜单删除操作
	public static String Menu_Delete(String Menu_Id) throws SQLException {
		Connection conn = DbUtil.getconn();
		sql = "delete from Menu_Info where Menu_Id =" + Menu_Id ;
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int i = ps.executeUpdate();
		if(i>0){
			String str = "删除成功";
			return str;
		}else{
			String str = "删除失败";
			return str;
		}
	}
	
	//根据菜品编号查询菜品信息
	public static ArrayList<Menu_Data> Menu_Check_One(String Menu_Id) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice, Menu_memberPrice,Gr_Sort ,Menu_upPhoto,Menu_fState,Menu_Gr_Id  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id where Menu_Id = ? order by Menu_Id";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, Menu_Id);
	    
		//定义Menu_Data类型的集合
		ArrayList<Menu_Data> MenuList = new<Menu_Data> ArrayList();
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
			 rowDish.setMenu_Gr_Id(rs.getInt("Menu_Gr_Id"));
			 
			 MenuList.add(rowDish);
		 	}
		 
			DbUtil.closeConn(conn);
		
		return MenuList; 
	}
	
	//菜单修改
	public static int Menu_Update(String Menu_Id, String Menu_Name,String Menu_Rmaterial, String Menu_marketPrice, String Menu_memberPrice, String Menu_Gr_Id, String Menu_fState, String Menu_upPhoto) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		int i=0;
		if(Menu_upPhoto == ""){
			sql = "update Menu_Info set Menu_Name = ?, Menu_Rmaterial = ?, Menu_marketPrice = ?, Menu_memberPrice = ?, Menu_Gr_Id = ?, Menu_fState = ? where Menu_Id = ?";
			
			i = DbHelper.executeUpdate(conn, sql, Menu_Name, Menu_Rmaterial, Menu_marketPrice, Menu_memberPrice, Menu_Gr_Id, Menu_fState, Menu_Id);
		}else{
			sql = "update Menu_Info set Menu_Name = ?, Menu_Rmaterial = ?, Menu_marketPrice = ?, Menu_memberPrice = ?, Menu_Gr_Id = ?, Menu_fState = ?, Menu_upPhoto = ? where Menu_Id = ?";
			
			i = DbHelper.executeUpdate(conn, sql, Menu_Name, Menu_Rmaterial, Menu_marketPrice, Menu_memberPrice, Menu_Gr_Id, Menu_fState, Menu_upPhoto, Menu_Id);
		}
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}	
	
	/**
	 * @author Administrator
	 *	类别表数据处理
	 */
	//后台添加类别方法
	public static int Add_Classes(String ClassesName) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Greens_Classes values(sequence_classes.nextval, ?)";
		//编写SQL语句, 注意日期格式要进行转化
		int i = DbHelper.executeUpdate(conn, sql, ClassesName);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//后台类别查询
	public static ResultSet Classes_Select(int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from(select t.*,rownum rn from Greens_Classes t order by Gr_Id) m where m.rn between ? and ?";
	    
	    ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);
		
	    return rs; 
	}
	
	//后台类别查询
		public static ResultSet Classes_Select_Menu() throws SQLException{
			Connection conn = DbUtil.getconn();
			
		    sql = "select * from Greens_Classes order by Gr_Id";
		    
		    ResultSet rs = DbHelper.executeQuery(conn, sql);
			
		    return rs; 
		}
	
	//类别删除
	public static int Classes_Delete(String Gr_Id) throws SQLException {
		Connection conn = DbUtil.getconn();
		sql = "delete from Greens_Classes where Gr_Id =" + Gr_Id ;
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int i = ps.executeUpdate();
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//查询单个类别
	public static ResultSet Classes_Check_One(String Gr_Id) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select * from Greens_Classes where Gr_Id = ?";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, Gr_Id);
		
		return rs; 
	}
	
	//修改类别
	public static int Classes_Update(String Gr_Id, String ClassesName) throws SQLException{
		Connection conn = DbUtil.getconn();

		sql = "update Greens_Classes set Gr_Sort = ? where Gr_Id = ?";
		
		int i = DbHelper.executeUpdate(conn, sql, ClassesName, Gr_Id);

		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}	
	
	
	/**
	 * @author Administrator
	 *	公告表数据处理
	 */
	
	//添加公告信息
	public static int Add_Notice(String title, String content) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Notice(No_Id, No_Title, No_Message) values(sequence_Notice.nextval, ?, ?)";
		//编写SQL语句, 注意日期格式要进行转化
		int i = DbHelper.executeUpdate(conn, sql, title, content);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//查询公告信息
	public static ResultSet Notice_Select() throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Notice order by No_Id desc";
	    PreparedStatement ps = conn.prepareStatement(sql);
	  
	    ResultSet rs = ps.executeQuery();
		
	    return rs; 
	}
	
	//删除制定公告
	public static int Notice_Delete(String No_Title) throws SQLException {
		Connection conn = DbUtil.getconn();
		sql = "delete from Notice where No_Title = ? ";
		int i = DbHelper.executeUpdate(conn, sql, No_Title);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//查询单个公告
	public static ResultSet Notice_Check_One(String title) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select * from Notice where No_Title = ?";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, title);
		
		return rs; 
	}
	
	//修改公告
	public static int Notice_Update(String No_Id, String uptitle, String upcontent) throws SQLException{
		Connection conn = DbUtil.getconn();

		sql = "update Notice set No_Title = ?, No_Message = ? where No_Id = ?";
		
		int i = DbHelper.executeUpdate(conn, sql, uptitle, upcontent, No_Id);

		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}	
	
	//后台管理员的查询
	public static ResultSet Select_Admin() throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Admin_Info order by Adm_Id asc ";
	    PreparedStatement ps = conn.prepareStatement(sql);
	  
	    ResultSet rs = ps.executeQuery();
		
	    return rs; 
	}
	
	//后台管理员添加
		public static int Add_Admin(String name, String pass, String content ) throws SQLException{
			Connection conn = DbUtil.getconn();
			
			sql = "insert into Admin_Info values(sequence_Admin.nextval, ?, ?, ?)";
			//编写SQL语句, 注意日期格式要进行转化
			int i = DbHelper.executeUpdate(conn, sql, name, pass, content);
			
			if(i>0){
				return 1;
			}else{
				return 0;
			}
		}
	//查询单个管理员
	public static ResultSet Select_Admin_one(String num) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Admin_Info where Adm_Id = ? ";
	    ResultSet rs = DbHelper.executeQuery(conn, sql, num);
		
	    return rs; 
	}
	
	//修改单个管理员
	public static int Update_Admin( String Adm_Name, String Adm_Psw, String Adm_Remark, String Adm_Id) throws SQLException{
		Connection conn = DbUtil.getconn();

		sql = "update Admin_Info set Adm_Name = ?, Adm_Psw = ?, Adm_Remark = ? where Adm_Id = ?";
		
		int i = DbHelper.executeUpdate(conn, sql, Adm_Name, Adm_Psw, Adm_Remark, Adm_Id);

		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}	
	
	//删除单个管理员
	public static int Admin_Delete(String Adm_Id) throws SQLException {
		Connection conn = DbUtil.getconn();
		sql = "delete from Admin_Info where Adm_Id = ? ";
		int i = DbHelper.executeUpdate(conn, sql, Adm_Id);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
}























