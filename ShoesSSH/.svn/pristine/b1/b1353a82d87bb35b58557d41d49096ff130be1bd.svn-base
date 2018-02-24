package com.shoe.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.shoe.framework.BaseAction;
import com.shoe.pojo.PointShop;
import com.shoe.pojo.PointVo;
import com.shoe.service.PointService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p>
 * 处理积分秒杀商品
 * 
 * @author 李杨
 *
 */
public class PointAction extends BaseAction {
	@Resource
	private PointService pointService;

	private PointVo pointVO;
	private Integer status;
	private Integer statuss;
	private Integer id;
	private Integer[] ids;
	private PointShop pointShop;

	public PointShop getPointShop() {
		return pointShop;
	}

	public void setPointShop(PointShop pointShop) {
		this.pointShop = pointShop;
	}

	public Integer getStatuss() {
		return statuss;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// 获取全部积分商品
	public String getPoint() {
		return returnResult(JSONObject.fromObject(pointService.getPointShop(page, rows, statuss)));
	}

	// 上架下架
	public String updatestatus() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isok", pointService.updateStatus(status, id));
		return returnResult(JSONObject.fromObject(map));
	}

	// 删除积分商品
	public String deletePoint() {
		return returnResult(JSONObject.fromObject(pointService.deletePointByIds(ids)));
	}

	// 查询尺寸 ---因为是做下拉框,所以拿到的应该是array而不是object
	public String getSize() {
		return returnResult(JSONArray.fromObject(pointService.getSize()));
	}

	// 查询颜色 ---因为是做下拉框,所以拿到的应该是array而不是object
	public String getColor() {
		return returnResult(JSONArray.fromObject(pointService.getColor()));
	}

	// 查询商品
	public String getGoods() {
		return returnResult(JSONArray.fromObject(pointService.getGoods()));
	}

	// 修改积分商品
	public String saveOrUpdate() {
		System.out.println(pointVO);
		return returnResult(JSONObject.fromObject(pointService.saveOrUpdate(pointVO)));
	}

	// 新增积分商品
	public String addPoint() {
		return "";
	}

	public PointVo getPointVO() {
		return pointVO;
	}

	public void setPointVO(PointVo pointVO) {
		this.pointVO = pointVO;
	}



}
