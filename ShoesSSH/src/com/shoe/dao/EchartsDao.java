package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.EchartsSex;

/**
 * 
 * add by wyh 2018��1��17<p>
 * ��Ʒ�������� 
 *
 */
public interface EchartsDao {
     
	/**
	 * add by wyh 2018��1��17
	 * @param reserve
	 * @return ���� ��Ь �·�   ����
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtSex()throws Exception;
	/**
	 * add by wyh 2018��1��18
	 * @param reserve
	 * @return ���� ŮЬ �·�   ����
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtSexWomen()throws Exception;
	
	/**
	 * 
	 * @return ���� X ������
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtLengd()throws Exception;
	
	/**
	 * 
	 * @param month
	 * @return �����·�����ѯ�������Ь����Ϣ
	 * @throws Exception
	 */
	public List<EchartsSex> getEchsrtType(String month)throws Exception;
	
}
