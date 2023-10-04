package com.automation.ui.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.interactions.Action;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.automation.ui.basetest.baseTest;
import com.automation.ui.pages.pageHome;
import com.automation.ui.utils.configReader;

public class verifyHomePage extends baseTest{

	pageHome home;
	Action action;
	public verifyHomePage(){
		super();
	}
	
	@Test
	public void HomePage() throws IOException {
		driver.getTitle();
	}
	
	@Test(dependsOnMethods="HomePage")
	public void searchAndClick() throws IOException {
		home.search(configReader.readConfigFile("searchText"));
		home.clickonCard();
	}
	
	@Test(dependsOnMethods="searchAndClick")
	public void goBackToHomePageWindow() {
		home.switchToParent();
	}
	

	
}
