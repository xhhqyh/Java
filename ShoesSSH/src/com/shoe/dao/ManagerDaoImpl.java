
package com.shoe.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;

import net.sf.json.JSONArray;

/**
 * 
 * @gx
 * update by gx 2018-1-12
 * 管理员管理Dao层实现
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by gx 2018-1-11
	 * 管理员登录模块的实现
	 * @return manager  返回一个manager对象
	 */
	@Override
	public List<Manager> loginManager(Manager manager) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Manager where managerName = ? and managerPwd = ?";
		Query<Manager> query = session.createQuery(hql);
		query.setParameter(0, manager.getManagerName());
		query.setParameter(1, manager.getManagerPwd());
		List<Manager> managerList = query.getResultList();//在数据库中查询是否有符合条件的manager对象
		return managerList;
	}

	/**
	 * add by gx 2018-1-11
	 * 添加或修改管理员信息
	 */
	@Override
	public void addManager(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(managerVO);
	}

	/**
	 * add by gx 2018-1-11
	 * 获取管理员总数
	 * 
	 */
	@Override
	public long getManagerCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Manager";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();//返回一个long类型的查询结果
	}

	/**
	 * add by gx 2018-1-11
	 * 删除管理员
	 * @param managerIds 从前台获取到的管理员ID
	 */
	@Override
	public void deleteManager(List<Integer> managerIds) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql="delete from Manager where managerId in (:managerIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("managerIds",managerIds).executeUpdate();
	}

	/**
	 * add by gx 2018-1-11
	 * 获取一页管理员信息
	 * @param currentPage 当前页
	 * @param pageSize 当前页显示数据条数
	 * @param managers List<Manager> 返回一个List集合,存放当前页的管理员数据
	 */
	@Override
	public List<Manager> getManagerPage(int currentPage, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Manager";
		Query<Manager> query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Manager> managers = query.getResultList();
		return managers;
	}
	/**
	 * add by wyh 2018-1-22
	 * 修改角色名未有的管理员
	 */
	@Override
	public void updateManger(List<Integer> roleId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="update from ManagerVO m set m.roleId =0 where m.roleId in (:roleIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("roleIds",roleId).executeUpdate();		
	}
}
