package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class CampaignPageLoc {

	public CampaignPageLoc(WebDriver driver) {
		GlobalConfig.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Click on  the campaign management tab
	@FindBy(xpath = "//span[contains(text(),'Campaign Management')]")
	public static WebElement campaignmgmt;

//Click on the Add Campaign Button to add the Campaign 	
	@FindBy(xpath = "//button[contains(text(),' Add Campaign')]")
	public static WebElement Addcmp;

//Locate Campaign Name 
	@FindBy(id = "cmpNm")
	public static WebElement cmpName;

//Select Campaign Type	as Instant
	@FindBy(xpath = "//input[@value=\"instant\"]//..//span")
	public static WebElement cmpType;

//Select Campaign Type as Scheduled	
	@FindBy(xpath = "//input[@value=\"scheduled\"]//..//span")
	public static WebElement schCmp;

// Select Campaign Type as Scheduled
	@FindBy(xpath = "//input[@formcontrolname=\"account_validity_from_time\"]")
	public static WebElement selTime;

//Enter SID for Campaign 	
	@FindBy(name = "anySid")
	public static WebElement cmpSid;

//Click on Next Button	
	@FindBy(xpath = "//button[contains(text(),'Next ')]")
	public static WebElement nextBtn;

//Select Uplaod type as Msisdn
	@FindBy(xpath = "//input[@id=\"rxId\"]")
	public static WebElement msisdn;

//Upload a file with Numbers	
	@FindBy(xpath = "(//input[@id=\"chooseFile\"])[1]")
	public static WebElement uploadFile;

//Enter the Message for the Campaign	
	@FindBy(xpath = "//textarea[@id=\"number\"]")
	public static WebElement enterMsg;

// Submit the campaign
	@FindBy(xpath = "//button[text()=\"Submit \"]")
	public static WebElement submitCmp;

}
