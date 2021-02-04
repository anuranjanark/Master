package com.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;

public class DynamicXpath_calendarPopUp2 {
	@Test
	/**
	 * script works whenever we execute
	 * @throws InterruptedException
	 */
	public void bookTicket() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavaUtils j=new JavaUtils();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).sendKeys("blr");
		driver.findElement(By.xpath("//a[contains(text(),'Bangalore, IN')]")).click();
		driver.findElement(By.id("ToTag")).sendKeys("goi");
		driver.findElement(By.xpath("//a[contains(text(),'Goa, IN ')]")).click();
		driver.findElement(By.xpath("//td[@data-month='"+j.getCurrentMonth()+"' and @data-year='"+j.getCurrentYear()+"']/a[.='"+j.getCuurentDate()+"']")).click();
	}
}
