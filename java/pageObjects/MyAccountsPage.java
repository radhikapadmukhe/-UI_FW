package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage {

	public MyAccountsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccountSectionTitle;
	
	public boolean verifyMyAccountTitle() {
		
		boolean status=myAccountSectionTitle.isDisplayed();
		return status;
	}

	public String getPageTitleOfMyAcc() {
		
		String title=driver.getTitle();
		return title ;
	}
}
