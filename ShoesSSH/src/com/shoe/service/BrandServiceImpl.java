package com.shoe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.BrandDao;
import com.shoe.pojo.Brand;

/**
 * add by zrh 2018年1月12 
 * 品牌接口实现类
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	@Resource
	private BrandDao brandDao;
	
	
	/**
	 * 查询品牌名字
	 */
	@Override
	public List<Brand> getBrandName() {
		List<Brand> brandList = null;
		try {
			brandList = brandDao.getBrandName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brandList;
	}

	/**
	 * 获得品牌信息
	 * @param currentPage
	 * @param pageSize
	 */
	@Override
	public Map<String, Object> getBrandList(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			long brandCount = brandDao.getBrandCount();
			List<Brand> brandList = brandDao.getBrandInfo(currentPage, pageSize);
			data.put("total", brandCount);
			data.put("rows", brandList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 添加或修改
	 * @param brand
	 */
	public Boolean addBrand(Brand brand) {
		boolean isOk = true;
		try {
			brandDao.addBrand(brand);
		} catch (Exception e) {
			isOk = false;
		}
		return isOk;
	}

	/**
	 * 删除
	 * @param brandIds
	 */
	public boolean deleteBrands(List<Integer> brandIds) {
		boolean isOk = true;
		try {
			brandDao.deleteBrand(brandIds);
		} catch (Exception e) {
			isOk = false;
		}
		return isOk;
	}


}
