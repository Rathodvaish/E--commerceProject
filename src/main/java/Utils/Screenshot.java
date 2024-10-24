package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
public class Screenshot {
	
	public WebDriver driver;
	
	public Screenshot(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public static String captureFailScreenShotInsideProject(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"\\Failed_ScreenShots\\"+filename+".png";
		
		File destination = new File(path);
		FileHandler.copy(source, destination);
		
		return path;
		  
	}
	public static String capturePassScreenShotInsideProject(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"\\Passed_ScreenShots\\"+filename+".png";
		
		File destination = new File(path);
		FileHandler.copy(source, destination);
		
		return path;
		  
	}
		
   public static String caturescreenshot(WebDriver driver, String filename) throws IOException {
		
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
		
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"\\TestCaseScreenShot\\"+filename+timeStamp+".png";
		
		File destination = new File(path);
		FileHandler.copy(source, destination);
		
		return path;
		  

}}
