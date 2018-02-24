package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/**
 * <p>用来执行与用户(User)相关的数据库操作
 * @author 李杨
 * @see User
 */
public interface UserDao {
	/**
	 * <p>查询并展示全部的用户,并将查询到的全部用户用List装起来返回给调用函数;
	 * @return List 返回User类型的集合 
	 * @throws Exception 
	 */
	public List<User> getUser() throws Exception;

	/**
	 * <p>查询并展示全部问题,
	 * @return List 返回Security类型的集合
	 * @throws Exception
	 */
	List<Security> getSecurity() throws Exception;
	
	/**
	 * <p>冻结或解冻用户
	 * @param ids 需要处理的id
	 * @param state 需要执行的操作
	 * @return 返回执行的行数
	 * @throws Exception
	 */
	int update(Integer[] ids, int state) throws Exception;
}
