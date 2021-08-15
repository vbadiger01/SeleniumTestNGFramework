package Utilities;

import com.aventstack.extentreports.Status;

public class ReportingAssist {

	public enum ReportStatus {
		Info, Pass, Fail
	}

	public static void ExtentReportLogger(ReportStatus statusVal, String message) {
		switch (statusVal) {
		case Info:
			ExtentTestManager.getTest().log(Status.INFO, message);
			break;
		case Pass:
			ExtentTestManager.getTest().log(Status.PASS, message);
			break;
		case Fail:
			ExtentTestManager.getTest().log(Status.FAIL, message);
			break;
		}

	}

	public static void ExtentReportLogger(ReportStatus statusVal, String message, String expected, String actual) {
		String resultMessage = null;
		switch (statusVal) {

		case Info:
			ExtentTestManager.getTest().log(Status.INFO, message);
			break;
		case Pass:
			resultMessage = "Expected = <font face=\"verdana\" color=\"#32CD32\"> " + expected
					+ "</font> <br> Actual = <font face=\"verdana\" color=\"#32CD32\">" + actual + " </font>";
			ExtentTestManager.getTest().log(Status.PASS, message + "<br>" + resultMessage);
			break;
		case Fail:
			resultMessage = "Expected = <font face=\"verdana\" color=\"Red\"> " + expected
					+ "</font> <br> Actual = <font face=\"verdana\" color=\"Red\">" + actual + " </font>";
			ExtentTestManager.getTest().log(Status.FAIL, message + "<br>" + resultMessage);
			break;
		}

	}

}
