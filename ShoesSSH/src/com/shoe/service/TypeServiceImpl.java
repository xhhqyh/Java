package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.TypeDao;
import com.shoe.pojo.Type;
/**
 * 类型管理
 * add by zrh 2018年1月13日 下午4:37:32
 *
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Resource
	private TypeDao typeDao;
	
	/**
	 * 获取类型列表
	 * @param currentPage
	 * @param pageSize
	 * 
	 */
	public Map<String, Object> getTypeList(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 获取总数量
		try {
			long typeCount = typeDao.getTypeCount();
			// 获取查询的数据
			List<Type> typeList = typeDao.getTypeInfo(currentPage, pageSize);
			data.put("total", typeCount);
			data.put("rows", typeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 获得类型名字
	 */
	@Override
	public List<Type> getTypeName() {
		
		List<Type> typeList = null;
		try {
			typeList = typeDao.getTypeName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeList;
	}
	
	
	/**
	 * 
	 * 添加或修改
	 * @param type
	 */
	@Override
	public Boolean addType(Type type) {
		boolean isOk = true;
		try {
			typeDao.addType(type);
		} catch (Exception e) {
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * 删除
	 * @param typeIds
	 */
	@Override
	public boolean deleteTypes(List<Integer> typeIds) {
		boolean isOk = true;
		try {
			typeDao.deleteType(typeIds);
		} catch (Exception e) {
			isOk = false;
		}
		return isOk;
	}


}
