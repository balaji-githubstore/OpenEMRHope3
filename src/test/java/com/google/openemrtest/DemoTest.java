package com.google.openemrtest;

import org.testng.annotations.Test;

import com.google.utilities.DataProviderUtils;

public class DemoTest {
	
	
	@Test(dataProvider = "validData",dataProviderClass = DataProviderUtils.class)
	public void validTest(String username,String password)
	{
		System.out.println(username+password);
	}

}	
