package Tests;


import org.testng.annotations.Test;

import Base.SerialExecution_Base;
import Pages_ByPOM.LoginPage_ByPOM;
import Pages_ByPageFactory.HomePage_PageFactory;
import Pages_ByPageFactory.LoginPage_PageFactory;

public class SerialExecution_Tests extends SerialExecution_Base {

	LoginPage_ByPOM loginPagePOM;
	LoginPage_PageFactory loginPagePF;
	HomePage_PageFactory homePage;

	@Test
	public void verifyFieldsOnLoginPage() {
		driver.get(getConfigProp.getAUTUrl());
		loginPagePOM = new LoginPage_ByPOM(driver);
		loginPagePOM.elementsPresntOnLogin();
	}

	@Test
	public void verifySuccessfulLogin() {
		driver.get(getConfigProp.getAUTUrl());

		loginPagePOM = new LoginPage_ByPOM(driver);		
//		Use below individualSteps or function
//		loginPagePOM.enterUserName(dataMap.get("Username1"));
//		loginPagePOM.enterPassword(dataMap.get("Password"));
//		loginPagePOM.clickLogin(); OR AS BELOW.		
		System.out.println(dataMap.get("Password").toString());
		loginPagePOM.loginasUser(dataMap.get("Username1"), dataMap.get("Password"));
		homePage = new HomePage_PageFactory(driver);
		homePage.checkLogoutisDisplayed();
	}

	@Test
	public void verifyUnsuccessfulLogin() {
		driver.get(getConfigProp.getAUTUrl());
		loginPagePOM = new LoginPage_ByPOM(driver);
		loginPagePOM.loginasUser(dataMap.get("Username1"), dataMap.get("InvalidPassword"));
		loginPagePOM.verifyErrorOnLogin();
	}

}
