package pages;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Home page.
 */
public class HomePage extends Page {
	/**
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "nav-link-yourAccount")
	WebElement signin;
	
	public LoginPage clickSignin() {
		signin.click();
		return new LoginPage(driver);
	}
	
}
