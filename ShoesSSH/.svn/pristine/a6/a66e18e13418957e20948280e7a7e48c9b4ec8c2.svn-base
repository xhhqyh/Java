package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Menu;
/**
 * 菜单Dao层实现
 * @gx
 * add by 2018-1-11
 * @param roleId 角色ID
 */
@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	
	/**
	 * 根据角色ID权限获取角色权限树
	 */
	public List<Menu> getRolePermissionMenu(int roleId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select t2.menu_id, t2.menu_name, t2.menu_pid, t2.menu_url from t_role_menu t1 join t_menu t2 on t1.menu_id = t2.menu_id where t1.role_id = ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, roleId);
		List<Object[]> menuList = query.list();
		List<Menu> menus = new ArrayList<>();
		for(Object[] objects : menuList){
			Menu menu = new Menu();
			Integer menuId = Integer.parseInt(objects[0].toString());
			menu.setMenuId(menuId);
			menu.setMenuName((String) objects[1]);
			Integer menuPid = Integer.parseInt(objects[2].toString());
			menu.setMenuPid(menuPid);
			menu.setMenuUrl((String) objects[3]);	
			menus.add(menu);
		}
		return menus;
	}
}
