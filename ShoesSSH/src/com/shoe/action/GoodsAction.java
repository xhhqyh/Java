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
 * add by wyh 2018��1��11
 * ��Ʒ�������Ʋ�
 *
 */
public class GoodsAction extends BaseAction{

	//װ��ʵ��	
	@Resource 
	private GoodsService goodsService;
	//���տ����Ϣ
	private Object params;
	private Goods goods;
	private Stock stock;
	//�޸���Ʒ��Ϣʱ����ȡ����Ʒ���еĿ�棬��Ҫ��Ʒid
	private Integer goodsId;
	//ɾ����Ʒ����Ҫɾ������Ʒid����
	private List<Integer> goodsIds;
	private Integer imgId;
	public File excelFile;//���ļ�ѡ�����name���Ե�ֵһ��
	
	public File getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	//Excel����
/*	public String importExcel(@RequestParam("excelFile") MultipartFile excelFile, ModelMap map){
		//��ȡ�ϴ��ļ����ļ���
        String fileName = excelFile.getOriginalFilename();
		//��ȡ�ļ���׺
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        //�ж��ļ���ʽ�Ƿ���ȷ
        if("xlsx".equals(suffix)){
        	List<Goods> goodsList = 
        	
        }
        
        
		return null;
	}*/
	
	
	/**
	 * ɾ��ͼƬ
	 * add by qyh 2018��1��19�� ����5:41:43
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
	 * ������Ʒid��ȡ��Ʒ�����Ϣ
	 * add by qyh 2018��1��18�� ����7:28:16
	 * 
	 * @return
	 */
	public String getStockInfoByGoodsid(){
		List<Stock> stockList = goodsService.getStockInfoByGoodsid(goodsId);
    	JSONArray datas = JSONArray.fromObject(stockList);
		return returnResult(datas);
	}
	
	/**
	 * ���������Ʒ��Ϣ
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getGoodsInfo() throws UnsupportedEncodingException{
    	Map<String, Object> dataGoods = goodsService.getGoodsInfo(page,rows);
		return returnHandleDateRe(dataGoods);
    }
	/**
	 * �������޸���Ʒ��Ϣ 
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public String saveGoods() throws UnsupportedEncodingException, NoSuchFieldException, SecurityException{
		//json�ַ����ŵ�json����
		JSONArray json2 = JSONArray.fromObject(params);
		//ȡ�����е�һ��Ԫ��
		JSONArray json3 = (JSONArray) json2.get(0);
		//Json����תtesty���ͼ���
		List<Cosinum> list2 = JSONArray.toList(json3, Cosinum.class);
		
		//����һ��������ʵ��
		Set<Stock> stocks = new HashSet<Stock>();
		
		for(Cosinum role: list2){
			Stock stock = new Stock();
			stock.setColorName(role.getColorName());
			stock.setSizeName(role.getSizeName());
			stock.setStockNum(role.getStockNum());
			stocks.add(stock);
		}
		//���ÿ����Ϣ
		goods.setStocks(stocks);
		//������Ʒ��ͼƬ·��
		goods.setGoodsImgUrl(uploadOneImg());
		
		//��ȡ��Ʒ��ͼƬ�����ݿⱣ��·��
		goods.setImgs(uploadManyImg());
		//������Ʒ�ּ�
		goods.setGoodsNewPrice(goods.getGoodsOldPrice()*goods.getGoodsPoint()*0.1);
		//���ӻ���,���ص�ǰ�����Id
		int returnGoodsId = goodsService.saveGoods(goods);
		
    	JSONObject datas = new JSONObject();
    	//datas.put("isOk", isOk);
    	
		return returnResult(datas);
	}
	
	/**
	 * �޸���Ʒ
	 * add by qyh 2018��1��19�� ����5:40:40
	 * 
	 * @return
	 */
	public String updateGoods(){
		//json�ַ����ŵ�json����
		JSONArray json2 = JSONArray.fromObject(params);
		//ȡ�����е�һ��Ԫ��
		JSONArray json3 = (JSONArray) json2.get(0);
		//Json����תtesty���ͼ���
		List<Cosinum> list2 = JSONArray.toList(json3, Cosinum.class);
		
		//����һ��������ʵ��
		Set<Stock> stocks = new HashSet<Stock>();
		
		for(Cosinum role: list2){
			Stock stock = new Stock();
			stock.setColorName(role.getColorName());
			stock.setSizeName(role.getSizeName());
			stock.setStockNum(role.getStockNum());
			stocks.add(stock);
		}
		//���ÿ����Ϣ
		goods.setStocks(stocks);
		//������Ʒ��ͼƬ·��
		goods.setGoodsImgUrl(uploadOneImg());
		//��ȡ��Ʒ��ͼƬ�����ݿⱣ��·��
		goods.setImgs(uploadManyImg());
		
		//������Ʒ�ּ�
		goods.setGoodsNewPrice(goods.getGoodsOldPrice()*goods.getGoodsPoint()*0.1);
		//�޸���Ʒ
		goodsService.updateGoods(goods);
		
    	JSONObject datas = new JSONObject();
    	//datas.put("isOk", isOk);
    	
		return returnResult(datas);
	}
	
	/**
	 * ɾ��ָ����Ʒ
	 * add by qyh 2018��1��19�� ����5:41:05
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
	 * ��ȡ��ɫ
	 * add by qyh 2018��1��19�� ����5:41:14
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
	 * ��ȡ�ߴ�
	 * add by qyh 2018��1��19�� ����5:41:24
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