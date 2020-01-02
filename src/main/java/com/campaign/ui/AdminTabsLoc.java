package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class AdminTabsLoc extends GlobalConfig {

	public AdminTabsLoc(WebDriver driver) {
		GlobalConfig.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-bars']")
	public static WebElement tabbtn;
	
	@FindBy(xpath="//span[contains(text(),'User')]")
	public static WebElement usrmgmt;
	
	@FindBy(xpath="//span[contains(text(),'Region')]")
	public static WebElement rgnmgmt;
	
	@FindBy(xpath="//span[contains(text(),'DND')]")
	public static WebElement dndmgmt;
	
	@FindBy(xpath="//span[contains(text(),'SMSC')]")
	public static WebElement smscmgmt;
	
	@FindBy(xpath="//span[contains(text(),'MIS')]")
	public static WebElement mismgmt;
	
	@FindBy(xpath="//span[contains(text(),'Barred')]")
	public static WebElement brdmgmt;
	
	@FindBy(xpath="//span[contains(text(),'Quota')]")
	public static WebElement qtamgmt;
	
	@FindBy(xpath="//span[contains(text(),'SID')]")
	public static WebElement sidmgmt;
	
	@FindBy(xpath="//span[contains(text(),'License')]")
	public static WebElement lcnsemgmt;
	
	@FindBy(xpath="//span[contains(text(),'Audit')]")
	public static WebElement adtmgmt;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public static WebElement hme;
	
}
