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
	
		//all cell value
		FileInputStream file = new FileInputStream("src/test/resources/testdata/OpenEMRData.xlsx"); // location
		XSSFWorkbook book = new XSSFWorkbook(file); // open
		XSSFSheet sheet = book.getSheet("validCredentialTest"); // sheet
		
		
		
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<4;c++)
			{
				XSSFRow row = sheet.getRow(r);
				XSSFCell cell = row.getCell(c);
				
				DataFormatter format=new DataFormatter();
				String cellValue = format.formatCellValue(cell);
				System.out.println(cellValue);
				
			}
			System.out.println("-----------------------");
		}
		
		
	}

}




