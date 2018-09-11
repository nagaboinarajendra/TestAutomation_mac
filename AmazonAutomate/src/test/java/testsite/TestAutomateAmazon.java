package testsite;
/**
 * @author Rajendra_nagaboina
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProfilePage;
import com.amazon.pages.SelectByStarRating;
/**
 * Test the amazon website.
 */
public class TestAutomateAmazon {
	/**
	 * web browser object.
	 */
	WebDriver driver;
	HomePage home;
	LoginPage loginPage;
	ProfilePage profilePage;
	/**
	 * configure the web browser driver.
	 */
	@BeforeClass
	public void setProperties() {
		 System.setProperty("webdriver.chrome.driver","/Users/rajendra/Desktop/TestAutomation/drivers/chromedriver");
		 driver = new ChromeDriver();
		 home = new HomePage(driver);
	}
	/**
	 * launching the amazon website.
	 */
	@Test(description = "Launches the Amazon site", priority=1)
	public void launchSite(){
		driver.get("https://www.amazon.in/");
		assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",home.getTitle());
	}
	/**
	 * login to amazon website.
	 */
	@Test(description = "Login to amazon website", priority=2)
	public void logIn() {
		loginPage = home.clickSignin();
		assertEquals("Amazon Sign In",home.getTitle());
		profilePage = loginPage.login("nagabhoinarajendra@gmail.com", "Radgjmptw96*");
		assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",home.getTitle());
	}
	/**
	 * select the all books for the category.
	 */
	@Test(description = "selecting allbooks from books menu", priority=3)
	public void selectAllBooks() {
		profilePage.selectBooks();
		profilePage.selectAllBooks();
		assertEquals("Books",driver.findElement(By.xpath("//span[@class = 'nav-search-label']")).getText());
	}
	/**
	 * search for the book selenium with java
	 */
	@Test(description = "searching for 'selenium with java' books", priority=4)
	public void searchForBook() {
		profilePage.search("Selenium with java");
	}
	/**
	 * select the books with 4 star rating.
	 */
	@Test(description = "selecting 4 star rated books",priority = 5)
	public void selectFourStarRating() {
		SelectByStarRating fourStar = new SelectByStarRating(driver);
		fourStar.selectFourStarRating();
	}
	/**
	 * select selenium testing tools cook book from menu.
	 */
	@Test(description = " select selenium Testing Tools Cook Book", priority = 6)
	public void selectBook() {
		assertEquals("Amazon.in: Selenium with java: Books", home.getTitle());
	}
	/**
	 * click seemore and seeless
	 */
	@Test(description = " clicking seeMore and seeLess", priority = 7)
	public void clickSeeMoreAndSeeLess() {
		profilePage.clickSeeMore();
		profilePage.clickSeeLess();
	}
	/**
	 * choose the filter paperback.
	 */
	@Test(description ="choose paperback", priority = 8)
	public void choosePaperBack() {
		profilePage.choosePaperBack();
	}
	/**
	 * check for filter with required content.
	 */
	@Test(description = "checking for selenium iwth java in filter", priority = 9)
	public void checkFilter() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.id("editableBreadcrumbContent")));
		String actualString = driver.findElement(By.id("editableBreadcrumbContent")).getText();
		assertTrue(actualString.contains("Selenium with java"));

	}
}
