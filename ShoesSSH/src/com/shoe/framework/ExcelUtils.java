package com.shoe.framework;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.shoe.pojo.Goods;

public class ExcelUtils {
	
	/**
	 * 
	 * 获取数据表格
	 * add by qyh 2018年1月20日 上午11:13:02
	 * 
	 * @param excelFile 前台上传的excel文件
	 * @param map 用于存储错误信息
	 * @return 数据表格
	 */
	/*public static List<Goods> getExcelData(MultipartFile excelFile, ModelMap map){
		List<Goods> goodsList = new ArrayList<Goods>();		
		try {
			InputStream fis = excelFile.getInputStream();
			//读取excel文件
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			//获取第一个sheet页
			Sheet sheet = wb.getSheetAt(0);
			//遍历行
			for(int i = 1;i<sheet.getPhysicalNumberOfRows();i++){
				Row row = sheet.getRow(i);
				int index = 0;
				//商品编号
				Cell goodsIdCell = row.getCell(index++);
				int goodsId = goodsIdCell != null ?(int)goodsIdCell.getNumericCellValue() : 0;
				//类型ID
				Cell typeIdCell = row.getCell(index++);
				int typeId = typeIdCell != null ?(int)typeIdCell.getNumericCellValue() : 0;
				//品牌ID
				Cell brandIdCell = row.getCell(index++);
				int brandId = brandIdCell != null ?(int)brandIdCell.getNumericCellValue() : 0;
				//商品序列号
				Cell goodsNoCell = row.getCell(index++);
				int goodsNo = goodsNoCell != null ?(int)goodsNoCell.getNumericCellValue() : 0;
				//商品名字
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//商品现在价格
				Cell goodsNewPriceCell = row.getCell(index++);
				Double goodsNewPrice = goodsNewPriceCell != null ? (double)goodsNewPriceCell.getNumericCellValue():0.0;
				//商品上架日期
				SimpleDateFormat sdf = null;   
                sdf = new SimpleDateFormat("yyyy-MM-dd");    
                Date goodsDate = row.getCell(index++).getDateCellValue();				
				String goodDate =sdf.format(goodsDate);//根据需要取时间，date类型和String类型
				//商品名字
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//商品名字
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//商品名字
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
