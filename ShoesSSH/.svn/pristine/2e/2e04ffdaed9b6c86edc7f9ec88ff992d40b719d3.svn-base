package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Img;

/**
 * 商品图片数据层接口实现类
 * add by wyh 2018年1月13
 *
 *
 */
@Repository
public class ImgDaoImpl implements ImgDao {

	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory; 
	
	/**
	 * 根据商品Id查出图片
	 */
	@Override
	public List<Img> getImgs(int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//获得数量HQL
		String hql ="from Img where goodsId =? ";
		Query<Img> query = session.createQuery(hql);
		query.setParameter(0,goodsId);
		List<Img> imgList = query.getResultList();
		//返回查询结果
		return imgList;
	}

}
