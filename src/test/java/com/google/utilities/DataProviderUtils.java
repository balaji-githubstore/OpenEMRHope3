package com.google.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
		@DataProvider
		public Object[][] validData()
		{
			Object[][] main=new Object[3][2];
			//i-->no of test case
			//j-->no of parameter
			main[0][0]="peter";
			main[0][1]="peter123";
			
			main[1][0]="john";
			main[1][1]="john123";
			
			main[2][0]="king";
			main[2][1]="king123";
			
			return main;
		}

}
