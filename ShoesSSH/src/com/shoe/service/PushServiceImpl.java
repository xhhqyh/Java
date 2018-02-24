package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.PushDao;
import com.shoe.pojo.Push;
import com.shoe.pojo.Type;

/**
 * ���͹�������
 * add by zrh 2018��1��15�� ����9:37:52
 *
 */
@Service
@Transactional
public class PushServiceImpl implements PushService {
	@Resource
	private PushDao pushDao;
	/**
	 * �����б�
	 */
	@Override
	public Map<String, Object> getPushList(int currnetPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		// ��ȡ������
		try {
			long typeCount = pushDao.getPushCount();
			// ��ȡ��ѯ������
			List<Push> typeList = pushDao.getPushList(currnetPage, pageSize);
			data.put("total", typeCount);
			data.put("rows", typeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * ɾ��
	 */
	@Override
	public Boolean deletePushList(List<Integer> pushIds) {
		boolean isOk = true;
		try {
			pushDao.deletePushIds(pushIds);
		} catch (Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}
	
	/**
	 * ���
	 */
	@Override
	public Boolean addPush(Push push) {
		boolean isOk = true;
		try {
			pushDao.addPush(push);
		} catch (Exception e) {
			isOk = false;
		}
		return isOk;
	}

}
