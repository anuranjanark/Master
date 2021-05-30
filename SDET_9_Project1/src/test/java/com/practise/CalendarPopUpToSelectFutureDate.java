package com.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarPopUpToSelectFutureDate {
@Test
public void selectFutureDate() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.cleartrip.com/");
	driver.findElement(By.id("DepartDate")).click();
	int count=0;
	while(count<24)
	{
		try {
			driver.findElement(By.xpath("//td[@data-month='7' and @data-year='2021']/a[.='22']")).click();
			break;
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//a[@class='nextMonth '] ")).click();
			count++;
		}
	}
	driver.close();
}
}
