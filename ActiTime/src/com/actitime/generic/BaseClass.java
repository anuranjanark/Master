package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.objectrepository.LoginPage;

public class BaseClass {
static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
public static WebDriver driver;
@BeforeClass
public void openBrowser()
{
	driver=new ChromeDriver();
	WebdriverCommonLib w=new WebdriverCommonLib();
	w.waitForElementInGui(driver);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
@BeforeMethod
public void login() throws IOException
{
	FileLib fl=new FileLib();
	String url = fl.getPropertyValue("url");
	String un = fl.getPropertyValue("username");
	String pwd = fl.getPropertyValue("password");
	driver.get(url);
	LoginPage lp=new LoginPage(driver);
	lp.setLogin(un, pwd);
}
@AfterMethod
public void logout()
{
	
}
@AfterClass
public void closeBrowser()
{
	driver.close();
}
}
