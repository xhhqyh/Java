package com.shoe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.PointDao;
import com.shoe.pojo.Color;
import com.shoe.pojo.Goods;
import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;
import com.shoe.pojo.Size;

import net.sf.json.JSONObject;

@Service  
@Transactional
public class PointServiceImpl implements PointService {

	@Resource 
	private PointDao pointDao;
	@Override
	public Map<String, Object> getPointShop(Integer currentPage,Integer pageSize ,Integer statuss) {
		
		//≤‚ ‘”√
		/*currentPage=1;
		pageSize=10;*/
		
		
		Map<String,Object> map=new HashMap<String,Object>();		
		try {		
			map.put("total", pointDao.getPointGoodsCount());
			map.put("rows", pointDao.getPointGoods(currentPage,pageSize,statuss));
			System.out.println(map);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public boolean updateStatus(Integer status,Integer id) {
		boolean flag=false;
		try {
			flag=pointDao.updateStatus(status,id)>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return flag;
	}
	@Override
	public Object deletePointByIds(Integer[] ids) {
		boolean flag=false;
		try {
			int result = pointDao.deletePointByIds(ids);
			if(result>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returns(flag);
	}
	@Override
	public Object getSize() {
		
		List<Size> sizes=null;
		try {
			sizes= pointDao.getSize(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizes;
	}
	@Override
	public Object getColor() {
		List<Color> colors=null;
		try {
		colors= pointDao.getColor(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colors;
	}
	@Override
	public Object saveOrUpdate(PointVo pointVO) {
		boolean flag=false;
		try {
			flag=pointDao.saveOrUpdate(pointVO)>0;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return returns(flag);
	}
	@Override
	public Object getGoods() {
		List<Goods> goods=null;
		List<Map<String, Object>> result =new ArrayList<Map<String, Object>>();
		try{
			goods=pointDao.getGoods();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Goods good:goods){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("goodsId", good.getGoodsId());
			map.put("goodsName", good.getGoodsName());
			result.add(map);
		}
		return result;
	}
	public Object returns(boolean flag){
		JSONObject json=new JSONObject();
		json.put("isok", flag);
		Map<String, Object> map=new HashMap<String ,Object>();		
		map.put("isok", flag);
		return json;
	}
}
