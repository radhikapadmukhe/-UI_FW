package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//input[@id='input-email']")
	WebElement txtEmailBox;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement txtPasswordBox;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void enterEmail(String emailID) {
		
		txtEmailBox.sendKeys(emailID);
		
		}
	
	public void enterPassword(String pwd) {
		
		txtPasswordBox.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		btnLogin.click();
	}
	
}	
