package com.draganddrop;
/**
 * @author Rajendra_Nagaboina
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 /**
 * Drag and drop operations.
 */
public class DragAndDrop {

	WebDriver driver;
	/**
	 * configuring the browser and launching he site.
	 */
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","/Users/rajendra/Desktop/TestAutomation/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("http://demo.guru99.com/test/drag_drop.html");
		 driver.manage().window().maximize();
	}
	
	@Test(description = "drag and drop")
	public void dandd() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='block13 ui-draggable'][1]")));
		WebElement From = driver.findElement(By.xpath("//li[@class='block13 ui-draggable'][1]"));
		WebElement To = driver.findElement(By.xpath("//ol[@id='amt8']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(From).moveToElement(To).release().build().perform();
	}
}
