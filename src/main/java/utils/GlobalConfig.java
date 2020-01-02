package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GlobalConfig {
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriver driver;

	static {
		prop = new Properties();
		FileInputStream sp;
		try {
			sp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\config.properties");

			prop.load(sp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static String Cdriverlocation = prop.getProperty("Cdriverlocation");
	public static String FdriverLocation = prop.getProperty("FdriverLocation");
	public static XSSFWorkbook wb;
	public static String sUsername;
	public static String sPassword;

	@BeforeTest

	public static void reports() throws FileNotFoundException {
		report = new ExtentReports(System.getProperty("user.dir") + "\\CampaignPortal.html", true);
		test = report.startTest("Campaign Portal Cases");
		test.log(LogStatus.PASS, "File Created for Report Successfully ");

		String browser = prop.getProperty("Browser");
		/* String browser=System.getProperty("browser"); */
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("window-size=1440,800"); //
		//  options.addArguments("headless");
		  options.addArguments("--ignore-certificate-errors");
		  
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FdriverLocation);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Cdriverlocation);
			driver = new ChromeDriver(options);
			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Browser Launched Successfully");
		driver.get(prop.getProperty("URL"));

	}
	/*
	 * @DataProvider public static Object[][] credentials(String sUsername, String
	 * sPassword) throws IOException { String FilePath =
	 * System.getProperty("user.dir") + "\\users.xlsx"; FileInputStream fs = new
	 * FileInputStream(FilePath); wb = new XSSFWorkbook(fs); XSSFSheet sh1 =
	 * wb.getSheetAt(0); int RowNum = sh1.getPhysicalNumberOfRows();// count my
	 * number of Rows int ColNum = sh1.getLastRowNum(); Object credentials[][] = new
	 * Object[RowNum - 1][ColNum]; for (int i = 0; i < RowNum - 1; i++) // Loop work
	 * for Rows { XSSFRow row = sh1.getRow(i + 1);
	 * 
	 * for (int j = 0; j < ColNum; j++) // Loop work for colNum { if (row == null)
	 * credentials[i][j] = ""; else { XSSFCell cell = row.getCell(j); if (cell ==
	 * null) credentials[i][j] = ""; // if it get Null value it pass no data else {
	 * Object value = null; credentials[i][j] = value; } } } } return credentials;
	 * 
	 * }
	 */

	@AfterTest(enabled = true)
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
