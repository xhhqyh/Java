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
 * 推送管理服务层
 * add by zrh 2018年1月15日 上午9:37:52
 *
 */
@Service
@Transactional
public class PushServiceImpl implements PushService {
	@Resource
	private PushDao pushDao;
	/**
	 * 推送列表
	 */
	@Override
	public Map<String, Object> getPushList(int currnetPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 获取总数量
		try {
			long typeCount = pushDao.getPushCount();
			// 获取查询的数据
			List<Push> typeList = pushDao.getPushList(currnetPage, pageSize);
			data.put("total", typeCount);
			data.put("rows", typeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 删除
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
	 * 添加
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
