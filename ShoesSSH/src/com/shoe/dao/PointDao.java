package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;
import com.shoe.pojo.Size;
/**
 * <p>���������ɱ��Ʒ
 * @author ����
 *
 */
public interface PointDao {
	/**
	 * �鿴������ɱ��Ʒ����
	 * add by liyang 2018��1��15�� ����4:15:31
	 * 
	 * @return count,���ػ�����ɱ��Ʒ����
	 * @throws Exception
	 */
	Long getPointGoodsCount() throws Exception; 
	/**
	 * �鿴ȫ��������Ʒ,
	 * add by liyang 2018��1��15�� ����4:25:49
	 * @param pageSize 
	 * @param currentPage 
	 * @param statuss 
	 * 
	 * @return ����ȫ��������ɱ��Ʒ
	 * @throws Exception
	 */
	List<PointShop> getPointGoods(Integer currentPage, Integer pageSize, Integer statuss) throws Exception;
	/**
	 * �޸�
	 * add by liyang 2018��1��17�� ����11:23:38
	 * 
	 * @param status
	 * @param id 
	 * @return
	 */
	int updateStatus(Integer status, Integer id) throws Exception ;
	/**
	 * ɾ��
	 * add by liyang 2018��1��17�� ����4:23:25
	 *
	 */
	int deletePointByIds(Integer[] ids) throws Exception;
	/**
	 * ��ѯ�ߴ�
	 * add by liyang 2018��1��18�� ����7:33:02
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	List<Size> getSize(int i) throws Exception;
	/**
	 * ��ѯ��ɫ��
	 * add by liyang 2018��1��18�� ����7:33:47
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	List<Color> getColor(int i) throws Exception;
	/**
	 * �鿴��Ʒ��
	 * add by liyang 2018��1��19�� ����11:28:06
	 * 
	 * @return
	 */
	List<Goods> getGoods() throws Exception;
	/**
	 * ���ӻ��޸�
	 * add by liyang 2018��1��19�� ����2:51:29
	 * 
	 * @param pointVO
	 * @throws Exception
	 */
	int saveOrUpdate(PointVo pointVO) throws Exception;
}
