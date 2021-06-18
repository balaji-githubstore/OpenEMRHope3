package com.google.openemrpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientDashboardPage {
	
	private WebDriver driver;

	public PatientDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForPresenceOfAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	

}
