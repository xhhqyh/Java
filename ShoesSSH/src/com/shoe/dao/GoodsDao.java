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
 * 商品管理模型层接口
 * add by wyh  2018年1月11日
 * 
 */
public interface GoodsDao {	
	/**
	 * 查询商品表中总行数
	 * add by qyh 2018年1月19日 下午5:15:41
	 * 
	 * @return 返回商品总数量
	 * @throws Exception
	 */
	public long getCount() throws Exception;
	
	/**
	 * 获取商品表信息
	 * add by qyh 2018年1月19日 下午5:16:23
	 * 
	 * @param currentPage 当前页
	 * @param pageSize 每页行数
	 * @return
	 * @throws Exception
	 */
	public List<Goods> getGoodsInfo(int currentPage, int pageSize)throws Exception;  
	
	/**
	 * 增加商品信息
	 * add by qyh 2018年1月17日 下午2:36:59
	 * 
	 * @param goods 新增商品数据
	 * @return
	 * @throws Exception
	 */
	public Integer saveGoods(Goods goods) throws Exception; 
	
	/**
	 * 获取商品颜色数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	public List<Color> getColor() throws Exception;
	
	/**
	 * 获取商品尺寸数据
	 * add by qyh 2018年1月15日
	 * @return
	 * @throws Exception
	 */
	public List<Size> getSize() throws Exception;
	
	/**
	 * 根据商品id获取库存信息
	 * add by qyh 2018年1月18日 下午7:22:03
	 * 
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public List<Stock> getStockInfoByGoodsid(int goodsId) throws Exception;  
	
	/**
	 * 修改商品时，删除指定商品副图
	 * add by qyh 2018年1月19日 下午5:17:54
	 * 
	 * @param imgId 要删除的商品图片id
	 * @throws Exception
	 */
	public void deleteImgByImgid(int imgId) throws Exception;
	
	/**
	 * 修改商品信息
	 * add by qyh 2018年1月19日 下午5:19:36
	 * 
	 * @param goods 修改后的商品数据
	 * @throws Exception
	 */
	public void updateGoods(Goods goods) throws Exception;
	
	/**
	 * 根据商品id删除该商品下的库存信息
	 * add by qyh 2018年1月19日 下午5:20:10
	 * 
	 * @param goodsId 商品id
	 * @throws Exception
	 */
	public void deleteStockByGoodsId(int goodsId) throws Exception;
	
	/**
	 * 增加库存
	 * add by qyh 2018年1月19日 下午5:21:12
	 * 
	 * @param stocks 库存数据
	 * @param goodsId 该库存所属的商品id
	 * @throws Exception
	 */
	public void addStock(Set<Stock> stocks, int goodsId) throws Exception;
	
	/**
	 * 添加图片
	 * add by qyh 2018年1月19日 下午5:22:03
	 * 
	 * @param imgs 图片数据
	 * @param goodsId 该图片所属的商品id
	 * @throws Exception
	 */
	public void addImgs(Set<Img> imgs, int goodsId) throws Exception;
	
	/**
	 * 删除指定的商品,根据商品id
	 * add by qyh 2018年1月19日 下午5:22:40
	 * 
	 * @param goodsIds 要删除的商品的id集合
	 * @throws Exception
	 */
	public void deleteGoodById(List<Integer> goodsIds) throws Exception;
	
	/**
	 * 要删除的图片
	 * add by qyh 2018年1月19日 下午5:23:27
	 * 
	 * @param goodsIds 要删除的图片所属的商品id
	 * @throws Exception
	 */
	public void deleteImgs(List<Integer> goodsIds) throws Exception;
	
	/**
	 * 删除库存
	 * add by qyh 2018年1月19日 下午5:27:42
	 * 
	 * @param goodsIds 要删除的库存所属的商品  id集合
	 * @throws Exception
	 */
	public void deleteStock(List<Integer> goodsIds) throws Exception;
	
	/**
	 * add by wyh 2018-1-22
	 * @param typeId
	 * @throws Exception
	 * 删除类型时  修改相关商品的类型
	 */
	public void updateGoodsType(List<Integer> typeId) throws Exception;
	/**
	 * add by wyh 2018-1-22
	 * @param brandId
	 * @throws Exception
	 * 删除品牌时  修改相关商品的品牌
	 */
	public void updateGoodsBrand(List<Integer> brandId) throws Exception;
	
}