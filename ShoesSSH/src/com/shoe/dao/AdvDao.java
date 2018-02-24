package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Advertisement;

/**
 * 
 * add by qyh 2018��1��11��
 * 
 * ������ģ�Ͳ�ӿ�
 *
 */
public interface AdvDao {
	/**
	 * add by qyh 2018��1��11��
	 * 
	 * ��ȡ�����Ϣ
	 * @return ����װ��ʵ����ļ���
	 */
	public List<Advertisement> getAdvPageList(int currentPage, int pageSize) throws Exception;
	
	/**
	 * ��ȡ����������
	 * add by qyh 2018��1��11��
	 * @return long�͹���������
	 * @throws Exception
	 */
	public long getAdvCount() throws Exception;
	
	/**
	 * �������
	 * add by qyh 2018��1��12��
	 * @param adv ���������
	 * @throws Exception
	 */
	public void saveAdv(Advertisement adv) throws Exception;
	
	/**
	 * ����ɾ�����
	 * add by qyh 2018��1��12��
	 * @param advIds Ҫɾ���Ĺ��Id
	 * @throws Exception
	 */
	public void deleteAdvByIds(List<Integer> advIds) throws Exception;
}














