package com.qa.utiliti;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import net.bytebuddy.asm.Advice.Return;

public class Utilities {
	
	
	
	  public static final int implicity_wait = 10;
	  public static final int page_load = 5;

	public static String dateTime() {
		
		 Date date = new Date();
		
		String dateS= date.toString().replace("", "").replace(":", "_");
		return "munmun67"+ dateS+ "@gmail.com";
	}

	
	public static Object[][] getDataFromeExel(String sheetNmae) {
		XSSFWorkbook workbook =null;
		
		File exelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\testdata\\testDatas.xlsx");
		try {
			FileInputStream fisExel = new FileInputStream(exelFile);
			
			 workbook = new XSSFWorkbook(fisExel);
			
		} catch (Throwable e) {	
           e.printStackTrace();			// TODO: handle exception
		}
        XSSFSheet   sheet =workbook.getSheet(sheetNmae);
		
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        
        Object [][] data = new Object [rows][cols];
        
        for(int i=0;i < rows;i++) {
        
            XSSFRow row= sheet.getRow(i+1);
        
            
            for(int j=0; j<cols;j++) {
            	
            XSSFCell	cell =row.getCell(j);
            
             org.apache.poi.ss.usermodel.CellType CellType = cell.getCellType();
             
             
             switch (CellType) {
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;

			case NUMERIC:
				data[i][j] = Integer.toString ( (int)cell.getNumericCellValue());
				break;
				
				
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
			}
             
            }
        }
        
        
        
        
        return data;
        
        
	}
	
	
	
}
