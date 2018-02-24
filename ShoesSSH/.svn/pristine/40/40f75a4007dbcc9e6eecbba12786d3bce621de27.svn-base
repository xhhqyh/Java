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
 * add by qyh 2018年1月11日
 *
 * 广告管理模型层
 */

@Repository 
public class AdvDaoImpl implements AdvDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by qyh 2018年1月11日
	 * 
	 * 获取广告信息
	 * @return 广告封装的实体类的集合
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
	 * 获取广告表总行数
	 * add by qyh 2018年1月11日
	 * @return long型广告表总条数
	 */
	@Override
	public long getAdvCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select count(*) from Advertisement";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}

	/**
	 * 新增广告
	 * add by qyh 2018年1月12日
	 * @param adv 广告具体参数
	 * @throws Exception
	 */
	@Override
	public void saveAdv(Advertisement adv) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(adv);
	}

	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @param advIds 要删除的广告Id
	 * @throws Exception
	 */
	@Override
	public void deleteAdvByIds(List<Integer> advIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Advertisement where adverId in (:advIds)";
		session.createQuery(hql).setParameter("advIds", advIds).executeUpdate();
	}

}











