package Base;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Tests.LoginTests;
import Utilities.Assertions;
import Utilities.LoadConfigProperties;
import Utilities.Screenshots;
import Utilities.TestDataMap;

public class TestBase {
	protected LoadConfigProperties getConfigProp = new LoadConfigProperties();
	protected WebDriver driver = null;

	public Assertions assertion;
	public Screenshots screenshot;
	public TestDataMap testDataMap = new TestDataMap();
	public LoginTests loginTest;
	public Map<String, String> dataMap;	

	
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUpDriver(String browser) {
		System.out.println("Test Browser - " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getConfigProp.getChromeDriverPath());
			driver = new ChromeDriver();
			System.out.println("Thread "+Thread.currentThread().getId());
		}

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getConfigProp.getFirefoxDriverPath());
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", true);
			driver = new FirefoxDriver(options);
		}

		driver.manage().window().maximize();
		assertion = new Assertions(driver);
		screenshot = new Screenshots(driver);
		dataMap = testDataMap.createTestDataMap();
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();		
	}
}
