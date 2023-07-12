package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		
	   @FindBy(id = "input-email")
		WebElement txtEmail;

	   @FindBy(id = "input-password")
		WebElement txtPassword;
	   
	   @FindBy(xpath = "//button[@type='submit']")
	   WebElement btnLogin;
	   

		public void setEmail(String email) {
			txtEmail.clear();
			txtEmail.sendKeys(email);

		}
		
		public void setPassword(String pwd) {
			txtPassword.clear();
			txtPassword.sendKeys(pwd);

		}
		
		public void clickLogin() {
			btnLogin.click();

		}


		

	
}
