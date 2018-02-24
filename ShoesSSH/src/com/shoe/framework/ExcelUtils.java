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
	 * ��ȡ���ݱ��
	 * add by qyh 2018��1��20�� ����11:13:02
	 * 
	 * @param excelFile ǰ̨�ϴ���excel�ļ�
	 * @param map ���ڴ洢������Ϣ
	 * @return ���ݱ��
	 */
	/*public static List<Goods> getExcelData(MultipartFile excelFile, ModelMap map){
		List<Goods> goodsList = new ArrayList<Goods>();		
		try {
			InputStream fis = excelFile.getInputStream();
			//��ȡexcel�ļ�
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			//��ȡ��һ��sheetҳ
			Sheet sheet = wb.getSheetAt(0);
			//������
			for(int i = 1;i<sheet.getPhysicalNumberOfRows();i++){
				Row row = sheet.getRow(i);
				int index = 0;
				//��Ʒ���
				Cell goodsIdCell = row.getCell(index++);
				int goodsId = goodsIdCell != null ?(int)goodsIdCell.getNumericCellValue() : 0;
				//����ID
				Cell typeIdCell = row.getCell(index++);
				int typeId = typeIdCell != null ?(int)typeIdCell.getNumericCellValue() : 0;
				//Ʒ��ID
				Cell brandIdCell = row.getCell(index++);
				int brandId = brandIdCell != null ?(int)brandIdCell.getNumericCellValue() : 0;
				//��Ʒ���к�
				Cell goodsNoCell = row.getCell(index++);
				int goodsNo = goodsNoCell != null ?(int)goodsNoCell.getNumericCellValue() : 0;
				//��Ʒ����
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//��Ʒ���ڼ۸�
				Cell goodsNewPriceCell = row.getCell(index++);
				Double goodsNewPrice = goodsNewPriceCell != null ? (double)goodsNewPriceCell.getNumericCellValue():0.0;
				//��Ʒ�ϼ�����
				SimpleDateFormat sdf = null;   
                sdf = new SimpleDateFormat("yyyy-MM-dd");    
                Date goodsDate = row.getCell(index++).getDateCellValue();				
				String goodDate =sdf.format(goodsDate);//������Ҫȡʱ�䣬date���ͺ�String����
				//��Ʒ����
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//��Ʒ����
				Cell goodsNameCell = row.getCell(index++);
				String goodsName = goodsNameCell != null ? goodsNameCell.getStringCellValue() : "";
				//��Ʒ����
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
