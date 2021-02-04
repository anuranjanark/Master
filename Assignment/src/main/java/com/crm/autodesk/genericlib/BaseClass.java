package com.crm.autodesk.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;

public class BaseClass {
	public FileUtility fLib=new FileUtility();
	public WebDriverUtiles wLib=new WebDriverUtiles();
	public JavaUtils jLib=new JavaUtils();
	public ExcelUtility eLib=new ExcelUtility();
	public Login lp;
	//public Home hp;
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void configBS() {

	}
	@BeforeTest(groups= {"smoke","regression"})
	public void configBT() {

	}
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() throws Throwable {
		if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();	 
		}
		else if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("ie")) {
			 driver=new InternetExplorerDriver();	 
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(fLib.getPropertyKeyValue("url"));
 }
   
	/*@Parameters("browser")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBCParallel(String BROWSER) throws Throwable {
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();	 
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver=new InternetExplorerDriver();	 
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(fLib.getPropertyKeyValue("url"));
 }*/


	/**
	 * login to vtiger app
	 * @throws Throwable 
	 */
	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() throws Throwable {
		String un = fLib.getPropertyKeyValue("username");
		String pwd = fLib.getPropertyKeyValue("password");
		lp=new Login(driver);
		//  lp.loginToApp(fLib.getPropertyKeyValue("username"),fLib.getPropertyKeyValue("password"));
		lp.loginToApp(un, pwd);
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() {
	   Home	hp=new Home(driver);
		hp.logout();
	}
	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		driver.quit();
	}
	@AfterTest(groups= {"smoke","regression"})
	public void configAT() {
		// close browser launched in cross browser testing
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void configAS() {
		// close connection to db/ flush extent report
	}
}
