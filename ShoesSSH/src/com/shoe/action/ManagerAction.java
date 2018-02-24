package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.shoe.pojo.Manager;
import com.shoe.pojo.ManagerVO;
import com.shoe.pojo.Role;
import com.shoe.service.EvaluteService;
import com.shoe.service.ManagerService;

import net.sf.json.JSONObject;

/**
 * 管理员信息管理控制层
 * @gx add by 2018-1-11 
 * 
 */
public class ManagerAction {

	@Resource
	private ManagerService managerService;

	@Resource
	private EvaluteService evaluteService;
	private Manager manager;

	private InputStream returnJson;
	private Integer rows;
	private Integer page;
	private InputStream returnData;
	private List<Integer> resId;
	private Role role;
	private ManagerVO managerVO;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

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

	public InputStream getReturnData() {
		return returnData;
	}

	public List<Integer> getResId() {
		return resId;
	}

	public void setResId(List<Integer> resId) {
		this.resId = resId;
	}

	/**
	 * 管理员登录
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String loginManager() throws UnsupportedEncodingException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		JSONObject data = new JSONObject();
		List<Manager> managerList = managerService.loginManager(manager);
		//未读信息数量
		long count = evaluteService.getEvaluteCount();
		
		if (managerList != null && managerList.size()>0) {
			session.setAttribute("count", count);
			session.setAttribute("manager", managerList.get(0));// 登录成功情况下,将登录者信息存储进session中
			session.setAttribute("username", managerList.get(0).getManagerName());
			data.put("msg", "success");
		} else {
			data.put("msg", "您的账号或密码有误");
		}
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		//System.out.println(manager.getRole().getRoleId());
		return "success";
	}

	/**
	 * 管理员信息分页显示
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getManagerList() throws UnsupportedEncodingException {
		Map<String, Object> dataManager = managerService.getManagerPage(page, rows);
		JSONObject data = JSONObject.fromObject(dataManager);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
	}

	
	/**
	 * 添加或修改管理员信息方法
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String addManager() throws UnsupportedEncodingException {
		System.out.println(managerVO);
		boolean isOk = managerService.addManager(managerVO);//修改或添加时调用managerVO
		JSONObject data = new JSONObject();
		data.put("isOk", isOk);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
	}

	/**
	 * 删除管理员操作
	 * @param resId 前台获取的选中managerId的集合
	 */
	public String deleteManager() throws UnsupportedEncodingException {
		boolean isOk = managerService.deleteManager(resId);
		JSONObject data = new JSONObject();
		data.put("isOk", isOk);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
	}

	/**
	 * add by wyh 2018-1-22   
	 * @return 安全退出 清除缓存
	 * @throws UnsupportedEncodingException
	 */
	public String getLoginOut() throws UnsupportedEncodingException{		
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();		//清除缓存
		//session.invalidate();
		
		session.setAttribute("manager", null);
		session.setAttribute("username", null);
		
		JSONObject data = new JSONObject();
		data.put("isOk", true);
		returnData = new ByteArrayInputStream(data.toString().getBytes("utf-8"));
		return "success";
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ManagerVO getManagerVO() {
		return managerVO;
	}

	public void setManagerVO(ManagerVO managerVO) {
		this.managerVO = managerVO;
	}

}
