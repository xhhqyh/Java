package com.shoe.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;
/**
 * ����Ь
 * add by zrh 2018��1��17�� ����11:13:04
 *
 */
@Repository
public class CustomizeDaoImpl implements CustomizeDao {
	
	@Resource(name="mySessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * ����Ь������
	 */
	@Override
	public long getCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(*) from Customize";
		Query<Long> query = session.createQuery(hql);		
		return query.getSingleResult();
	}
	
	
	/**
	 * ����Ь��ѯ
	 * @param  currentPage
	 * @param  pageSize
	 */
	@Override
	public List<Customize> getCustomizeInfo(int currentPage, int pageSize,String customizeCards) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "";
		if(customizeCards==null){
			hql ="from Customize c left join fetch c.size s left join fetch c.type d left join fetch c.brand m ";
		}else{
			hql ="from Customize c left join fetch c.size s left join fetch c.type d left join fetch c.brand m where c.customizeCard="+customizeCards;
		}
		 
		Query<Customize> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Customize> customizeList = query.getResultList(); 
		return customizeList;
	}
	

	
	/**
	 * ��Ӷ���Ь
	 * @param customize
	 */
	@Override
	public void addCustomize(Customize customize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customize);
	}

	
	/**
	 * ɾ��
	 * @param customizeIds
	 */
	@Override
	public void deleteCustomize(List<Integer> customizeIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Customize where customizeId in (:customizeIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("customizeIds", (Collection) customizeIds).executeUpdate();
	}

	
	/**
	 * ��ѯЬ�ӳ���
	 */
	@Override
	public List<Size> getSize() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Size";
		Query<Size> query = session.createQuery(hql);		
		List<Size> sizeList = query.getResultList();
		return sizeList;
	}


	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * @throws Exception
	 * ɾ������ʱ  �޸������Ʒ������
	 */
	@Override
	public void updateGoodsType(List<Integer> typeId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update from CustomizeVO c set c.typeId=0 where c.typeId in (:typeIds)";
		session.createQuery(hql).setParameter("typeIds", typeId).executeUpdate();		
	}
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * @throws Exception
	 * ɾ��Ʒ��ʱ  �޸������Ʒ��Ʒ��
	 */
	@Override
	public void updateGoodsBrand(List<Integer> brandId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update from CustomizeVO c set c.brandId=0 where c.brandId in (:brandIds)";
		session.createQuery(hql).setParameter("brandIds", brandId).executeUpdate();
		
	}

}
