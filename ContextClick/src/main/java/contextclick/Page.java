package contextclick;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Common functionalities of ContextClick page.
 */
public class Page {
	/**
	 * Web Driver object.
	 */
	WebDriver driver;
	/**
	 * array of options to be selected.
	 */
	String actionSequence[] = new String[]{"Edit","Cut","Copy","Paste","Delete","Quit"};
	/**
	 * xpath of right click button.
	 */
	@FindBy(xpath = "//span[@class = 'context-menu-one btn btn-neutral']")
	WebElement rightClick;
	/**
	 * variable to iterate over options available.
	 */
	static int number = 0;
	/**
	 * Page constructor to initialize the page elements.
	 * @param driver
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * performs the context click.
	 * when alert is popped up then confirm button is pressed
	 */
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
