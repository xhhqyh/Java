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
 * <p>订单处理
 * @author 李杨
 * @see OrderDao
 */
@Repository 
public class OrderDaoImpl implements OrderDao {
	/**
	 * 从Spring容器注入一个sessionfactory
	 */
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * <p>查询全部订单
	 */
	@Override
	public List<Reserve> getOrder(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t order by r.reserveId ";
		Query<Reserve> query = session.createQuery(hql);
		//分页
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Reserve> list = query.getResultList();
		return list;
	}
	/**
	 * <p>查询订单总数
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
	 * <p>发货或退货处理
	 */
	@Override
	public String updateOrder(Integer[] ids, Integer status) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		//将数组中的所有id全部整合到一条字符串中,并进行修改操作
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
	 * <p>选择查询部分订单
	 * @return 
	 */
	@Override
	public List<Reserve> getSomeOrder(int status, int currentPage,int pageSize )throws Exception{
		Session session=sessionFactory.getCurrentSession();
		String hql="";
		if(status==5){
			//查询热卖商品，当传入status的参数为5时；
			hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t where r.reserveType=1 order by r.reserveId";
		}else{
			//依据订单状态查询订单
			hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t where r.reserveStatus="+status+" order by r.reserveId";
		}
		Query<Reserve> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Reserve> list = query.getResultList();
		return list;
	}
	/**
	 * <P>查询条件查询的订单总数量<p>
	 * add by liyang 2018年1月15日 上午9:15:24
	 * 
	 * @param status 条件是 订单状态
	 * @return 返回结果值
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
	 * 订单索引查询，查看有没有这条记录
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
	 * 订单索引查询,查询该条数据全部信息
	 */
	public List<Reserve> getSomeOrder(String order) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Reserve r left join fetch r.user u left join fetch r.recive e left join fetch r.goods g  left  join fetch g.brand b left join fetch g.type t  where r.reserveNo="+order+" order by r.reserveId";
		Query<Reserve> query = session.createQuery(hql);
		List<Reserve> list = query.getResultList();
		return list;
	}
}
