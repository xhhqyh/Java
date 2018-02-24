package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.AdvDao;
import com.shoe.dao.CooperDao;
import com.shoe.pojo.Advertisement;
import com.shoe.pojo.Cooperation;

/**
 * 商务合作服务层实现类
 * add by qyh 2018年1月12日 下午8:46:50
 *
 */
@Service  
@Transactional
public class CooperServiceImpl implements CooperService{
	
	@Resource 
	private CooperDao cooperDao;

	/**
	 * add by qyh 2018年1月12日 下午8:46:50
	 * 
	 * 获取商务合作信息
	 * @return 商务合作封装的实体类的集合
	 */
	@Override
	public Map<String, Object> getCooperPageList(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long cooperCount = cooperDao.getCooperCount();
			List<Cooperation> cooperList = cooperDao.getCooperPageList(currentPage, pageSize);
			data.put("total", cooperCount);
			data.put("rows", cooperList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 新增或修改商务合作
	 * add by qyh 2018年1月12日 下午8:46:50
	 * @param cooper 商务合作具体参数
	 * @throws Exception
	 */
	@Override
	public boolean saveCooper(Cooperation cooper) {
		boolean isOk = true;
		try {
			cooperDao.saveCooper(cooper);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}

	/**
	 * 批量删除商务合作
	 * add by qyh 2018年1月12日 下午8:46:50
	 * @param cooperIds 要删除的商务合作Id
	 * @return
	 */
	@Override
	public boolean deleteCooperByIds(List<Integer> cooperIds) {
		boolean isOk = true;
		try {
			cooperDao.deleteCooperByIds(cooperIds);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}

}
