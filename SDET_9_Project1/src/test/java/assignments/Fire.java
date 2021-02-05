package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Fire {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//p[text()='Login or Create Account']")).click();
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
//	driver.findElement(By.id("username")).sendKeys("divya491k@gmail.com");
	//driver.findElement(By.xpath("//span[.='Departure']")).click();
	driver.findElement(By.id("fromCity")).click();
}	
}
	
