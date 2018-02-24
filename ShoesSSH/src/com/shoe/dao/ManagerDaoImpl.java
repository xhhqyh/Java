
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
 * ����Ա����Dao��ʵ��
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	@Resource(name="mySessionFactory")   
    private SessionFactory sessionFactory;
	
	/**
	 * add by gx 2018-1-11
	 * ����Ա��¼ģ���ʵ��
	 * @return manager  ����һ��manager����
	 */
	@Override
	public List<Manager> loginManager(Manager manager) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Manager where managerName = ? and managerPwd = ?";
		Query<Manager> query = session.createQuery(hql);
		query.setParameter(0, manager.getManagerName());
		query.setParameter(1, manager.getManagerPwd());
		List<Manager> managerList = query.getResultList();//�����ݿ��в�ѯ�Ƿ��з���������manager����
		return managerList;
	}

	/**
	 * add by gx 2018-1-11
	 * ��ӻ��޸Ĺ���Ա��Ϣ
	 */
	@Override
	public void addManager(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(managerVO);
	}

	/**
	 * add by gx 2018-1-11
	 * ��ȡ����Ա����
	 * 
	 */
	@Override
	public long getManagerCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Manager";
		Query<Long> query = session.createQuery(hql);
		return query.getSingleResult();//����һ��long���͵Ĳ�ѯ���
	}

	/**
	 * add by gx 2018-1-11
	 * ɾ������Ա
	 * @param managerIds ��ǰ̨��ȡ���Ĺ���ԱID
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
	 * ��ȡһҳ����Ա��Ϣ
	 * @param currentPage ��ǰҳ
	 * @param pageSize ��ǰҳ��ʾ��������
	 * @param managers List<Manager> ����һ��List����,��ŵ�ǰҳ�Ĺ���Ա����
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
	 * �޸Ľ�ɫ��δ�еĹ���Ա
	 */
	@Override
	public void updateManger(List<Integer> roleId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="update from ManagerVO m set m.roleId =0 where m.roleId in (:roleIds)";
		Query<Long> query = session.createQuery(hql);
		query.setParameterList("roleIds",roleId).executeUpdate();		
	}
}
