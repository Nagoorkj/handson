package com.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.base.BaseClass;

public class Login {
	private WebDriver driver;
	
	
	
	
	//for sign up
	
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
	
	
	
	
	
	//for login
	
	
	@CacheLookup
	@FindBy(id = "login2")
	WebElement uilogin;
	
	@CacheLookup
	@FindBy(id = "loginusername")
	WebElement lusername;	
	
	@CacheLookup
	@FindBy(id = "loginpassword")
	WebElement lpassword;
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Log')]")
	WebElement loginBtn;
	
	
	@CacheLookup
	@FindBy(xpath="//a[@id='nameofuser']")	
	WebElement welcome;
	
		
	BaseClass bc=new BaseClass();
	
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//for signup
	

	//for login
	public void SignUp() {
		Signup.click();
	}
	
		public void EnterCredentials(String username, String password) throws InterruptedException {	
		
		WebElement returnedElement =bc.explicitWait(driver,susername);
		returnedElement.sendKeys(username);
		spassword.sendKeys(password);
		SignupButton.click();
		bc.HandleAlerts(driver);
		
		
	}
	
	//for login
	public void ClickLogin() {
		uilogin.click();
	}
	
	public void loginWithCredentials(String username, String password) throws InterruptedException {
		
		
		WebElement returnedElement =bc.explicitWait(driver,lusername);
		returnedElement.sendKeys(username);
		lpassword.clear();
		lpassword.sendKeys(password);
		loginBtn.click();
	}
	
	public String GetUserName() throws InterruptedException {
		//WebElement returnedElement =bc.explicitWait(driver,welcome);
		//returnedElement.click();
		bc.waitForJStoLoad(driver);
		welcome.click();
		bc.waitForJStoLoad(driver);
		welcome.isDisplayed();
		welcome.getText();
		//String GetName= returnedElement.getText();
		System.out.println("Print "+welcome.getText());
		System.out.println("Nagoor  ");
		return welcome.getText();
		
		
	}

}
