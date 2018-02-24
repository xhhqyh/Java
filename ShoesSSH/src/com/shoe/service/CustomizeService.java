package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;
/**
 * ����Ь ҵ���
 * add by zrh 2018��1��17�� ����11:24:18
 *
 */
public interface CustomizeService {
	/**
	 * ����Ь�б�
	 * add by zrh 2018��1��17�� ����11:24:36
	 *
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> getCustomizeList(int currentPage, int pageSize,String customizeCards);
	
	/**
	 * ��Ӷ���Ь
	 * add by zrh 2018��1��17�� ����4:10:08
	 *
	 * @param customize
	 * @return
	 */
	public boolean addCustomize(Customize customize);
	
	/**
	 * ɾ������Ь
	 * add by zrh 2018��1��17�� ����4:11:05
	 *
	 * @param customizeIds
	 * @return
	 */
	public boolean deleteCustomize(List<Integer> customizeIds);
	
	/**
	 * ��ѯЬ�ӳߴ�
	 * add by zrh 2018��1��18�� ����4:03:49
	 *
	 * @return
	 */
	public List<Size> getSizeName();
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * ɾ������ʱ  �޸������Ʒ������
	 */
	public boolean updateGoodsType(List<Integer> typeId);
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * ɾ��Ʒ��ʱ  �޸������Ʒ��Ʒ��
	 */
	public boolean updateGoodsBrand(List<Integer> brandId);
	
}
