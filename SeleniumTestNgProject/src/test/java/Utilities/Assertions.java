package Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assertions {

	public WebDriver driver;
	private Screenshots screenshot;

	public Assertions(WebDriver driver) {
		this.driver = driver;
		screenshot = new Screenshots(driver);
	}

	public boolean stringAssertEquals(String strExpected, String strActual) {
		try {
			Assert.assertTrue(strExpected.equalsIgnoreCase(strActual.trim()));
			return true;
		} catch (AssertionError exception) {
			screenshot.takeScreenshot();
			System.out.println("Expected Value :" + strExpected + " do not match with Actual Value :" + strActual);
		}
		return false;
	}

}
