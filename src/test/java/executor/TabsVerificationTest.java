package executor;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.campaign.ui.AdminTabsLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class TabsVerificationTest extends GlobalConfig {
	public static boolean b;
	@Test
	public static void tabsVerify() throws Exception {
		
		LoginToUserAccountTest.login();
		new AdminTabsLoc(driver);
		AdminTabsLoc.usrmgmt.click();
		b = AdminTabsLoc.usrmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "User  Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "User  Management tab is not present");
		}
		AdminTabsLoc.rgnmgmt.click();
		b = AdminTabsLoc.rgnmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "Region  Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "Region  Management tab is not present");
		}
		AdminTabsLoc.dndmgmt.click();
		b = AdminTabsLoc.dndmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "DND  Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "DND  Management tab is not present");
		}
		AdminTabsLoc.smscmgmt.click();
		b = AdminTabsLoc.smscmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "SMSC  Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "SMSC  Management tab is not present");
		}
		AdminTabsLoc.brdmgmt.click();
		b = AdminTabsLoc.brdmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "Barred Content  Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "Barred Content  Management tab is not present");
		}
		AdminTabsLoc.qtamgmt.click();
		b = AdminTabsLoc.qtamgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "Quota Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "Quota Management tab is not present");
		}
		AdminTabsLoc.sidmgmt.click();
		b = AdminTabsLoc.sidmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "SID Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "SID Management tab is not present");
		}
		AdminTabsLoc.lcnsemgmt.click();
		b = AdminTabsLoc.lcnsemgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "License Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "License  Management tab is not present");
		}
		AdminTabsLoc.adtmgmt.click();
		b = AdminTabsLoc.adtmgmt.isDisplayed();
		Assert.assertTrue(b);
		if (b == true) {
			test.log(LogStatus.PASS, "Audit Management tab Clicked Successfully");
		} else {
			test.log(LogStatus.FAIL, "Audit Management tab is not present");
		}
		VerifyAdminLoginTest.logout();
	}
}
