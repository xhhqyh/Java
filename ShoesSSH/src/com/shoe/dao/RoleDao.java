package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Role;

import net.sf.json.JSONArray;
/**
 *  ����Ա��ɫ��Ϣ����Dao�ӿ�
 * @gx
 * add by 2018-1-11
 */
public interface RoleDao {
	public List<Role> getRolePage(int currentPage,int pageSize) throws Exception;//��ȡ��ɫ��Ϣ
	
	public long getRoleCount() throws Exception;//��ȡ��ɫ��������
	
	public void addRole(Role role) throws Exception;//��ӽ�ɫ
	
	public void deleteRole(List<Integer> roleIds) throws Exception;//ɾ����ɫ

	public JSONArray getRolePermission(int roleId) throws Exception;//��ȡ�û�Ȩ��

	public void addPermission(int roleId,String menuId) throws Exception;//����û�Ȩ��

	public void deletePermission(int roleId) throws Exception;//ɾ��Ȩ��
	
	public List<Role> getAllRole() throws Exception;//��ȡ���н�ɫ��Ϣ
	
}
