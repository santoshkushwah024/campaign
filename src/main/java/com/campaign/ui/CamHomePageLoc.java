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
		
		@FindBy(xpath="//span[contains(text(),'User Management')]")
		public static WebElement userMgmt;
		
		@FindBy(xpath="//a[contains(text(),'Home')]")
		public static WebElement homePage;
		
		@FindBy(xpath="//i[@class='fa fa-bars']")
		public static WebElement barButton;
		
		@FindBy(xpath="//div[@id='toast-container']")
		public static WebElement toaster;

}
