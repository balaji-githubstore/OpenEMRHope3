package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
	private By movetoPatientLocator = By.xpath("//div[text()='Patient/Client']");
	private By clickonPatientsLocator = By.xpath("(//div[@class='menuLabel'])[5]");
	private By newSearchLocator=By.xpath("//div[text()='New/Search']");
	
	
    private WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void moveToPatientClient()
	{
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(movetoPatientLocator);
		action.moveToElement(target).perform();
	}
	
	public void clickonPatients()
	{
		driver.findElement(clickonPatientsLocator).click();
	}
	
	public void clickOnNewSearchMenu()
	{
		driver.findElement(newSearchLocator).click();
	}
	
	
}
