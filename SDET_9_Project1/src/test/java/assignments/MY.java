package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;

public class MY {
	/**
	 * script to test with multiple data in makemyTrip
	 * @param src
	 * @param dest
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData")
  public void bookFlight(String src, String dest) throws InterruptedException {
	ChromeOptions ch=new ChromeOptions();
	ch.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(ch);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	JavaUtils j=new JavaUtils();
	driver.get("https://www.makemytrip.com/");
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	
	Actions actions=new Actions(driver);
	actions.moveByOffset(57, 59).click().perform();
	
	//driver.findElement(By.xpath("//div[@class='landingContainer']")).click();
	driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
	WebElement fromLoc = driver.findElement(By.xpath("//div[.='"+src+"']"));
	wait.until(ExpectedConditions.elementToBeClickable(fromLoc));
	fromLoc.click();
	
	driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(dest);
	WebElement destt = driver.findElement(By.xpath("//div[.='"+dest+"']"));
	wait.until(ExpectedConditions.elementToBeClickable(destt));
	destt.click();
	driver.findElement(By.xpath("//div[.='"+j.getCuurentDate()+"']")).click();
	driver.close();
}
@DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[5][2];
	objArr[0][0]="BLR";
	objArr[0][1]="DEL";
	
	objArr[1][0]="BLR";
	objArr[1][1]="BKK";
	
	objArr[2][0]="BLR";
	objArr[2][1]="PNQ";
	
	objArr[3][0]="BLR";
	objArr[3][1]="HYD";
	
	objArr[4][0]="BLR";
	objArr[4][1]="GOI";
	return objArr;
}
}
