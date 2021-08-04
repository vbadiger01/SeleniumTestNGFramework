package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	WebDriver driver;
	public Screenshots(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void takeScreenshot() {
		LoadConfigProperties getFrameworkConfig = new LoadConfigProperties();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		File destFile = new File(getFrameworkConfig.getScreenshotDir()+dateFormat.format(new Date())+"_scrShot.png");
		
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
