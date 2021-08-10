package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {	
	
	private WebDriver driver;
	Screenshots screenshot;
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
		screenshot = new Screenshots(driver);
	}
	
	public void enterText(WebElement element, String text) {
		
		try {
			
			element.clear();
			element.sendKeys(text);
		}
		catch(Exception ex) {
			screenshot.takeScreenshot();
			System.out.println("Error in entering text");
			
		}
		
	}
	
}
