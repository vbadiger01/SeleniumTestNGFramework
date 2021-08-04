package Utilities;

import com.aventstack.extentreports.Status;

public class ReportingAssist {

	public enum ReportStatus{
		Info,
		Pass,
		Fail
	}
	
	public static void ExtentReportLogger(ReportStatus statusVal, String message) {
		switch(statusVal) {
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
	
}
