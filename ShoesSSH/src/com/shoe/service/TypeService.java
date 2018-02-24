package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.Type;
/**
 *  ����
 * add by zrh 2018��1��13�� ����4:35:36
 *
 */
public interface TypeService {
	
	/**
	 * ��ѯ����������
	 * @return
	 */
	 public List<Type> getTypeName();
	 
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return ����������Ϣ
	 */
	public Map<String, Object> getTypeList(int currentPage, int pageSize);
	
	/**
	 * ��ӻ��޸�
	 * @param type
	 */
	public Boolean addType(Type type);
	
	/**
	 * ɾ��
	 *
	 * @param typeIds
	 * @return
	 */
	public boolean deleteTypes(List<Integer> typeIds);
	
}
