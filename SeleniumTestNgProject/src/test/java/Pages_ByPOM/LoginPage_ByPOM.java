package Pages_ByPOM;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import Utilities.Assertions;
import Utilities.ReportingAssist;
import Utilities.ReportingAssist.ReportStatus;
import Utilities.Verify;

public class LoginPage_ByPOM {
	WebDriver driver;
	Verify verify;
	Assertions assertion;
	By txt_userName = By.id("name");
	By txt_password = By.id("password");
	By loginBtn = By.id("login");
	By logoutBtn = By.id("logout");
	By invalidCredError = By.xpath("//*[@id='pageLogin']/form/div[2]/div/div[2]");

	// Creating constructor to initiate driver
	public LoginPage_ByPOM(WebDriver driver) {
		this.driver = driver;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Inside Login - " + s2);

		System.out.println("Assigned driver" + timestamp);

		System.out.println("Assigned Session Id - " + s2);

		verify = new Verify(driver);
		assertion = new Assertions(driver);
	}

	// ********
	// Creating Individual methods for action on each object

	public void enterUserName(String userName) {
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

		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Inside Login - " + s2);

		driver.findElement(txt_userName).sendKeys(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "User Name Entered");

		driver.findElement(txt_password).sendKeys(password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Password Entered");

		driver.findElement(loginBtn).click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Clicked on Login Button");

	}

	public void verifyErrorOnLogin(WebDriver testdriver) {

		SessionId s2 = ((RemoteWebDriver) testdriver).getSessionId();
		System.out.println("Session Inside Verify - " + s2);
		String actualError = testdriver.findElement(invalidCredError).getText().trim();
		System.out.println("Actual Error Message - " + actualError);
		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
	}

	public void verifyErrorOnLogin() {
		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Inside Verify - " + s2);
		String actualError = driver.findElement(invalidCredError).getText().trim();
		System.out.println("Actual Error Message - " + actualError);
		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
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

		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
	}

}
