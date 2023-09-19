package com.pom;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class Registration {
	private WebDriver driver;
	
	
	@CacheLookup
	@FindBy(id = "signin2")
	WebElement Signup;
	
	@CacheLookup
	@FindBy(id = "sign-username")
	WebElement susername;	
	
	@CacheLookup
	@FindBy(id = "sign-password")
	WebElement spassword;
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	WebElement SignupButton;
	
	
	
	
	
	
	public Registration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void ClickSignUp() {
		Signup.click();
	}
	
	public void Signup(String username, String password) {
		
		
		spassword.clear();
		spassword.sendKeys(password);
		SignupButton.click();
	}
	
	public String GetUserName() {
//		WebElement returnedElement =bc.explicitWait(driver,welcome);
//		returnedElement.click();
		String GetName= "";
		return GetName;
		
		
	}

}
