package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Utilities.ExtentTestManager;
import Utilities.ReportingAssist;
import Utilities.ReportingAssist.ReportStatus;

public class LoginPage_ByPOM {	
	WebDriver driver;
	
	By txt_userName = By.id("name");
	By txt_password = By.id("password");
	By loginBtn = By.id("login");
	By logoutBtn = By.id("logout");
	
	//Creating constructor to initiate driver
	public LoginPage_ByPOM(WebDriver driver) {
		this.driver = driver;		
	}
	
	
	
	//********
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
	
	////*********
	
	
	///Creating Logical flow using objects	
	public void loginValidUser(String userName, String password) {
		driver.findElement(txt_userName).sendKeys(userName);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "User Name Entered");
		
		driver.findElement(txt_password).sendKeys(password);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Password Entered");
		
		driver.findElement(loginBtn).click();
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Clicked on Login Button");
		
		
	}
	

}
