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
 * 商务合作模型层实现类
 * 
 * add by qyh 2018年1月12日 下午8:36:50
 *
 */
@Repository
public class CooperDaoImpl implements CooperDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by qyh 2018年1月12日 下午8:36:50
	 * 
	 * 获取商务合作信息
	 * @return 商务合作封装的实体类的集合
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
	 * 获取商务合作表总行数
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @return long型商务合作表总条数
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
	 * 新增商务合作
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @param cooper 商务合作具体参数
	 * @throws Exception
	 */
	@Override
	public void saveCooper(Cooperation cooper) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cooper);
	}

	/**
	 * 批量删除商务合作
	 * add by qyh 2018年1月12日 下午8:36:50
	 * @param cooperIds 要删除的商务合作Id
	 * @throws Exception
	 */
	@Override
	public void deleteCooperByIds(List<Integer> cooperIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Cooperation where coId in (:cooperIds)";
		session.createQuery(hql).setParameter("cooperIds", cooperIds).executeUpdate();
	}

}
