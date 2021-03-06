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
 * add by wyh 2018年1月11
 * 商品模块
 *
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {
	
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	/**
	 * 查询商品表中总行数
	 * add by qyh 2018年1月19日 下午5:15:41
	 * 
	 * @return 返回商品总数量
	 * @throws Exception
	 */
	@Override
	public long getCount() throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		//获得数量HQL
		String hql ="select count(*) from Goods g where g.goodsDel=1";
		Query<Long> query = session.createQuery(hql);		
		//返回查询结果
		return query.getSingleResult();
	}

	/**
	 * 获取商品表信息
	 * add by qyh 2018年1月19日 下午5:16:23
	 * 
	 * @param currentPage 当前页
	 * @param pageSize 每页行数
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Goods> getGoodsInfo(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得商品信息HQL
		//String hql ="from Goods g left join fetch g.type t left join fetch g.brand b";
		String hql ="from Goods where goodsDel = 1 order by goodsId";
		Query<Goods> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Goods> goodList = query.getResultList(); 
		//返回查询结果
		return goodList;
	}
	
	/**
	 * 增加商品信息
	 * add by qyh 2018年1月17日 下午2:36:59
	 * 
	 * @param goods 新增商品数据
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
	 * 获取商品颜色数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Color> getColor() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得商品信息HQL
		String hql ="from Color";
		Query<Color> query = session.createQuery(hql);
		List<Color> colorList = query.getResultList(); 
		for(Color cs: colorList){
			System.out.println(cs);
		}
		//返回查询结果
		return colorList;
	}
	
	/**
	 * 获取商品尺寸数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Size> getSize() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得商品信息HQL
		String hql ="from Size";
		Query<Size> query = session.createQuery(hql);
		List<Size> colorList = query.getResultList(); 
		//返回查询结果
		return colorList;
	}
	
	/**
	 * 根据商品id获取库存信息
	 * add by qyh 2018年1月18日 下午7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Stock> getStockInfoByGoodsid(int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得商品信息HQL
		String hql ="from Stock where goodsId = :goodsId";
		Query<Stock> query = session.createQuery(hql);
		query.setParameter("goodsId", goodsId);
		List<Stock> stockList = query.getResultList(); 
		//返回查询结果
		return stockList;
	}
	
	/**
	 * 修改商品时，删除指定商品副图
	 * add by qyh 2018年1月19日 下午5:17:54
	 * 
	 * @param imgId 要删除的商品图片id
	 * @throws Exception
	 */
	@Override
	public void deleteImgByImgid(int imgId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Img where imgId = :imgId";
		session.createQuery(hql).setParameter("imgId", imgId).executeUpdate();
	}
	
	/**
	 * 修改商品信息
	 * add by qyh 2018年1月19日 下午5:19:36
	 * 
	 * @param goods 修改后的商品数据
	 * @throws Exception
	 */
	@Override
	public void updateGoods(Goods goods) throws Exception {
		String sql = "";
		Session session = sessionFactory.getCurrentSession();
		//判断商品主图是否被修改
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
		//执行修改
		Query.executeUpdate();
	}
	
	/**
	 * 根据商品id删除该商品下的库存信息
	 * add by qyh 2018年1月19日 下午5:20:10
	 * 
	 * @param goodsId 商品id
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
	 * 增加库存
	 * add by qyh 2018年1月19日 下午5:21:12
	 * 
	 * @param stocks 库存数据
	 * @param goodsId 该库存所属的商品id
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
	 * 添加图片
	 * add by qyh 2018年1月19日 下午5:22:03
	 * 
	 * @param imgs 图片数据
	 * @param goodsId 该图片所属的商品id
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
	 * 删除指定的商品,根据商品id
	 * add by qyh 2018年1月19日 下午5:22:40
	 * 
	 * @param goodsIds 要删除的商品的id集合
	 * @throws Exception
	 */
	@Override
	public void deleteGoodById(List<Integer> goodsIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql = "update t_goods set goods_del=0 where goods_id=?";
		NativeQuery Query = session.createNativeQuery(sql);
		//循环修改商品是否删除信息
		for(Integer ids:goodsIds){
			Query.setParameter(1, ids);
			Query.executeUpdate();
		}
	}
	
	/**
	 * 要删除的图片
	 * add by qyh 2018年1月19日 下午5:23:27
	 * 
	 * @param goodsIds 要删除的图片所属的商品id
	 * @throws Exception
	 */
	@Override
	public void deleteImgs(List<Integer> goodsIds) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Img where goodsId in (:goodsIds)";
		session.createQuery(hql).setParameter("goodsIds", goodsIds).executeUpdate();
		
	}
	
	/**
	 * 删除库存
	 * add by qyh 2018年1月19日 下午5:27:42
	 * 
	 * @param goodsIds 要删除的库存所属的商品  id集合
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
	 * 删除类型时  修改相关商品的类型
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
	 * 删除品牌时  修改相关商品的品牌
	 */
	@Override
	public void updateGoodsBrand(List<Integer> brandId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update from GoodsTwo g set g.brandId=0 where g.brandId in (:brandIds)";
		session.createQuery(hql).setParameter("brandIds", brandId).executeUpdate();
		
	}


}