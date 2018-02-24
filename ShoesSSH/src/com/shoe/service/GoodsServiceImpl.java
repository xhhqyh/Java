package com.shoe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.GoodsDao;
import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.Size;
import com.shoe.pojo.Stock;

/**
 * ��Ʒ���������
 * @author qyh 2018��1��11��
 *
 */
@Service  
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Resource 
	private GoodsDao goodsDao; 
	
	/**
	 * ��ȡ��Ʒ����Ϣ
	 * add by qyh 2018��1��19�� ����5:16:23
	 * 
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ����
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getGoodsInfo(int currentPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		//��ȡ������		
		try {
			long goodCount = goodsDao.getCount();
			//��ȡ��ѯ������
			List<Goods> goodList = goodsDao.getGoodsInfo(currentPage, pageSize);
			data.put("total", goodCount);
			data.put("rows", goodList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return data;
	}
   
	/**
	 * ������Ʒ��Ϣ
	 * add by qyh 2018��1��17�� ����2:36:59
	 * 
	 * @param goods ������Ʒ����
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer saveGoods(Goods goods) {
		int returnGoodsId = 0;
		try {
			returnGoodsId = goodsDao.saveGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
			returnGoodsId = 0;
		}
		return returnGoodsId;
	}
	
	/**
	 * ��ȡ��Ʒ��ɫ����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Color> getColor() {
		List<Color> csList=new ArrayList<Color>();
		//��ȡ������		
		try {
			//��ȡ��ѯ������
			csList = goodsDao.getColor();	
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return csList;
	}
	
	/**
	 * ��ȡ��Ʒ�ߴ�����
	 * add by qyh 2018��1��15��
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Size> getSize() {
		List<Size> csList=new ArrayList<Size>();
		//��ȡ������		
		try {
			//��ȡ��ѯ������
			csList = goodsDao.getSize();	
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return csList;
	}
	
	/**
	 * ������Ʒid��ȡ�����Ϣ
	 * add by qyh 2018��1��18�� ����7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Stock> getStockInfoByGoodsid(int goodsId) {
		List<Stock> goodsList=new ArrayList<Stock>();
		//��ȡ������		
		try {
			//��ȡ��ѯ������
			goodsList = goodsDao.getStockInfoByGoodsid(goodsId);	
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return goodsList;
	}
	
	/**
	 * �޸���Ʒʱ��ɾ��ָ����Ʒ��ͼ
	 * add by qyh 2018��1��19�� ����5:17:54
	 * 
	 * @param imgId Ҫɾ������ƷͼƬid
	 * @throws Exception
	 */
	@Override
	public boolean deleteImgByImgid(int imgId) {
		boolean isOk = true;
		try {
			goodsDao.deleteImgByImgid(imgId);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * add by qyh 2018��1��19�� ����5:19:36
	 * 
	 * @param goods �޸ĺ����Ʒ����
	 * @throws Exception
	 */
	@Override
	public boolean updateGoods(Goods goods) {
		boolean isOk=true;
		try {
			/*�������*/
			//ɾ�����
			goodsDao.deleteStockByGoodsId(goods.getGoodsId());
			//�����¿��
			goodsDao.addStock(goods.getStocks(),goods.getGoodsId());
			//�ж��Ƿ���������Ʒ��ͼ
			if( goods.getImgs()!=null && goods.getImgs().size()>0 ){
				goodsDao.addImgs(goods.getImgs(), goods.getGoodsId());
			}
			//�޸���Ʒ��Ϣ
			goodsDao.updateGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * ɾ��ָ������Ʒ,������Ʒid
	 * �����߼�ɾ���������ݿ��в�ɾ��
	 * add by qyh 2018��1��19�� ����5:22:40
	 * 
	 * @param goodsIds Ҫɾ������Ʒ��id����
	 * @throws Exception
	 */
	@Override
	public boolean deleteGoodById(List<Integer> goodsIds) {
		boolean isOk = true;
		try {
			//ɾ����Ʒ��Ӧ�ĸ�ͼ
			//goodsDao.deleteImgs(goodsIds);
			//ɾ����Ʒ��Ӧ�Ŀ��
			//goodsDao.deleteStock(goodsIds);
			
			//ɾ��ָ����Ʒ
			goodsDao.deleteGoodById(goodsIds);
		} catch (Exception e) {
			e.printStackTrace();
			isOk=false;
		}
		return isOk;
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
			goodsDao.updateGoodsType(typeId);;
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
			goodsDao.updateGoodsBrand(brandId);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		}		
		return isOk;
	}
	
}