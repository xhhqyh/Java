package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Role;

import net.sf.json.JSONArray;
/**
 *  管理员角色信息管理Dao接口
 * @gx
 * add by 2018-1-11
 */
public interface RoleDao {
	public List<Role> getRolePage(int currentPage,int pageSize) throws Exception;//获取角色信息
	
	public long getRoleCount() throws Exception;//获取角色种类总数
	
	public void addRole(Role role) throws Exception;//添加角色
	
	public void deleteRole(List<Integer> roleIds) throws Exception;//删除角色

	public JSONArray getRolePermission(int roleId) throws Exception;//获取用户权限

	public void addPermission(int roleId,String menuId) throws Exception;//添加用户权限

	public void deletePermission(int roleId) throws Exception;//删除权限
	
	public List<Role> getAllRole() throws Exception;//获取所有角色信息
	
}
