package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Advertisement;
/**
 * 
 * add by qyh 2018��1��11��
 *
 * ������ģ�Ͳ�
 */

@Repository 
public class AdvDaoImpl implements AdvDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by qyh 2018��1��11��
	 * 
	 * ��ȡ�����Ϣ
	 * @return ����װ��ʵ����ļ���
	 */
	@Override
	public List<Advertisement> getAdvPageList(int currentPage, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Advertisement";
		Query<Advertisement> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Advertisement> advList = query.getResultList();
		return advList;
	}

	/**
	 * ��ȡ����������
	 * add by qyh 2018��1��11��
	 * @return long�͹���������
	 */
	@Override
	public long getAdvCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select count(*) from Advertisement";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}

	/**
	 * �������
	 * add by qyh 2018��1��12��
	 * @param adv ���������
	 * @throws Exception
	 */
	@Override
	public void saveAdv(Advertisement adv) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(adv);
	}

	/**
	 * ����ɾ�����
	 * add by qyh 2018��1��12��
	 * @param advIds Ҫɾ���Ĺ��Id
	 * @throws Exception
	 */
	@Override
	public void deleteAdvByIds(List<Integer> advIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Advertisement where adverId in (:advIds)";
		session.createQuery(hql).setParameter("advIds", advIds).executeUpdate();
	}

}











