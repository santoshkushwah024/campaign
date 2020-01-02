package executor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.campaign.ui.AdminTabsLoc;
import com.campaign.ui.BcastUserCreationLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class BcastUserCreationTest extends GlobalConfig {
	public static boolean b;
	@BeforeTest
	public static void deleteExistingUser() throws Exception {

		try {
			LoginToUserAccountTest.login();
			new AdminTabsLoc(driver);
			AdminTabsLoc.usrmgmt.click();
			new BcastUserCreationLoc(driver);
			BcastUserCreationLoc.Usrloctn.click();
			String str = BcastUserCreationLoc.UsrNme.getText();
			BcastUserCreationLoc.deleteUsr.click();
			WebDriverWait w = new WebDriverWait(driver, 5);
			if (str.equals(prop.get("BcastUserName"))) {
				w.until(ExpectedConditions.visibilityOf(BcastUserCreationLoc.YesToDelte)).click();
				test.log(LogStatus.PASS, " Draft User Deleted Successfully");
				Thread.sleep(4000);
			} else {
				w.until(ExpectedConditions.visibilityOf(BcastUserCreationLoc.noToDelte)).click();
				test.log(LogStatus.PASS, " No USer to Delete ");
			}
		} catch (Exception e1) {
			System.out.println("User is Not present to Delete");
		}
		Thread.sleep(2000);
	}

	@Test
	public static void bcastUserCreation() throws Exception {
		/*
		 * LoginToUserAccountTest.login(); new AdminTabsLoc(driver);
		 * AdminTabsLoc.usrmgmt.click();
		 */
		new BcastUserCreationLoc(driver);
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(BcastUserCreationLoc.addBtn)).click();
		// User Details page
		try {
			BcastUserCreationLoc.clear.click();
			BcastUserCreationLoc.urnNamefld.sendKeys(prop.getProperty("BcastUserName"));
			BcastUserCreationLoc.contactNo.sendKeys(prop.getProperty("ContactNo"));
			BcastUserCreationLoc.emailId.sendKeys(prop.getProperty("Email_id"));
			boolean b = BcastUserCreationLoc.nxtpage.isEnabled();
			if (b == true) {
				test.log(LogStatus.PASS, "User Details Section Filled Successfully");
				BcastUserCreationLoc.nxtpage.click();
			} else {
				test.log(LogStatus.FAIL, "User Details is not Filled ");
			}
		} catch (Exception e) {
			System.out.println("Details is not Valid");
		}
		// Account Details page
		Thread.sleep(2000);
		BcastUserCreationLoc.accStartValiditiy.click();
		BcastUserCreationLoc.accEndValiditiy.click();
		BcastUserCreationLoc.allowIpAll.click();
		BcastUserCreationLoc.nxtpage.click();
		
	
	// Campaign Details page
		Thread.sleep(1000);
		//BcastUserCreationLoc.blckoutEnableDisable.click();
		//BcastUserCreationLoc.contentFltrEnableDisbale.click();
		BcastUserCreationLoc.nxtpage.click();
		
		//User Control Page 
		//BcastUserCreationLoc.dndEnableDisable.click();
		//BcastUserCreationLoc.selSMSC.click();
		BcastUserCreationLoc.tps.clear();
		BcastUserCreationLoc.tps.sendKeys(prop.getProperty("TPS"));
		BcastUserCreationLoc.floodEnableDisable.click();
		 b=BcastUserCreationLoc.destAll.isSelected();
		 if(b==true) {
			 System.out.println("All Dest Selected");
		 }
		 b=BcastUserCreationLoc.sidAll.isSelected();
		 if(b==true) {
			 System.out.println("All SID Selected");
		 }
		
	}
}
