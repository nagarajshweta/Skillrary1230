package TestScript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.Base;

public class SecondScript extends Base {
	
	@Test
	public void SecondScript() {
		SoftAssert soft=new SoftAssert();
		
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.switchToChildBrowser();
		
		soft.assertEquals(DemoApp.getPageHeader(), "SkillRary-ECommerce");
		DemoApp.selectCategory(web,1);
		
		soft.assertEquals(testing.getPageHeader(), "Testing");//checking page is appearing or not
		web.dragAndDropElementr(testing.getJavaImage(),testing.getMyCartArea());
		web.scrollToElement(testing.clickFacebookIcon());
		testing.clickFacebookIcon();
		soft.assertAll();
	}
	

}
