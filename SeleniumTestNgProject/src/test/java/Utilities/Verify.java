package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Verify {

	WebDriver driver;
	private boolean takeScreenshot = true;

	private Screenshots screenShot;

	public Verify(WebDriver driver) {
		this.driver = driver;
		
		screenShot = new Screenshots(driver);

	}

	public void verifyElementDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			Reporter.log(element + " is displayed.");
		} else {
			if (takeScreenshot)
				screenShot.takeScreenshot();
			Assert.fail(element + " is not displayed");
		}
	}

}
