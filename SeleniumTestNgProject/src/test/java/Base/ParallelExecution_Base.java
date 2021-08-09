package Base;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ParallelExecution_Pages.LoginPagePOM_Parallel;
import Tests.LoginTests;
import Utilities.Assertions;
import Utilities.LoadConfigProperties;
import Utilities.Screenshots;
import Utilities.TestDataMap;


public class ParallelExecution_Base {
	
	protected LoadConfigProperties getConfigProp = new LoadConfigProperties();
	public TestDataMap testDataMap = new TestDataMap();
	public LoginTests loginTest;
	public Map<String, String> dataMap;
	
	//protected RemoteWebDriver driver = null;
	protected InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>();
	protected InheritableThreadLocal<LoginPagePOM_Parallel> loginPagePOM = new InheritableThreadLocal<LoginPagePOM_Parallel>();
	protected InheritableThreadLocal<Assertions> assertion = new InheritableThreadLocal<Assertions>();
	protected InheritableThreadLocal<Screenshots> screenshot = new InheritableThreadLocal<Screenshots>();
	
	
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUpBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getConfigProp.getChromeDriverPath());
			driver.set(new ChromeDriver());
			System.out.println("Thread "+Thread.currentThread().getId());
		}

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getConfigProp.getFirefoxDriverPath());
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", true);
			driver.set(new FirefoxDriver());
		}
				
		driver.get().manage().window().maximize();
		
		loginPagePOM.set(new LoginPagePOM_Parallel(driver.get()));
		dataMap = testDataMap.createTestDataMap();		
	}
	
	public WebDriver gettestDriver() {
		return driver.get();
	}
	
	@AfterMethod
	public void tearDown() {
		gettestDriver().quit();
	}
	
}
