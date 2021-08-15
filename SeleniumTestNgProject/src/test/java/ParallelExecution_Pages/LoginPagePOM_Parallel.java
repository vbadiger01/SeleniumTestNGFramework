package ParallelExecution_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Assertions;
import Utilities.ElementActions;
import Utilities.LoadConfigProperties;
import Utilities.ReportingAssist;
import Utilities.ReportingAssist.ReportStatus;
import Utilities.Screenshots;
import Utilities.Verify;

public class LoginPagePOM_Parallel {
	WebDriver driver;
	Verify verify;
	Assertions assertion;
	ElementActions elementActions;
	Screenshots screenshot;
	
	protected LoadConfigProperties getConfigProp = new LoadConfigProperties();
	
	
	By txt_userName = By.id("name");
	By txt_password = By.id("password");
	By loginBtn = By.id("login");
	By logoutBtn = By.id("logout");
	By invalidCredError = By.xpath("//*[@id='pageLogin']/form/div[2]/div/div[2]");

	// Creating constructor to initiate driver
	public LoginPagePOM_Parallel(WebDriver driver) {
		this.driver = driver;		
		verify = new Verify(driver);
		assertion = new Assertions(driver);
		elementActions = new ElementActions(driver);
		screenshot = new Screenshots(driver);
	}

	// ********
	// Creating Individual methods for action on each object

	public void enterUserName(String userName) {
		driver.get(getConfigProp.getAUTUrl());
		driver.findElement(txt_userName).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public void checkLogoutisDisplayed() {
		driver.findElement(logoutBtn).isDisplayed();
	}

	//// *********

	// Verify Username, Password and Login button present
	public void elementsPresntOnLogin() {
		driver.get(getConfigProp.getAUTUrl());
		WebElement userName = driver.findElement(txt_userName);
		verify.verifyElementDisplayed(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Username field is displayed");
		verify.verifyElementDisplayed(driver.findElement(txt_password));
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Password field is displayed");
		verify.verifyElementDisplayed(driver.findElement(loginBtn));
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Login button is displayed");
	}

	/// Creating Logical flow using objects
	public void loginasUser(String userName, String password) {
		driver.get(getConfigProp.getAUTUrl());

		//driver.findElement(txt_userName).sendKeys(userName);
		
		// *** We can use above statement or Element extension methods as below. ***		
		elementActions.enterText(driver.findElement(txt_userName), userName);				
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "User Name Entered");

		//driver.findElement(txt_password).sendKeys(password);
		
		elementActions.enterText(driver.findElement(txt_password), password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Password Entered");

		driver.findElement(loginBtn).click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Clicked on Login Button");

	}

	public void verifyErrorOnLogin(WebDriver testdriver) {
		String actualError = testdriver.findElement(invalidCredError).getText().trim();
		System.out.println("Actual Error Message - " + actualError);
		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
		
	}

	public void verifyErrorOnLogin() {		
		String actualError = driver.findElement(invalidCredError).getText().trim();
		System.out.println("Actual Error Message - " + actualError);
		String expectedError = "Password is invalid";
		assertion.stringAssertEquals(expectedError, actualError);		
		
		
//		if(assertion.stringAssertEquals(expectedError, actualError)) {
//			ReportingAssist.ExtentReportLogger(ReportStatus.Pass, "Messages displayed Match",expectedError,actualError);
//		}
//		else {
//			ReportingAssist.ExtentReportLogger(ReportStatus.Fail, "Messages displayed do not Match",expectedError,actualError);
//			Assert.fail();
//		}
	}

	public void verifyInvalidLogin(String userName, String password) {
		driver.findElement(txt_userName).sendKeys(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "User Name Entered");

		driver.findElement(txt_password).sendKeys(password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Password Entered");

		driver.findElement(loginBtn).click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Clicked on Login Button");

		String actualError = driver.findElement(invalidCredError).getText().trim();

		System.out.println("Actual Error Message - " + actualError);
		String expectedError = "Password is invalid";
		if(assertion.stringAssertEquals(expectedError, actualError)) {
			ReportingAssist.ExtentReportLogger(ReportStatus.Pass, "Message displayed Match",expectedError,actualError);
		}
		else {
			ReportingAssist.ExtentReportLogger(ReportStatus.Fail, "Message displayed do not Match",expectedError,actualError);
			Assert.fail();
		}		
	}
		
	public void searchGoogleText() throws InterruptedException {
		driver.get("https://google.co.in");
		Thread.sleep(5000);
		elementActions.enterText(driver.findElement(By.name("q")), "3i Infotech Share price");
		Thread.sleep(5000);
		elementActions.enterText(driver.findElement(By.name("q")), "3i Infotech results");		
		screenshot.takeScreenshot(true);
		
		
	}

}
