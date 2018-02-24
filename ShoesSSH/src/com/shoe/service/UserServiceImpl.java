package com.shoe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.UserDao;
import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/*
 * @Service�Զ�װ�䵽Spring������,Ϊ��������ṩ����
 * @Transactional��������Ĺ���
 * @Resourceע��UserDao����
 *
 */

/**
 * <P>
 * @author ����
 * @see UserService
 * @Service ����������Spring Bean
 * @Transactional ������ע�������
 */
@Service  
@Transactional
public class UserServiceImpl implements UserService {
	/**
	 * <P>ע��userDao,
	 */
	@Resource  
    UserDao userDao;
	/**
	 * <P>��ȡUserDao��ѯ����ȫ���û���Ϣ,�������Ƿ�����Action��
	 */
	@Override
	public List<User> getUser() {
		System.out.println("---����Service----");
		List<User> lists=null;
		try {
			lists=userDao.getUser();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		System.out.println("---����Service----");
		return lists;
	}
	/**
	 * <P>��ȡUserDao��ѯ����ȫ������
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
	 * <p>����
	 */
	@Override
	public boolean updateUser(Integer[] ids,String freeze) {
		int state=0;
		int update = 0;
		if(freeze.equals("����")){
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
