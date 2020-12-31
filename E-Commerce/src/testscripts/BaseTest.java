package testscripts;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericlibraries.AutoConstants;
import genericlibraries.ToTakeScreenShot;
import genericlibraries.WebActionUtils;
import pom.HomePage;
import pom.LoginPage;

public class BaseTest implements AutoConstants {
	WebDriver driver;
	WebActionUtils webActionUtils;
	@Parameters({"browserName","appURL","ito","eto"})
	@BeforeClass
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(DEFAULT_URL)String appURL,
						@Optional(ITO)String ito,
						@Optional(ETO)String eto) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		} else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		} else {
			Assert.fail("Sorry, This Browser is not Supported");
		}
		long implicit = Long.parseLong(ito);
		long explicit = Long.parseLong(eto);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit, TimeUnit.SECONDS);
		driver.get(appURL);
		webActionUtils = new WebActionUtils(driver, explicit);
	}
	
	@Parameters({"username", "password"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USERNAME)String username,
						   @Optional(DEFAULT_PASSWORD)String password) {
		LoginPage lp = new LoginPage(driver, webActionUtils);
		lp.login(username, password);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult result) {
		String testCaseName = result.getName();
		if(ITestResult.FAILURE==result.getStatus()) {
			String imageFilePath=ToTakeScreenShot.getSnapshot(driver, testCaseName);
			Reporter.log(imageFilePath, true);
		}
		try {
			HomePage hp = new HomePage(driver, webActionUtils);
			hp.logout();
		} catch (Exception e) {
		
		}
	}
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
	
	
}
