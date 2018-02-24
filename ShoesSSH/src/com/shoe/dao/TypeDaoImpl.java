package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Type;
/*
 * add by zrh 2018年1月12日
 * 类型管理
 */
@Repository
public class TypeDaoImpl implements TypeDao {
	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * 获取总行数
	 */
	@Override
	public long getTypeCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得数量HQL
		String hql = "select count(*) from Type";
		Query<Long> query = session.createQuery(hql);
		// 返回查询结果
		return query.getSingleResult();
	}
	
	/**
	 * 获得所有类型名字
	 */
	@Override
	public List<Type> getTypeName() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得数量HQL
		String hql ="from Type t where t.typeId>0";
		Query<Type> query = session.createQuery(hql);		
		//查询结果
		List<Type> typeList = query.getResultList();
		return typeList;
	}



	
	/**
	 * 
	 * @param brand
	 * @return 返回类型所有信息
	 */
	@Override
	public List<Type> getTypeInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得商品信息HQL
		String hql = "from Type t where t.typeId>0";
		Query<Type> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Type> typeList = query.getResultList();
		// 返回查询结果
		return typeList;
	}
	
	/**
	 * 添加或修改
	 * 
	 */
	@Override
	public void addType(Type type) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(type);
	}
	
	/**
	 * 删除
	 * @param typeIds 选中数据的ID的集合
	 */
	@Override
	public void deleteType(List<Integer> typeIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Type where typeId in (:typeIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("typeIds", typeIds).executeUpdate();
	}

}
