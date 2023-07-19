package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
   
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) throws InterruptedException {
		   logger.info(" Starting TC_003_LoginDataDrivenTest ");
		   System.out.println("exp:"+exp);
		   System.out.println("email:"+email);
		   System.out.println("pwd:"+pwd);
	
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info(" The clickMyAccount in homepage clicked ");
			hp.clickLogin();
			logger.info(" The clickLogin in homepage clicked ");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info(" The email in Loginpage setted ");
			lp.setPassword(pwd);
			logger.info(" The password in Loginpage setted ");
			lp.clickLogin();
			logger.info("logon in Loginpage clicked"); 
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExist();// this method is created MyAccountPage
			logger.info(targetpage);
			
			if (exp.equals("valid")) {
				logger.info("valid is true");
				if (targetpage == true) {
					logger.info("targetpage is true");   
					macc.clickLogout();
					
					logger.info("logout clicked");
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					logger.info("Invalid is true");   
					myaccpage.clickLogout();
					
					Assert.assertTrue(false);
				} else {
					logger.info("Invalid is false"); 
					Assert.assertTrue(true);
				}
			}

		
		logger.info(" Finished TC_003_LoginDataDrivenTest");
		

	}

}
