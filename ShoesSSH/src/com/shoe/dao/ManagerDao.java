package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;

/**
 * 
 * @gx
 * add by 2018-1-11
 * 管理员管理模型层接口
 */
public interface ManagerDao {
	public List<Manager> loginManager(Manager manager) throws Exception;//管理员登录,获取登录信息
	
	public void addManager(ManagerVO managerVO) throws Exception;//添加管理员
	
	public long getManagerCount() throws Exception;//获取管理员的总数
	
	public void deleteManager(List<Integer> managerIds) throws Exception;//删除管理员
	
	public List<Manager> getManagerPage(int currentPage,int pageSize) throws Exception;//获取当前页管理员信息
	
	/**
	 * add by wyh 2018-1-22
	 * 修改角色名未有的管理员
	 */
	public void updateManger(List<Integer> roleId) throws Exception;
}
