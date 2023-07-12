package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
   @Test
	public void test_login(){
		try {
		logger.info("*** Starting TC_002_LoginTest");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccountPage");
		hp.clickLogin();
		logger.info("Clicked on MLoginPage");
		LoginPage lp = new LoginPage(driver);
		logger.info("providing login detail");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		logger.info("Clicked on login button");
		MyAccountPage myAccount = new MyAccountPage(driver);
		boolean targetpage = myAccount.isMyAccountPageExist();
		Assert.assertEquals(targetpage, true,"invalid login data");
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest");
	}
}