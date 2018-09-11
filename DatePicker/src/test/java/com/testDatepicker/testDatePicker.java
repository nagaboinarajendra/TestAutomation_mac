package com.datepicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class testDatePicker {

	WebDriver driver;
	
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajendra_Nagaboina\\Desktop\\Selenium Test Automation\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	@Test(description = "launch the site", priority = 1)
	public void launchSite() {
		driver.get("https://reactdatepicker.com");
	}
	@Test(description = "picks the date", priority = 2)
	public void pickDate() {
		Page page = new Page(driver);
		page.datePicker();
	}
}
