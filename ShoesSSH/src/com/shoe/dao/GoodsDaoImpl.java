package com.shoe.dao;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.ColorSize;
import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.GoodsTwo;
import com.shoe.pojo.Img;
import com.shoe.pojo.Size;
import com.shoe.pojo.Stock;

/**
 * 
 * add by wyh 2018��1��11
 * ��Ʒģ��
 *
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {
	
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	/**
	 * ��ѯ��Ʒ����������
	 * add by qyh 2018��1��19�� ����5:15:41
	 * 
	 * @return ������Ʒ������
	 * @throws Exception
	 */
	@Override
	public long getCount() throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		//�������HQL
		String hql ="select count(*) from Goods g where g.goodsDel=1";
		Query<Long> query = session.createQuery(hql);		
		//���ز�ѯ���
		return query.getSingleResult();
	}

	/**
	 * ��ȡ��Ʒ����Ϣ
	 * add by qyh 2018��1��19�� ����5:16:23
	 * 
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ����
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Goods> getGoodsInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�����Ʒ��ϢHQL
		//String hql ="from Goods g left join fetch g.type t left join fetch g.brand b";
		String hql ="from Goods where goodsDel = 1 order by goodsId";
		Query<Goods> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Goods> goodList = query.getResultList(); 
		//���ز�ѯ���
		return goodList;
	}
	
	/**
	 * ������Ʒ��Ϣ
	 * add by qyh 2018��1��17�� ����2:36:59
	 * 
	 * @param goods ������Ʒ����
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer saveGoods(Goods goods) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(goods);
		return goods.getGoodsId();
	}

	/**
	 * ��ȡ��Ʒ��ɫ����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Color> getColor() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�����Ʒ��ϢHQL
		String hql ="from Color";
		Query<Color> query = session.createQuery(hql);
		List<Color> colorList = query.getResultList(); 
		for(Color cs: colorList){
			System.out.println(cs);
		}
		//���ز�ѯ���
		return colorList;
	}
	
	/**
	 * ��ȡ��Ʒ�ߴ�����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Size> getSize() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�����Ʒ��ϢHQL
		String hql ="from Size";
		Query<Size> query = session.createQuery(hql);
		List<Size> colorList = query.getResultList(); 
		//���ز�ѯ���
		return colorList;
	}
	
	/**
	 * ������Ʒid��ȡ�����Ϣ
	 * add by qyh 2018��1��18�� ����7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Stock> getStockInfoByGoodsid(int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�����Ʒ��ϢHQL
		String hql ="from Stock where goodsId = :goodsId";
		Query<Stock> query = session.createQuery(hql);
		query.setParameter("goodsId", goodsId);
		List<Stock> stockList = query.getResultList(); 
		//���ز�ѯ���
		return stockList;
	}
	
	/**
	 * �޸���Ʒʱ��ɾ��ָ����Ʒ��ͼ
	 * add by qyh 2018��1��19�� ����5:17:54
	 * 
	 * @param imgId Ҫɾ������ƷͼƬid
	 * @throws Exception
	 */
	@Override
	public void deleteImgByImgid(int imgId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Img where imgId = :imgId";
		session.createQuery(hql).setParameter("imgId", imgId).executeUpdate();
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * add by qyh 2018��1��19�� ����5:19:36
	 * 
	 * @param goods �޸ĺ����Ʒ����
	 * @throws Exception
	 */
	@Override
	public void updateGoods(Goods goods) throws Exception {
		String sql = "";
		Session session = sessionFactory.getCurrentSession();
		//�ж���Ʒ��ͼ�Ƿ��޸�
		if(goods.getGoodsImgUrl() != null){
			sql = "update t_goods set type_id=?,brand_id=?,goods_no=?,goods_name=?,goods_newprice=?,goods_oldprice=?,goods_date=?,goods_producer=?,goods_style=?,goods_informantion=?,goods_snumber=?,goods_discount=?,goods_point=?,goods_status=?,goods_imgurl=? where goods_id=?";
		}else{
			sql = "update t_goods set type_id=?,brand_id=?,goods_no=?,goods_name=?,goods_newprice=?,goods_oldprice=?,goods_date=?,goods_producer=?,goods_style=?,goods_informantion=?,goods_snumber=?,goods_discount=?,goods_point=?,goods_status=? where goods_id=?";
		}
		int i=1;
		NativeQuery Query = session.createNativeQuery(sql);
		Query.setParameter(i++, goods.getType().getTypeId());
		Query.setParameter(i++, goods.getBrand().getBrandId());
		Query.setParameter(i++, goods.getGoodsNo());
		Query.setParameter(i++, goods.getGoodsName());
		Query.setParameter(i++, goods.getGoodsNewPrice());
		Query.setParameter(i++, goods.getGoodsOldPrice());
		Query.setParameter(i++, goods.getGoodsDate());
		Query.setParameter(i++, goods.getGoodsProducer());
		Query.setParameter(i++, goods.getGoodsStyle());
		Query.setParameter(i++, goods.getGoodsInformation());
		Query.setParameter(i++, goods.getGoodsSnumber());
		Query.setParameter(i++, goods.getGoodsDiscount());
		Query.setParameter(i++, goods.getGoodsPoint());
		Query.setParameter(i++, goods.getGoodsStatus());
		if(goods.getGoodsImgUrl() != null){
			Query.setParameter(i++, goods.getGoodsImgUrl());
		}
		Query.setParameter(i++, goods.getGoodsId());
		//ִ���޸�
		Query.executeUpdate();
	}
	
	/**
	 * ������Ʒidɾ������Ʒ�µĿ����Ϣ
	 * add by qyh 2018��1��19�� ����5:20:10
	 * 
	 * @param goodsId ��Ʒid
	 * @throws Exception
	 */
	@Override
	public void deleteStockByGoodsId(int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql="delete t_stock where goods_id = ?";
		NativeQuery createNativeQuery = session.createNativeQuery(sql);
		createNativeQuery.setParameter(1,goodsId);
		createNativeQuery.executeUpdate();
	}
	
	/**
	 * ���ӿ��
	 * add by qyh 2018��1��19�� ����5:21:12
	 * 
	 * @param stocks �������
	 * @param goodsId �ÿ����������Ʒid
	 * @throws Exception
	 */
	@Override
	public void addStock(Set<Stock> stocks, int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql="insert into t_stock(stock_id,goods_id,size_name,stock_num,color_name) values(stock_seq.nextval,?,?,?,?)";			
		NativeQuery createNativeQuery = session.createNativeQuery(sql);
		for(Stock s:stocks){
			createNativeQuery.setParameter(1,goodsId);		
			createNativeQuery.setParameter(2,s.getSizeName());
			createNativeQuery.setParameter(3,s.getStockNum());
			createNativeQuery.setParameter(4,s.getColorName());
			createNativeQuery.executeUpdate();
		}
	}
	
	/**
	 * ����ͼƬ
	 * add by qyh 2018��1��19�� ����5:22:03
	 * 
	 * @param imgs ͼƬ����
	 * @param goodsId ��ͼƬ��������Ʒid
	 * @throws Exception
	 */
	@Override
	public void addImgs(Set<Img> imgs, int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql="insert into t_img(img_id,goods_id,img_url) values(img_seq.nextval,?,?)";			
		NativeQuery createNativeQuery = session.createNativeQuery(sql);
		for(Img img:imgs){
			createNativeQuery.setParameter(1,goodsId);		
			createNativeQuery.setParameter(2,img.getImgUrl());
			createNativeQuery.executeUpdate();
		}
	}
	
	/**
	 * ɾ��ָ������Ʒ,������Ʒid
	 * add by qyh 2018��1��19�� ����5:22:40
	 * 
	 * @param goodsIds Ҫɾ������Ʒ��id����
	 * @throws Exception
	 */
	@Override
	public void deleteGoodById(List<Integer> goodsIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql = "update t_goods set goods_del=0 where goods_id=?";
		NativeQuery Query = session.createNativeQuery(sql);
		//ѭ���޸���Ʒ�Ƿ�ɾ����Ϣ
		for(Integer ids:goodsIds){
			Query.setParameter(1, ids);
			Query.executeUpdate();
		}
	}
	
	/**
	 * Ҫɾ����ͼƬ
	 * add by qyh 2018��1��19�� ����5:23:27
	 * 
	 * @param goodsIds Ҫɾ����ͼƬ��������Ʒid
	 * @throws Exception
	 */
	@Override
	public void deleteImgs(List<Integer> goodsIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Img where goodsId in (:goodsIds)";
		session.createQuery(hql).setParameter("goodsIds", goodsIds).executeUpdate();
		
	}
	
	/**
	 * ɾ�����
	 * add by qyh 2018��1��19�� ����5:27:42
	 * 
	 * @param goodsIds Ҫɾ���Ŀ����������Ʒ  id����
	 * @throws Exception
	 */
	public void deleteStock(List<Integer> goodsIds) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Stock where goodsId in (:goodsIds)";
		session.createQuery(hql).setParameter("goodsIds", goodsIds).executeUpdate();
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
		String hql = "update from GoodsTwo g set g.typeId=0 where g.typeId in (:typeIds)";
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
		String hql = "update from GoodsTwo g set g.brandId=0 where g.brandId in (:brandIds)";
		session.createQuery(hql).setParameter("brandIds", brandId).executeUpdate();
		
	}


}