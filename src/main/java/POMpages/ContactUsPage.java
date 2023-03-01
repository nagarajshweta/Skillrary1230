package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	//declaration
			@FindBy(xpath= "//img[contains=(@src,'contactus')]")
			private WebElement pageHeader;

			@FindBy(name= "name")
			private WebElement fullnametf;

			@FindBy(name= "sender")
			private WebElement emailtf;
			
			@FindBy(name= "subject")
			private WebElement subjecttf ;
			
			@FindBy(name= "message")
			private WebElement messagearea;
			
			@FindBy(xpath= "//button[text()='Send us mail']")
			private WebElement sendUsMailButton;
			
			
			
			//initializtion
				public ContactUsPage(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}
				//utilization
				public WebElement getPageHeader() {
					return pageHeader;
				}
		
				public void sendContactDetails(String name,String email,String subject,String message) {
					fullnametf.sendKeys(name);
					emailtf.sendKeys(email);
					subjecttf.sendKeys(subject);
					messagearea.sendKeys(message);
					sendUsMailButton.click();
	}


}
