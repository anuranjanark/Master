package com.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;
import com.google.common.base.Objects;

public class DataProviderUsage {
@Test(dataProvider = "getData")
/**
 * @dataprovider: test the same script with multiple data
 * @throws InterruptedException
 */
public void bookTicket(String src, String dest) throws InterruptedException {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	JavaUtils j=new JavaUtils();
	driver.get("https://www.cleartrip.com/");
	driver.findElement(By.id("FromTag")).sendKeys(src);
	driver.findElement(By.xpath("//a[contains(text(),'"+src+"')]")).click();
	driver.findElement(By.id("ToTag")).sendKeys(dest);
	driver.findElement(By.xpath("//a[contains(text(),'"+dest+"')]")).click();
	driver.findElement(By.xpath("//td[@data-month='"+j.getCurrentMonth()+"' and @data-year='"+j.getCurrentYear()+"']/a[.='"+j.getCuurentDate()+"']")).click();
	driver.close();
}
 @DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[5][2];
	objArr[0][0]="BLR";
	objArr[0][1]="GOI";
	
	objArr[1][0]="BLR";
	objArr[1][1]="EWR";
	
	objArr[2][0]="BLR";
	objArr[2][1]="NCL";
	
	objArr[3][0]="BLR";
	objArr[3][1]="LGA";
	
	objArr[4][0]="BLR";
	objArr[4][1]="NYC";
	return objArr;
}
}
