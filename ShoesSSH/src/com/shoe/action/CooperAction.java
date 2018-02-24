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
import com.shoe.pojo.Cooperation;
import com.shoe.service.AdvService;
import com.shoe.service.CooperService;

import net.sf.json.JSONObject;

/**
 * 商务合作控制层
 * add by qyh 2018年1月12日 下午8:56:04
 *
 */
public class CooperAction extends BaseAction{
	//装配实例
	@Resource 
	private CooperService cooperService;
	
	private Cooperation cooper;
	private List<Integer> cooperIds;

	/**
	 * 新增广告
	 * add by qyh 2018年1月12日
	 * @return
	 * @throws IOException 
	 */
	public String saveCooper() throws IOException{
		//获取上传图片的保存路径
		cooper.setCpImgUrl(uploadOneImg());
		
		boolean isOk = cooperService.saveCooper(cooper);
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
	public String getCooperPageList() throws UnsupportedEncodingException {
		Map<String, Object> dataMap = cooperService.getCooperPageList(page, rows);
		JSONObject datas = JSONObject.fromObject(dataMap);
		return returnResult(datas);
	}
	
	/**
	 * 批量删除广告
	 * add by qyh 2018年1月12日
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	public String deleteCooperByIds() throws UnsupportedEncodingException{
		boolean isOk = cooperService.deleteCooperByIds(cooperIds);
		JSONObject datas = new JSONObject();
		datas.put("isOk", isOk);
		return returnResult(datas);
	}

	public Cooperation getCooper() {
		return cooper;
	}

	public void setCooper(Cooperation cooper) {
		this.cooper = cooper;
	}
	public List<Integer> getCooperIds() {
		return cooperIds;
	}

	public void setCooperIds(List<Integer> cooperIds) {
		this.cooperIds = cooperIds;
	}

}
