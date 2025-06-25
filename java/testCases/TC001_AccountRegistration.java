package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
		
	@Test(groups= {"sanity","master"})
	public void verifyAccountRegistration() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAcc();
		hp.clickOnRegister();
		
		AccountRegistrationPage ap= new AccountRegistrationPage(driver);
		ap.enterfn(generateRandomString());
		ap.enterln(generateRandomString());
		ap.enteremail(generateRandomString()+"@gmail.com");
		ap.entetel(generateRandomNumbers());
		String pwd=generateRandomString();
		ap.enterpwd(pwd);
		ap.confirmpassword(pwd);
		ap.clickOnCheckbox();
		ap.clickOncontinueButton();
		String msg=ap.getTheSuccessMessage();
		
		Assert.assertEquals(msg, "Your Account Has Been Created!");
				
	}
		
}
