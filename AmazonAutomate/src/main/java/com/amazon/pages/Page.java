package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	WebDriver driver;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	@FindBy(id = "nav-link-shopall")
	WebElement hoverOverCategory;
	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[15]/span")
	WebElement books;
	@FindBy(xpath = "//h2[text() = 'Selenium Testing Tools Cookbook -']")
	WebElement seleniumTestingToolsCookBook;
	@FindBy(xpath = "//span[text()='All Books']")
	WebElement allBooks;
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void search(String searchContent) {
		searchBox.sendKeys(searchContent);
		searchBox.submit();
	}
	
	public void hoverOverShopByCategory() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverOverCategory).build().perform();
	}
	
	public void selectBooks() {
		hoverOverShopByCategory();
		books.click();
	}
	
	public void selectSeleniumTestingToolsCookBook() {
		seleniumTestingToolsCookBook.click();
	}
	public void selectAllBooks() {
		allBooks.click();
	}
}


