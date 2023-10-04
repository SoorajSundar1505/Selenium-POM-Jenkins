package com.automation.ui.utils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.automation.ui.config.Configurations;

public class base extends Configurations {
	static String parent=" ";
	static String filePath = System.getProperty("user.dir")+"/src/main/resource/result.png";
	
	public static void getWinHandles() {
		parent = driver.getWindowHandle();
		Set<String> win= driver.getWindowHandles();
		
		Iterator<String> it = win.iterator();
		while(it.hasNext()) {
			String child  = it.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
	}
	
	public static void implicitTimeOut(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void switchToParentWindow() {
		driver.switchTo().window(parent);
	}
	
	public static void takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		FileUtils.copyFile(src, dest);
	}
}
