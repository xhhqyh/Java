package com.shoe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.shoe.framework.BaseAction;
import com.shoe.framework.Instrument;
import com.shoe.pojo.Customize;
import com.shoe.pojo.Size;
import com.shoe.service.CustomizeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 定制鞋 
 * add by zrh 2018年1月17日 上午11:30:10
 *		控制层
 */
public class CustomizeAction extends BaseAction{
	@Resource 
	private CustomizeService customizeService;
	
	private Customize customize;
	private List<Integer> customizeIds;
	private String customizeCards;
	/**
	 * 定制鞋列表
	 * add by zrh 2018年1月17日 上午11:32:49
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getCustomizeInfo() throws UnsupportedEncodingException{
    	Map<String, Object> dataCustomize = customizeService.getCustomizeList(page, rows,customizeCards);
    	JSONObject datas = JSONObject.fromObject(dataCustomize);
		return returnResult(datas);
    }
	
	/**
	 * 添加或修改定制鞋
	 * add by zrh 2018年1月17日 下午4:25:42
	 *
	 * @return
	 */
	public String addCustomize(){
		Instrument i=new Instrument();
		/*Random random = new Random();
		String radom = String.valueOf(Math.ceil(Math.random()*10000000));*/
		customize.setCustomizeCard(i.returnOrderNum(2));
		boolean isOk = customizeService.addCustomize(customize);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}
	
	/**
	 * 删除定制鞋
	 * add by zrh 2018年1月17日 下午4:26:00
	 *
	 * @return
	 */
	public String deleteCustomize(){
		boolean isOk = customizeService.deleteCustomize(customizeIds);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}
	
	/**
	 * 返回所有的鞋子尺寸
	 * add by zrh 2018年1月18日 下午4:07:59
	 *
	 * @return
	 */
	public String getSizeName(){
		List<Size> sizeList = customizeService.getSizeName();
		JSONArray datas = JSONArray.fromObject(sizeList);
		return returnResult(datas);
	}
	

	
	
	
	public String getCustomizeCards() {
		return customizeCards;
	}

	public void setCustomizeCards(String customizeCards) {
		this.customizeCards = customizeCards;
	}

	public Customize getCustomize() {
		return customize;
	}

	public void setCustomize(Customize customize) {
		this.customize = customize;
	}

	public List<Integer> getCustomizeIds() {
		return customizeIds;
	}

	public void setCustomizeIds(List<Integer> customizeIds) {
		this.customizeIds = customizeIds;
	}
	
	
}
