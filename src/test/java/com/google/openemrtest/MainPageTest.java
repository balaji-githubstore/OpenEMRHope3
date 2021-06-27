package com.google.openemrtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;
import com.google.utilities.DataProviderUtils;

public class MainPageTest extends WebDriverWrapper {

	@Test(priority = 2,dataProvider = "openEmrData",dataProviderClass = DataProviderUtils.class)
	public void patientsMenuTest(String username,String password,String language,String expectedValue) {
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();

		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickonPatients();
		// assertion
		PatientFinderPage pfPage=new PatientFinderPage(driver);
		Assert.assertEquals(pfPage.getPatientFinderHeader(), expectedValue);
	}
	
	@Test(dataProvider = "openEmrData",dataProviderClass = DataProviderUtils.class)
	public void newSearchMenuTest(String username,String password,String language,String expectedValue)
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		
		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickOnNewSearchMenu();
		
		SearchOrAddPatientPage searchAddPage=new SearchOrAddPatientPage(driver);
		
		Assert.assertEquals(searchAddPage.getSearchOrAddPatientHeader(),expectedValue);
	}
	
	

}
