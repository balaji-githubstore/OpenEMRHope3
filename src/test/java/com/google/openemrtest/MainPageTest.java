package com.google.openemrtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;

public class MainPageTest extends WebDriverWrapper {

	@Test(priority = 2)
	public void patientsMenuTest() {
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
		login.loginButton();

		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickonPatients();
		// assertion
		PatientFinderPage pfPage=new PatientFinderPage(driver);
		Assert.assertEquals(pfPage.getPatientFinderHeader(), "Patient Finder");
	}
	
	@Test
	public void newSearchMenuTest()
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
		login.loginButton();
		
		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickOnNewSearchMenu();
		
		SearchOrAddPatientPage searchAddPage=new SearchOrAddPatientPage(driver);
		
		Assert.assertEquals(searchAddPage.getSearchOrAddPatientHeader(), "Search or Add Patient");
	}
	
	

}
