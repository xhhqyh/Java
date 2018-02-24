package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Reserve;
/**
 * <p>��������
 * @author ����
 * @see OrderDao
 */
@Repository 
public class OrderDaoImpl implements OrderDao {
	/**
	 * ��Spring����ע��һ��sessionfactory
	 */
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * <p>��ѯȫ������
	 */
	@Override
	public List<Reserve> getOrder(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t order by r.reserveId ";
		Query<Reserve> query = session.createQuery(hql);
		//��ҳ
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Reserve> list = query.getResultList();
		return list;
	}
	/**
	 * <p>��ѯ��������
	 */
	@Override
	public long getCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="select count(*) from Reserve";
		Query<Long> query = session.createQuery(hql);
		Long result = query.getSingleResult();
		return result;
	}
	/**
	 * <p>�������˻�����
	 */
	@Override
	public String updateOrder(Integer[] ids, Integer status) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		//�������е�����idȫ�����ϵ�һ���ַ�����,�������޸Ĳ���
		String id="";
		for(int i=0;i<ids.length;i++){
			id+=ids[i];
			if(i<ids.length-1){
				id+=",";
			}
		}	
		String sql="update T_RESERVE set RESERVE_STATUS ="+status+"  where RESERVE_ID in("+id+")";
		NativeQuery query = session.createNativeQuery(sql);
		int result = query.executeUpdate();
		
	
		return result>0?"true":"false";
	}
	/**
	 * <p>ѡ���ѯ���ֶ���
	 * @return 
	 */
	@Override
	public List<Reserve> getSomeOrder(int status, int currentPage,int pageSize )throws Exception{
		Session session=sessionFactory.getCurrentSession();
		String hql="";
		if(status==5){
			//��ѯ������Ʒ��������status�Ĳ���Ϊ5ʱ��
			hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t where r.reserveType=1 order by r.reserveId";
		}else{
			//���ݶ���״̬��ѯ����
			hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t where r.reserveStatus="+status+" order by r.reserveId";
		}
		Query<Reserve> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Reserve> list = query.getResultList();
		return list;
	}
	/**
	 * <P>��ѯ������ѯ�Ķ���������<p>
	 * add by liyang 2018��1��15�� ����9:15:24
	 * 
	 * @param status ������ ����״̬
	 * @return ���ؽ��ֵ
	 * @throws Exception
	 */
	@Override
	public long getSomeCount(int status)throws Exception{
		Session session=sessionFactory.getCurrentSession();
		String hql="";
			if(status!=5){
				hql="select count(*) from Reserve where reserveStatus="+status;
			}else{
				hql="select count(*) from Reserve where reserveType=1";
			}
		Query<Long> query = session.createQuery(hql);
		Long result = query.getSingleResult();
		return result;
		
	}
	/**
	 * ����������ѯ���鿴��û��������¼
	 */
	@Override
	public long getSomeCount(String order) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from Reserve where reserveNo="+order;
		Query<Long> query = session.createQuery(hql);
		Long result = query.getSingleResult();
		return result;
	}
	
	@Override
	/**
	 * ����������ѯ,��ѯ��������ȫ����Ϣ
	 */
	public List<Reserve> getSomeOrder(String order) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t  where r.reserveNo="+order+" order by r.reserveId";
		Query<Reserve> query = session.createQuery(hql);
		List<Reserve> list = query.getResultList();
		return list;
	}
}