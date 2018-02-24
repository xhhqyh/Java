package com.shoe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.ImgDao;
import com.shoe.pojo.Img;

/**
 * 商品图片服务层接口实现类
 * add by wyh 2018年1月13
 *
 *
 */
@Service  
@Transactional
public class ImgServiceImpl implements ImgService {

	//装配Dao层
	@Resource
	private ImgDao imgDao;
	
	
	/**
	 * 根据商品Id查出图片
	 */
	@Override
	public List<Img> getImgs(int goodsId) {
		List<Img> imgList = null;
		try {
			imgList = imgDao.getImgs(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgList;
	}

}
