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
 * ����Ա��ɫ��Ϣ����Daoʵ�ֲ�
 * @gx
 * add by 2018-1-11
 * 
 */
@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	
	/**
	 * �����ݿ��ȡ��ɫ������
	 * 
	 */
	public long getRoleCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Role";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();
	}

	/**
	 * ��ȡ���н�ɫ��Ϣ
	 * @return roles List<Role> ����һ���洢���н�ɫ��Ϣ��List����
	 */
	public List<Role> getAllRole() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role r where r.roleId>0";
		Query<Role> query = session.createQuery(hql);
		List<Role> roles = query.getResultList();
		return roles;//����һ���洢���н�ɫ��Ϣ��List����
 	}
	
	
	/**
	 * ��ȡ��ǰҳ�Ĺ���Ա��Ϣ
	 * @param currentPage ��ǰҳ
	 * @param pageSize ҳ����������
	 * @return roles List<Role> ����һ���洢���н�ɫ��Ϣ��List����
	 */
	public List<Role> getRolePage(int currentPage,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role r where r.roleId>0";
		Query<Role> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Role> roles = query.getResultList();
		return roles;//����һ���洢��ǰҳ���ɫ��Ϣ��List����
	}

	/**
	 * ��ӻ��޸Ľ�ɫ
	 */
	@Override
	public void addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}

	
	/**
	 * ɾ����ɫ
	 * @param roleIds List<Integer> ��ɫId�ļ���
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
	 * ��ȡ��ɫ��Ȩ��
	 * @param roleId ��ɫID
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
	 * ���ӽ�ɫȨ��
	 * @param roleId ��ɫId
	 * @param menuId �˵�Id
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
	 * ɾ����ɫȨ��
	 * @param roleId ��ɫId
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
