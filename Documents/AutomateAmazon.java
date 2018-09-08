package com.ta.amazon;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
public class AutomateAmazon {
	
	WebDriver driver;
	@BeforeClass
	public void setProperties() {
   System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajendra_Nagaboina\\Desktop\\Selenium Test Automation\\drivers\\chromedriver.exe");
   driver = new ChromeDriver();
	}

	@Test(description="Launches the Amazon site")
	public void launchSite(){
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.id("nav-link-shopall"));
		Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        element =driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[15]/span"));
        element.click();
        element =driver.findElement(By.xpath("//span[text()='All Books']"));
        element.click();
        element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("selenium with java");
        element.submit();
        element = driver.findElement(By.xpath("//h2[text() = 'Selenium Testing Tools Cookbook -']"));
        assertEquals(element.getText(),"Selenium Testing Tools Cookbook -");
        driver.findElement(By.xpath("//span[text()='4 Stars & Up']")).click();
        element = driver.findElement(By.xpath("//span[text()='See more' and @class='a-expander-prompt']"));
        assertEquals(element.getText(),"See more");
        
//    element.sendKeys("nagabhoinarajendra@gmail.com");
//    WebElement element1 = driver.findElement(By.className("qhFLie"));
//    element1.click();
//
//
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
//    WebElement element2 = driver.findElement(By.xpath("//input[@type='password']"));
//    element2.sendKeys("&*");
//    WebElement element3 = driver.findElement(By.className("qhFLie"));
//    element3.click();
	
	}
	
}

