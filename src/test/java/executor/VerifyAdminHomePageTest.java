package executor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.campaign.ui.CamHomePageLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class VerifyAdminHomePageTest extends GlobalConfig {
	@Test
	public static void adminHomePage() throws Exception {
		LoginToUserAccountTest.login();
		new CamHomePageLoc(driver);
		test.log(LogStatus.PASS, "Admin Tab Bar clicked Successfully");
		CamHomePageLoc.userMgmt.click();
		//CamHomePageLoc.homePage.click();
		WebDriverWait w1 = new WebDriverWait(driver, 10);
		w1.until(ExpectedConditions.visibilityOf(CamHomePageLoc.homePage)).click();
		test.log(LogStatus.PASS, "Admin Home page is displayed Successfully");
		CamHomePageLoc.barButton.click();
		/*
		String str=CamHomePageLoc.toaster.getText();
		System.out.println(str);
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(CamHomePageLoc.toaster)).click();
		Thread.sleep(2000);
		*/
		VerifyAdminLoginTest.logout();
	}

}
