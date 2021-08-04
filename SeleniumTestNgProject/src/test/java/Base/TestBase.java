package Base;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Tests.LoginTests;
import Utilities.Assertions;
import Utilities.LoadConfigProperties;
import Utilities.Screenshots;
import Utilities.TestDataMap;

public class TestBase {
	protected LoadConfigProperties getConfigProp = new LoadConfigProperties();
	protected WebDriver driver;

	public Assertions assertion;
	public Screenshots screenshot;
	public TestDataMap testDataMap = new TestDataMap();
	public LoginTests loginTest;
	public Map<String, String> dataMap;
	
	
	
	@BeforeMethod
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", getConfigProp.getChromeDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		assertion = new Assertions(driver);
		screenshot = new Screenshots(driver);
		dataMap = testDataMap.createTestDataMap();
		//loginTest = new LoginTests(driver);
	}

	@AfterMethod
	public void quitDriver() {
		driver.close();
		driver.quit();
	}

}
