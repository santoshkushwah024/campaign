package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class BcastUserLogoutLoc extends GlobalConfig{
	public BcastUserLogoutLoc(WebDriver driver) {
		GlobalConfig.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Broadcast user')]")    		//locator for Broadcast user Profile 
	public static WebElement profile;

	@FindBy(xpath="//i[contains(text(),'clear')]")      				//Locator to close the Page
	public static WebElement cancel;
	
	@FindBy(xpath="//button[contains(text(),'Change Password')]")       //Locator to Click on Change Password button
	public static WebElement chngPwd;

	@FindBy(xpath="(//i[contains(text(),'edit')])[1]")					//Locator to change Email
	public static WebElement editEmail;
	
	@FindBy(xpath="//input[@placeholder=\"username@domain.com\"]")      //Locator to Enter the Email
	public static WebElement inputMail;
	
	@FindBy(xpath="(//i[contains(text(),'check_circle')])[1]")          //Locator to Save the Email
	public static WebElement aceptEditmail;
	
	@FindBy(xpath="(//i[contains(text(),'cancel')])[1]")				//Locator to  Cancel the Email Changes
	public static WebElement cnclEditmail;

	@FindBy(xpath="(//i[contains(text(),'edit')])[2]")					//Locator to Edit Mobile Number
	public static WebElement editmobile;

	@FindBy(xpath="//input[@formcontrolname=\"changeMobile\"]")         //Locator to Enter the Mobile Number
	public static WebElement chngMobile;
	
	@FindBy(xpath="(//i[contains(text(),'check_circle')])[2]")			//Locator to Save Mobile Number Changes
	public static WebElement aceptEditmobile;
	
	@FindBy(xpath="(//i[contains(text(),'cancel')])[2]")				//Locator to Cancel Mobile Number Changes
	public static WebElement cnclEditmobile;

	@FindBy(xpath="//span[contains(text(),'Verify')]")					//Locator to Verify The Email Address
	public static WebElement verifyEmail;

	@FindBy(xpath="//span[contains(text(),' Sign Out')]")				//Locator to click SignOut 
	public static WebElement signout;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")					//Locator to For Popup to click on Yes to Signout
	public static WebElement loggedout;

	@FindBy(xpath = "//button[contains(text(),'No')]")					//Locator to For Popup to click on No to Signout
	public static WebElement escape;
}
