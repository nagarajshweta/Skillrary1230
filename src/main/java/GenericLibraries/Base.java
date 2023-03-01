package GenericLibraries;

	import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMpages.ContactUsPage;
import POMpages.CoreJavaForSeleniumPage;
import POMpages.CoreJavaForVideoPage;
import POMpages.HomePage;
import POMpages.SeleniumTrainingPage;
import POMpages.SkillraryDemoAppPage;
import POMpages.TestingPage;

	public class Base{
	
		protected PropertiesUtility property;
		protected ExcelUtility excel;
		protected WebDriverUtility web;
		protected WebDriver driver;
		protected HomePage home;
		protected SkillraryDemoAppPage DemoApp;
		protected SeleniumTrainingPage selenium;
		protected CoreJavaForSeleniumPage coreJava;
		protected CoreJavaForVideoPage javaVideo;
		protected TestingPage testing;
		protected ContactUsPage contact;
		
		
		//@BeforeSuite
		//@BeforeTest
		@BeforeClass
		 public void classConfiguration()
		 {
			property=new PropertiesUtility();
			excel=new ExcelUtility();
			web=new WebDriverUtility();
			
			 
			 property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
			 excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
			 
			 
			 
		 }
		@BeforeMethod
		public void methodConfiguration()
		{
			long time= Long.parseLong(property.fetchProperty("timeouts"));
			 driver=web.openApplication(property.fetchProperty("browser"), 
					 property.fetchProperty("url"), time);
			 
			 home= new HomePage(driver);
			 Assert.assertTrue(home.getLogo().isDisplayed());
			 DemoApp= new SkillraryDemoAppPage(driver);
			 selenium=new SeleniumTrainingPage(driver);
			 coreJava=new CoreJavaForSeleniumPage(driver);
			 javaVideo=new CoreJavaForVideoPage(driver);
			 testing=new TestingPage(driver);
			 contact = new ContactUsPage(driver); 
			 
		}
		@AfterMethod
		public void methodTearDown()
		{
			web.quitBrowser();
		}
		@AfterClass
		public void classTearDown()
		{
			excel.closeExcel();
		}
		//@AfterTest
		//@AfterSuite
	}



	


