package com.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import com.base.BaseClass;
import com.pom.Login;

import static org.junit.jupiter.api.Assertions.assertTrue;



import org.openqa.selenium.WebDriver;


public class StepDefinitions {

	private WebDriver driver;

	BaseClass base;

	String browsername = "Chrome";
	String url = "https://www.demoblaze.com/";
	
	String ExpectedUserName="";
	String AlertMessage="";
	
	
	
	@Before
	public void setup() {

		base = new BaseClass();
		base.ChooseDriver(browsername, url);
		driver = base.getDriver();
		

	}
	
	
	@After
	public void TearDown() {

		//base.exitCurrentBrowser();

	}

	// Login login = new Login(driver);

	@Given("launching the homepage")
	public void launching_the_homepage() {
		// launch the url in chrome browser
		driver.navigate().to(url);
	}

	
	
	
//for sign up
	
	

@Given("User Clicks  on the SignUp Button")
public void user_clicks_on_the_sign_up_button() {
	Login login = new Login(driver);
	login.SignUp();

}

@When("I pass the {string} and {string}")
public void i_pass_the_and(String username, String password) {
	Login login = new Login(driver);
	try {
		login.EnterCredentials(username, password);
		base.AlertsWithGetText(driver);
		// Capturing alert message.    
		//AlertMessage = driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@When("User should be create the account successfully.")
public void user_should_be_create_the_account_successfully() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User should be landed to the HomePage")
public void user_should_be_landed_to_the_home_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



	
	
	//for login
	
	
	@Given("Verify the site is working properly")
	public void verify_the_site_is_working_properly() {
			new Login(driver);
		// Write code here that turns the phrase above into concrete actions
		String currentURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.demoblaze.com/";

		System.out.println("curnet URL" + currentURL);
		assertTrue(ExpectedURL.equals(currentURL), "site is not expected");

	}

	@Given("User Clicks  on the Login Button")
	public void user_clicks_on_the_login_button() {
		Login login = new Login(driver);
		login.ClickLogin();
		
		

	}

	@When("I enter {string} and {string}")
		public void i_enter_and(String username, String password) throws InterruptedException {
		
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);
		ExpectedUserName=username;
	}

//	@Then("I should be able to successfully login")
//	public void i_should_be_able_to_successfully_login() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

	@Then("User should be logged in and greeting message should be displayed")
	public void verify_the_welcome_message() throws InterruptedException {
		Login login = new Login(driver);
		
		String Actual=login.GetUserName();
		System.out.println("varist"+Actual);
		
		
//		WebElement ActualUserName =base.explicitWait(driver,login.GetUserName());
//		ActualUserName.getText();
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		
//		WebElement FoundElement = wait.until(ExpectedConditions.visibilityOf(element));
//		System.out.println("actual returned"+ActualUserName	);
//		
		//String CurrentUserName= log.info
		
		//System.out.println("Expected  user " + ExpectedUserName);
		//System.out.println("current user " + CurrentUserName);
		//assertTrue(ExpectedUserName.equals(CurrentUserName), "User Name is not Matching");

	}

}
