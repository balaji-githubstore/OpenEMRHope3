package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {

	private By patientFinderHeaderLocator = By.xpath("//span[text()='Patient Finder']");
	private By switchToFrameLocator = By.xpath("//iframe[@src='/b/openemr/interface/main/finder/dynamic_finder.php']");
	private By clickonCreatePatientLocator = By.id("create_patient_btn1");
	

	private WebDriver driver;

	public PatientFinderPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPatientFinderHeader() {
		String actualValue = driver.findElement(patientFinderHeaderLocator).getText().trim();
		return actualValue;
	}
	
	public void switchToFinFrame()
	{
		driver.switchTo().frame(driver.findElement(switchToFrameLocator));
	}
	
	public void clickOnAddNewPatient()
	{
		driver.findElement(clickonCreatePatientLocator).click();
	}
	
	public void switchOutOfFrame()
	{
		driver.switchTo().defaultContent();
	}

}
