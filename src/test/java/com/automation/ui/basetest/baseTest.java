package com.automation.ui.basetest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.ui.config.Configurations;
import com.automation.ui.pages.pageHome;
import com.automation.ui.utils.base;
import com.automation.ui.utils.configReader;
import com.aventstack.extentreports.Status;

public class baseTest extends Configurations {
	pageHome home;
	
	@BeforeSuite
	public void setup() throws IOException {
		initRemoteDriver(configReader.readConfigFile("url"), configReader.readConfigFile("browser"));
		home=new pageHome();
		generateReport();
	}
	
	@BeforeMethod
	public void initiateReport(Method method) {
		logger = report.createTest(method.getName()).log(Status.INFO, "Log events");
	}
	
	@AfterMethod
	public void flushreport(ITestResult result) throws IOException {
		 if(result.getStatus() == ITestResult.FAILURE) {
			 	base.takeScreenshot();
	        	logger.log(Status.FAIL,result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	base.takeScreenshot();
	        	logger.log(Status.PASS, result.getTestName());
	        }
	        else {
	        	base.takeScreenshot();
	        	logger.log(Status.SKIP, result.getTestName());
	        }
		report.flush();
	}
	
	
	@AfterSuite
	public void tearDown() {
		quitDriver();
	}
}