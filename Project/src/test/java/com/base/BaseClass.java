package com.base;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.WebElement;




public class BaseClass {

	protected WebDriver driver;

	public void ChooseDriver(String Driver, String Url) {

		if (Driver.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();

			driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("am opening chrome");

		}

		if (Driver.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

			driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("am opening firfox");

		}
		if (Driver.equalsIgnoreCase("Safari")) {

			driver = new SafariDriver();

			driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("am opening safari");

		} else {
			System.err.println("please choose driver name like chrome, firefox or safari");
		}
		//return driver;

	}

	public WebDriver getDriver() {
		return this.driver;

	}

	public void exitAllBrowser() {
			driver.close();

	}
	
	public String getText(WebElement webelement) {
		String GetText=webelement.getText();
		
		return GetText;
		

	}
	
	public void HandleAlerts(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public String  AlertsWithGetText(WebDriver driver)
	{
		String msg= driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return msg;
	}
	
	//byExplicitwait and argument as two driver and 
	public WebElement explicitWait(WebDriver driver,WebElement element) throws InterruptedException {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//Thread.sleep(7000);
		WebElement FoundElement = wait.until(ExpectedConditions.visibilityOf(element));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			
		return FoundElement;
		
	}

	
	public boolean waitForJStoLoad(WebDriver driver) {

	   // WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    final JavascriptExecutor js = (JavascriptExecutor) driver;
	 // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return js.executeScript("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return wait.until(jsLoad);
	}

	
	
	public void exitCurrentBrowser() {
		driver.quit();

	}

}
