package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.shoe.pojo.Role;
import com.shoe.service.ManagerService;
import com.shoe.service.RoleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 管理员角色信息管理模块
 * @gx
 * add by 2018-1-11
 */
public class RoleAction {
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private ManagerService managerService;
	private Role role;
	private Integer rows;
	private Integer page;
	private InputStream returnData;
	private List<Integer> resId;
	private String[] menuIds;
	 
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Integer> getResId() {
			return resId;
		}

	public void setResId(List<Integer> resId) {
			this.resId = resId;
		}
	public InputStream getReturnData() {
		return returnData;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String[] menuIds) {
		this.menuIds = menuIds;
	}
	
	/**
	 * 分页显示获取角色信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getRoleList() throws UnsupportedEncodingException{
		Map<String, Object> dataRole = roleService.getRolePage(page,rows);
		JSONObject data = JSONObject.fromObject(dataRole);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));		
		return "success";
	}
	
	/**
	 * 添加角色模块
	 * @param isOk 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String addRole() throws UnsupportedEncodingException{		
		boolean isOk = roleService.addRole(role);
		JSONObject data = new JSONObject();
		data.put("isOk", isOk);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));		
		return "success";	
	}
	
	/**
	 * 删除角色模块
	 * @param 前台获取选中角色ID
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String deleteRole() throws UnsupportedEncodingException{
		boolean isOk = roleService.deleteRole(resId);
		if(isOk){
			//删除与角色相关联的管理员
			boolean isOks = managerService.updateManager(resId);
			if(isOks){
				isOk = true;
			}else{
				isOk = false;
			}
		}else{
			isOk = false;
		}		
		JSONObject data = new JSONObject();
		data.put("isOk", isOk);		
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));		
		return "success";
		
	}
	
	/**
	 * 获取角色权限信息
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String getRolePermission() throws UnsupportedEncodingException {
		
		JSONArray json = roleService.getRolePermission(roleId);
		returnData = new ByteArrayInputStream(json.toString().getBytes("utf-8"));
		return "success";
	}
	
	/**
	 * 添加角色权限
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String addPermission() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String addResult = roleService.addPermission(roleId,menuIds);
		JSONObject data = new JSONObject();
		data.put("update",addResult);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
		
		
	}
	
	/**
	 * 获取所有角色信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getAllRole() throws UnsupportedEncodingException {
		List<Role> roles = roleService.getAllRole();
		JSONArray data = JSONArray.fromObject(roles);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
	}
	
}
