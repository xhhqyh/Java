package com.shoe.pojo;

/**
 * Ȩ�ޱ�(t_menu)
 * 
 * @param menuId
 *            Integer Ȩ��id,������ʶ��
 * @param menuName
 *            String Ȩ������
 * @param menuUrl
 *            String Ȩ��URL
 * @author ����
 */
public class Menu {

	private Integer menuId;

	private String menuName;
	
	private Integer menuPid;

	private String menuUrl;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getMenuPid() {
		return menuPid;
	}

	public void setMenuPid(Integer menuPid) {
		this.menuPid = menuPid;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuPid=" + menuPid + "]";
	}

	
	
	
}
