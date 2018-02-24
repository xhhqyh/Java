package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Security;
import com.shoe.pojo.User;

/*
 * @Repository自动装配到Spring的容器
 * @Resource获得Sessionfactory，将User对象持久化
 */
/**
 * 
 * @author 李杨
 * @see UserDao
 */
@Repository 
public class UserDaoImpl implements UserDao  {
	/**
	 * <p>注入Hibernate框架数据处理结构
	 */
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory; 
	
	
	/**
	 * 查询全部用户数据
	 */
	@Override
	public List<User> getUser() throws Exception {
		System.out.println("----------UserDao-----------");
		Session session = sessionFactory.getCurrentSession();    //声明一个session对象 
		String hql="from User";									 //sql查询
		Query<User> query = session.createQuery(hql);			 //封装结果集
		List<User> list = query.getResultList();
		return list;
	} 
	/**
	 * 查询所有的问题
	 */
	@Override
	public List<Security> getSecurity() throws Exception{
		Session session = sessionFactory.getCurrentSession();    //声明一个session对象 
		String hql ="from Security";
		Query query = session.createQuery(hql);
		List<Security> list= query.getResultList();
		return list;
		
	}
	/**
	 * 冻结或解冻
	 */
	@Override
	public int update(Integer[] ids, int state) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String id="";
		for(int i=0;i<ids.length;i++){
			id+=ids[i];
			if(i<ids.length-1){
				id+=",";
			}
		}		
		//将信息拼接到hql中
		String hql="update t_user set user_status ="+state+"  where user_id in("+id+")";
		NativeQuery query = session.createNativeQuery(hql);
		int result = query.executeUpdate();
		return result;
	}
	
}
