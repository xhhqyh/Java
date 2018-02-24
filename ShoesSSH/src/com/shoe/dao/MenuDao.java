package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Menu;
/**
 * 菜单Dao层
 * @gx
 * add by 2018-1-11
 * 
 */
public interface MenuDao {
	public List<Menu> getRolePermissionMenu(int roleId) throws Exception;//获取权限树
}
