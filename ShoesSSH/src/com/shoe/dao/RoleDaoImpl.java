package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Role;

import net.sf.json.JSONArray;

import com.shoe.dao.RoleDao;
/**
 * 管理员角色信息管理Dao实现层
 * @gx
 * add by 2018-1-11
 * 
 */
@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	
	/**
	 * 从数据库获取角色总条数
	 * 
	 */
	public long getRoleCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Role";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}

	/**
	 * 获取所有角色信息
	 * @return roles List<Role> 返回一个存储所有角色信息的List集合
	 */
	public List<Role> getAllRole() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role r where r.roleId>0";
		Query<Role> query = session.createQuery(hql);
		List<Role> roles = query.getResultList();
		return roles;//返回一个存储所有角色信息的List集合
 	}
	
	
	/**
	 * 获取当前页的管理员信息
	 * @param currentPage 当前页
	 * @param pageSize 页面数据条数
	 * @return roles List<Role> 返回一个存储所有角色信息的List集合
	 */
	public List<Role> getRolePage(int currentPage,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role r where r.roleId>0";
		Query<Role> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Role> roles = query.getResultList();
		return roles;//返回一个存储当前页面角色信息的List集合
	}

	/**
	 * 添加或修改角色
	 */
	@Override
	public void addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}

	
	/**
	 * 删除角色
	 * @param roleIds List<Integer> 角色Id的集合
	 */
	@Override
	public void deleteRole(List<Integer> roleIds) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql="delete from Role where roleId in (:roleIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("roleIds",roleIds).executeUpdate();	
	}

	/**
	 * 获取角色的权限
	 * @param roleId 角色ID
	 */
	@Override
	public JSONArray getRolePermission(int roleId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select menu_id from t_role_menu where role_id=:role_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("role_id", roleId);
		List<Map<String, Object>> mapList = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		JSONArray arr = JSONArray.fromObject(mapList);
		return arr;
	}

	/**
	 * 增加角色权限
	 * @param roleId 角色Id
	 * @param menuId 菜单Id
	 */
	@Override
	public void addPermission(int roleId, String menuId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "insert into t_role_menu values(:role_id,:menu_id)";
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("role_id",roleId);
		query.setParameter("menu_id", menuId);
		query.executeUpdate();	
	}


	/**
	 * 删除角色权限
	 * @param roleId 角色Id
	 */
	@Override
	public void deletePermission(int roleId) throws Exception{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "delete from t_role_menu where role_id=:role_id";
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("role_id", roleId);
		query.executeUpdate();
	}
	
	
	
}
