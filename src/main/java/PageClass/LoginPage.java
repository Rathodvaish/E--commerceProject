package PageClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends LocatorsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public String parent;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void testcase_01() throws InterruptedException {
		
		Boolean title= Title.isDisplayed();
		 if(title) {
			  System.out.println("Amazon.in title is showing to user");}
		  else {
			  System.out.println("title is not showing to user"); 
			  }

//			Boolean SerchBar = Serchbar.isDisplayed();
//			
//			Serchbar.sendKeys("ld345tsxslfer");
//			clickonSerchbutton.click();
//			
//			NoResultFound.isDisplayed();
//				
//			 String Actualresult=NoResultFound.getText();
//			 String Expectedresult="No results for ld345tsxslfer.";
//				 
//			 Assert.assertEquals(Expectedresult, Actualresult);
//				
       		 System.out.println("'No results found' message should be displayed");
	}


	
	public void testcase_02() throws InterruptedException {
		
//		Serchbar.clear();
//		System.out.println("Clear the data");
		
		Serchbar.sendKeys("Laptop");
		
		 clickonSerchbutton.click();
		 Thread.sleep(2000); 
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptopResults);
	
		 Thread.sleep(2000); 
		 laptopResults.isDisplayed();
		 
		 String Actualresult=laptopResults.getText();
		 String Expectedresult="Results";
			 
		 Assert.assertEquals(Expectedresult, Actualresult);
		 
		 System.out.println("Product results should displayed 'Laptop' on the page");			 
		 Thread.sleep(2000); 	 
	}
	
	 public void testcase_03() throws InterruptedException {
		 
	 		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", select4thProduct);
		    
		 System.out.println("list of productS");
		 
		 wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(select4thProduct));
		 
		 Boolean selectpro= select4thProduct.isDisplayed();
	     
	     parent =driver.getWindowHandle();
		  
		 select4thProduct.click();
		 System.out.println("select the 4th Product");
		    
         Set<String> handles=  driver.getWindowHandles();
			
		   for(String Windowsid: handles) {  
				if(!(parent.equals(Windowsid))) {
					driver.switchTo().window(Windowsid);
				}
	 }
		  System.out.println("reflect on Child window");
		
	 
	 }
		    
	 public void testcase_04() throws InterruptedException{
		 Thread.sleep(1000); 	
	 		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddToCartButton);
				    
				 wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.elementToBeClickable(AddToCartButton));
			 
				 AddToCartButton.click();
		         System.out.println("add to cart product");
		         
		         Thread.sleep(1000);
		        
			}
		    
	
		 public void testcase_05() throws InterruptedException{
			 
			 closebutton.click();
			 Thread.sleep(1000);
			 
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carticonbox);
			 
			 carticonbox.isDisplayed();
			 System.out.println("cart icon is displayed");
			 

			 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.elementToBeClickable(carticonbox));
			 
      		 carticonbox.click();
      		 Thread.sleep(2000);
      		 
	         String Actualresult=updatedquanity.getText();
			 String Expectedresult="Subtotal (1 item):";
				 
			 Assert.assertEquals(Expectedresult, Actualresult);
			 System.out.println("Product (Select 4th result from list) should be added to the cart with correct quantity and price details");		         
    
 
      		 
		 }
		 
		 public void testcase_06() throws InterruptedException {
			 
             quantitydropdown.click();	 
             
             selectquantity.click();
             Thread.sleep(2000);
             
             String quantityActualresult=updatedquanity.getText();
			 String quantityExpectedresult="Subtotal (2 items):";
				 
			 Assert.assertEquals(quantityExpectedresult, quantityActualresult);
			 System.out.println("The cart should reflect the updated quantity and price");
		 }


		 
		   public void testcase_07() throws InterruptedException {
				 Thread.sleep(1000);
				 
			 deleteproduct.click();
			 
			 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.visibilityOf(emptycart));
			 
			 String Actualresult=emptycart.getText();
			 String Expectedresult="Your Amazon Cart is empty.";
				 
			 Assert.assertEquals(Expectedresult, Actualresult);
			 System.out.println("The cart should be empty");
			 	
		 }}	 


		 
   
	 
     
	 
	
	


