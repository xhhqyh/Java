package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shoe.framework.BaseAction;
import com.shoe.framework.DateJsonValueProcessor;
import com.shoe.pojo.Color;
import com.shoe.pojo.Cosinum;
import com.shoe.pojo.Goods;
import com.shoe.pojo.Size;
import com.shoe.pojo.Stock;
import com.shoe.service.GoodsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * add by wyh 2018年1月11
 * 商品管理控制层
 *
 */
public class GoodsAction extends BaseAction{

	//装配实例	
	@Resource 
	private GoodsService goodsService;
	//接收库存信息
	private Object params;
	private Goods goods;
	private Stock stock;
	//修改商品信息时，获取该商品所有的库存，需要商品id
	private Integer goodsId;
	//删除商品，所要删除的商品id集合
	private List<Integer> goodsIds;
	private Integer imgId;
	public File excelFile;//跟文件选择域的name属性的值一致
	
	public File getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	//Excel导入
/*	public String importExcel(@RequestParam("excelFile") MultipartFile excelFile, ModelMap map){
		//获取上传文件的文件名
        String fileName = excelFile.getOriginalFilename();
		//截取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        //判断文件格式是否正确
        if("xlsx".equals(suffix)){
        	List<Goods> goodsList = 
        	
        }
        
        
		return null;
	}*/
	
	
	/**
	 * 删除图片
	 * add by qyh 2018年1月19日 下午5:41:43
	 * 
	 * @return
	 */
	public String deleteImgByImgid(){
		boolean isOk = goodsService.deleteImgByImgid(imgId);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}
	
	/**
	 * 根据商品id获取商品库存信息
	 * add by qyh 2018年1月18日 下午7:28:16
	 * 
	 * @return
	 */
	public String getStockInfoByGoodsid(){
		List<Stock> stockList = goodsService.getStockInfoByGoodsid(goodsId);
    	JSONArray datas = JSONArray.fromObject(stockList);
		return returnResult(datas);
	}
	
	/**
	 * 获得所有商品信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getGoodsInfo() throws UnsupportedEncodingException{
    	Map<String, Object> dataGoods = goodsService.getGoodsInfo(page,rows);
		return returnHandleDateRe(dataGoods);
    }
	/**
	 * 增进或修改商品信息 
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public String saveGoods() throws UnsupportedEncodingException, NoSuchFieldException, SecurityException{
		//json字符串放到json数组
		JSONArray json2 = JSONArray.fromObject(params);
		//取数组中第一个元素
		JSONArray json3 = (JSONArray) json2.get(0);
		//Json数组转testy类型集合
		List<Cosinum> list2 = JSONArray.toList(json3, Cosinum.class);
		
		//创建一个库存表的实例
		Set<Stock> stocks = new HashSet<Stock>();
		
		for(Cosinum role: list2){
			Stock stock = new Stock();
			stock.setColorName(role.getColorName());
			stock.setSizeName(role.getSizeName());
			stock.setStockNum(role.getStockNum());
			stocks.add(stock);
		}
		//设置库存信息
		goods.setStocks(stocks);
		//设置商品主图片路径
		goods.setGoodsImgUrl(uploadOneImg());
		
		//获取商品副图片的数据库保存路径
		goods.setImgs(uploadManyImg());
		//设置商品现价
		goods.setGoodsNewPrice(goods.getGoodsOldPrice()*goods.getGoodsPoint()*0.1);
		//添加货物,返回当前货物的Id
		int returnGoodsId = goodsService.saveGoods(goods);
		
    	JSONObject datas = new JSONObject();
    	//datas.put("isOk", isOk);
    	
		return returnResult(datas);
	}
	
	/**
	 * 修改商品
	 * add by qyh 2018年1月19日 下午5:40:40
	 * 
	 * @return
	 */
	public String updateGoods(){
		//json字符串放到json数组
		JSONArray json2 = JSONArray.fromObject(params);
		//取数组中第一个元素
		JSONArray json3 = (JSONArray) json2.get(0);
		//Json数组转testy类型集合
		List<Cosinum> list2 = JSONArray.toList(json3, Cosinum.class);
		
		//创建一个库存表的实例
		Set<Stock> stocks = new HashSet<Stock>();
		
		for(Cosinum role: list2){
			Stock stock = new Stock();
			stock.setColorName(role.getColorName());
			stock.setSizeName(role.getSizeName());
			stock.setStockNum(role.getStockNum());
			stocks.add(stock);
		}
		//设置库存信息
		goods.setStocks(stocks);
		//设置商品主图片路径
		goods.setGoodsImgUrl(uploadOneImg());
		//获取商品副图片的数据库保存路径
		goods.setImgs(uploadManyImg());
		
		//设置商品现价
		goods.setGoodsNewPrice(goods.getGoodsOldPrice()*goods.getGoodsPoint()*0.1);
		//修改商品
		goodsService.updateGoods(goods);
		
    	JSONObject datas = new JSONObject();
    	//datas.put("isOk", isOk);
    	
		return returnResult(datas);
	}
	
	/**
	 * 删除指定商品
	 * add by qyh 2018年1月19日 下午5:41:05
	 * 
	 * @return
	 */
	public String deleteGoodById(){
		boolean isOk = goodsService.deleteGoodById(goodsIds);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}
	
	/**
	 * 获取颜色
	 * add by qyh 2018年1月19日 下午5:41:14
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getColor() throws UnsupportedEncodingException{
		List<Color> csList = goodsService.getColor();
    	JSONArray datas = JSONArray.fromObject(csList);
		return returnResult(datas);
	}
	
	/**
	 * 获取尺寸
	 * add by qyh 2018年1月19日 下午5:41:24
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getSize() throws UnsupportedEncodingException{
		List<Size> csList = goodsService.getSize();
    	JSONArray datas = JSONArray.fromObject(csList);
		return returnResult(datas);
	}
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Object getParams() {
		return params;
	}
	public void setParams(Object params) {
		this.params = params;
	}
	public List<Integer> getGoodsIds() {
		return goodsIds;
	}
	public void setGoodsIds(List<Integer> goodsIds) {
		this.goodsIds = goodsIds;
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	
}
