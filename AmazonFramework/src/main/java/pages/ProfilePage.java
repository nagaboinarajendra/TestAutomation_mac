package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends Page{

	@FindBy(xpath = "//span[text() = 'Hello, rajendra']")
	WebElement profileName;
	@FindBy(xpath = "//span[text() = 'Sign Out']")
	WebElement signOut;
	@FindBy(xpath = "//i[@class='a-icon a-icon-extender-expand']")
	WebElement seeMore;
	@FindBy(xpath = "//span[text() = 'See Less']")
	WebElement seeLess;
	@FindBy(xpath = "//span[text() = 'Paperback']")
	WebElement paperBack;
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public HomePage signOut() {
		Actions action = new Actions(driver);
		action.moveToElement(profileName).build().perform();
		signOut.click();
		return new HomePage(driver);
	}
	public void clickSeeMore() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='a-icon a-icon-extender-expand']")));
        seeMore.click();	
	}
	public void clickSeeLess() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'See Less']")));
        seeLess.click();
	}
	public void choosePaperBack() {
		paperBack.click();
	}
	
}
