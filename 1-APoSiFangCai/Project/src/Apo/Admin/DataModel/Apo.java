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
 * @author С�һ�
 * @version 2017��7��31������3:06:16
 * ��˵��:
 * 
*/


public class Apo {
	public static String sql=""; 
	
	//��̨��¼��֤����Ա��Ϣ��ѯ���ݿ�
	public static int selectAdmin(String name, String pass) throws SQLException{
		//�������ݿ�
		Connection conn = DbUtil.getconn();
	    //��ѯSQL���
		sql = "select * from Admin_Info where Adm_Name = ? and Adm_Psw = ?";
		//ִ��SQL��䣬�����շ���ֵ
		ResultSet rs = DbHelper.executeQuery(conn, sql, name, pass);
		if(rs.next()){
			return 1;  //�ɹ�
		}else{
			return 0;  //ʧ��
		}
	}
	
	
	/**
	 * @author Administrator
	 *	�˵������ݴ���
	 */
	
	//��̨��Ӳ˵�����
	public static int Add_Menu(String DishName,String Material, String MarketPrice, String MemberPrice, String Clssify, String Description, String img) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Menu_Info values(sequence2.nextval, ?, ?, ?, ?, ?, ?, ?)";
		//��дSQL���, ע�����ڸ�ʽҪ����ת��
		int i = DbHelper.executeUpdate(conn, sql, DishName, Material, MarketPrice, MemberPrice, Clssify, Description, img);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//���ú�̨�Ĳ�Ʒ��Ϣ
	public static ArrayList<Menu_Data> select(int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    //sql = "select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id";
		sql = " select * from (select t.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) t order by t.Menu_Id) m where m.rn between ? and ?";
	    ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);
	    
		//����Menu_Data���͵ļ���
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
	
	//��̨�˵�ɾ������
	public static String Menu_Delete(String Menu_Id) throws SQLException {
		Connection conn = DbUtil.getconn();
		sql = "delete from Menu_Info where Menu_Id =" + Menu_Id ;
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int i = ps.executeUpdate();
		if(i>0){
			String str = "ɾ���ɹ�";
			return str;
		}else{
			String str = "ɾ��ʧ��";
			return str;
		}
	}
	
	//���ݲ�Ʒ��Ų�ѯ��Ʒ��Ϣ
	public static ArrayList<Menu_Data> Menu_Check_One(String Menu_Id) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice, Menu_memberPrice,Gr_Sort ,Menu_upPhoto,Menu_fState,Menu_Gr_Id  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id where Menu_Id = ? order by Menu_Id";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, Menu_Id);
	    
		//����Menu_Data���͵ļ���
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
	
	//�˵��޸�
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
	 *	�������ݴ���
	 */
	//��̨�����𷽷�
	public static int Add_Classes(String ClassesName) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Greens_Classes values(sequence_classes.nextval, ?)";
		//��дSQL���, ע�����ڸ�ʽҪ����ת��
		int i = DbHelper.executeUpdate(conn, sql, ClassesName);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//��̨����ѯ
	public static ResultSet Classes_Select(int min, int max) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from(select t.*,rownum rn from Greens_Classes t order by Gr_Id) m where m.rn between ? and ?";
	    
	    ResultSet rs = DbHelper.executeQuery(conn, sql, min, max);
		
	    return rs; 
	}
	
	//��̨����ѯ
		public static ResultSet Classes_Select_Menu() throws SQLException{
			Connection conn = DbUtil.getconn();
			
		    sql = "select * from Greens_Classes order by Gr_Id";
		    
		    ResultSet rs = DbHelper.executeQuery(conn, sql);
			
		    return rs; 
		}
	
	//���ɾ��
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
	
	//��ѯ�������
	public static ResultSet Classes_Check_One(String Gr_Id) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select * from Greens_Classes where Gr_Id = ?";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, Gr_Id);
		
		return rs; 
	}
	
	//�޸����
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
	 *	��������ݴ���
	 */
	
	//��ӹ�����Ϣ
	public static int Add_Notice(String title, String content) throws SQLException{
		Connection conn = DbUtil.getconn();
		
		sql = "insert into Notice(No_Id, No_Title, No_Message) values(sequence_Notice.nextval, ?, ?)";
		//��дSQL���, ע�����ڸ�ʽҪ����ת��
		int i = DbHelper.executeUpdate(conn, sql, title, content);
		
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//��ѯ������Ϣ
	public static ResultSet Notice_Select() throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Notice order by No_Id desc";
	    PreparedStatement ps = conn.prepareStatement(sql);
	  
	    ResultSet rs = ps.executeQuery();
		
	    return rs; 
	}
	
	//ɾ���ƶ�����
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
	
	//��ѯ��������
	public static ResultSet Notice_Check_One(String title) throws SQLException{
		Connection conn = DbUtil.getconn();

	    sql = "select * from Notice where No_Title = ?";
	  
	    ResultSet rs = DbHelper.executeQuery(conn, sql, title);
		
		return rs; 
	}
	
	//�޸Ĺ���
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
	
	//��̨����Ա�Ĳ�ѯ
	public static ResultSet Select_Admin() throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Admin_Info order by Adm_Id asc ";
	    PreparedStatement ps = conn.prepareStatement(sql);
	  
	    ResultSet rs = ps.executeQuery();
		
	    return rs; 
	}
	
	//��̨����Ա���
		public static int Add_Admin(String name, String pass, String content ) throws SQLException{
			Connection conn = DbUtil.getconn();
			
			sql = "insert into Admin_Info values(sequence_Admin.nextval, ?, ?, ?)";
			//��дSQL���, ע�����ڸ�ʽҪ����ת��
			int i = DbHelper.executeUpdate(conn, sql, name, pass, content);
			
			if(i>0){
				return 1;
			}else{
				return 0;
			}
		}
	//��ѯ��������Ա
	public static ResultSet Select_Admin_one(String num) throws SQLException{
		Connection conn = DbUtil.getconn();
		
	    sql = "select * from Admin_Info where Adm_Id = ? ";
	    ResultSet rs = DbHelper.executeQuery(conn, sql, num);
		
	    return rs; 
	}
	
	//�޸ĵ�������Ա
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
	
	//ɾ����������Ա
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























