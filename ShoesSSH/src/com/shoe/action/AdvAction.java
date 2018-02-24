package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;

import com.shoe.framework.BaseAction;
import com.shoe.pojo.Advertisement;
import com.shoe.service.AdvService;

import net.sf.json.JSONObject;

/**
 * 
 * add by qyh 2018年1月11日
 *
 * 广告管理控制层
 */

public class AdvAction extends BaseAction{
	
	//装配实例
	@Resource 
	private AdvService advService;

	private Advertisement adv;
	private List<Integer> advIds;
	
	/**
	 * 新增广告
	 * add by qyh 2018年1月12日
	 * @return
	 * @throws IOException 
	 */
	public String saveAdv() throws IOException{
		//广告计算价钱
		String start = adv.getAdverStartTime();
		String end = adv.getAdverEndTime();
		
		//截取月
		int stmo = Integer.parseInt(start.substring(5, 7));
		int enmo = Integer.parseInt(start.substring(5, 7));
		
		//截取日
		int st = Integer.parseInt(start.substring(8, 10));
		int en = Integer.parseInt(end.substring(8, 10));
		
		int day = 0;
		if(enmo == stmo){
			day = en - st;
		}else{
			day = (30-st) + en ;
		}
		
		//计算总费用
		double allPrice = day * 10; 
		adv.setAdverSalary(allPrice);

		//获取图片上传路径
		adv.setAdverImgUrl(uploadOneImg());
		
		boolean isOk = advService.saveAdv(adv);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}
	
	/**
	 * 获取广告信息
	 * add by qyh 2018年1月11日
	 * @return json字符串
	 * @throws UnsupportedEncodingException
	 */
	public String getAdvPageList() throws UnsupportedEncodingException {
		Map<String, Object> dataMap = advService.getAdvPageList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataMap);
		return returnResult(datas);
	}
	
	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	public String deleteAdvByIds() throws UnsupportedEncodingException{
		boolean isOk = advService.deleteAdvByIds(advIds);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}

	public Advertisement getAdv() {
		return adv;
	}
	public void setAdv(Advertisement adv) {
		this.adv = adv;
	}

	public List<Integer> getAdvIds() {
		return advIds;
	}

	public void setAdvIds(List<Integer> advIds) {
		this.advIds = advIds;
	}
}
























