package executor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.campaign.ui.LoginLogoutLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class VerifyAdminLoginTest extends GlobalConfig {

	public static SoftAssert softAssert = new SoftAssert();


	@Test
	public static void loginUsr() throws Exception {

		String str = driver.getTitle();
		new LoginLogoutLoc(driver);
		LoginLogoutLoc.UserName.sendKeys(prop.getProperty("UserName"));
		LoginLogoutLoc.Password.sendKeys(prop.getProperty("Password"));
		LoginLogoutLoc.Login.click();
		softAssert.assertEquals(str, prop.getProperty("Title"));
		test.log(LogStatus.PASS, "Title verified Successfully");
		String profile = LoginLogoutLoc.profile.getText();
		softAssert.assertEquals(profile, prop.getProperty("UserType"));
		test.log(LogStatus.PASS, "Admin Login Successfully");
		softAssert.assertAll();
	}

	@Test
	public static void logout() throws InterruptedException {
		new LoginLogoutLoc(driver);		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(LoginLogoutLoc.profile)).click();
		LoginLogoutLoc.logout.click();

		if (prop.getProperty("Logout").equals("1")) {
			WebDriverWait w1 = new WebDriverWait(driver, 5);
			w1.until(ExpectedConditions.visibilityOf(LoginLogoutLoc.loggedout)).click();
			test.log(LogStatus.PASS, "Admin Logged out verified Successfully");
		} else {
			LoginLogoutLoc.escape.click();
			test.log(LogStatus.PASS, "Admin logout discard  Successfully");
		}

	}

}
