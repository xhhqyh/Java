package com.shoe.dao;

import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;
import com.shoe.pojo.Size;
/**
 * <p>积分热卖商品
 * @author 李杨
 * @see PointDao
 */
@Repository 
public class PointDaoImpl implements PointDao {
	/**
	 * 注入session
	 */
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;

	@Override
	public Long getPointGoodsCount() throws Exception {	
		Session session = sessionFactory.getCurrentSession();		
		String hql="";
		
			hql="select count(*) from PointShop p where p.goods.goodsDel=1";
		
		Query<Long> query = session.createQuery(hql);
		Long result = query.getSingleResult();
		return result;
	}

	@Override
	public List<PointShop> getPointGoods(Integer currentPage, Integer pageSize,Integer statuss) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="";
		if(statuss==null){
			hql="from PointShop p left join fetch p.color c left join fetch p.size left join fetch p.goods g left  join fetch g.brand left join fetch g.type where g.goodsDel=1 order by p.pShopId";
		}else{
			hql="from PointShop p left join fetch p.color c left join fetch p.size left join fetch p.goods g left  join fetch g.brand left join fetch g.type  where g.goodsDel=1 and p.pShopStatus="+statuss+" order by p.pShopId";
		}
		Query<PointShop> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<PointShop> list = query.getResultList();
		return list; 
	}

	@Override
	public int updateStatus(Integer status,Integer id) throws Exception  {
		Session session=sessionFactory.getCurrentSession();
		String sql="update t_PointShop set PT_STATUS="+status+"where PT_ID="+id;
		NativeQuery query = session.createNativeQuery(sql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int deletePointByIds(Integer[] ids) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String id="";
		for(int i=0;i<ids.length;i++){
			if(i!=ids.length-1){
				id=id+ids[i]+",";
			}else{
				id=id+ids[i];
			}
		}
		String hql="delete t_pointShop where PT_ID in("+id+")";
		int update = session.createNativeQuery(hql).executeUpdate();
		return update;
	}

	@Override
	public List<Size> getSize(int i) throws Exception{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Size";
		Query<Size> query = session.createQuery(hql);
		List<Size> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<Color> getColor(int i) throws Exception{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Color";
		Query<Color> query = session.createQuery(hql);
		List<Color> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<Goods> getGoods() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="select new com.shoe.pojo.Goods(goodsId ,goodsName) from Goods g where g.goodsDel=1 order by goodsId";
		Query<Goods> query = session.createQuery(hql);
		List<Goods> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public int saveOrUpdate(PointVo pointVO) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="";
		if(pointVO.getPointId()!=0){
			hql="update t_pointshop set pt_point=:ptPoint ,pt_stime =:ptStime ,pt_etime=:ptEtime,pt_num=:ptNum   where pt_id="+pointVO.getPointId();			
		}else{
			hql="insert into t_pointshop values(pointshop_seq.nextval,:ptGoodsId,:ptPoint,:ptStime,:ptEtime,:ptNum,:ptSize,:ptStatus,:ptColor)";
			
		}
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter("ptPoint",pointVO.getpShopPoint());
		query.setParameter("ptStime",pointVO.getpShopStartTime());
		query.setParameter("ptEtime",pointVO.getpShopEndTime());
		query.setParameter("ptNum",pointVO.getpShopNum());
		if(pointVO.getPointId()==0){
			query.setParameter("ptGoodsId", pointVO.getGoodsId());
			query.setParameter("ptSize", pointVO.getSizeId());
			query.setParameter("ptColor", pointVO.getColorId());
			query.setParameter("ptStatus",0);
		}
		int update = query.executeUpdate();
		
		System.out.println(pointVO);
		return update;
	}
	
	

}
