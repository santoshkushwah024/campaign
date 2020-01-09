package executor;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.campaign.ui.AdminTabsLoc;
import com.campaign.ui.BcastUserCreationLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class BcastUserCreationTest extends GlobalConfig {
	public static boolean b;
	
	@Test
	public static void bcastUserCreation() throws Exception {
		LoginToUserAccountTest.login();
		new AdminTabsLoc(driver);
		AdminTabsLoc.usrmgmt.click();
		Thread.sleep(2000);
		new BcastUserCreationLoc(driver);
		// User Details page
		XSSFSheet sh1 = wb.getSheetAt(0);
		RowNum = sh1.getPhysicalNumberOfRows();
		try {
			for (int i = 0; i <= RowNum - 1; i++) {
				WebDriverWait w = new WebDriverWait(driver, 10);
				w.until(ExpectedConditions.visibilityOf(BcastUserCreationLoc.addBtn)).click();
				sUsername = sh1.getRow(i).getCell(0).getStringCellValue();
			BcastUserCreationLoc.clear.click();
			BcastUserCreationLoc.urnNamefld.sendKeys(sUsername);
			BcastUserCreationLoc.contactNo.sendKeys(prop.getProperty("ContactNo")+i);
			BcastUserCreationLoc.emailId.sendKeys(sUsername+i+"@gmail.com");
			BcastUserCreationLoc.nxtpage.click();
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
		//BcastUserCreationLoc.floodEnableDisable.click();
		  BcastUserCreationLoc.nxtpage.click();
		 Thread.sleep(2000);
		 BcastUserCreationLoc.saveUsr.click();
		 Thread.sleep(5000);
			test.log(LogStatus.PASS, sUsername + " User Created Successfully");
			}
			}catch (Exception e) {
				test.log(LogStatus.FAIL, "Bcast user Creation Test Case Failed ");
		}
	}
}
