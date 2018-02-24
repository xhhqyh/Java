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
 * �˵������Ʋ�
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
	 * ��ȡ�˵���Ϣ
	 * @throws Exception
	 */
	public String getMenuByRoleId() throws Exception{
		//�����Ựsession
		HttpSession session = ServletActionContext.getRequest().getSession();		
		Manager manager = (Manager) session.getAttribute("manager");//��session��ȡ��ǰ��¼����Ա��Ϣ
		int roleId = manager.getRole().getRoleId();
//		System.out.println(roleId);
		//һ���˵��õ���Json(Object)
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
			//�𼶵ݹ��²�ڵ�
			getChildrenNodes(lv2Pid, json, menuList);
			
			lv1Data.add(json);
			menus.put("menus",lv1Data );
		}
		//��JSON����toString Ȼ��ת���� byte���͵ļ��� ��װ��data��
		returnData = new ByteArrayInputStream(menus.toString().getBytes("utf-8"));
		return "success";		
	}
	
	/**
	 * ��ȡ�ӽڵ�
	 * @param pid
	 * @param parentJson
	 * @param currentList
	 */
	public void getChildrenNodes(int pid, JSONObject parentJson, List<Menu> currentList){
		//��ȡ��ǰ��������нڵ�
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
	 * ��ȡ�˵���Ϣ
	 * @throws Exception
	 */
	public void getMenu() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Manager manager = (Manager) session.getAttribute("manager");//��session��ȡ��ǰ��¼����Ա��Ϣ
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
			//�𼶵ݹ��²�ڵ�
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
	 * ��ȡ�ӽڵ�
	 * @param pid
	 * @param parentJson
	 * @param currentList
	 */
	public void getChildrenNode(int pid, JSONObject parentJson, List<Menu> currentList){
		//��ȡ��ǰ��������нڵ�
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