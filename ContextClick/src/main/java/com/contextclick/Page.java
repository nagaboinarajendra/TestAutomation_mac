package com.contextclick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

	WebDriver driver;
	String actionSequence[] = new String[]{"Edit","Cut","Copy","Paste","Delete","Quit"};
	@FindBy(xpath = "//span[@class = 'context-menu-one btn btn-neutral']")
	WebElement rightClick;
	static int number = 0;
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void contextClick() {
		while(number < 6) {
			Actions oAction = new Actions(driver);
			oAction.moveToElement(rightClick);
			oAction.contextClick(rightClick).build().perform();
			WebElement elementToClick = driver.findElement(By.xpath("//span[text() = '"+actionSequence[number]+"']"));
			elementToClick.click();
			driver.switchTo().alert().accept();
			number++;
		}
	}
}
