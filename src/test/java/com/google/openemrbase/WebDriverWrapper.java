package com.google.openemrbase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.utilities.PropUtils;

//browser config
public class WebDriverWrapper {
	protected WebDriver driver;

	@BeforeMethod
	@Parameters("browsername")
	public void setup(@Optional("NONE") String browser) throws IOException {
		
		if(browser.equals("NONE"))
		{
			browser= PropUtils.getValue("src/test/resources/testdata/data.properties", "browser");
		}
		
		if(browser.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String baseUrl=PropUtils.getValue("src/test/resources/testdata/data.properties", "url");
		driver.get(baseUrl);
		
		
		
	}
		@AfterMethod
		public void teardown() {
			driver.quit();	
	}

}
