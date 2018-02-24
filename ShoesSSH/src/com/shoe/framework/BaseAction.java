package com.shoe.framework;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.shoe.pojo.Img;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 图片上传工具类
 * add by qyh 2018年1月13日 上午11:28:51
 *
 */
public class BaseAction {
	public Integer rows;
	public Integer page;
	public InputStream returnData;
	
	public File files;//跟文件选择域的name属性的值一致
	public String filesFileName;//获取文件名：files + FileName
	public String filesContentType;//获取上传文件的文件类型 files + ContentType
	
	public File manyfiles[];//跟文件选择域的name属性的值一致
	public String manyfilesFileName[];//获取文件名：files + FileName
	public String manyfilesContentType[];//获取上传文件的文件类型 files + ContentType
	
	/**
	 * 上传单个图片
	 * add by qyh 2018年1月13日
	 * @return
	 */
	public String uploadOneImg(){
		String imgUrl = null;
		if(files != null){
			//图片保存路径
			String path = "D:/uploadimg/"+filesFileName;
			//图片原路径路径
			File file = new File(path);
			/**
			 * 拷贝文件
			 * srcFile 文件的来源
			 * destFile 目标文件
			 */
			try {
				FileUtils.copyFile(files, file);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("图片上传失败");
			}
			
			//数据库要保存的路径
			imgUrl = "/uploadimg/"+filesFileName;
		}
		return imgUrl;
	}
	
	/**
	 * 多图片上传
	 * add by qyh 2018年1月16日
	 * @return
	 */
	public Set<Img> uploadManyImg(){
		
		Set<Img> imgUrl = new HashSet<Img>();
		if(manyfiles != null && manyfiles.length > 0){
			for(int i=0; i<manyfiles.length; i++){
				Img img = new Img();
				//路径
				String path = "D:/uploadimg/"+manyfilesFileName[i];
				//定位路径
				File file = new File(path);
				//图片数据库保存路径
				path = "/uploadimg/"+manyfilesFileName[i];
				
				img.setImgUrl(path);
				imgUrl.add(img);
				//拷贝文件
				try {
					FileUtils.copyFile(manyfiles[i], file);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("多图片上传出错....");
				}
			}
		}
		return imgUrl;
	}
	
	/**
	 * 返回Java字符串
	 * add by qyh 2018年1月13日
	 * @param obj
	 * @return
	 */
	public String returnResult(Object obj){
		String result = "success";
		try {
			returnData = new ByteArrayInputStream(obj.toString().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("json格式化错误!");
			result = "false";
		}
		return result;
	}
	
	/**
	 * 返回json字符串，处理时间格式
	 * add by qyh 2018年1月18日 上午11:11:31
	 * 
	 * @param obj
	 * @return
	 */
	public String returnHandleDateRe(Map<String, Object> obj){
		String result = "success";
		try {
			JSONObject datas = JSONObject.fromObject(obj);
			JsonConfig jf = new JsonConfig();
			jf.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
			jf.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
			returnData = new ByteArrayInputStream(datas.fromObject(obj,jf).toString().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("json格式化错误!");
			result = "false";
		}
		return result;
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
	
	public String getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String filesContentType) {
		this.filesContentType = filesContentType;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public String getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	}

	public File[] getManyfiles() {
		return manyfiles;
	}

	public void setManyfiles(File[] manyfiles) {
		this.manyfiles = manyfiles;
	}

	public String[] getManyfilesFileName() {
		return manyfilesFileName;
	}

	public void setManyfilesFileName(String[] manyfilesFileName) {
		this.manyfilesFileName = manyfilesFileName;
	}

	public String[] getManyfilesContentType() {
		return manyfilesContentType;
	}

	public void setManyfilesContentType(String[] manyfilesContentType) {
		this.manyfilesContentType = manyfilesContentType;
	}
	
}
