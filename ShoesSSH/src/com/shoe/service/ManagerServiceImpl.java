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
 * 管理员管理Service实现层
 * @gx
 * update by gx 2018-1-12
 */

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private ManagerDao managerDao;
	
	/**
	 * 获取登录信息
	 * @return 返回manager对象
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
	 * 添加管理员
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
	 * 获取管理员信息
	 * @return 管理员封装的实体类的集合
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
	 * 删除管理员
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
	 * 修改角色名未有的管理员
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
