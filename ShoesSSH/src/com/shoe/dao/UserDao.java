package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/**
 * <p>����ִ�����û�(User)��ص����ݿ����
 * @author ����
 * @see User
 */
public interface UserDao {
	/**
	 * <p>��ѯ��չʾȫ�����û�,������ѯ����ȫ���û���Listװ�������ظ����ú���;
	 * @return List ����User���͵ļ��� 
	 * @throws Exception 
	 */
	public List<User> getUser() throws Exception;

	/**
	 * <p>��ѯ��չʾȫ������,
	 * @return List ����Security���͵ļ���
	 * @throws Exception
	 */
	List<Security> getSecurity() throws Exception;
	
	/**
	 * <p>�����ⶳ�û�
	 * @param ids ��Ҫ�����id
	 * @param state ��Ҫִ�еĲ���
	 * @return ����ִ�е�����
	 * @throws Exception
	 */
	int update(Integer[] ids, int state) throws Exception;
}
