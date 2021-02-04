package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;

public class MakeMyTrip {
	@Test
	public void bookFlight() throws InterruptedException {
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(ch);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavaUtils j=new JavaUtils();
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait=new WebDriverWait(driver, 20);

		Actions actions=new Actions(driver);
		actions.moveByOffset(57, 59).click().perform();
		//driver.findElement(By.xpath("//div[@class='landingContainer']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("BLR");
		WebElement fromLoc = driver.findElement(By.xpath("//p[.='Bengaluru, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(fromLoc));
		fromLoc.click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("DEL");
		WebElement dest = driver.findElement(By.xpath("//p[.='Delhi, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(dest));
		dest.click();
		driver.findElement(By.xpath("//div[.='"+j.getCuurentDate()+"']")).click();

		/* driver.findElement(By.xpath("//span[text()='From']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("JFK");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='JFK']")));			
	 driver.findElement(By.xpath("//div[text()='JFK']")).click();

	  driver.findElement(By.xpath("//span[text()='To']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MYQ");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='MYQ']")));
	  driver.findElement(By.xpath("//div[text()='MYQ']")).click();*/

	}
}
