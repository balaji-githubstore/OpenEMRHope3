package com.google.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	
//	@DataProvider
//	public Object[][] invalidCredentialData() throws IOException {
//		Object[][] main = ExcelUtils.sheetIntoObject("src/test/resources/testdata/OpenEMRData.xlsx",
//				"invalidCredentialTest");
//		return main;
//	}
//
//	@DataProvider
//	public Object[][] patientsMenuData() throws IOException {
//		Object[][] main = ExcelUtils.sheetIntoObject("src/test/resources/testdata/OpenEMRData.xlsx",
//				"patientsMenuTest");
//		return main;
//	}
	 
	
	@DataProvider
	public Object[][] openEmrData(Method method) throws IOException
	{
		System.out.println(method.getName());
		Object[][] main = ExcelUtils.sheetIntoObject("src/test/resources/testdata/OpenEMRData.xlsx", method.getName());	
		return main;
	}
	
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object[][] main=new Object[2][4];
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Standard)";
		main[0][3]="Patient: None";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="English (Standard)";
		main[1][3]="Patient: None";
		
		return main;
	}

	@DataProvider
	public Object[][] validData() {
		Object[][] main = new Object[4][2];
		// i-->no of test case
		// j-->no of parameter
		main[0][0] = "peter";
		main[0][1] = "peter123";

		main[1][0] = "john";
		main[1][1] = "john123";

		main[2][0] = "king";
		main[2][1] = "king123";

		main[3][0] = "mark";
		main[3][1] = "mark123";

		return main;
	}

}
