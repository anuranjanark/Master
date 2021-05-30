package com.vtiger.productsModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ChoiceparameterFromJenkins {
	WebDriver driver;
@Test
public void test() {
	
	String browserName = System.getProperty("BROWSERNAME");
	if(browserName.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		 driver=new FirefoxDriver();	 
	}
	else if(browserName.equalsIgnoreCase("ie")) {
		 driver=new InternetExplorerDriver();	 
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.facebook.com/");
	System.out.println(driver.getTitle());
	}
}
