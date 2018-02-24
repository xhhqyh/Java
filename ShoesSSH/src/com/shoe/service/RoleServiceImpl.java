package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.RoleDao;
import com.shoe.pojo.Role;

import net.sf.json.JSONArray;
/**
 * 角色管理Service实现层
 * @gx
 * add by 2018-1-11
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleDao roleDao;
	
	
	/**
	 * 添加或修改角色信息
	 */
	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		boolean isOk = true;
		try {
			roleDao.addRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isOk = false;
		}
		return isOk;
	}


	/**
	 * 删除角色
	 * @param roleIds 角色Id的集合
	 */
	@Override
	public boolean deleteRole(List<Integer> roleIds) {
		// TODO Auto-generated method stub
		boolean isOk = true;
		try {
			roleDao.deleteRole(roleIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isOk = false;
		}
		return isOk;
	}


	/**
	 * 获取当前页的角色信息
	 * @param currentPage 当前页
	 * @param pageSize 页面最大数据条数
	 */
	@Override
	public Map<String, Object> getRolePage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long roleCount = roleDao.getRoleCount();//获取所有的角色总数
			List<Role> roleList = roleDao.getRolePage(currentPage, pageSize);//新建一个集合来接受当前页的角色信息
			data.put("total", roleCount);
			data.put("rows", roleList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 获取当前角色的权限
	 */
	@Override
	public JSONArray getRolePermission(int roleId) {
		JSONArray menuList = null;
		try {
			menuList = roleDao.getRolePermission(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}


	/**
	 * 添加或修改角色权限
	 */
	@Override
	public String addPermission(int roleId,String[] menuIds) {
		// TODO Auto-generated method stub
		String addResult = "";
		
		try {
			roleDao.deletePermission(roleId);//删除当前角色的所有权限
			for(int i = 0;i<menuIds.length; i++) {
				roleDao.addPermission(roleId,menuIds[i]);//添加权限
			}
			addResult = "修改成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addResult = "修改失败";
		}
		return addResult;
	}


	/**
	 * 获取所有角色信息
	 */
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		List<Role> roles = null;
		try {
			roles = roleDao.getAllRole();//新建一个集合来接受所有角色信息
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}


	
}
