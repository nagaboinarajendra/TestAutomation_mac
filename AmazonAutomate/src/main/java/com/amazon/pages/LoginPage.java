package com.amazon.pages;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Login to the amazon web site.
 */
public class LoginPage {
	/**
	 * web browser driver.
	 */
	WebDriver driver;
	/**
	 * email web element.
	 */
	@FindBy(id = "ap_email")
	WebElement username;
	/**
	 * continue web element.
	 */
	@FindBy(id = "continue")
	WebElement continueLogin;
	/**
	 * password web element.
	 */
	@FindBy(id = "ap_password")
	WebElement password;
	/**
	 * submit the login credentials.
	 */
	@FindBy(id = "signInSubmit")
	WebElement login;
	/**
	 * LoginPage constructor the initialize the current page web elements.
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * Login to the amazon web site.
	 * @param strUserName valid username 
	 * @param strPassword valid password
	 * @return profile page if it is success.
	 */
	public ProfilePage login(String strUserName, String strPassword) {
		username.sendKeys(strUserName);
		continueLogin.submit();
		password.sendKeys(strPassword);
		login.click();
		return new ProfilePage(driver);
	}
}
