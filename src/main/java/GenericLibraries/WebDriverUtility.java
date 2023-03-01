package GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * THIS CLASS CONTAINS REUSABLE WEBDRIVER
 * @author HP
 *
 */

public class WebDriverUtility {
	
	private WebDriver driver;
	/**
	 * THIS METHOD USED TO NAVIGte to an application using user desired browser
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	
	public WebDriver openApplication(String browser, String url, long time) {
		
		switch(browser) {
		
		case "chrome":driver=new ChromeDriver();
		break;
		case "firefox":driver=new FirefoxDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		default:System.out.println("Invalid browser data");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		return driver;
	}
	/**
	 * THIS MWTHOD IS USED TO WAIT UNTILL THE VISIBILITY OF PERTICULAR ELEMENT
	 * @param element
	 * @param time
	 * @return
	 */

	public WebElement explicitWait(WebElement element,long time) {
		
	
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * THIS METHOD IS USED TO PERFORM MOUSE HOVER ON AN ELEMENT
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * DOUBLE CLICK OF AN ELEMENT
	 * @param element
	 */
	public void doubleClickElement(WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * THIS METHOD IS USED TO PERFORM DRAG AND DROP OF AN ELEMENT
	 * @param source
	 * @param target
	 */
	public void dragAndDropElementr(WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source,target).perform();
	}
	/**
	 *USED TO SELECT AN ELEMENT FROM DROPDOWN BASED ON INDEX
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index) {
		Select s =new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * USED TO SELECT AN ELEMENT FROM DROPDOWN BASED ON VISIBLE TEXT
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element,String text) {
		Select s =new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * USED TO SELECT AN ELEMENT FROM DROPDOWN BASED ON VALUE
	 * @param value
	 * @param element
	 */
	public void dropdown(String value,WebElement element) {
		Select s =new Select(element);
		s.selectByVisibleText(value);
	}
	/**
	 * USED TO SCROLL TILL THE ELEMENT 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0],scrollIntoView(true)",element);
	}
	/**
	 * USED TO TO TAKE SCREENSHOT OF WEBPAGE
	 */
	public void takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * USED TO HANDLE ALERT POPUP
	 */
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}
	/**
	 * USED TO SWITCH TO CHILD BROWSER
	 */
	public void switchToChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String windowID:set) {
			driver.switchTo().window(windowID);
		}
	}
	/**
	 * USED TO SWITCH TO FRAME
	 */
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	/**
	 * USED TO SWITCHBACK FROM THE FRAME
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();}
	/**
	 * USED TO CLOSE THE CURRENT TAB
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	/**
	 * USED TO CLOSE ALL TABS AND EXIT WEBDRIVER
	 */
	public void quitBrowser() {
		driver.quit();
		}
}																																																																																
