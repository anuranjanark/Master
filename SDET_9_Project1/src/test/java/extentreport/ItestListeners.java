package extentreport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.ARG_IN;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.autodesk.generics.JavaUtils;

public class ItestListeners implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
	test=report.createTest(result.getMethod().getMethodName());	
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" pass");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver =null;
		test.log(Status.FAIL, result.getMethod().getMethodName()+" fail");
		test.log(Status.FAIL, result.getThrowable());
		String results=result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String screenShotPath="./errorshot/"+result.getMethod().getMethodName()+".png";
		File dest = new File(screenShotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShotPath);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" skip");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		JavaUtils j=new JavaUtils();
	  ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File("./ExtentReport"+j.getCuurentDate()+".html")); 
	  htmlReport.config().setDocumentTitle("Vtiger App");
	  htmlReport.config().setTheme(Theme.DARK);
	  htmlReport.config().setReportName("smoke test");
	 
	  report=new ExtentReports();
	  report.attachReporter(htmlReport);
	  report.setSystemInfo("ReporterName", "divya k");
	  report.setSystemInfo("TestUrl", "http://localhost:8888");
	  report.setSystemInfo("os", "windows");
	  report.setSystemInfo("browser", "chrome");
	  report.setSystemInfo("browserVersion", "87");
	}

	public void onFinish(ITestContext context) {
	report.flush();
		
	}

}
