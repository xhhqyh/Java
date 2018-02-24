package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Img;

/**
 * ��ƷͼƬ���ݲ�ӿ�ʵ����
 * add by wyh 2018��1��13
 *
 *
 */
@Repository
public class ImgDaoImpl implements ImgDao {

	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory; 
	
	/**
	 * ������ƷId���ͼƬ
	 */
	@Override
	public List<Img> getImgs(int goodsId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//�������HQL
		String hql ="from Img where goodsId =? ";
		Query<Img> query = session.createQuery(hql);
		query.setParameter(0,goodsId);
		List<Img> imgList = query.getResultList();
		//���ز�ѯ���
		return imgList;
	}

}
