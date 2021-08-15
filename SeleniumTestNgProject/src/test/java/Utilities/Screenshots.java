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

import com.aventstack.extentreports.MediaEntityBuilder;

public class Screenshots {
	WebDriver driver;
	String fileSeperator = System.getProperty("file.separator");
	boolean attachScreenShots = true;

	public Screenshots(WebDriver driver) {
		this.driver = driver;
	}

	public String takeScreenshot() {
		String targetLocation = captureScreenshot();
		return targetLocation;
	}

	public String takeScreenshot(boolean attachToExtentReport) {
		String targetLocation = captureScreenshot();
		if (attachToExtentReport) {
			attachScrenshotToExtentReport(targetLocation);
		}		
		return targetLocation;
	}
	
	private String captureScreenshot() {		
		LoadConfigProperties getFrameworkConfig = new LoadConfigProperties();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + "_scrShot.png";
		File destFile = new File(getFrameworkConfig.getScreenshotDir() + fileName);
		String targetLocation = System.getProperty("user.dir") + fileSeperator + getFrameworkConfig.getScreenshotDir()
				+ fileSeperator + fileName;
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return targetLocation;
	}
	

	private void attachScrenshotToExtentReport(String targetLocation) {

		try {
			ExtentTestManager.getTest().info("Screenshot Capture",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
	}

}
