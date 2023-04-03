package com.w2a.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	
	public ExcelReader(String path) {
		
		try {
			file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
			file.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount(String sheetName) {
		
		sheet = workbook.getSheet(sheetName);
		
		int rowNum = sheet.getLastRowNum();
		
		if(rowNum > -1)
			return rowNum;
		
		return -1;
	}
	
	public int getColCount(String sheetName) {
		
		sheet = workbook.getSheet(sheetName);
		
		if(getRowCount(sheetName) > -1) {
			
			row = sheet.getRow(0);
			int colNum = row.getLastCellNum();
			return colNum;
		}
		
		return -1;
		
	}
	
	
	public String getCellData(String sheetName,int rowNum,int colNum) {
		
		int index = workbook.getSheetIndex(sheetName);
		
		if(index == -1) {
			System.out.println("Invalid sheetName");
		}
		
		sheet = workbook.getSheetAt(index);
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		if(cell.getCellType() == CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType() == CellType.NUMERIC)
		{
			return (String) String.valueOf((int)cell.getNumericCellValue());
		}
		
		return "";
	}
	
	
	public Object[][] getData(String sheetName) {
		
		int sheetIndex = workbook.getSheetIndex(sheetName);
		
		if(sheetIndex < 0 ) {
			return null;
		}
		
		sheet = workbook.getSheet(sheetName);
		
		int rowNum = getRowCount(sheetName);
		int colNum = getColCount(sheetName);
		
		Object data[][] = new Object[rowNum][1];
		
		HashMap<String,String> map = null;
		
		if(rowNum > -1 && colNum > -1) {
			
			for(int i=1;i<=rowNum;i++) {  
				map = new HashMap<String,String>();
				
				for(int j=0;j<colNum;j++) {
					map.put(getCellData(sheetName,0,j), getCellData(sheetName,i,j));
				}
				data[i-1][0] = map;
			}	
		}
		
		return data;
		
	}

}
