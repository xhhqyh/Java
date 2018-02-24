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
 * 商品管理服务层接口
 * @author qyh 2018年1月11日
 *
 */
public interface GoodsService {	
	
	/**
	 * 获取商品表信息
	 * add by qyh 2018年1月19日 下午5:16:23
	 * 
	 * @param currentPage 当前页
	 * @param pageSize 每页行数
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getGoodsInfo(int currentPage, int pageSize);
   
	/**
	 * 增加商品信息
	 * add by qyh 2018年1月17日 下午2:36:59
	 * 
	 * @param goods 新增商品数据
	 * @return
	 * @throws Exception
	 */
	public Integer saveGoods(Goods goods);
	
	/**
	 * 获取商品颜色数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	public List<Color> getColor();
	
	/**
	 * 获取商品尺寸数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize();
	
	/**
	 * 删除指定的商品,根据商品id
	 * add by qyh 2018年1月19日 下午5:22:40
	 * 
	 * @param goodsIds 要删除的商品的id集合
	 * @throws Exception
	 */
	public boolean deleteGoodById(List<Integer> goodsIds);
	
	/**
	 * 根据商品id获取库存信息
	 * add by qyh 2018年1月18日 下午7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public List<Stock> getStockInfoByGoodsid(int goodsId);
	
	/**
	 * 修改商品时，删除指定商品副图
	 * add by qyh 2018年1月19日 下午5:17:54
	 * 
	 * @param imgId 要删除的商品图片id
	 * @throws Exception
	 */
	public boolean deleteImgByImgid(int imgId);
	
	/**
	 * 修改商品信息
	 * add by qyh 2018年1月19日 下午5:19:36
	 * 
	 * @param goods 修改后的商品数据
	 * @throws Exception
	 */
	public boolean updateGoods(Goods goods);
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * 删除类型时  修改相关商品的类型
	 */
	public boolean updateGoodsType(List<Integer> typeId);
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * 删除品牌时  修改相关商品的品牌
	 */
	public boolean updateGoodsBrand(List<Integer> brandId);
}
