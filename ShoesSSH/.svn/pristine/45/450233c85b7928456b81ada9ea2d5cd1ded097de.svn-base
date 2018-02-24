package com.shoe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.UserDao;
import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/*
 * @Service自动装配到Spring的容器,为其他组件提供服务
 * @Transactional进行事务的管理
 * @Resource注入UserDao对象。
 *
 */

/**
 * <P>
 * @author 李杨
 * @see UserService
 * @Service 将这个类放入Spring Bean
 * @Transactional 将事物注入这个类
 */
@Service  
@Transactional
public class UserServiceImpl implements UserService {
	/**
	 * <P>注入userDao,
	 */
	@Resource  
    UserDao userDao;
	/**
	 * <P>获取UserDao查询到的全部用户信息,并将它们返还给Action类
	 */
	@Override
	public List<User> getUser() {
		System.out.println("---进入Service----");
		List<User> lists=null;
		try {
			lists=userDao.getUser();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		System.out.println("---结束Service----");
		return lists;
	}
	/**
	 * <P>获取UserDao查询到的全部问题
	 */
	@Override
	public List<Security> getSecurity(){
		List<Security> lists =null;
		try {
		lists= userDao.getSecurity();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
		
	}
	/**
	 * <p>处理
	 */
	@Override
	public boolean updateUser(Integer[] ids,String freeze) {
		int state=0;
		int update = 0;
		if(freeze.equals("冻结")){
			state=1;
		}
		try {
			update= userDao.update(ids, state);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(update>0){
			return true;
		}else{
			return false;
		}
	}

}
