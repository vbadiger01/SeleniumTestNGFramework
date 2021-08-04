package Tests;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Pages.HomePage_PageFactory;
import Pages.LoginPage_ByPOM;
import Pages.LoginPage_PageFactory;
import Utilities.ExtentTestManager;


public class LoginTests extends TestBase {

	LoginPage_ByPOM loginPagePOM;
	LoginPage_PageFactory loginPagePF;
	HomePage_PageFactory homePage;

	@Test
	public void verifyFieldsPresent() {
		System.out.println("Test - Fields Present. Data from Excel : " + dataMap.get("Username1"));
	}

	@Test
	public void verifySuccessfulLogin() {
		driver.get(getConfigProp.getAUTUrl());

		loginPagePOM = new LoginPage_ByPOM(driver);
//		loginPagePOM.enterUserName(dataMap.get("Username1"));
//		loginPagePOM.enterPassword(dataMap.get("Password"));
//		loginPagePOM.clickLogin(); OR AS BELOW.
		
		System.out.println(dataMap.get("Password").toString());
		loginPagePOM.loginValidUser(dataMap.get("Username1"), dataMap.get("Password"));
		
		
		homePage = new HomePage_PageFactory(driver);
		homePage.checkLogoutisDisplayed();

	}

	@Test
	public void verifyUnsuccessfulLogin() {
		System.out.println("Test - Unsuccessful Login");
	}

}
