package com.google.openemrtest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	
	//peter,peter123
	//john,john123
	//king,king123
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
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println(username+password);
	}

}
