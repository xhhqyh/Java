package com.shoe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoe.dao.EchartsDao;
import com.shoe.pojo.EchartsSex;

/**
 * 
 * add by wyh 2018年1月17<p>
 * 报表服务层接口实现类
 *
 */
@Service  
@Transactional
public class EchartsServiceImpl implements EchartsService {

	//装配dao 层
	@Resource
	private EchartsDao echartsDao;
	
	/**
	 * add by wyh 2018年1月17
	 * 返回 男鞋 月份 数量
	 */
	@Override
	public List<EchartsSex> getEchartSex() {
		List<EchartsSex> echarts = null;
		try {
			echarts = echartsDao.getEchsrtSex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return echarts;
	}
	/**
	 * add by wyh 2018年1月17
	 * 返回  女鞋 月份  数量
	 */
	@Override
	public List<EchartsSex> getEchartSexWomen() {
		List<EchartsSex> echarts = null;
		try {
			echarts = echartsDao.getEchsrtSexWomen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return echarts;
	}
	/**
	 * add by wyh 2018年1月18
	 * 返回 X轴数据
	 */
	@Override
	public List<EchartsSex> getEchartLengd() {
		List<EchartsSex> echarts = null;
		try {
			echarts = echartsDao.getEchsrtLengd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return echarts;
	}
	
	/**
	 * 
	 * @return 根据月份来返回鞋子类型数据
	 */
	@Override
	public List<EchartsSex> getEchartType(String month) {
		List<EchartsSex> echarts = null;
		try {
			echarts = echartsDao.getEchsrtType(month);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return echarts;
	}
	

}
