package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	public void clickOnMyAcc() {
		
		myAccount.click();
		
	}
	
	public void clickOnRegister() {
		register.click();
	}
	
	public void clickOnLoginHP() {
		login.click();
	}
}
