package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.shoe.pojo.Security;
import com.shoe.pojo.User;
import com.shoe.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * ����User�Ķ���
 * 
 * @author ����
 * 
 */
/*@Results({ // ���ؽ�� ,���ؽ��Ϊnameʱ,�ͻ���ת��location�Ľ���
		@Result(name = "success", location = "/success.jsp"), @Result(name = "failure", location = "/failure.jsp") })*/
public class UserAction extends ActionSupport {
	//
	/**
	 * ע��User������
	 * 
	 * @see UserService
	 */
	@Resource
	private UserService userService;

	/**
	 * ͨ��get����ע��һ��io��
	 */
	private InputStream data;

	public InputStream getData() {
		return data;
	}
	/**
	 * <p>ͨ��get����ע������rows ҳ��page
	 */
	private Integer rows;
	private Integer page;
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * ͨ��get����ע��ID������ids,����Ҫ���ĸı�;
	 */
	private Integer[] ids;
	private String freeze;
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getFreeze() {
		return freeze;
	}
	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}
	
	
	
	
	
	public String updateUser(){
		boolean isok= userService.updateUser(ids, freeze);

		System.out.println(freeze+ids);
		JSONObject json=new JSONObject();
		json.put("isok", isok);
		try {
		data=new ByteArrayInputStream(json.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	
	/**
	 * ����Ϊaction����,����ΪgetUser
	 * 
	 * @return
	 */
	@Action(value = "getUser")
	public String getUser() {
		List<User> users = null;
		List<Security> userSecurity = null;
		Integer count ;
		try {
			/**
			 * �õ������û�����������
			 */
			users = userService.getUser();
			userSecurity = userService.getSecurity();
			//count��������û�����
			count=users.size();
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * һ������͵�����ҳ��,����500������
			 */
			return "failure";
		}
		

		/*
		 * �����õ����û���Ϣ������
		 */
		
		/**
		 * 1.����һ�������洢����ֵ��json�ַ���
		 */
		JSONArray jsonarr = new JSONArray();


		int num=1;
		for (User user : users) {
			String str = null;
			Integer no = user.getSecurityId();
			// ���û������idȡ�����������ȶ�,������Ӧ�����ֶ��ҳ���
			for (Security sec : userSecurity) {
				if (sec.getSecurityId() == no) {
					str = sec.getSecurityQuestion();
					break;
				}
			}
			JSONObject json = new JSONObject();
			// ��ÿ���û���Ϣ�����Ӧ�����ֶη���һ��
			json.put("user", user);
			json.put("question", str);
			//�����û��ı��,���ں�������
			json.put("num",num++ );
			jsonarr.add(json);
		}
		
		//����������
		int deal=deal(count);
		/**
		 * 2.��ҳ����
		 */
		JSONObject js=new JSONObject();
		/**
		 * ҳ��Խ�缰��ҳ��������һҳ�������,���ص�һҳ������
		 */
		//if(deal==0||deal==2){
			
			//json���� state������ǰ̨ҳ���ṩ�ο�
			//json.put("state", deal);  
		//	js.put("rows", count);
			
			//JSONArray jsons = jsons(jsonarr, 1);
			
		//	js.put("total", jsons);
			
			
			
			/**
			 * ҳ�����������һҳ(��һ����װ��) ��ҳ�����м�ҳ��ʱ��,��ʾ�����page��Ӧҳ
			 */
		//}else if(deal==1||deal==3){
			//JSONObject json=new JSONObject();
			//json.put("state", deal);
			js.put("total", count);
			
			
			
			JSONArray jsons = jsons(jsonarr, this.page);
			
			js.put("rows", jsons);
			//js.add(json);
/*			js.add(jsons);*/
		//}
		
		
		System.out.println(js);
		/**
		 * <p>�����ѯ���Ľ��
		 * <p>�����д��jsonȻ�����ñ��뼯
		 */
		try {
			data = new ByteArrayInputStream(js.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			/**
			 * һ������͵�����ҳ��,����500������
			 */
			return "failure";
		}
		System.out.println(rows+""+page+count);
		System.out.println("Action����");
		return "success";

	}
	/**
	 * <p>�����ж����û�����ҳ�������Ĺ�ϵ
	 * @param count
	 * @return 0 ��ʾ������ҳ��Խ��<p>1 ��ʾ���������һҳ<p>2 ��ʾ������ֻ����һҳ<p>3��ʾ ���м�ҳ
	 */
	public int deal(int count){
		if(count<(page-1)*rows){
			return 0;
		}else if(count>(page-1)*rows){
			return 1;
		}else if(count<rows){
			return 2;
		}
		return 3;
	}
	/**
	 * �����ַ���
	 * @param jsonArray �������ַ���
	 * @param page ��ǰҳ��
	 * @return 
	 */
	public JSONArray jsons(JSONArray jsonArray, int page){
		JSONArray js=new JSONArray();
		//����json�ַ���
		for(int i=0;i<jsonArray.size();i++){ 
			Object object =jsonArray.get(i);
			JSONObject json=JSONObject.fromObject(object);
			//������������json�����װ��json��������
			int num=json.getInt("num");
			if(num>(page-1)*rows&&num<=page*rows){
				JSONObject jsonx=new JSONObject();
				jsonx.put("userId",json.getJSONObject("user").getInt("userId"));
				jsonx.put("userAccount", json.getJSONObject("user").getString("userAccount"));
				jsonx.put("userDate", json.getJSONObject("user").getString("userDate"));
				jsonx.put("userEmail", json.getJSONObject("user").getString("userEmail"));
				jsonx.put("userSex", json.getJSONObject("user").getInt("userSex")==0?"��":"Ů");
				jsonx.put("userName", json.getJSONObject("user").getString("userName"));
				jsonx.put("userStatus", json.getJSONObject("user").getInt("userStatus")==0?"����":"���");
				jsonx.put("userTel", json.getJSONObject("user").getString("userTel"));
				jsonx.put("question", json.getString("question"));
				jsonx.put("userAnswer", json.getJSONObject("user").getString("userAnswer"));


				System.out.println(jsonx);
				js.add(jsonx);
			}
		}
		//������ҳ����ɹ��� json�ַ���
		return js;
	}
/*	*//**
	 * ��ѯȫ���Ա��������
	 * @return
	 * @throws Exception
	 *//*
	public List<User> getAllUser() throws Exception{
		List<User> users = null;
		List<Security> userSecurity = null;
		users = userService.getUser();
		userSecurity = userService.getSecurity();
		//count��������û�����
		count=users.size();

		return users;
		
	}*/
}
