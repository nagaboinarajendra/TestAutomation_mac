package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectByStarRating {

	WebDriver driver;
	@FindBy(xpath = "//span[text()='4 Stars & Up']")
	WebElement fourStar;
	@FindBy(xpath = "//span[text()='3 Stars & Up']")
	WebElement threeStar;
	@FindBy(xpath = "//span[text()='2 Stars & Up']")
	WebElement twoStar;
	@FindBy(xpath = "//span[text()='1 Stars & Up']")
	WebElement oneStar;
	public SelectByStarRating(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void selectFourStarRating() {
		fourStar.click();
	}
	public void selectThreeStarRating() {
		threeStar.click();
	}
	public void selectTwoStarRating() {
		twoStar.click();
	}
	public void selectOneStarRating() {
		oneStar.click();
	}
	/*public xyzpage clickOnStartRating(String rating) {
	driver.findElement(By.xpath("//span[text()='+rating+']")).click();
	return new xyzPage(driver);
	}*/
}
