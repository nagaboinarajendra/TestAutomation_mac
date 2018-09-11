package testcontextclick;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import contextclick.Page;
/**
 * test class for context clicking.
 */
public class TestContextClick {
	/**
	 * web browser object.
	 */
	WebDriver driver;
	/**
	 * 
	 */
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","/Users/rajendra/Desktop/TestAutomation/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	}
	/**
	 * performs the context click.
	 */
	@Test(description = "launch drad and drop website", priority = 1)
	public void launchSite() {
		Page p = new Page(driver);
		p.contextClick();
	}
	
}
