package com.shoe.dao;

import java.util.List;
import java.util.Set;

import com.shoe.pojo.ColorSize;
import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.GoodsTwo;
import com.shoe.pojo.Img;
import com.shoe.pojo.Size;
import com.shoe.pojo.Stock;

/**
 * ��Ʒ����ģ�Ͳ�ӿ�
 * add by wyh  2018��1��11��
 * 
 */
public interface GoodsDao {	
	/**
	 * ��ѯ��Ʒ����������
	 * add by qyh 2018��1��19�� ����5:15:41
	 * 
	 * @return ������Ʒ������
	 * @throws Exception
	 */
	public long getCount() throws Exception;
	
	/**
	 * ��ȡ��Ʒ����Ϣ
	 * add by qyh 2018��1��19�� ����5:16:23
	 * 
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ����
	 * @return
	 * @throws Exception
	 */
	public List<Goods> getGoodsInfo(int currentPage, int pageSize)throws Exception;  
	
	/**
	 * ������Ʒ��Ϣ
	 * add by qyh 2018��1��17�� ����2:36:59
	 * 
	 * @param goods ������Ʒ����
	 * @return
	 * @throws Exception
	 */
	public Integer saveGoods(Goods goods) throws Exception; 
	
	/**
	 * ��ȡ��Ʒ��ɫ����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	public List<Color> getColor() throws Exception;
	
	/**
	 * ��ȡ��Ʒ�ߴ�����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize() throws Exception;
	
	/**
	 * ������Ʒid��ȡ�����Ϣ
	 * add by qyh 2018��1��18�� ����7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public List<Stock> getStockInfoByGoodsid(int goodsId) throws Exception;  
	
	/**
	 * �޸���Ʒʱ��ɾ��ָ����Ʒ��ͼ
	 * add by qyh 2018��1��19�� ����5:17:54
	 * 
	 * @param imgId Ҫɾ������ƷͼƬid
	 * @throws Exception
	 */
	public void deleteImgByImgid(int imgId) throws Exception;
	
	/**
	 * �޸���Ʒ��Ϣ
	 * add by qyh 2018��1��19�� ����5:19:36
	 * 
	 * @param goods �޸ĺ����Ʒ����
	 * @throws Exception
	 */
	public void updateGoods(Goods goods) throws Exception;
	
	/**
	 * ������Ʒidɾ������Ʒ�µĿ����Ϣ
	 * add by qyh 2018��1��19�� ����5:20:10
	 * 
	 * @param goodsId ��Ʒid
	 * @throws Exception
	 */
	public void deleteStockByGoodsId(int goodsId) throws Exception;
	
	/**
	 * ���ӿ��
	 * add by qyh 2018��1��19�� ����5:21:12
	 * 
	 * @param stocks �������
	 * @param goodsId �ÿ����������Ʒid
	 * @throws Exception
	 */
	public void addStock(Set<Stock> stocks, int goodsId) throws Exception;
	
	/**
	 * ���ͼƬ
	 * add by qyh 2018��1��19�� ����5:22:03
	 * 
	 * @param imgs ͼƬ����
	 * @param goodsId ��ͼƬ��������Ʒid
	 * @throws Exception
	 */
	public void addImgs(Set<Img> imgs, int goodsId) throws Exception;
	
	/**
	 * ɾ��ָ������Ʒ,������Ʒid
	 * add by qyh 2018��1��19�� ����5:22:40
	 * 
	 * @param goodsIds Ҫɾ������Ʒ��id����
	 * @throws Exception
	 */
	public void deleteGoodById(List<Integer> goodsIds) throws Exception;
	
	/**
	 * Ҫɾ����ͼƬ
	 * add by qyh 2018��1��19�� ����5:23:27
	 * 
	 * @param goodsIds Ҫɾ����ͼƬ��������Ʒid
	 * @throws Exception
	 */
	public void deleteImgs(List<Integer> goodsIds) throws Exception;
	
	/**
	 * ɾ�����
	 * add by qyh 2018��1��19�� ����5:27:42
	 * 
	 * @param goodsIds Ҫɾ���Ŀ����������Ʒ  id����
	 * @throws Exception
	 */
	public void deleteStock(List<Integer> goodsIds) throws Exception;
	
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * @throws Exception
	 * ɾ������ʱ  �޸������Ʒ������
	 */
	public void updateGoodsType(List<Integer> typeId) throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * @throws Exception
	 * ɾ��Ʒ��ʱ  �޸������Ʒ��Ʒ��
	 */
	public void updateGoodsBrand(List<Integer> brandId) throws Exception;
	
}