package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchOrAddPatientPage {
	
	private String patFrameLocator="pat";
	private By searchOrAddPatientHeaderLocator=By.xpath("//*[text()='Search or Add Patient']");
	private By formTitleLocator= By.xpath("//select[@id='form_title']");

	private WebDriver driver;

	public SearchOrAddPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchOrAddPatientHeader() {
		String actualValue = driver.findElement(searchOrAddPatientHeaderLocator).getText();
		return actualValue;
	}
	
	public void switchToPatFrame()
	{
		driver.switchTo().frame(patFrameLocator);
	}
	
	public void titleOfTheName(String formTitle)
	{
		Select prefix = new Select(driver.findElement(formTitleLocator));
		prefix.selectByVisibleText(formTitle);
	}
}
