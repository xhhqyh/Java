package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.CustomizeDao;
import com.shoe.pojo.Customize;
import com.shoe.pojo.Goods;
import com.shoe.pojo.Size;
import com.shoe.pojo.Type;

/**
 * ����Ь
 * add by zrh 2018��1��17�� ����11:25:58
 *
 */
@Service  
@Transactional
public class CustomizeServiceImpl implements CustomizeService {
	
	@Resource
	private CustomizeDao customizeDao;
	
	/**
	 * ����Ь��ѯ
	 * @param currentPage
	 * @param pageSize
	 */
	public Map<String, Object> getCustomizeList(int currentPage, int pageSize,String customizeCards) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long customizeCount = customizeDao.getCount();
			List<Customize> CustomizeList = customizeDao.getCustomizeInfo(currentPage, pageSize,customizeCards);
			data.put("total", customizeCount);
			data.put("rows", CustomizeList);	
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return data;
	}
	
	/**
	 * ��ӻ��޸�
	 * @param customize ����Ь����Ϣ
	 */
	@Override
	public boolean addCustomize(Customize customize) {
		boolean isOk = true;
		try {
			customizeDao.addCustomize(customize);
		} catch (Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}

	/**
	 * ɾ��
	 * @param customizeIds ѡ�����ݵ���ID
	 */
	@Override
	public boolean deleteCustomize(List<Integer> customizeIds) {
		boolean isOk = true;
		try {
			customizeDao.deleteCustomize(customizeIds);
		} catch (Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}

	/**
	 * ����Ь�����гߴ�
	 */
	@Override
	public List<Size> getSizeName() {
		List<Size> sizeList = null;
		try {
			sizeList = customizeDao.getSize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizeList;
	}

	/**
	 * add by wyh 2018-1-22
	 * @param typeId	 
	 * ɾ������ʱ  �޸������Ʒ������
	 */
	@Override
	public boolean updateGoodsType(List<Integer> typeId) {
		boolean isOk = true;
		try {
			customizeDao.updateGoodsType(typeId);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		}		
		return isOk;
	}
	/**
	 * add by wyh 2018-1-22
	 * @param brandId	 
	 * ɾ��Ʒ��ʱ  �޸������Ʒ��Ʒ��
	 */
	@Override
	public boolean updateGoodsBrand(List<Integer> brandId) {
		boolean isOk = true;
		try {
			customizeDao.updateGoodsBrand(brandId);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		}		
		return isOk;
	}


}
