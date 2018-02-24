package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;
/**
 * 管理员管理Service层
 * @gx
 * add by 2018-1-11
 */
public interface ManagerService {
	public boolean addManager(ManagerVO manager);//添加或修改管理员
	public List<Manager> loginManager(Manager manager);//管理员登录
	public Map<String, Object> getManagerPage(int currentPage, int pageSize);//获取当前页面管理员信息
	public boolean deleteManager(List<Integer> managerIds);//删除管理员
	/**
	 * add by wyh 2018-1-22
	 * 修改角色名未有的管理员
	 */
	public boolean updateManager(List<Integer> roleId);
}
