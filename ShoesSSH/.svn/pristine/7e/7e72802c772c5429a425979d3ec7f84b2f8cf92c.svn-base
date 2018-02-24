package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Push;
/**
 * 推送管理
 * add by zrh 2018年1月15日 上午9:20:50
 *
 */
@Repository
public class PushDaoImpl implements PushDao {
	@Resource(name="mySessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * 返回总行数
	 */
	@Override
	public long getPushCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Push";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}
	/**
	 * 返回总数量
	 */
	@Override
	public List<Push> getPushList(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Push";
		Query<Push> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Push> pushList = query.getResultList();
		return pushList;
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deletePushIds(List<Integer> pushIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Push where pushId in (:pushIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("pushIds", pushIds).executeUpdate();	
	}
	
	
	/**
	 * 添加或修改
	 */
	@Override
	public void addPush(Push push) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(push);
	}
	

}
