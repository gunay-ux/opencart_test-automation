package pageObjects;



//import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class MyAccountPage  extends BasePage{
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	

	
	
	
	//WebElement logout = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));	
	//List<WebElement> options=driver.findElements(By.className("list-group mb-3"));

	public boolean isMyAccountPageExist() {
		
		try {  
			
			return msgHeading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		
		logout.click();
		/*for(WebElement option:options)                      
		{   System.out.println(option.getText());
			if(option.getText().equals("Logout"))
				option.click();
		}*/
		
	}
	


}
