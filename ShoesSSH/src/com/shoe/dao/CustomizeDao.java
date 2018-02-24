package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;

/**
 * ����Ь 
 * add by zrh 2018��1��17�� ����11:07:19
 *  �־ò�
 */
public interface CustomizeDao {
	/**
	 * ��ѯ������
	 * add by zrh 2018��1��17�� ����11:10:31
	 *
	 * @throws Exception
	 */
	public long getCount() throws Exception;
	
	/**
	 * ����Ь��Ϣ
	 * add by zrh 2018��1��17�� ����11:10:45
	 *
	 * @param curentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Customize> getCustomizeInfo(int currentPage,int pageSize,String customizeCards) throws Exception;
	
	/**
	 * ���ӻ��޸Ķ���Ь
	 * add by zrh 2018��1��17�� ����11:12:13
	 *
	 * @param customize
	 * @throws Exception
	 */
	public void addCustomize(Customize customize)throws Exception;
	
	/**
	 * ɾ��
	 * add by zrh 2018��1��17�� ����3:50:27
	 *
	 * @param customizeIds
	 * @throws Exception
	 */
	public void deleteCustomize(List<Integer> customizeIds) throws Exception;
	
	/**
	 * ��ѯЬ�ӳߴ�
	 * add by zrh 2018��1��18�� ����3:58:12
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize() throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * @throws Exception
	 * ɾ������ʱ  �޸���ض�����Ʒ������
	 */
	public void updateGoodsType(List<Integer> typeId) throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * @throws Exception
	 * ɾ��Ʒ��ʱ  �޸���ض�����Ʒ��Ʒ��
	 */
	public void updateGoodsBrand(List<Integer> brandId) throws Exception;
	
}