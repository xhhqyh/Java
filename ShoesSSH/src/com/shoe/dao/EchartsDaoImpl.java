package com.shoe.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.shoe.pojo.EchartsSex;

/**
 * 
 * add by wyh 2018��1��17<p>
 * �������ݲ�ӿ�ʵ����
 *
 */
@Repository
public class EchartsDaoImpl implements EchartsDao {

	/**
	 * ��Spring����ע��һ��sessionfactory
	 */
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by wyh 2018��1��17
	 * ����  ��Ь �·�   ����
	 */
	@Override
	public List<EchartsSex> getEchsrtSex() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		//hql���
		String hql ="select new com.shoe.pojo.EchartsSex(to_char(g.goodsDate,'mm'),g.goodsStyle,sum(g.goodsSnumber)) from GoodsTwo g group by to_char(g.goodsDate,'mm'),g.goodsStyle having g.goodsStyle =0 order by to_char(g.goodsDate,'mm')";
		Query<EchartsSex> query = session.createQuery(hql);
		List<EchartsSex> echarts = query.getResultList();		
		return echarts;
	}
	/**
	 * add by wyh 2018��1��18
	 * ����  ŮЬ �·�   ����
	 */
	@Override
	public List<EchartsSex> getEchsrtSexWomen() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		//hql���
		String hql ="select new com.shoe.pojo.EchartsSex(to_char(g.goodsDate,'mm'),g.goodsStyle,sum(g.goodsSnumber)) from GoodsTwo g group by to_char(g.goodsDate,'mm'),g.goodsStyle having g.goodsStyle =1 order by to_char(g.goodsDate,'mm')";
		Query<EchartsSex> query = session.createQuery(hql);
		List<EchartsSex> echarts = query.getResultList();		
		return echarts;
	}
	/**
	 * add by wyh 2018��1��18
	 * ���� X ������
	 */
	@Override
	public List<EchartsSex> getEchsrtLengd() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		//hql���
		String hql ="select new com.shoe.pojo.EchartsSex(to_char(g.goodsDate,'mm'),sum(g.goodsSnumber)) from GoodsTwo g group by to_char(g.goodsDate,'mm') order by to_char(g.goodsDate,'mm')";
		Query<EchartsSex> query = session.createQuery(hql);
		List<EchartsSex> echarts = query.getResultList();		
		return echarts;
	}
	/**
	 * 	  
	 *  �����·�����ѯ�������Ь����Ϣ	
	 */
	@Override
	public List<EchartsSex> getEchsrtType(String month) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		//hql���
		String hql ="select new com.shoe.pojo.EchartsSex(to_char(g.goodsDate,'mm'),p.typeName,sum(g.goodsSnumber)) from Goods g left join g.type p  group by to_char(g.goodsDate,'mm'),p.typeName having to_char(g.goodsDate,'mm') = :month order by to_char(g.goodsDate,'mm')";
		Query<EchartsSex> query = session.createQuery(hql);
		query.setParameter("month",month);
		List<EchartsSex> echarts = query.getResultList();		
		return echarts;
	}

	
}
