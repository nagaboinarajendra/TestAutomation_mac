package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	WebDriver driver;
	@FindBy(id = "ap_email")
	WebElement username;
	@FindBy(id = "continue")
	WebElement continueLogin;
	@FindBy(id = "ap_password")
	WebElement password;
	@FindBy(id = "signInSubmit")
	WebElement login;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProfilePage login(String strUserName, String strPassword) {
		username.sendKeys(strUserName);
		continueLogin.submit();
		password.sendKeys(strPassword);
		login.click();
		return new ProfilePage(driver);
	}
}
