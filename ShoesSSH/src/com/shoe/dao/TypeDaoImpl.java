package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Type;
/*
 * add by zrh 2018��1��12��
 * ���͹���
 */
@Repository
public class TypeDaoImpl implements TypeDao {
	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * ��ȡ������
	 */
	@Override
	public long getTypeCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// �������HQL
		String hql = "select count(*) from Type";
		Query<Long> query = session.createQuery(hql);
		// ���ز�ѯ���
		return query.getSingleResult();
	}
	
	/**
	 * ���������������
	 */
	@Override
	public List<Type> getTypeName() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�������HQL
		String hql ="from Type t where t.typeId>0";
		Query<Type> query = session.createQuery(hql);		
		//��ѯ���
		List<Type> typeList = query.getResultList();
		return typeList;
	}



	
	/**
	 * 
	 * @param brand
	 * @return ��������������Ϣ
	 */
	@Override
	public List<Type> getTypeInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// �����Ʒ��ϢHQL
		String hql = "from Type t where t.typeId>0";
		Query<Type> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Type> typeList = query.getResultList();
		// ���ز�ѯ���
		return typeList;
	}
	
	/**
	 * ���ӻ��޸�
	 * 
	 */
	@Override
	public void addType(Type type) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(type);
	}
	
	/**
	 * ɾ��
	 * @param typeIds ѡ�����ݵ�ID�ļ���
	 */
	@Override
	public void deleteType(List<Integer> typeIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Type where typeId in (:typeIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("typeIds", typeIds).executeUpdate();
	}

}