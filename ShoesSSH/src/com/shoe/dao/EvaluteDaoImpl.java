package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Evalute;
import com.shoe.pojo.EvaluteTwo;
import com.shoe.pojo.Goods;
import com.shoe.pojo.GoodsTwo;

/**
 * 
 * add by wyh 2018��1��13
 * <p>
 * ���ۻ���ѯ���ݲ�ӿ�ʵ����
 *
 */
@Repository
public class EvaluteDaoImpl implements EvaluteDao {

	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param goods
	 * @return ���ػظ�������
	 */
	@Override
	public long getCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// �������HQL
		String hql = "select count(*) from Evalute";
		Query<Long> query = session.createQuery(hql);
		// ���ز�ѯ���
		return query.getSingleResult();
	}

	/**
	 * ���ػظ���Ϣ
	 */
	@Override
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// ��ûظ���ϢHQL
		String hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1";
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// ���ز�ѯ���
		return evalList;
	}

	/**
	 * �����������ػظ���Ϣ
	 */
	@Override
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize, int stauts) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = null;
		// ��ûظ���ϢHQL
		if (stauts == 2) {
			// �����2 ȫ����ѯ ��������
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1";
		} else {
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1 and e.evaluteStatus="+stauts;
		}
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// ���ز�ѯ���
		return evalList;
	}

	/**
	 * �ظ���ѯ
	 */
	@Override
	public void saveEvalute(EvaluteTwo evalute) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(evalute);

	}

	/**
	 * ����������Ϣ
	 */
	@Override
	public List<Evalute> getCommentInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// ��ûظ���ϢHQL
		String hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0";
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// ���ز�ѯ���
		return evalList;
	}

	/**
	 * ������������������Ϣ
	 */
	@Override
	public List<Evalute> getCommentInfo(int currentPage, int pageSize, int stauts) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = null;
		// ��ûظ���ϢHQL
		if (stauts == 2) {
			// �����2 ȫ����ѯ ��������
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0";
		} else {
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0 and e.evaluteStatus="+stauts;
		}
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// ���ز�ѯ���
		return evalList;
	}
    /**
     * ����δ�ظ���Ϣ
     */
	@Override
	public long getEvaluteCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// �������HQL
		String hql = "select count(*) from Evalute e where e.evaluteStatus=0 and e.evaluteChoice=1";
		Query<Long> query = session.createQuery(hql);
		// ���ز�ѯ���
		return query.getSingleResult();
	}

}
