package com.google.openemrtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest {
	public static void main(String[] args) throws IOException {
		//read cell
		FileInputStream file = new FileInputStream("src/test/resources/testdata/OpenEMRData.xlsx"); // location
		XSSFWorkbook book = new XSSFWorkbook(file); // open
		XSSFSheet sheet = book.getSheet("validCredentialTest"); // sheet
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(1);
		
		DataFormatter format=new DataFormatter();
		String cellValue = format.formatCellValue(cell);
		System.out.println(cellValue);
		
	}

}
