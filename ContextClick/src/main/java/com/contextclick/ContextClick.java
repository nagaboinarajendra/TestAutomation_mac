package com.contextclick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextClick {

	WebDriver driver;
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajendra_Nagaboina\\Desktop\\Selenium Test Automation\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	@Test(description = "launch drad and drop website", priority = 1)
	public void launchSite() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Page p = new Page(driver);
		p.contextClick();
	}
	
}
