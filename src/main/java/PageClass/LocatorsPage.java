package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsPage {
	
	
	@FindBy(xpath = "//a[@aria-label='Amazon.in']")
	protected WebElement Title;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	protected WebElement Serchbar;
	
	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']") 
	protected WebElement clickonSerchbutton;
	
	@FindBy(xpath="(//div[@class='a-row'])[1]")
	protected WebElement NoResultFound;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	protected WebElement result;
	
	@FindBy(xpath="//img[@class='s-image']")
	protected WebElement Laptop;
	
	@FindBy(xpath="//h2[text()='Results']")
	protected WebElement laptopResults;
	
	@FindBy(xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[4]")
	protected WebElement select4thProduct;
	
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	protected WebElement AddToCartButton;
	
	@FindBy(xpath="(//h4[@class='a-alert-heading'])[5]")
	protected String AddToCartText;

	@FindBy(xpath= "//span[@id='attach-sidesheet-view-cart-button-announce']")
	protected WebElement Cardbutton;
	
	@FindBy(xpath="//a[@class='a-link-normal close-button']")
	protected WebElement closebutton;
	
	@FindBy(xpath= "//span[@id='nav-cart-count']")
	protected WebElement carticonbox;
	
	@FindBy(xpath= "//span[@class='a-dropdown-prompt']")
	protected WebElement quantitydropdown;
	
	@FindBy(xpath= "(//a[@class='a-dropdown-link'])[2]")
	protected WebElement selectquantity;	
	
	@FindBy(xpath= "//input[@data-feature-id='item-delete-button']")
	protected WebElement deleteproduct;
	
	@FindBy(xpath= "//h2[contains(text(),' Your Amazon Cart is empty.')]")
	protected WebElement emptycart;
	
	@FindBy(xpath= "//span[@id='sc-subtotal-label-activecart']")
	protected WebElement updatedquanity;	

}
