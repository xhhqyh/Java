package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Role;

import net.sf.json.JSONArray;
/**
 * 角色管理Service层
 * @gx
 * add by 2018-1-11
 */
public interface RoleService {
	public Map<String, Object> getRolePage(int currentPage, int pageSize);//获取当前页的角色数据
	public boolean addRole(Role role);//添加或修改角色信息
	public boolean deleteRole(List<Integer> roleIds);//删除角色
	public JSONArray getRolePermission(int roleId);//获取角色的角色权限
	public String addPermission(int roleId, String[] menuIds);//添加或修改角色的权限
	public List<Role> getAllRole();//获取所有角色数据
}
