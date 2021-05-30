package com.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynamicXpath_CalendarPopUp {
@Test
/**
 * script works only today cuz values are hardcoded
 * sol: in runtime we need to give values ref calendarpop2 script
 * @throws InterruptedException
 */
public void bookTicket() throws InterruptedException {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.cleartrip.com/");
	driver.findElement(By.id("FromTag")).sendKeys("blr");
	driver.findElement(By.xpath("//a[contains(text(),'Bangalore, IN')]")).click();
	driver.findElement(By.id("ToTag")).sendKeys("goi");
	driver.findElement(By.xpath("//a[contains(text(),'Goa, IN ')]")).click();
	driver.findElement(By.xpath("//td[@data-month='0' and @data-year='2021']/a[.='22']")).click();
}
}
