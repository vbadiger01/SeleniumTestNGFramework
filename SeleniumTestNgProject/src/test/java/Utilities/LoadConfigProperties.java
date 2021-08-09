package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class LoadConfigProperties {
	Properties prop = null;

	public LoadConfigProperties() {
		prop = new Properties();
		InputStream inputStr = null;

		try {
			File config = new File("config.properties");
			inputStr = new FileInputStream(config);
		} catch (Exception exception) {
			System.out.println(ExceptionUtils.getStackTrace(exception));
		}

		try {
			if (inputStr == null) {
				inputStr = getClass().getResourceAsStream("config.properties");
			}			
			prop.load(inputStr);
		} catch (Exception exception) {
			System.out.println(ExceptionUtils.getStackTrace(exception));
		}
	}
	
	public String getChromeDriverPath() {
		return prop.getProperty("chromeDriver");
	}
	
	public String getFirefoxDriverPath() {
		return prop.getProperty("firefoxdriver");
	}
	
	public String getTestData() {
		return prop.getProperty("TestDataExcel");
	}
	
	public String getScreenshotDir() {
		return prop.getProperty("Screenshots");
	}
	
	public String getAUTUrl() {
		return prop.getProperty("autURL");
	}


}
