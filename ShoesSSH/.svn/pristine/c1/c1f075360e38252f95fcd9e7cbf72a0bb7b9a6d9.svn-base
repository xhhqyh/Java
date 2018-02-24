package com.shoe.framework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Instrument {
	/**
	 * 获取当前时间的时间戳<p>
	 * add by liyang 2018年1月20日 下午2:21:45
	 * 
	 * @return 返还的是一个字符串类型
	 */
	public String getCurrentTime(){
		long now=System.currentTimeMillis();
		String str=String.valueOf(now);
		return str;
	}
	/**
	 * 获取当前订单号<p>
	 * 生成方式为:在一个13位的时间戳前后分别加一个随机数;<p>
	 * add by liyang 2018年1月20日 下午2:40:35
	 * 
	 * @return
	 */
	public String returnOrderNum(){
		//获取当前时间
		String time=getCurrentTime();
		int n1=(int) Math.ceil((Math.random()*10));
		int n2=(int) Math.floor((Math.random()*10));
		int n3=(int) Math.floor((Math.random()*10));
		String paymentID=n1+time+n2+n3;
		return paymentID;
	}
	public String returnOrderNum(int i){
		//获取当前时间
		String time=getCurrentTime();
		int n2=(int) Math.floor((Math.random()*10));
		String paymentID=time+n2;
		return paymentID;
	}
	/**
	 * 解析订单号<p>获取订单号的时间<p>
	 * add by liyang 2018年1月20日 下午2:42:20
	 *
	 */
	public Date getOrderTime(String str){
		//截取字符串,获取的是时间戳的字符串
		str=str.substring(1,str.length()-2);
		long time = Long.parseLong(str);
		//制定时间格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strTime = format.format(time);
		Date date = null;
		try {
			date = format.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
