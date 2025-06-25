package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
			}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement fntxtbox;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement lntxtbox;

@FindBy(xpath="//input[@id='input-email']")
WebElement emailtxtbox;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement telphone;

@FindBy(xpath="//input[@id='input-password']")
WebElement pwd;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement pwdCnfrm;

@FindBy(xpath="//input[@name='agree']")
WebElement chckbox;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//div[@id='content']//h1")
WebElement successmsg;

public void enterfn(String fn) {
	
	fntxtbox.sendKeys(fn);
}
public void enterln(String ln) {
	
	lntxtbox.sendKeys(ln);
}

public void enteremail(String email) {
	
	emailtxtbox.sendKeys(email);
}

public void entetel(String telephone) {
	
	telphone.sendKeys(telephone);
}

public void enterpwd(String pswd) {
	pwd.sendKeys(pswd);
	
}

public void confirmpassword(String pswd) {
	
	pwdCnfrm.sendKeys(pswd);
}
 

 
public void clickOnCheckbox() {
	
	chckbox.click();
}

public void clickOncontinueButton()
{
	btnContinue.click();
}

public String getTheSuccessMessage() {
	
	try
	{
		return successmsg.getText();
	}
	catch(Exception e) {
		
		return e.getMessage();
	}

}
}
