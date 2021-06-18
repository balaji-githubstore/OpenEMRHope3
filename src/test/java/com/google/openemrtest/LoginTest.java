package com.google.openemrtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;

public class LoginTest extends WebDriverWrapper{ 
	
	@Test(priority=1)
	public void validCredentialTest()
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
		login.loginButton();
		Assert.assertEquals(login.getPagename(), "Patient: None" );
	}

}
