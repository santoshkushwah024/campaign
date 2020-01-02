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

	@FindBy(xpath="//span[contains(text(),'Campaign Management')]")
	public static WebElement campaignmgmt;
	
	@FindBy(xpath="//button[contains(text(),' Add Campaign')]")
	public static WebElement Addcmp;
	
	@FindBy(id ="cmpNm")
	public static WebElement cmpName;
	
	@FindBy(id="disablingId")
	public static WebElement cmpType;
	
	@FindBy(name="anySid")
	public static WebElement cmpSid;
	
	@FindBy(xpath="//button[contains(text(),'Next ')]")
	public static WebElement nextBtn;
	
	@FindBy(xpath="//input[@id=\"rxId\"]")
	public static WebElement msisdn;
	
	
	@FindBy(xpath="(//input[@id=\"chooseFile\"])[1]")
	public static WebElement uploadFile;
}
