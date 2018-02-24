package com.shoe.service;

import java.util.Map;

/**
 * <p>��������
 * @author ����
 *
 */
public interface OrderService {
	/**
	 * <p>��ѯȫ������
	 * @param currentPage ��ǰҳ��
	 * @param pageSize ҳ����
	 * @return Map
	 */
	Map<String,Object> getReserve(int currentPage, int pageSize);
	/**
	 * <p>�޸Ķ�����Ϣ
	 * @param ids ���޸ĵĶ���
	 * @param status ���ı��״̬
	 * @return ��� isok �����true,��ʾ����,���false,�Ͳ�����
	 */
	Object updateOrder(Integer[] ids, Integer status);
	/**
	 * <p>������ѯ�����Ĵ���<p>
	 * add by liyang 2018��1��15�� ����9:19:15
	 * 
	 * @param currentPage ��ǰҳ��
	 * @param pageSize ҳ����
	 * @param status ����ѯ��״̬
	 * @return ����map��,����ֱ�ӷ�װ��easyUI�Ĳ���
	 */
	Map<String, Object> getSomeOrder(int currentPage, int pageSize, int status);
	/**
	 *  ������ѯ<p>
	 * add by liyang 2018��1��20�� ����4:15:50
	 * 
	 * @param order
	 * @return
	 */
	Map<String, Object> getSomeOrder(String order);
}