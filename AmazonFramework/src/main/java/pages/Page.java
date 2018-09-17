package pages;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * basic functions of the amazon web page.
 */
public class Page {
	/**
	 * web browser driver object.
	 */
	WebDriver driver;
	/**
	 * search box element by xpath.
	 */
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	/**
	 * hover button element.
	 */
	@FindBy(id = "nav-link-shopall")
	WebElement hoverOverCategory;
	/**
	 * books element.
	 */
	@FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[15]/span")
	WebElement books;
	/**
	 * xpath for specific book in selenium.
	 */
	@FindBy(xpath = "//h2[text() = 'Selenium Testing Tools Cookbook -']")
	WebElement seleniumTestingToolsCookBook;
	/**
	 * All books web element.
	 */
	@FindBy(xpath = "//span[text()='All Books']")
	WebElement allBooks;
	/**
	 * page constructor that initializes the web elements.
	 * @param driver
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * title of the web page.
	 * @return the title of current web page.
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	/**
	 * search option in amazon site.
	 * @param searchContent content to be searched on amazon site.
	 */
	public void search(String searchContent) {
		searchBox.sendKeys(searchContent);
		searchBox.submit();
	}
	/**
	 * moves to the hover web element.
	 */
	public void hoverOverShopByCategory() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverOverCategory).build().perform();
	}
	/**
	 * select the specific book in the desired category.
	 */
	public void selectBooks() {
		hoverOverShopByCategory();
		books.click();
	}
	/**
	 * select the specific book in the selenium books.
	 */
	public void selectSeleniumTestingToolsCookBook() {
		seleniumTestingToolsCookBook.click();
	}
	/**
	 * select all books form the hovered category.
	 */
	public void selectAllBooks() {
		allBooks.click();
	}
}


