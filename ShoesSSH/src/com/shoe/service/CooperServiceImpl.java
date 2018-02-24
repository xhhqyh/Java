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
 * ������������ʵ����
 * add by qyh 2018��1��12�� ����8:46:50
 *
 */
@Service  
@Transactional
public class CooperServiceImpl implements CooperService{
	
	@Resource 
	private CooperDao cooperDao;

	/**
	 * add by qyh 2018��1��12�� ����8:46:50
	 * 
	 * ��ȡ���������Ϣ
	 * @return ���������װ��ʵ����ļ���
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
	 * �������޸��������
	 * add by qyh 2018��1��12�� ����8:46:50
	 * @param cooper ��������������
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
	 * ����ɾ���������
	 * add by qyh 2018��1��12�� ����8:46:50
	 * @param cooperIds Ҫɾ�����������Id
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
