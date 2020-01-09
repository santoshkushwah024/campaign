package executor;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.campaign.ui.BcastUserLogoutLoc;
import com.campaign.ui.CampaignPageLoc;
import com.campaign.ui.LoginLogoutLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class CampaignCreationTest extends GlobalConfig {

	@Test(priority = 1)
	public static void instCampaignCreation() throws Exception {
		new LoginLogoutLoc(driver);
		XSSFSheet sh1 = wb.getSheetAt(0);
		RowNum = sh1.getPhysicalNumberOfRows();
		for (int i = 0; i <= RowNum - 1; i++) {
			sUsername = sh1.getRow(i).getCell(0).getStringCellValue();
			// sPassword =sh1.getRow(i).getCell(i + 1).getStringCellValue();
			LoginLogoutLoc.UserName.sendKeys(sUsername);
			LoginLogoutLoc.Password.sendKeys(prop.getProperty("PASSWD"));
			LoginLogoutLoc.Login.click();
			instCmpCreationSteps();
			logoutBcastUsr();
		}

	}

	// Method for Instant Campaign Creation
	public static void instCmpCreationSteps() throws InterruptedException {
		new CampaignPageLoc(driver);
		try {
			Thread.sleep(1000);
			CampaignPageLoc.campaignmgmt.click();
			CampaignPageLoc.Addcmp.click();
			CampaignPageLoc.cmpName.sendKeys(sUsername);
			CampaignPageLoc.cmpType.click();
			CampaignPageLoc.cmpSid.sendKeys("LM-1234");
			CampaignPageLoc.nextBtn.click();
			Thread.sleep(4000);
			CampaignPageLoc.uploadFile.sendKeys(System.getProperty("user.dir") + "\\10lakhs1.txt");
			test.log(LogStatus.PASS, "File Upload  Successfully");
			CampaignPageLoc.enterMsg.sendKeys(prop.getProperty("MSG"));
			CampaignPageLoc.submitCmp.click();
			test.log(LogStatus.PASS, sUsername + " User Instant Campaign Created Successfully");
			Thread.sleep(12000);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, sUsername + "Instant Campaign Creation Failed");
		}
	}

	@Test(priority = 2, enabled = true)
	public static void schCampaignCreation() throws Exception {
		new LoginLogoutLoc(driver);
		XSSFSheet sh1 = wb.getSheetAt(0);
		RowNum = sh1.getPhysicalNumberOfRows();
		for (int i = 0; i <= RowNum - 1; i++) {
			sUsername = sh1.getRow(i).getCell(0).getStringCellValue();
			// sPassword = sh1.getRow(i).getCell(i+1).getStringCellValue();
			LoginLogoutLoc.UserName.sendKeys(sUsername);
			LoginLogoutLoc.Password.sendKeys(prop.getProperty("PASSWD"));
			LoginLogoutLoc.Login.click();

			try {
				if (prop.getProperty("EnableLoad").equalsIgnoreCase("yes")) {
					{
						schCmpCreationSteps();
					}
				} else if (prop.getProperty("EnableLoad").equalsIgnoreCase("no")) {
					test.log(LogStatus.PASS, sUsername + " Load Is diabled so Not Creating Campaigns");
				}
				logoutBcastUsr();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, sUsername + " Load Variable is not defined in Configurations");
			}

		}
	}

	// Method for Schedule Campaign Creation
	public static void schCmpCreationSteps() throws InterruptedException, AWTException {
		int num1 = Integer.parseInt(prop.getProperty("LoadHours"));
		for (int j = 1; j <= (num1 * 2)-1; j++) {
			new CampaignPageLoc(driver);
			try {
				Thread.sleep(1000);
				CampaignPageLoc.campaignmgmt.click();
				CampaignPageLoc.Addcmp.click();
				CampaignPageLoc.cmpName.sendKeys(sUsername);
				CampaignPageLoc.schCmp.click();
				// Create object of SimpleDateFormat class and decide the format
				DateFormat dateFormat = new SimpleDateFormat("HH:mm");
				// get current date time with Date()
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.MINUTE, 30 * j);
				String newTime = dateFormat.format(cal.getTime());
				CampaignPageLoc.selTime.clear();
				CampaignPageLoc.selTime.sendKeys(newTime);
				Thread.sleep(1000);

				CampaignPageLoc.cmpSid.sendKeys("LM-1234");
				CampaignPageLoc.nextBtn.click();
				Thread.sleep(4000);
				CampaignPageLoc.uploadFile.sendKeys(System.getProperty("user.dir") + "\\10lakhs1.txt");
				test.log(LogStatus.PASS, "File Upload  Successfully");
				CampaignPageLoc.enterMsg.sendKeys(prop.getProperty("MSG"));
				CampaignPageLoc.submitCmp.click();
				Thread.sleep(12000);
				test.log(LogStatus.PASS, sUsername + "Scheduled Campaign Created Successfully");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, sUsername + "Scheduled Campaign Creation Failed");
			}

		}
	}

	public static void logoutBcastUsr() throws Exception {
		new BcastUserLogoutLoc(driver);
		try {
			BcastUserLogoutLoc.profile.click();
			BcastUserLogoutLoc.signout.click();
			Thread.sleep(1000);
			BcastUserLogoutLoc.loggedout.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, sUsername + "Logout Failed");
		}

	}

}
