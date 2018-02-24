package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.shoe.pojo.Manager;
import com.shoe.pojo.Menu;
import com.shoe.service.MenuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 菜单树控制层
 * @gx
 * add by 2018-1-11
 */
public class MenuAction {
	
	@Resource
	private MenuService menuService;

	private InputStream returnData;

	public InputStream getReturnData() {
		return returnData;
	}

	/**
	 * 获取菜单信息
	 * @throws Exception
	 */
	public String getMenuByRoleId() throws Exception{
		//声明会话session
		HttpSession session = ServletActionContext.getRequest().getSession();		
		Manager manager = (Manager) session.getAttribute("manager");//从session获取当前登录管理员信息
		int roleId = manager.getRole().getRoleId();
//		System.out.println(roleId);
		//一级菜单得到的Json(Object)
		JSONObject menus = new JSONObject();
		JSONArray lv1Data = new JSONArray();
		List<Menu> menuList = menuService.getRolePermissionMenu(roleId);
		List<Menu> lv1List = new ArrayList<Menu>();
		for(Menu menu: menuList){
			if(menu.getMenuPid() == 0){
				lv1List.add(menu);
			}
		}
		for(Menu menu : lv1List){
			int lv2Pid = menu.getMenuId();
			
			JSONObject json = new JSONObject();
			json.put("menuid", menu.getMenuId());
			json.put("menuname", menu.getMenuName());
			//json.put("pId", menu.getMenuPid());
			//json.put("url", menu.getMenuUrl());
			//json.put("state", "open");
			//逐级递归下层节点
			getChildrenNodes(lv2Pid, json, menuList);
			
			lv1Data.add(json);
			menus.put("menus",lv1Data );
		}
		//把JSON数据toString 然后转化成 byte类型的集合 封装到data中
		returnData = new ByteArrayInputStream(menus.toString().getBytes("utf-8"));
		return "success";		
	}
	
	/**
	 * 获取子节点
	 * @param pid
	 * @param parentJson
	 * @param currentList
	 */
	public void getChildrenNodes(int pid, JSONObject parentJson, List<Menu> currentList){
		//获取当前级别的所有节点
		List<Menu> currentLvList = new ArrayList<Menu>();
		for(Menu currntLvMenu: currentList){
			if(currntLvMenu.getMenuPid() == pid){
				currentLvList.add(currntLvMenu);
			}
		}
		
		if(currentLvList.size() > 0){
			JSONArray currentData = new JSONArray();
			for(Menu currentMenu: currentLvList){
				int currentPid = currentMenu.getMenuId();
				
				JSONObject currentjson = new JSONObject();
				//currentjson.put("id", currentPid);
				currentjson.put("menuname", currentMenu.getMenuName());
				//currentjson.put("pId", currentMenu.getMenuPid());
				currentjson.put("url", currentMenu.getMenuUrl());
				
				getChildrenNodes(currentPid, currentjson, currentList);
				
				currentData.add(currentjson);
			}
			
			parentJson.put("menus", currentData);
		}
	}	

	/**
	 * 获取菜单信息
	 * @throws Exception
	 */
	public void getMenu() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Manager manager = (Manager) session.getAttribute("manager");//从session获取当前登录管理员信息
		int roleId = manager.getRole().getRoleId();
//		System.out.println(roleId);
		JSONArray lv1Data = new JSONArray();
		List<Menu> menuList = menuService.getRolePermissionMenu(roleId);
		List<Menu> lv1List = new ArrayList<Menu>();
		for(Menu menu: menuList){
			if(menu.getMenuPid() == 0){
				lv1List.add(menu);
			}
		}
		for(Menu menu : lv1List){
			int lv2Pid = menu.getMenuId();
			
			JSONObject json = new JSONObject();
			json.put("id", lv2Pid);
			json.put("text", menu.getMenuName());
			json.put("pId", menu.getMenuPid());
			json.put("url", menu.getMenuUrl());
			json.put("state", "open");
			//逐级递归下层节点
			getChildrenNode(lv2Pid, json, menuList);
			
			lv1Data.add(json);
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(lv1Data.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * 获取子节点
	 * @param pid
	 * @param parentJson
	 * @param currentList
	 */
	public void getChildrenNode(int pid, JSONObject parentJson, List<Menu> currentList){
		//获取当前级别的所有节点
		List<Menu> currentLvList = new ArrayList<Menu>();
		for(Menu currntLvMenu: currentList){
			if(currntLvMenu.getMenuPid() == pid){
				currentLvList.add(currntLvMenu);
			}
		}
		
		if(currentLvList.size() > 0){
			JSONArray currentData = new JSONArray();
			for(Menu currentMenu: currentLvList){
				int currentPid = currentMenu.getMenuId();
				
				JSONObject currentjson = new JSONObject();
				currentjson.put("id", currentPid);
				currentjson.put("text", currentMenu.getMenuName());
				currentjson.put("pId", currentMenu.getMenuPid());
				currentjson.put("url", currentMenu.getMenuUrl());
				
				getChildrenNodes(currentPid, currentjson, currentList);
				
				currentData.add(currentjson);
			}
			parentJson.put("state", "open");
			parentJson.put("children", currentData);
		}
	}	
	
}
