package testCases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_Registration() throws InterruptedException
	{
	    logger.debug("application logs....");
		logger.info("*** Starting TC_001_AccountRegistrationTest ");
		
		try{	
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My account");
			
			hp.clickRegister();
			logger.info("Clicked on Register link");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			
			String password=randomAlphaNumeric();
			System.out.println("password:" + password);
			regpage.setPassword(randomAlphaNumeric());
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("clicked continue");
			String confmsg=regpage.getConfirmationMsg();
			logger.info("Validating expected message");
			AssertJUnit.assertEquals("Test Failed", "Your Account Has Been Created!",confmsg);
	  }
		catch( Exception e) {
		  logger.error("test failed");
		  Assert.fail();
	  }
		logger.info("*** Finished TC_001_AccountRegistrationTest ");
		
	}
	
	
}
