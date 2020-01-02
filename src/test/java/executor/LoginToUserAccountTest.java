package executor;

import org.testng.annotations.Test;

import com.campaign.ui.LoginLogoutLoc;

import utils.GlobalConfig;

public class LoginToUserAccountTest extends GlobalConfig {
	@Test
	public static void login() {
	new LoginLogoutLoc(driver);
	LoginLogoutLoc.UserName.sendKeys(prop.getProperty("UserName"));
	LoginLogoutLoc.Password.sendKeys(prop.getProperty("Password"));
	LoginLogoutLoc.Login.click();
	}
}
