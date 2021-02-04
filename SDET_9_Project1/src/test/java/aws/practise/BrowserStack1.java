package aws.practise;

import java.net.MalformedURLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStack1 {
	
	public static final String USERNAME = "divya502";
	public static final String AUTOMATE_KEY = "pgCoiJamiWfNv2Ksfcqb";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
@Test
public void browserRun() throws MalformedURLException {
	
	DesiredCapabilities caps = new DesiredCapabilities();
    
	caps.setPlatform(Platform.WINDOWS);
	caps.setBrowserName("chrome");
	caps.setVersion("80");
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "10");
	caps.setCapability("browser", "Chrome");
	caps.setCapability("browser_version", "80");
	caps.setCapability("name", "divya' First Test");
	
	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	driver.get("http://www,facebook.com/");
	driver.quit();
}
}
