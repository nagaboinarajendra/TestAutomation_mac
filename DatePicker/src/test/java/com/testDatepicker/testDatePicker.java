package com.testDatepicker;
/**
 * @author Rajendra_Nagaboina
 */
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.datepicker.Page;
public class testDatePicker {
	/**
	 * web browser object.
	 */
	WebDriver driver;
	/**
	 * Initializes the web Browser.
	 */
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","/Users/rajendra/Desktop/TestAutomation/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("https://reactdatepicker.com");
	}
	/**
	 * check for selected date is correct or not.
	 */
	@Test(description = "picks the date")
	public void pickDate() {
		String date = "08/16/2016";
		Page page = new Page(driver);
		page.datePicker(date);
		assertEquals(driver.findElement(By.xpath("//*[@id='example-0']/div/div/div/div/div/input")).getAttribute("value"),date);
	}
}
