package com.google.openemrtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper{ 
	
	//admin,pass,English (Standard),Patient: None
	//physician,physician,English (Standard),Patient: None
	
	@Test(priority=1,dataProvider = "validCredentialData",dataProviderClass = DataProviderUtils.class)
	public void validCredentialTest(String username,String password,String language,String expectedValue)
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		Assert.assertEquals(login.getPagename(),  expectedValue);
	}

	@Test(dataProvider = "openEmrData",dataProviderClass = DataProviderUtils.class)
	public void invalidCredentialTest(String username,String password,String language,String expectedValue)
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		Assert.assertEquals(login.getErrorMessage(),  expectedValue);
	}
}
