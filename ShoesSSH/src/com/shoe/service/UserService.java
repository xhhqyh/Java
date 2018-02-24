package com.shoe.service;

import java.util.List;

import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/**
 * <P>用于处理与User相关的所有服务
 * @author 李杨
 * 
 */
public interface UserService {
	/**
	 * <P>查询所有的用户信息
	 * @return List 全体用户信息
	 */
	List<User> getUser();
	/**
	 * <P>查询所有的问题
	 * @return List 所有问题
	 */
	List<Security> getSecurity();
	/**
	 * <p>修改用户信息
	 * @return int 修改的总条数
	 * @param ids
	 * @param freeze
	 */
	boolean updateUser(Integer[] ids, String freeze);
}
