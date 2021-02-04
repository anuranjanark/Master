package aws.practise;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practise1 {
@Test
public void remoteExecution() throws MalformedURLException {
	URL url=new URL(" http://192.168.174.1:4444/wd/hub");
	DesiredCapabilities cap=new DesiredCapabilities().chrome();
	cap.setPlatform(Platform.WINDOWS);
	cap.setBrowserName("chrome");
	
	RemoteWebDriver driver=new RemoteWebDriver(url, cap);
	driver.get("http://gmail.com");
	
}
}
