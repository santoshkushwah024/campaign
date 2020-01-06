package executor;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.campaign.ui.BcastUserLogoutLoc;
import com.campaign.ui.CampaignPageLoc;
import com.campaign.ui.LoginLogoutLoc;
import com.relevantcodes.extentreports.LogStatus;

import utils.GlobalConfig;

public class CampaignCreationTest extends GlobalConfig {
	public static XSSFWorkbook wb;
	public static String sUsername;
	public static String sPassword;
	public static int RowNum;
	static {
		String FilePath = System.getProperty("user.dir") + "\\users.xlsx";
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = false)
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
			test.log(LogStatus.PASS, sUsername + " User Campaign Created Successfully");
			logoutBcastUsr();
			Thread.sleep(1000);
		}

	}

	// Method for Instant Campaign Creation
	public static void instCmpCreationSteps() throws InterruptedException {
		new CampaignPageLoc(driver);
		CampaignPageLoc.campaignmgmt.click();
		CampaignPageLoc.Addcmp.click();
		CampaignPageLoc.cmpName.sendKeys(sUsername);
		CampaignPageLoc.cmpType.click();
		CampaignPageLoc.cmpSid.sendKeys("LM-1234");
		CampaignPageLoc.nextBtn.click();
		CampaignPageLoc.msisdn.click();
		Thread.sleep(4000);
		CampaignPageLoc.uploadFile.sendKeys(System.getProperty("user.dir") + "\\10lakhs1.txt");
		test.log(LogStatus.PASS, "File Upload  Successfully");
		CampaignPageLoc.enterMsg.sendKeys(prop.getProperty("MSG"));
		CampaignPageLoc.submitCmp.click();
		Thread.sleep(12000);
	}

	@Test(priority = 2)
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
				test.log(LogStatus.PASS, sUsername + " User Campaign Created Successfully");
				logoutBcastUsr();
			} catch (Exception e) {
				System.out.println(" Campaign Creation Failed ");
			}
			Thread.sleep(5000);
		}
	}

	// Method for Schedule Campaign Creation
	public static void schCmpCreationSteps() throws InterruptedException, AWTException {
		int num1 = Integer.parseInt(prop.getProperty("LoadHours"));
		for (int j = 1; j <= num1 * 2; j++) {
			new CampaignPageLoc(driver);
			try {
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
				test.log(LogStatus.PASS, sUsername + "Campaign Created Successfully");
			} catch (Exception e) {
				System.out.println("Error In the campaign Creation");
			}

		}
	}

	public static void logoutBcastUsr() throws Exception {
		new BcastUserLogoutLoc(driver);
		BcastUserLogoutLoc.profile.click();
		BcastUserLogoutLoc.signout.click();
		Thread.sleep(1000);
		BcastUserLogoutLoc.loggedout.click();
	}

}
