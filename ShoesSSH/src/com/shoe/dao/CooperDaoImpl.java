package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Advertisement;
import com.shoe.pojo.Cooperation;

/**
 * �������ģ�Ͳ�ʵ����
 * 
 * add by qyh 2018��1��12�� ����8:36:50
 *
 */
@Repository
public class CooperDaoImpl implements CooperDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by qyh 2018��1��12�� ����8:36:50
	 * 
	 * ��ȡ���������Ϣ
	 * @return ���������װ��ʵ����ļ���
	 */
	@Override
	public List<Cooperation> getCooperPageList(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Cooperation";
		Query<Cooperation> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Cooperation> cooperList = query.getResultList();
		return cooperList;
	}

	/**
	 * ��ȡ���������������
	 * add by qyh 2018��1��12�� ����8:36:50
	 * @return long�����������������
	 * @throws Exception
	 */
	@Override
	public long getCooperCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select count(*) from Cooperation";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}

	/**
	 * �����������
	 * add by qyh 2018��1��12�� ����8:36:50
	 * @param cooper ��������������
	 * @throws Exception
	 */
	@Override
	public void saveCooper(Cooperation cooper) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cooper);
	}

	/**
	 * ����ɾ���������
	 * add by qyh 2018��1��12�� ����8:36:50
	 * @param cooperIds Ҫɾ�����������Id
	 * @throws Exception
	 */
	@Override
	public void deleteCooperByIds(List<Integer> cooperIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Cooperation where coId in (:cooperIds)";
		session.createQuery(hql).setParameter("cooperIds", cooperIds).executeUpdate();
	}

}
