package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
//login page 
public class Loginpage {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By selectLanguageLocator = By.name("languageChoice");
	private By loginButtonLocator = By.xpath("//button[@type='submit']");
	private By getPagename = By.xpath("//span[@class ='mx-2 font-weight-bold']");
	private WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public void enterPassword(String password )
	{
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void selectLanguage(String language)
	{
		Select lang = new Select(driver.findElement(selectLanguageLocator));
		lang.selectByVisibleText(language);
	}
	
	public void loginButton()
	{
		driver.findElement(loginButtonLocator).click();
	}
	
	public String getPagename()
	{
		return driver.findElement(getPagename).getText().trim();
	}
}

