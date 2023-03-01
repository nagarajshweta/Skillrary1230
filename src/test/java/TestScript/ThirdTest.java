package TestScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.Base;


public class ThirdTest extends Base {
	@Test
	public void ThirdTest() throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		
		home.searchFor("Core Java For selenium");
		soft.assertEquals(coreJava.getPageHeader(), "CORE JAVA FOR SELENIUM");
		coreJava.clickcorejavaforseleniumlink();
		soft.assertEquals(javaVideo.getPageHeader(),"Core Java For Selenium Training");
		
		javaVideo.clickclosecookies();
		web.switchToFrame();
		javaVideo.clickPlayButton();
		Thread.sleep(2000);
		javaVideo.clickAddToWhishlist();
		
		web.switchBackFromFrame();
		javaVideo.clickAddToWhishlist();
	soft.assertAll();
	}

}
