package com.shoe.service;

import java.util.List;
import java.util.Map;

import com.shoe.pojo.ColorSize;
import com.shoe.pojo.Goods;
import com.shoe.pojo.Color;
import com.shoe.pojo.GoodsTwo;
import com.shoe.pojo.Img;
import com.shoe.pojo.Size;
import com.shoe.pojo.Stock;
import com.shoe.pojo.Type;

/**
 * ��Ʒ��������ӿ�
 * @author qyh 2018��1��11��
 *
 */
public interface GoodsService {	
	
	/**
	 * ��ȡ��Ʒ����Ϣ
	 * add by qyh 2018��1��19�� ����5:16:23
	 * 
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ����
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getGoodsInfo(int currentPage, int pageSize);
   
	/**
	 * ������Ʒ��Ϣ
	 * add by qyh 2018��1��17�� ����2:36:59
	 * 
	 * @param goods ������Ʒ����
	 * @return
	 * @throws Exception
	 */
	public Integer saveGoods(Goods goods);
	
	/**
	 * ��ȡ��Ʒ��ɫ����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	public List<Color> getColor();
	
	/**
	 * ��ȡ��Ʒ�ߴ�����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize();
	
	/**
	 * ɾ��ָ������Ʒ,������Ʒid
	 * add by qyh 2018��1��19�� ����5:22:40
	 * 
	 * @param goodsIds Ҫɾ������Ʒ��id����
	 * @throws Exception
	 */
	public boolean deleteGoodById(List<Integer> goodsIds);
	
	/**
	 * ������Ʒid��ȡ�����Ϣ
	 * add by qyh 2018��1��18�� ����7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public List<Stock> getStockInfoByGoodsid(int goodsId);
	
	/**
	 * �޸���Ʒʱ��ɾ��ָ����Ʒ��ͼ
	 * add by qyh 2018��1��19�� ����5:17:54
	 * 
	 * @param imgId Ҫɾ������ƷͼƬid
	 * @throws Exception
	 */
	public boolean deleteImgByImgid(int imgId);
	
	/**
	 * �޸���Ʒ��Ϣ
	 * add by qyh 2018��1��19�� ����5:19:36
	 * 
	 * @param goods �޸ĺ����Ʒ����
	 * @throws Exception
	 */
	public boolean updateGoods(Goods goods);
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * ɾ������ʱ  �޸������Ʒ������
	 */
	public boolean updateGoodsType(List<Integer> typeId);
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * ɾ��Ʒ��ʱ  �޸������Ʒ��Ʒ��
	 */
	public boolean updateGoodsBrand(List<Integer> brandId);
}
