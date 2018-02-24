package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.AdvDao;
import com.shoe.pojo.Advertisement;

/**
 * 
 * add by qyh 2018年1月11日
 *
 * 广告管理服务层
 */
@Service  
@Transactional
public class AdvServiceImpl implements AdvService{
	@Resource 
	private AdvDao advDao;

	/**
	 * add by qyh 2018年1月11日
	 * 
	 * 获取广告信息
	 * @return 广告封装的实体类的集合
	 */
	@Override
	public Map<String, Object> getAdvPageList(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long advCount = advDao.getAdvCount();
			List<Advertisement> advList = advDao.getAdvPageList(currentPage, pageSize);
			data.put("total", advCount);
			data.put("rows", advList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 新增或修改广告
	 * add by qyh 2018年1月12日
	 * @param adv 广告具体参数
	 * @throws Exception
	 */
	@Override
	public boolean saveAdv(Advertisement adv) {
		boolean isOk = true;
		try {
			advDao.saveAdv(adv);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}

	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @param advIds 要删除的广告Id
	 * @return
	 */
	@Override
	public boolean deleteAdvByIds(List<Integer> advIds) {
		boolean isOk = true;
		try {
			advDao.deleteAdvByIds(advIds);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}

}











