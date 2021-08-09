package Pages_ByPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Assertions;
import Utilities.ReportingAssist;
import Utilities.ReportingAssist.ReportStatus;
import Utilities.Verify;

public class HomePage_PageFactory {
	WebDriver driver;
	Verify verify;
	Assertions assertion;

	@FindBy(id = "logout")
	WebElement logoutBtn;

	public HomePage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		verify = new Verify(driver);
		assertion = new Assertions(driver);

	}

	public void checkLogoutisDisplayed() {
		verify.verifyElementDisplayed(logoutBtn);
		ReportingAssist.ExtentReportLogger(ReportStatus.Info, "Verified Log out button is displayed on Home Page");
	}

}
