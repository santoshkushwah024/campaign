package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class CamHomePageLoc extends GlobalConfig{
		
		public CamHomePageLoc(WebDriver driver) {
			GlobalConfig.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//Locator to click on UserManagement
		@FindBy(xpath="//span[contains(text(),'User Management')]")
		public static WebElement userMgmt;
		
		//Locator to click on HomePage
		@FindBy(xpath="//a[contains(text(),'Home')]")
		public static WebElement homePage;
		
		//Locator to click on Side Bar
		@FindBy(xpath="//i[@class='fa fa-bars']")
		public static WebElement barButton;
		
		//Locator to click on Toaster
		@FindBy(xpath="//div[@id='toast-container']")
		public static WebElement toaster;

}
