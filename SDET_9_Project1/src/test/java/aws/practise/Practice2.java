package aws.practise;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice2 {
	@Test(dataProvider="data")
	public void remoteExecution(Platform platform, String bName) throws MalformedURLException {
		URL url=new URL(" http://192.168.174.1:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities().chrome();
		cap.setPlatform(platform);
		cap.setBrowserName(bName);
		
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		driver.get("http://gmail.com");
		
	}
	@DataProvider(name="data", parallel=true)
	public Object[][] getData(){
		Object[][] test=new Object[][]
				{
			{Platform.WINDOWS, "chrome"},
			{Platform.WINDOWS,"firefox"}
           };
           return test;
	}
}
