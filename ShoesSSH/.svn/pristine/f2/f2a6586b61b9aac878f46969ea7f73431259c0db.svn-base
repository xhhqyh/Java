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
 * 处理User的动作
 * 
 * @author 李杨
 * 
 */
/*@Results({ // 返回结果 ,返回结果为name时,就会跳转到location的界面
		@Result(name = "success", location = "/success.jsp"), @Result(name = "failure", location = "/failure.jsp") })*/
public class UserAction extends ActionSupport {
	//
	/**
	 * 注入User服务类
	 * 
	 * @see UserService
	 */
	@Resource
	private UserService userService;

	/**
	 * 通过get方法注入一个io流
	 */
	private InputStream data;

	public InputStream getData() {
		return data;
	}
	/**
	 * <p>通过get方法注入行数rows 页数page
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
	 * 通过get方法注入ID的数组ids,及需要做的改变;
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
	 * 声明为action方法,名字为getUser
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
			 * 拿到所有用户及所有问题
			 */
			users = userService.getUser();
			userSecurity = userService.getSecurity();
			//count用来存放用户总数
			count=users.size();
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * 一旦报错就弹错误页面,避免500的尴尬
			 */
			return "failure";
		}
		

		/*
		 * 处理拿到的用户信息及问题
		 */
		
		/**
		 * 1.建立一个用来存储返回值的json字符串
		 */
		JSONArray jsonarr = new JSONArray();


		int num=1;
		for (User user : users) {
			String str = null;
			Integer no = user.getSecurityId();
			// 将用户问题的id取出来和问题表比对,并将对应问题字段找出来
			for (Security sec : userSecurity) {
				if (sec.getSecurityId() == no) {
					str = sec.getSecurityQuestion();
					break;
				}
			}
			JSONObject json = new JSONObject();
			// 将每个用户信息及其对应问题字段放在一起
			json.put("user", user);
			json.put("question", str);
			//存入用户的编号,便于后续操作
			json.put("num",num++ );
			jsonarr.add(json);
		}
		
		//处理总行数
		int deal=deal(count);
		/**
		 * 2.分页操作
		 */
		JSONObject js=new JSONObject();
		/**
		 * 页数越界及总页数不过第一页的情况下,返回第一页的数据
		 */
		//if(deal==0||deal==2){
			
			//json参数 state用来给前台页面提供参考
			//json.put("state", deal);  
		//	js.put("rows", count);
			
			//JSONArray jsons = jsons(jsonarr, 1);
			
		//	js.put("total", jsons);
			
			
			
			/**
			 * 页数正好是最后一页(不一定能装满) 和页数是中间页的时候,显示传入的page对应页
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
		 * <p>输出查询到的结果
		 * <p>将结果写入json然后设置编码集
		 */
		try {
			data = new ByteArrayInputStream(js.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			/**
			 * 一旦报错就弹错误页面,避免500的尴尬
			 */
			return "failure";
		}
		System.out.println(rows+""+page+count);
		System.out.println("Action结束");
		return "success";

	}
	/**
	 * <p>用来判断总用户数与页数行数的关系
	 * @param count
	 * @return 0 表示行数与页数越界<p>1 表示正好是最后一页<p>2 表示总行数只够第一页<p>3表示 是中间页
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
	 * 处理字符串
	 * @param jsonArray 待处理字符串
	 * @param page 当前页面
	 * @return 
	 */
	public JSONArray jsons(JSONArray jsonArray, int page){
		JSONArray js=new JSONArray();
		//遍历json字符串
		for(int i=0;i<jsonArray.size();i++){ 
			Object object =jsonArray.get(i);
			JSONObject json=JSONObject.fromObject(object);
			//将符合条件的json对象封装到json数组里面
			int num=json.getInt("num");
			if(num>(page-1)*rows&&num<=page*rows){
				JSONObject jsonx=new JSONObject();
				jsonx.put("userId",json.getJSONObject("user").getInt("userId"));
				jsonx.put("userAccount", json.getJSONObject("user").getString("userAccount"));
				jsonx.put("userDate", json.getJSONObject("user").getString("userDate"));
				jsonx.put("userEmail", json.getJSONObject("user").getString("userEmail"));
				jsonx.put("userSex", json.getJSONObject("user").getInt("userSex")==0?"男":"女");
				jsonx.put("userName", json.getJSONObject("user").getString("userName"));
				jsonx.put("userStatus", json.getJSONObject("user").getInt("userStatus")==0?"正常":"封号");
				jsonx.put("userTel", json.getJSONObject("user").getString("userTel"));
				jsonx.put("question", json.getString("question"));
				jsonx.put("userAnswer", json.getJSONObject("user").getString("userAnswer"));


				System.out.println(jsonx);
				js.add(jsonx);
			}
		}
		//返还分页处理成功的 json字符串
		return js;
	}
/*	*//**
	 * 查询全体会员及其问题
	 * @return
	 * @throws Exception
	 *//*
	public List<User> getAllUser() throws Exception{
		List<User> users = null;
		List<Security> userSecurity = null;
		users = userService.getUser();
		userSecurity = userService.getSecurity();
		//count用来存放用户总数
		count=users.size();

		return users;
		
	}*/
}
