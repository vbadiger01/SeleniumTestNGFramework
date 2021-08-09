package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {


	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

//	public void onTestFailure(ITestResult result) {
//		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//	}
	
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().log(Status.INFO,"*** Test Method " + result.getMethod().getMethodName() + " failed...");		
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		
//		ITestContext context = result.getTestContext();
//		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
//		System.out.println(driver.getCurrentUrl());
//		String targetLocation = null;
//		Screenshots screenshot = new Screenshots(driver);
//		boolean attachScreenshotToReport = true;
//		
//		if(attachScreenshotToReport) {
//			try {
//				SessionId s2 = ((RemoteWebDriver) driver).getSessionId();
//				System.out.println("Session Id In Test LIstener - "+s2);
//				targetLocation = screenshot.takeScreenshot();
//					
//				} catch (Exception e) {
//					System.out.println("An exception occurred while taking screenshot " + e.getCause());
//				}
//
//				// attach screenshots to report
//				try {
//					ExtentTestManager.getTest().fail("Screenshot",
//							MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
//				} catch (IOException e) {
//					System.out.println("An exception occured while taking screenshot " + e.getCause());
//				}
//		}
	}
	
	

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}