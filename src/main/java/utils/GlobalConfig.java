package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GlobalConfig {
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriver driver;
	public static XSSFWorkbook wb;
	public static String sUsername;
	public static String sPassword;
	public static int RowNum;
//Static Method to read the Properties file for Global Configurations
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
//Method to Fetch the data from Excel Work Book
	}
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

	public static String Cdriverlocation = prop.getProperty("Cdriverlocation");
	public static String FdriverLocation = prop.getProperty("FdriverLocation");


	@BeforeTest
//Method is used to Create a Extend report File and Launch the Browser as per the Requirement
	public static void reports() throws FileNotFoundException {
		report = new ExtentReports(System.getProperty("user.dir") + "\\CampaignPortal.html", true);
		test = report.startTest("Campaign Portal Cases");
		test.log(LogStatus.PASS, "File Created for Report Successfully ");

		String browser = prop.getProperty("Browser");
		/* String browser=System.getProperty("browser"); */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1440,800"); //
		// options.addArguments("headless");
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
	//Method to Export the Reports to file and close the Browser afte the Test.
	@AfterTest(enabled = true)
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
