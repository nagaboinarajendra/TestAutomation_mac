package com.ta.seleniumtest;

	
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
public class BrowserTest {
 
public static void main(String[] args) {
 
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajendra_Nagaboina\\Downloads\\chromedriver_win32\\chromedriver.exe");
 
// Initialize browser
WebDriver driver=new ChromeDriver();
 
// Open facebook
driver.get("https://www.youtube.com");
 
// Maximize browser
 
driver.manage().window().maximize();
}
 
}