package com.shoe.dao;

import java.util.List;

import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;
import com.shoe.pojo.Size;
/**
 * <p>处理积分秒杀商品
 * @author 李杨
 *
 */
public interface PointDao {
	/**
	 * 查看积分秒杀商品总数
	 * add by liyang 2018年1月15日 下午4:15:31
	 * 
	 * @return count,返回积分秒杀商品总数
	 * @throws Exception
	 */
	Long getPointGoodsCount() throws Exception; 
	/**
	 * 查看全部积分商品,
	 * add by liyang 2018年1月15日 下午4:25:49
	 * @param pageSize 
	 * @param currentPage 
	 * @param statuss 
	 * 
	 * @return 返回全部积分秒杀商品
	 * @throws Exception
	 */
	List<PointShop> getPointGoods(Integer currentPage, Integer pageSize, Integer statuss) throws Exception;
	/**
	 * 修改
	 * add by liyang 2018年1月17日 上午11:23:38
	 * 
	 * @param status
	 * @param id 
	 * @return
	 */
	int updateStatus(Integer status, Integer id) throws Exception ;
	/**
	 * 删除
	 * add by liyang 2018年1月17日 下午4:23:25
	 *
	 */
	int deletePointByIds(Integer[] ids) throws Exception;
	/**
	 * 查询尺寸
	 * add by liyang 2018年1月18日 下午7:33:02
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	List<Size> getSize(int i) throws Exception;
	/**
	 * 查询颜色表
	 * add by liyang 2018年1月18日 下午7:33:47
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	List<Color> getColor(int i) throws Exception;
	/**
	 * 查看商品名
	 * add by liyang 2018年1月19日 上午11:28:06
	 * 
	 * @return
	 */
	List<Goods> getGoods() throws Exception;
	/**
	 * 增加或修改
	 * add by liyang 2018年1月19日 下午2:51:29
	 * 
	 * @param pointVO
	 * @throws Exception
	 */
	int saveOrUpdate(PointVo pointVO) throws Exception;
}
