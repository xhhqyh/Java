package com.shoe.service;

import java.util.List;

import com.shoe.pojo.Img;

/**
 * 商品图片服务层接口
 * add by wyh 2018年1月13
 *
 *
 */

public interface ImgService {
	
	/**
	 * 根据商品Id查出图片
	 * @param goodsId
	 * @return
	 */
	public List<Img> getImgs(int goodsId);

}
