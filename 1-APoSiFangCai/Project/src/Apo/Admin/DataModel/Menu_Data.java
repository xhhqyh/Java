package Apo.Admin.DataModel;

/**
 * @author 小灰灰
 * @version 2017年8月1日下午6:10:39
 * 类说明:
 *		菜单表数据封装
*/

public class Menu_Data {
	private int Menu_Id;               //菜单主键
	private String Menu_Name = "";     //菜品名称
	private String Menu_Rmaterial = "";  //原料
	private String Menu_marketPrice = "";  //市场价格
	private String Menu_memberPrice = "";  //会员价格
	private int Menu_Gr_Id;            //菜品类别、外键
	private String Menu_fState = "";   //菜品说明
	private String Menu_upPhoto = "";   //上传图片
	private String Gr_Sort = "";  //类型
	public String getGr_Sort() {
		return Gr_Sort;
	}
	public void setGr_Sort(String gr_Sort) {
		Gr_Sort = gr_Sort;
	}
	public int getMenu_Id() {
		return Menu_Id;
	}
	public void setMenu_Id(int menu_Id) {
		Menu_Id = menu_Id;
	}
	public String getMenu_Name() {
		return Menu_Name;
	}
	public void setMenu_Name(String menu_Name) {
		Menu_Name = menu_Name;
	}
	public String getMenu_Rmaterial() {
		return Menu_Rmaterial;
	}
	public void setMenu_Rmaterial(String menu_Rmaterial) {
		Menu_Rmaterial = menu_Rmaterial;
	}
	public String getMenu_marketPrice() {
		return Menu_marketPrice;
	}
	public void setMenu_marketPrice(String menu_marketPrice) {
		Menu_marketPrice = menu_marketPrice;
	}
	public String getMenu_memberPrice() {
		return Menu_memberPrice;
	}
	public void setMenu_memberPrice(String menu_memberPrice) {
		Menu_memberPrice = menu_memberPrice;
	}
	public int getMenu_Gr_Id() {
		return Menu_Gr_Id;
	}
	public void setMenu_Gr_Id(int menu_Gr_Id) {
		Menu_Gr_Id = menu_Gr_Id;
	}
	public String getMenu_fState() {
		return Menu_fState;
	}
	public void setMenu_fState(String menu_fState) {
		Menu_fState = menu_fState;
	}
	public String getMenu_upPhoto() {
		return Menu_upPhoto;
	}
	public void setMenu_upPhoto(String menu_upPhoto) {
		Menu_upPhoto = menu_upPhoto;
	}
	
	

}




