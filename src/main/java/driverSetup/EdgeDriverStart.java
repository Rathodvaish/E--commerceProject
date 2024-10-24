package driverSetup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageClass.LoginPage;
import Utils.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EdgeDriverStart {
	
	public ExtentReports extent;
	public ExtentHtmlReporter ExtentReporter;
	public  WebDriver driver;
	public ExtentTest test;
	
	@BeforeTest
	public void Setup() {
		
		
 
    driver=  WebDriverManager.edgedriver().create();
    
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
    System.out.println("amzone screen opend");
    
	}


	@BeforeClass
	 public void ExtentReport() {
		
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
	   ExtentHtmlReporter ExtentReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/" +"TestReports"+timeStamp+".html");
	  
	       extent = new ExtentReports();
	       extent.attachReporter(ExtentReporter);
	       
	       ExtentReporter.config().setChartVisibilityOnOpen(true);
	       ExtentReporter.config().setDocumentTitle("Simple Automation Report");
	       ExtentReporter.config().setReportName("Test Report");
	       ExtentReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	       ExtentReporter.config().setTheme(Theme.STANDARD);
	       ExtentReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm");
   	
	    }
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		 ITestContext context = null;

		if(result.getStatus() == ITestResult.SUCCESS) {

			String filepath = null ;
			try {
				filepath = Screenshot.caturescreenshot(driver, result.getMethod().getMethodName());
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			try {
				test.addScreenCaptureFromPath(Screenshot.capturePassScreenShotInsideProject(driver, result.getMethod().getMethodName()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	       
	    }
		else if(result.getStatus() == ITestResult.FAILURE) {
	    test.log(Status.FAIL,result.getTestName());
	   
		 test.log(Status.FAIL,result.getThrowable());
			String filepath = null ;
		
			try {
				filepath = Screenshot.capturePassScreenShotInsideProject(driver, result.getMethod().getMethodName());
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			     try {
				       test.addScreenCaptureFromPath(Screenshot.captureFailScreenShotInsideProject(driver, result.getMethod().getMethodName()));
				
			} catch (Exception e) {
				e.printStackTrace();
			  }
			     driver.quit();

	    }
	    
	    else {
	        test.log(Status.SKIP, result.getTestName());
	    }
	    
		
	}
	
	@AfterTest
	public void TearDown() {
		
		extent.flush();
	    driver.quit();
}
}