package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;
/**
 * ����Ա����Service��
 * @gx
 * add by 2018-1-11
 */
public interface ManagerService {
	public boolean addManager(ManagerVO manager);//���ӻ��޸Ĺ���Ա
	public List<Manager> loginManager(Manager manager);//����Ա��¼
	public Map<String, Object> getManagerPage(int currentPage, int pageSize);//��ȡ��ǰҳ�����Ա��Ϣ
	public boolean deleteManager(List<Integer> managerIds);//ɾ������Ա
	/**
	 * add by wyh 2018-1-22
	 * �޸Ľ�ɫ��δ�еĹ���Ա
	 */
	public boolean updateManager(List<Integer> roleId);
}