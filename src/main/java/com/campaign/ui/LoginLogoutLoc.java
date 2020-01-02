package com.campaign.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GlobalConfig;

public class LoginLogoutLoc extends GlobalConfig  {


	public LoginLogoutLoc(WebDriver driver) {
		GlobalConfig.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	public static WebElement UserName;
	

	@FindBy(name = "password")
	public static WebElement Password;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	public static WebElement Login;

	// profile Locators for logout
	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	public static WebElement profile;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	public static WebElement logout;

	// Pop up locators while logout
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public static WebElement loggedout;

	@FindBy(xpath = "//button[contains(text(),'No')]")
	public static WebElement escape;

}
