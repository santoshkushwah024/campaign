package executor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.campaign.ui.CampaignPageLoc;
import com.campaign.ui.LoginLogoutLoc;

import utils.GlobalConfig;

public class CampaignCreationTest extends GlobalConfig {

	@Test
	public static void campaignCreation() throws IOException, InterruptedException, AWTException {
		new LoginLogoutLoc(driver);
		String FilePath = System.getProperty("user.dir") + "\\users.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
		wb = new XSSFWorkbook(fs);
		XSSFSheet sh1 = wb.getSheetAt(0);
		int RowNum = sh1.getPhysicalNumberOfRows();
		for (int i = 0; i <= RowNum; i++) {
			sUsername = sh1.getRow(i).getCell(0).getStringCellValue();
			// sPassword = sh1.getRow(i).getCell(i+1).getStringCellValue();
			LoginLogoutLoc.UserName.sendKeys(sUsername);
			LoginLogoutLoc.Password.sendKeys(prop.getProperty("PASSWD"));
			LoginLogoutLoc.Login.click();
			campaignCreationSteps();
			break;
		}

	}

	public static void campaignCreationSteps() throws InterruptedException, AWTException {
		new CampaignPageLoc(driver);
		CampaignPageLoc.campaignmgmt.click();
		CampaignPageLoc.Addcmp.click();
		CampaignPageLoc.cmpName.sendKeys(sUsername);
		CampaignPageLoc.cmpType.click();
		CampaignPageLoc.cmpSid.sendKeys("LM-1234");
		CampaignPageLoc.nextBtn.click();
		Thread.sleep(5000);
		CampaignPageLoc.msisdn.click();
		CampaignPageLoc.uploadFile.click();
		Thread.sleep(2000);
		/*
		StringSelection sel = new StringSelection(System.getProperty("user.dir")+"\\campaign\\10lakhs1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 Robot robot = new Robot();
		 Thread.sleep(1000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 		// Release Enter
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
				// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 */
	}

}
