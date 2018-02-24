package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.shoe.pojo.Img;
import com.shoe.pojo.Type;
import com.shoe.service.ImgService;

import net.sf.json.JSONArray;

/**
 * 商品图片控制层
 * add by wyh 2018年1月13
 *
 *
 */
public class ImgAction {
	
	//装配服务层实例
	@Resource
	private ImgService imgService;
	
	private Integer goodId;
	private InputStream returnData;
	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public InputStream getReturnData() {
		return returnData;
	}
	/**
	 * 根据商品Id查出图片
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getImgs() throws UnsupportedEncodingException{
		List<Img> imgsList = imgService.getImgs(goodId);		
		JSONArray datas = JSONArray.fromObject(imgsList);
		returnData = new ByteArrayInputStream(datas.toString().getBytes("utf-8"));
		System.out.println(datas);
		return "success";		
	}

}
