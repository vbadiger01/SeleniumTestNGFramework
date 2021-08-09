package Tests;

import java.sql.Timestamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

import Base.ParallelExecution_Base;

public class ParallelExecution_MultiThread extends ParallelExecution_Base {
	
	@Test
	public void verifyFieldsOnLoginPage() {
		loginPagePOM.get().elementsPresntOnLogin();		
	}

	
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		loginPagePOM.get().loginasUser(dataMap.get("Username1"), dataMap.get("Password"));		
		loginPagePOM.get().checkLogoutisDisplayed();
	}	
	
	
	@Test
	public void verifyUnsuccessfulLogin() {				
		loginPagePOM.get().loginasUser(dataMap.get("Username1"), "465466");				
		loginPagePOM.get().verifyErrorOnLogin();
	}
	
	@Test
	public void verifySuccessfulLogin22() throws InterruptedException {
		loginPagePOM.get().loginasUser(dataMap.get("Username1"), dataMap.get("Password"));		
		loginPagePOM.get().checkLogoutisDisplayed();
	}
}
