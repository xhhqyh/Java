package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.ManagerDao;
import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;
/**
 * ����Ա����Serviceʵ�ֲ�
 * @gx
 * update by gx 2018-1-12
 */

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private ManagerDao managerDao;
	
	/**
	 * ��ȡ��¼��Ϣ
	 * @return ����manager����
	 * add by gx 2018-1-11
	 */
	@Override
	public List<Manager> loginManager(Manager manager) {
		List<Manager> managerList=null;
		try {
			managerList =  managerDao.loginManager(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return managerList;
		
	}
	/**
	 * ���ӹ���Ա
	 * add by gx 2018-1-11
	 */
	@Override
	public boolean addManager(ManagerVO managerVO) {
		// TODO Auto-generated method stub
		boolean isOk = true;
		try {
			managerDao.addManager(managerVO);
		} catch (Exception e) {
			// TODO: handle exception
			isOk = false;
		}
		return isOk;
	}

	/**
	 * ��ȡ����Ա��Ϣ
	 * @return ����Ա��װ��ʵ����ļ���
	 * add by gx 2018-1-11
	 * 
	 */
	@Override
	public Map<String, Object> getManagerPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long managerCount = managerDao.getManagerCount();
			List<Manager> managerList = managerDao.getManagerPage(currentPage, pageSize);
			data.put("total", managerCount);
			data.put("rows", managerList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * ɾ������Ա
	 * add by gx 2018-1-11
	 */
	@Override
	public boolean deleteManager(List<Integer> managerIds) {
		// TODO Auto-generated method stub
		boolean isOk = true;
		try {
			managerDao.deleteManager(managerIds);
		} catch (Exception e) {
			// TODO: handle exception
			isOk = false;
		}
		return isOk;
	}
	/**
	 * add by wyh 2018-1-22
	 * �޸Ľ�ɫ��δ�еĹ���Ա
	 */
	@Override
	public boolean updateManager(List<Integer> roleId) {
		boolean isOk = true;
		try {
			managerDao.updateManger(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		}		
		return isOk;
	}
}