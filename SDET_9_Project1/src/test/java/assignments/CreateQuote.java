package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;
import com.crm.autodesk.generics.WebDriverUtil;

public class CreateQuote {
	@Test
	/**
	 * script to create a quote
	 * @throws InterruptedException
	 */
	public void CreateQuoteTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverUtil wb=new WebDriverUtil();
		JavaUtils j=new JavaUtils();

		/* testScript data*/
		String subTB="quote"+j.GenerateRandomInt();
		String orgName="abc";
		String billingAdd="blr";
		String shippingAdd="blr";
		String prodNmae="P1001";
		String quantity="2";

		/*login to app*/
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		/*navigate to quote*/
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Quotes']")).click();
		driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();

		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subTB);

		/* contact name lookup*/
		driver.findElement(By.xpath("//input[@name='contact_id']/following-sibling::img")).click();
		wb.swicthToWindow(driver, "Contacts&action");
		WebElement contact = driver.findElement(By.xpath("//table[@class='small']/tbody/tr[*]/td/a[.=' divya']"));
		wb.waitforElementToBeClickable(driver, contact);
		contact.click();
		wb.alertCancel(driver);

		/*orgName lookup*/
		wb.swicthToWindow(driver, "Quotes");
		WebElement orgLookUp = driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img"));
		wb.waitforElementToBeClickable(driver, orgLookUp);
		orgLookUp.click();
		wb.swicthToWindow(driver, "Account&action");
		WebElement actual = driver.findElement(By.xpath("//table[@class='small']/tbody/tr[*]/td/a[.='"+orgName+"']"));
		wb.waitforElementToBeClickable(driver, actual);
		actual.click();
		wb.alertCancel(driver);

		/* billing address*/
		wb.swicthToWindow(driver, "Quotes");
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(billingAdd);

		/*shipping address*/
		//driver.findElement(By.xpath("//input[@name='cpy']/following-sibling::b[.='Copy Billing address']")).click();
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shippingAdd);

		/* adding product*/
		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		wb.swicthToWindow(driver, "Products&action");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[*]/td/a[.='"+prodNmae+"']")).click();
		wb.swicthToWindow(driver, "Quotes");

		/* entering quantity*/
		driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys(quantity);

		/* save*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*compare actul with expected*/
		String actualText=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		boolean expectedText = actualText.contains(subTB);
		Assert.assertTrue(expectedText);
       
       Reporter.log(subTB +" sucessfully created", true);

	}
}
