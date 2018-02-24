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
 * add by wyh 2018年1月13
 * <p>
 * 评论或咨询数据层接口实现类
 *
 */
@Repository
public class EvaluteDaoImpl implements EvaluteDao {

	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param goods
	 * @return 返回回复总数量
	 */
	@Override
	public long getCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得数量HQL
		String hql = "select count(*) from Evalute";
		Query<Long> query = session.createQuery(hql);
		// 返回查询结果
		return query.getSingleResult();
	}

	/**
	 * 返回回复信息
	 */
	@Override
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得回复信息HQL
		String hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1";
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// 返回查询结果
		return evalList;
	}

	/**
	 * 根据条件返回回复信息
	 */
	@Override
	public List<Evalute> getEvaluteInfo(int currentPage, int pageSize, int stauts) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = null;
		// 获得回复信息HQL
		if (stauts == 2) {
			// 如果是2 全部查询 不加条件
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1";
		} else {
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=1 and e.evaluteStatus="+stauts;
		}
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// 返回查询结果
		return evalList;
	}

	/**
	 * 回复咨询
	 */
	@Override
	public void saveEvalute(EvaluteTwo evalute) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(evalute);

	}

	/**
	 * 返回评价信息
	 */
	@Override
	public List<Evalute> getCommentInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得回复信息HQL
		String hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0";
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// 返回查询结果
		return evalList;
	}

	/**
	 * 根据条件返回评论信息
	 */
	@Override
	public List<Evalute> getCommentInfo(int currentPage, int pageSize, int stauts) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = null;
		// 获得回复信息HQL
		if (stauts == 2) {
			// 如果是2 全部查询 不加条件
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0";
		} else {
			hql = "from Evalute e left join fetch e.user u left join fetch e.goods g left join fetch e.manager m where e.evaluteChoice=0 and e.evaluteStatus="+stauts;
		}
		Query<Evalute> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Evalute> evalList = query.getResultList();
		// 返回查询结果
		return evalList;
	}
    /**
     * 返回未回复信息
     */
	@Override
	public long getEvaluteCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得数量HQL
		String hql = "select count(*) from Evalute e where e.evaluteStatus=0 and e.evaluteChoice=1";
		Query<Long> query = session.createQuery(hql);
		// 返回查询结果
		return query.getSingleResult();
	}

}
