package com.shoe.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.MenuDao;
import com.shoe.pojo.Menu;
/**
 * 菜单Service层实现
 * @gx
 * add by 2018-1-11
 */
@Service
@Transactional
public class MenuServiceImpl  implements MenuService {
	
	@Resource
	private MenuDao menuDao;


	/**
	 * 根据当前角色级别,获取菜单权限树
	 * @param roleId 角色Id
	 */
	@Override
	public List<Menu> getRolePermissionMenu(int roleId) {
		// TODO Auto-generated method stub
		List<Menu> menus = new ArrayList<Menu>();
		try {
			 menus = menuDao.getRolePermissionMenu(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}
	
}
