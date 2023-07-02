package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test
	public void test() {
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickRegister();
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLasttName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@"+"gmail.com");
		regpage.setTelephone(randomeNumber());
		String password = randomeAphaNumber();
		regpage.setPassword( password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String message = regpage.getConfirmationMsg();
		Assert.assertEquals(message, "Your Account Has Been Created!");
		 
		}catch(Exception e){
			Assert.fail();
		}
		
		
	}
}
