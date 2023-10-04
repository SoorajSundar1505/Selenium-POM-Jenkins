package com.automation.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	public static FileInputStream input;
	private static String filepath = System.getProperty("user.dir")+"/src/main/resource/testdata.xlsx";
	
	public static void readExcel(String columnName) throws IOException {
		input = new FileInputStream(filepath);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheetAt(0);
		int count = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=1;i<count+1;i++) {
			Row row = sheet.getRow(i);	
		}
	}

	public static void  getColumnValues() throws IOException {
		input = new FileInputStream(filepath);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheetAt(0);
//		Row row = sheet.getRow(0);
		for(int i=1;i<sheet.getLastRowNum()+1;i++) {
			Row row=sheet.getRow(i);
			int count = row.getLastCellNum();
			for(int j=0;j<count;j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
		}
		
	}
}
