package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Push;

/**
 * ���͹���
 * add by zrh 2018��1��15�� ����9:33:53
 *
 */
public interface PushService {
	/**
	 * ������������Ϣ
	 * add by zrh 2018��1��15�� ����9:36:17
	 *
	 * @param currnetPage
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> getPushList(int currnetPage,int pageSize);
	
	/**
	 * ɾ��
	 * add by zrh 2018��1��15�� ����3:08:43
	 *
	 * @param pushIds
	 * @return
	 */
	public Boolean deletePushList(List<Integer> pushIds);
	
	/**
	 * ��ӻ��޸�
	 * add by zrh 2018��1��15�� ����3:08:52
	 *
	 * @param push
	 * @return
	 */
	public Boolean addPush(Push push);
}
