package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage_PageFactory {
	WebDriver driver;
	
	@FindBy(id="name")
	WebElement txt_UserName;
		
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	
	
	
	public LoginPage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	//********
	// Creating Individual methods for action on each object
	
	public void enterUserName(String userName) {
		txt_UserName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	
	
	////*********
	
	
	///Creating Logical flow using objects	
	public void loginValidUser(String userName, String password) {
		txt_UserName.sendKeys(userName);
		txt_password.sendKeys(password);
		loginBtn.click();	
		
	}
}
