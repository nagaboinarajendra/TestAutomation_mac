package com.draganddrop;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DragAndDrop {
	WebDriver driver;
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajendra_Nagaboina\\Desktop\\Selenium Test Automation\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	@Test(description = "launch drad and drop website", priority = 1)
	public void launchSite() {
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
	}
	@Test(description = "ds", priority = 2)
	public void dandd() {
//		driver.findElement(By.xpath("//*[@id=\\\"wrapper\\\"]/article/ul/li[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='block13 ui-draggable'][1]")));
		
		WebElement From = driver.findElement(By.xpath("//li[@class='block13 ui-draggable'][1]"));
		 
		WebElement To = driver.findElement(By.xpath("//ol[@id='amt8']"));
		 
		Actions builder = new Actions(driver);
		builder.clickAndHold(From).moveToElement(To).release().build().perform();
	}
}
