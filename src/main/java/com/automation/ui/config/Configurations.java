package com.automation.ui.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.automation.ui.utils.extentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Configurations {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	
	public static void initDriver(String url, String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}else {
			driver=new SafariDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	
	
	//To run on docker
	public static void initRemoteDriver(String url, String browserName) throws MalformedURLException {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chrome = new ChromeOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),chrome);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefox = new FirefoxOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),firefox);
		}else if(browserName.equalsIgnoreCase("ie")) {
			InternetExplorerOptions ie = new InternetExplorerOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),ie);
		}else {
			SafariOptions safari = new SafariOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),safari);
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	
	public static void quitDriver() {
		driver.close();
		driver.quit();
	}
	
	public static void generateReport() {
		extentReport.generateReport();
	}
	
	
}
