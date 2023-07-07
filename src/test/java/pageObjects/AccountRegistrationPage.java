package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

	   @FindBy(css = "input#input-password")
		WebElement txtPassword;

		@FindBy(css = "input[value='1'][name='agree']")
		WebElement chkdPolicy;

		@FindBy(css = "button[type='submit']")
		WebElement btnContinue;

		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
   
		//Actions		
		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		

		public void setPrivacyPolicy() {
			
			
			boolean isSelected = chkdPolicy.isSelected();
			if(isSelected == false) {
				chkdPolicy.click();
			
				
			}

		}

		public void clickContinue() {
		
			btnContinue.click();
				
			
		}

		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

		}
}