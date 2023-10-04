package com.automation.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ui.config.Configurations;
import com.automation.ui.utils.base;

public class pageHome extends Configurations {
		static base b = new base();
		public pageHome() {
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath="//input[@placeholder='Search for anything']")
		private static WebElement searchBox;
		
		@FindBy(xpath="//h3[contains(text(),'Birthday')]")
		private static WebElement card;
		
		@FindBy(xpath="//h1[contains(text(),'Cats')]")
		private static WebElement text;
		
		public static void search(String textToSearch) {
			searchBox.clear();
			searchBox.sendKeys(textToSearch);
			searchBox.sendKeys(Keys.ENTER);
			b.implicitTimeOut(10);
		}
		
		public static void clickonCard() {
			card.click();
			b.getWinHandles();
			b.implicitTimeOut(10);
			text.isDisplayed();
		}
		
		public static void switchToParent() {
			b.switchToParentWindow();
			b.implicitTimeOut(5);
		}
		

}
