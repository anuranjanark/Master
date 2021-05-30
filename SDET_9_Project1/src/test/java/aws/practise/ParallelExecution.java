package aws.practise;

import java.net.MalformedURLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecution {

	public static final String USERNAME = "divya502";
	public static final String AUTOMATE_KEY = "pgCoiJamiWfNv2Ksfcqb";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test(dataProvider="data")
	public void browserRun(Platform platform, String bName, String bVersion) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(platform);
		caps.setBrowserName(bName);
		caps.setVersion(bVersion);
		/*caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "80");*/
		caps.setCapability("name", bName);
		caps.setCapability("browserstack.debug", true);

		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("http://www.facebook.com/");
		driver.quit();
	}
	@DataProvider(name="data", parallel=true)
	public Object[][] getData(){
		Object[][] test=new Object[][]
				{
			{Platform.WINDOWS, "chrome","80"},
			{Platform.WINDOWS,"firefox","57"},
			{Platform.MAC,"firefox","57"}
           };
           return test;
	}
}


