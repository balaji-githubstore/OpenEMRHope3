package com.google.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientDashboardPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;

public class AddpatientpageTest extends WebDriverWrapper {
	
	
	@Test(priority = 3)
	public void AddpatientEmrpageTest()
	{
		//Loginpage
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
		login.loginButton();
		
		//MainPage
		MainPage main=new MainPage(driver);
		main.moveToPatientClient();
		main.clickonPatients();
			
		//PatientFinderPage
		PatientFinderPage patient= new PatientFinderPage(driver);
		patient.switchToFinFrame();
		patient.clickOnAddNewPatient();
		patient.switchOutOfFrame();
		
		
		//SearchOrAddPatientPage
		SearchOrAddPatientPage sapPage=new SearchOrAddPatientPage(driver);
		sapPage.switchToPatFrame();
		sapPage.titleOfTheName("Ms.");
		
		driver.findElement(By.id("form_fname")).sendKeys("samara");
		driver.findElement(By.id("form_lname")).sendKeys("wills");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-05-24");
		Select gender = new Select(driver.findElement(By.id("form_sex")));
		gender.selectByVisibleText("Female");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("modalframe");
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
		
		//PatientDashboardPage
		PatientDashboardPage pdPage=new PatientDashboardPage(driver);
		pdPage.waitForPresenceOfAlert();

		//create method getTextandHandleAlert
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();

		if(driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size()>0)
		{
			driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}
		
		String actualValue=driver.findElement(By.xpath("//span[@data-bind='text: pname()']")).getText();
		
		Assert.assertEquals(actualValue, "Samara Wills");
	}

}
