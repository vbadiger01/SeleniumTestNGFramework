package Tests;


import java.sql.Timestamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

import Base.ParallelExeTestBaseThreadLocal;
import Pages_ByPOM.LoginPage_ByPOM;
import Pages_ByPageFactory.HomePage_PageFactory;
import Pages_ByPageFactory.LoginPage_PageFactory;

public class ParallelTest_ThreadLocal extends ParallelExeTestBaseThreadLocal{
	
	LoginPage_ByPOM loginPagePOM;
	LoginPage_PageFactory loginPagePF;
	HomePage_PageFactory homePage;

	
	@Test
	public void verifyFieldsOnLoginPage() {
		WebDriver driver = getDriver();
		
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id 1 - "+s);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Test 1 Timestamp - "+timestamp);
		driver.get(getConfigProp.getAUTUrl());
		loginPagePOM = new LoginPage_ByPOM(driver);
		loginPagePOM.elementsPresntOnLogin();
	}

	
	@Test
	public void verifySuccessfulLogin() {
		WebDriver driver = getDriver();
				
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id 2 - "+s);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Test 2 Timestamp - "+timestamp);
		driver.get(getConfigProp.getAUTUrl());
		loginPagePOM = new LoginPage_ByPOM(driver);
		
		System.out.println(dataMap.get("Password").toString());
		loginPagePOM.loginasUser(dataMap.get("Username1"), dataMap.get("Password"));
		
		
		homePage = new HomePage_PageFactory(driver);
		homePage.checkLogoutisDisplayed();		
		
	}
	
	@Test
	public void verifySuccessfulLogin_UsingPgFatory() {
		WebDriver driver = getDriver();
				
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id 3 - "+s);
		
		driver.get(getConfigProp.getAUTUrl());
		loginPagePF = new LoginPage_PageFactory(driver);		
		
		loginPagePF.loginasUser(dataMap.get("Username1"), dataMap.get("Password"));		
		
		homePage = new HomePage_PageFactory(driver);
		homePage.checkLogoutisDisplayed();		
		
	}
	
	@Test
	public void verifyUnsuccessfulLogin() {
		WebDriver driver = getDriver();
		driver.get(getConfigProp.getAUTUrl());
		SessionId sl = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id 4 - "+sl);
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		System.out.println("Test 4 Timestamp - "+timestamp);
		
		//Execution Using Page created using POM.
//		loginPagePOM = new LoginPage_ByPOM(driver);
//		loginPagePOM.verifyInvalidLogin(dataMap.get("Username1"), dataMap.get("InvalidPassword"));
//		loginPagePOM.loginasUser(dataMap.get("Username1"), dataMap.get("InvalidPassword"));
//		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
//		System.out.println("Session Id After Login Method - "+s2);
//		loginPagePOM.verifyErrorOnLogin(driver);
		
		//Execution Using Page Factory. Recommended method while running using Parallel methods
		loginPagePF = new LoginPage_PageFactory(driver);
		loginPagePF.loginasUser(dataMap.get("Username1"), dataMap.get("InvalidPassword"));
		SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id After Login Method - "+s2);
		loginPagePF.verifyErrorOnLogin();
	}
}
