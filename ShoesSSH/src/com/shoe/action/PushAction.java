package com.shoe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.shoe.framework.BaseAction;
import com.shoe.pojo.Push;
import com.shoe.service.PushService;

import net.sf.json.JSONObject;

public class PushAction extends BaseAction{
	// 装配实例
		@Resource
		private PushService pushService;

		private Push push;
		private List<Integer> pushIds;
		
		/**
		 * 推送列表
		 * add by zrh 2018年1月15日 上午9:48:53
		 *
		 * @return
		 */
		public String getPushList() {
			Map<String, Object> dataPush = pushService.getPushList(page, rows);
			JSONObject datas = JSONObject.fromObject(dataPush);
			return returnResult(datas);
		}
		
		/**
		 * 添加或修改
		 * add by zrh 2018年1月15日 下午3:14:03
		 *
		 * @return
		 */
		public String addPush(){
			/*
			 * 图片链接
			 */
			push.setPushImg(uploadOneImg());
			Boolean isOk = pushService.addPush(push);
			JSONObject datas = new JSONObject();
			datas.put("isOk", isOk);
			return returnResult(datas);
		}
		
		/**
		 * 删除
		 * add by zrh 2018年1月15日 下午3:14:15
		 *
		 * @return
		 * @throws UnsupportedEncodingException
		 */
		public String deletePush() throws UnsupportedEncodingException {
			boolean isOk = pushService.deletePushList(pushIds);
			JSONObject datas = new JSONObject();
			datas.put("isOk", isOk);
			return returnResult(datas);
		}
		
		
		
		
		public PushService getPushService() {
			return pushService;
		}
		public void setPushService(PushService pushService) {
			this.pushService = pushService;
		}
		public Push getPush() {
			return push;
		}
		public void setPush(Push push) {
			this.push = push;
		}
		public List<Integer> getPushIds() {
			return pushIds;
		}
		public void setPushIds(List<Integer> pushIds) {
			this.pushIds = pushIds;
		}
}
