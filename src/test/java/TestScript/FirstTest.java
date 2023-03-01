package TestScript;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.Base;

public class FirstTest extends Base {
	
	@Test
	public void firstTest() {
		
		SoftAssert soft=new SoftAssert();
		
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.switchToChildBrowser();
		
		soft.assertEquals(DemoApp.getPageHeader(), "SkillRary-ECommerce");
	    DemoApp.mouseHoverCourse(web);
		DemoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
	    selenium.doubleClickPlusButton(web);
		selenium.clickAddCart();
		web.handleAlert();
		
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		
		
		
		
		
	}

	
	}

	
		
	


