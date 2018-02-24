package com.shoe.service;

import java.util.List;

import com.shoe.pojo.Security;
import com.shoe.pojo.User;
/**
 * <P>���ڴ�����User��ص����з���
 * @author ����
 * 
 */
public interface UserService {
	/**
	 * <P>��ѯ���е��û���Ϣ
	 * @return List ȫ���û���Ϣ
	 */
	List<User> getUser();
	/**
	 * <P>��ѯ���е�����
	 * @return List ��������
	 */
	List<Security> getSecurity();
	/**
	 * <p>�޸��û���Ϣ
	 * @return int �޸ĵ�������
	 * @param ids
	 * @param freeze
	 */
	boolean updateUser(Integer[] ids, String freeze);
}
