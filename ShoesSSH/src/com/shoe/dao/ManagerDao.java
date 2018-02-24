package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;

/**
 * 
 * @gx
 * add by 2018-1-11
 * ����Ա����ģ�Ͳ�ӿ�
 */
public interface ManagerDao {
	public List<Manager> loginManager(Manager manager) throws Exception;//����Ա��¼,��ȡ��¼��Ϣ
	
	public void addManager(ManagerVO managerVO) throws Exception;//���ӹ���Ա
	
	public long getManagerCount() throws Exception;//��ȡ����Ա������
	
	public void deleteManager(List<Integer> managerIds) throws Exception;//ɾ������Ա
	
	public List<Manager> getManagerPage(int currentPage,int pageSize) throws Exception;//��ȡ��ǰҳ����Ա��Ϣ
	
	/**
	 * add by wyh 2018-1-22
	 * �޸Ľ�ɫ��δ�еĹ���Ա
	 */
	public void updateManger(List<Integer> roleId) throws Exception;
}