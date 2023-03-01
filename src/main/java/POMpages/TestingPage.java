package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class TestingPage {
	
	//declaration
		@FindBy(xpath= "//h1[@class='page-header']")
		private WebElement pageHeader;

		@FindBy(xpath= "//imag[@id='java']")
		private WebElement javaImage;

		@FindBy(xpath= "//div[@id='cartArea']")
		private WebElement myCartArea;
		@FindBy(xpath= "//footer/descendant::i[@class='fa-facebook']")
		private WebElement facebookIcon;

	
		
		
		//initializtion
			public TestingPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			//utilization
			public String getPageHeader() {
				return pageHeader.getText();
			}
	
			public WebElement getJavaImage() {
				return javaImage;
			}
			public WebElement getMyCartArea() {
				return myCartArea;
			}
			public void  clickFacebookIcon() {
			 facebookIcon.click();

			}
}
