package com.shoe.service;

import java.util.Map;

import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;

public interface PointService {
	/**
	 * �鿴������ɱ��Ʒ<p>
	 * add by liyang 2018��1��15�� ����5:02:09
	 * @param currentPage
	 * @param pageSize
	 * @param statuss 
	 * @return
	 */
	Map<String, Object> getPointShop(Integer currentPage, Integer pageSize, Integer statuss);
	/**
	 * �޸���Ʒ��Ϣ<p>
	 * add by liyang 2018��1��17�� ����11:21:18
	 * 
	 * @param status ״̬
	 * @param id 
	 * @return
	 */
	boolean updateStatus(Integer status, Integer id);
	/**
	 * ɾ��������ɱ��Ʒ
	 * add by liyang 2018��1��17�� ����4:14:33
	 * 
	 * @param ids[]
	 * @return
	 */
	Object deletePointByIds(Integer[] ids);
	/**
	 * ��ߴ��
	 * add by liyang 2018��1��18�� ����5:07:26
	 * 
	 * @return
	 */
	Object getSize();
	/**
	 * ����ɫ��
	 * add by liyang 2018��1��18�� ����5:07:46
	 * 
	 * @return
	 */
	Object getColor();
	/**
	 * ����Ʒ������ID
	 * add by liyang 2018��1��19�� ����11:24:31
	 * 
	 * @return
	 */
	Object getGoods();
	
	/**
	 * ���ӻ��޸�
	 * add by liyang 2018��1��19�� ����2:50:07
	 * 
	 * @param pointVO
	 * @return
	 */
	Object saveOrUpdate(PointVo pointVO);
	
}
