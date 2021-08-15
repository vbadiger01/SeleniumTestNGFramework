package Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utilities.ReportingAssist.ReportStatus;

public class Assertions {

	public WebDriver driver;
	private Screenshots screenshot;
	private static boolean screenShotToReport = true; 

	public Assertions(WebDriver driver) {
		this.driver = driver;
		screenshot = new Screenshots(driver);
	}

	public boolean stringAssertEquals(String strExpected, String strActual) {
		try {
			Assert.assertTrue(strExpected.equalsIgnoreCase(strActual.trim()));
			ReportingAssist.ExtentReportLogger(ReportStatus.Pass, "Expected and Actual Values Match",strExpected,strActual);
			screenshot.takeScreenshot(screenShotToReport);			
			return true;
		} catch (AssertionError exception) {
			screenshot.takeScreenshot(screenShotToReport);
			ReportingAssist.ExtentReportLogger(ReportStatus.Fail, "Expected and Actual Values Do Not Match",strExpected,strActual);			
			Assert.fail();
			return false;
		}
	
	}

}
