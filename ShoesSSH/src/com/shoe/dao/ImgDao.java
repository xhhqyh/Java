package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Img;

/**
 * 
 * add by wyh 2018年1月13
 * 图片数据层接口
 *
 */
public interface ImgDao {
	
	/**
	 * 根据商品Id查询出商品图片
	 * @param imgId
	 * @return
	 * @throws Exception
	 */
	public List<Img> getImgs(int goodsId) throws Exception;
   
	
}
