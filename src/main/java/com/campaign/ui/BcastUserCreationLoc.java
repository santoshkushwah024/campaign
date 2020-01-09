package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class BcastUserCreationLoc extends GlobalConfig {
	 public static String BcastUserName = prop.getProperty("BcastUserName");
	
	 public BcastUserCreationLoc(WebDriver driver) {
		GlobalConfig.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// User management Page Locators
	@FindBy(xpath = "//button[contains(text(),'Add User')]")
	public static WebElement addBtn;

	@FindBy(xpath = "//button[@title=\"Deactivate\"]")
	public static WebElement deactivateBtn;

	@FindBy(xpath = "//button[@title=\"Activate\"]")
	public static WebElement activateBtn;

	@FindBy(xpath = "//button[@title=\"Reset Password\"]")
	public static WebElement resetPswdBtn;
	
	@FindBy(xpath = "(//tbody/tr/td/input[@type=\"checkbox\"])[1]")
	public static WebElement Usrloctn;
	
	@FindBy(xpath = "(//td[@class=\"ng-star-inserted\"])[2]")
	public static WebElement UsrNme;


	@FindBy(xpath = "(//*[text()=\"delete\"])[1]")
	public static WebElement deleteUsr;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public static WebElement YesToDelte;

	@FindBy(xpath = "//button[contains(text(),'No')]")
	public static WebElement noToDelte;
	
	// user Addition page locators after click on Add User 1st Page User Details
	@FindBy(id = "usrNm")
	public static WebElement urnNamefld;

	@FindBy(xpath = "//input[@formcontrolname='user_contact_no']")
	public static WebElement contactNo;

	@FindBy(xpath = "//input[@formcontrolname='user_email']")
	public static WebElement emailId;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	public static WebElement nxtpage;

	@FindBy(xpath = "//span[text()=\"Clear\"]")
	public static WebElement clear;

	@FindBy(xpath = "//span[text()=\"Save as Draft\"] ")
	public static WebElement saveAsDraft;

	// user Addition page locators after click on Add User 2nd Page Account Details

	@FindBy(id = "fromDt")
	public static WebElement choseStartVldtyCalender;

	@FindBy(xpath="//input[@id='today']//..//span")
	public static WebElement accStartValiditiy;

	@FindBy(xpath="//input[@id='Indefinitely']//..//span")
	public static WebElement accEndValiditiy;

	@FindBy(xpath = "//label[text()=\"All\"]")
	public static WebElement allowIpAll;

	@FindBy(xpath = "//label[text()=\"Specific\"]")
	public static WebElement allowIpSpecific;

	@FindBy(xpath = "//div[@class=\"group\"]")
	public static WebElement allowIpSpcfcTxtBox;

	@FindBy(xpath = "//button[text()=\"Prev\"]")
	public static WebElement previous;

	// User Addition page locators after click on Add User 3rd Page Campaign Control

	@FindBy(xpath = "(//div[@class=\"detail-answer\"]/div/ui-switch/span/small)[1]")
	public static WebElement blckoutEnableDisable;

	@FindBy(xpath = "//span[text()=\"From Time\"]")
	public static WebElement frmTime;

	@FindBy(xpath = "(//div[text()=\"20:00\"])[1]")
	public static WebElement frmTimeSelect;

	@FindBy(xpath = "//span[text()=\"To Time\"]")
	public static WebElement toTime;

	@FindBy(xpath = "(//div[text()=\"06:00\"])[1]")
	public static WebElement toTimeSelect;

	@FindBy(xpath = "(//div[@class=\"detail-answer\"]/div/ui-switch/span/small)[2]")
	public static WebElement contentFltrEnableDisbale;

	// User Addition page locators after click on Add User 4Th Page User Control

	@FindBy(xpath = "(//div[@class=\"detail-answer\"]/div/ui-switch/span/small)[1]")
	public static WebElement dndEnableDisable;

	@FindBy(xpath = "//span[text()=\"SMSC Name\"]")
	public static WebElement selSMSC;

	@FindBy(name = "msg_Rate")
	public static WebElement tps;

	@FindBy(xpath = "(//div[@class=\"detail-answer\"]/div/ui-switch/span/small)[2]")
	public static WebElement floodEnableDisable;

	@FindBy(xpath = "(//label[text()=\"Any\"])[1]")
	public static WebElement destAll;

	@FindBy(xpath = "(//label[text()=\"Specific\"])[1]")
	public static WebElement destSpecific;

	@FindBy(xpath = "//span[text()=\"Region Name\"]")
	public static WebElement selDestSpecific;

	@FindBy(xpath = "//div[text()=\"Select All\"]")
	public static WebElement selAllDest; // select All the Destination

	@FindBy(xpath = "(//label[text()=\"Any\"])[1]")
	public static WebElement sidAll;

	@FindBy(xpath = "(//label[text()=\"Specific\"])[1]")
	public static WebElement sidSpecific;

	@FindBy(xpath = "(//div[@class=\"detail-answer\"]/div/ui-switch/span/small)[3]")
	public static WebElement ftpEnableDisable;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public static WebElement saveUsr;
}
