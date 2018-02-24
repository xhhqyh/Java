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
 * add by qyh 2018��1��11��
 *
 * ����������
 */
@Service  
@Transactional
public class AdvServiceImpl implements AdvService{
	@Resource 
	private AdvDao advDao;

	/**
	 * add by qyh 2018��1��11��
	 * 
	 * ��ȡ�����Ϣ
	 * @return ����װ��ʵ����ļ���
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
	 * �������޸Ĺ��
	 * add by qyh 2018��1��12��
	 * @param adv ���������
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
	 * ����ɾ�����
	 * add by qyh 2018��1��12��
	 * @param advIds Ҫɾ���Ĺ��Id
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











