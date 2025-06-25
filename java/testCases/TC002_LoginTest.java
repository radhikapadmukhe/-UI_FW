package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"regressionTest","master"})
	public void verifyLogin() {
		HomePage hp = new HomePage(driver);
		
		hp.clickOnMyAcc();
		hp.clickOnLoginHP();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickOnLoginButton();
		MyAccountsPage ap = new MyAccountsPage(driver);
		
		try {
		Assert.assertTrue(ap.verifyMyAccountTitle());
		}
		catch(Exception e) {
			Assert.fail();
		}
	
		Assert.assertEquals(ap.getPageTitleOfMyAcc(), "My Account");
		
	}

}
