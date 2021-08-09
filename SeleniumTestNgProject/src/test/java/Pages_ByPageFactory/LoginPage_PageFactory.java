package Pages_ByPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Assertions;
import Utilities.ReportingAssist;
import Utilities.Verify;
import Utilities.ReportingAssist.ReportStatus;

public class LoginPage_PageFactory {
	WebDriver driver;
	Verify verify;
	Assertions assertion;

	@FindBy(id = "name")
	WebElement txt_UserName;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id='pageLogin']/form/div[2]/div/div[2]")
	WebElement invalidCredError;

	public LoginPage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		verify = new Verify(driver);
		assertion = new Assertions(driver);
	}

	// ********
	// Creating Individual methods for action on each object

	public void enterUserName(String userName) {
		txt_UserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	//// *********

	/// Creating Logical flow using objects
	public void loginasUser(String userName, String password) {
		txt_UserName.sendKeys(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Username field is displayed");
		txt_password.sendKeys(password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Password field is displayed");
		loginBtn.click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Login button is displayed");

	}

	public void verifyErrorOnLogin() {

		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Inside Verify PF Page - " + s2);
		String actualError = invalidCredError.getText().trim();

		System.out.println("Actual Error Message - " + actualError);

		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
	}

	public void verifyInvalidLogin(String userName, String password) {
		txt_UserName.sendKeys(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "User Name Entered");

		txt_password.sendKeys(password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Password Entered");

		loginBtn.click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Clicked on Login Button");

		String actualError = invalidCredError.getText().trim();

		System.out.println("Actual Error Message - " + actualError);

		assertion.stringAssertEquals("Password is invalid", actualError);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Invalid Password Error");
	}

}
