package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class SkillraryDemoAppPage {
	
	//declaration
	@FindBy(xpath= "//div[@class='navbar-header']")
	private WebElement pageHeader;
	
	@FindBy(id= "course")
	private WebElement courseTab;
	
	@FindBy(xpath= "//span[@class='wrappers']/a[text()='Selenium Training']")
	private WebElement SeleniumTrainingLink;
	
	@FindBy(xpath= "//select[@name='addresstype']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath= "//a[text()='Contact Us']")
	private WebElement ContactUsLink;
	
	//initializtion
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void mouseHoverCourse(WebDriverUtility web) {
		web.mouseHover(courseTab);
	}
	public void clickSeleniumTraining() {
		SeleniumTrainingLink.click();
	}
	public void selectCategory(WebDriverUtility web,int index) {
		web.dropdown(categoryDropdown, index);
	}
public void clickContactUs() {
	ContactUsLink.click();
}
}
