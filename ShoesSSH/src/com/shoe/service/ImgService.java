package com.shoe.service;

import java.util.List;

import com.shoe.pojo.Img;

/**
 * ��ƷͼƬ�����ӿ�
 * add by wyh 2018��1��13
 *
 *
 */

public interface ImgService {
	
	/**
	 * ������ƷId���ͼƬ
	 * @param goodsId
	 * @return
	 */
	public List<Img> getImgs(int goodsId);

}
