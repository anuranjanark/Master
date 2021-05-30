package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author HP
 *
 */
public class Caputure_all_row_data {
	/**
	 * scrpit to capture particular row data
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Organizations")));
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> org = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		int count=0;
		for(WebElement lst:org)
		{ 
			count++;
			if(lst.getText().equals("tyy01"))
			{ System.out.println(count);
			 count++;
			}
		}
		List<WebElement> text = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr["+count+"]/td[*]"));
		for(WebElement t:text) 
		{
		System.out.println(t.getText());
		}
	}
}
