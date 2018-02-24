package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Brand;

/*
 * add by zrh 2018年1月12日
 * 品牌管理
 */
@Repository
public class BrandDaoImpl implements BrandDao {

	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Brand> getBrandName() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得数量HQL
		String hql ="from Brand b where b.brandId>0 ";
		Query<Brand> query = session.createQuery(hql);		
		//查询结果
		List<Brand> brandList = query.getResultList();
		return brandList;
		
	}

	/**
	 * 
	 * @param brand
	 * @return 返回品牌总数量
	 */

	@Override
	public long getBrandCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 获得数量HQL
		String hql = "select count(*) from Brand";
		Query<Long> query = session.createQuery(hql);
		// 返回查询结果
		return query.getSingleResult();
	}

	/**
	 * 
	 * @param brand
	 * @return 返回品牌所有信息
	 */
	@Override
	public List<Brand> getBrandInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Brand b where b.brandId>0";
		Query<Brand> query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Brand> brandList = query.getResultList();
		return brandList;
	}

	/**
	 * 添加或修改
	 * @param brand
	 */
	@Override
	public void addBrand(Brand brand) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(brand);
	}

	/**
	 * 删除
	 * @param brandIds 选中的数据ID的集合
	 * 
	 */
	@Override
	public void deleteBrand(List<Integer> brandIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Brand where brandId in (:brandIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("brandIds", brandIds).executeUpdate();
	}

}
