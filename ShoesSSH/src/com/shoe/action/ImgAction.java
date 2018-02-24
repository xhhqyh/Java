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
 * ��ƷͼƬ���Ʋ�
 * add by wyh 2018��1��13
 *
 *
 */
public class ImgAction {
	
	//װ������ʵ��
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
	 * ������ƷId���ͼƬ
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
