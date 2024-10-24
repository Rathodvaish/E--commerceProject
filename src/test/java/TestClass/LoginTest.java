package TestClass;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import PageClass.LoginPage;
import driverSetup.EdgeDriverStart;


public class LoginTest extends EdgeDriverStart  {

	
	@Test(priority=1)
	
	public void Logintestcase_01() throws InterruptedException {
		test = extent.createTest("Logintestcase_01 : ");
		LoginPage login = new LoginPage(driver);
		login.testcase_01();	
		
	}
@Test(priority=2)
	public void Logintestcase_02() throws InterruptedException {
		test= extent.createTest("Logintestcase_02: ");
			LoginPage login = new LoginPage(driver);;
		login.testcase_02();
		
	}
	
	@Test(priority=3)
		
	public void logintestcase_03() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		test= extent.createTest("logintestcase_03: ");
		login.testcase_03();
	}
	@Test(priority=4)
	public void Logintestcase_04() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		test= extent.createTest("logintestcase_04: ");
		login.testcase_04();
		
	}
	@Test(priority=5)
	public void Logintestcase_05() throws InterruptedException  {
		LoginPage login= new LoginPage(driver);
		test= extent.createTest("testcase_05(): ");
		login.testcase_05();
	}
	@Test(priority=6)
	
	public void Logintestcase_06() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		test= extent.createTest("testcase_06(): ");
		login.testcase_06();
	}
	
@Test(priority=7)
	
	public void Logintestcase_07() throws InterruptedException {
	LoginPage login = new LoginPage(driver);
	test= extent.createTest("testcase_07(): ");
	login.testcase_07();
	
	}
	
}
