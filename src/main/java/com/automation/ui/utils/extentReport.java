package com.automation.ui.utils;

import com.automation.ui.config.Configurations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport extends Configurations {
	
	static String filepath = System.getProperty("user.dir")+"/extentreport.html";
	
	public static void generateReport() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(filepath);
		report.attachReporter(spark);
		report.setSystemInfo("Host Name", "Automation Demo");
		report.setSystemInfo("env", "QA");
		spark.config().setDocumentTitle("QA Automation Report");
		spark.config().setReportName("Daily Automation Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

}
