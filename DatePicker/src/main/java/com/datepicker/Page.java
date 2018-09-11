package com.datepicker;
/**
 * @author Rajendra_nagaboina
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Basic functionality of Date picker Home page.
 */
public class Page {
	/**
	 * Web Browser driver object.
	 */
	WebDriver driver;
	/**
	 * path for text box with date.
	 */
	@FindBy(xpath = "//*[@id='example-0']/div/div/div/div/div/input")
	WebElement picker;
	/**
	 * path for previous month button.
	 */
	@FindBy(xpath = "//*[@id = 'example-0']//*[@class = 'react-datepicker__navigation react-datepicker__navigation--previous']")
	private WebElement previousMonth;
	/**
	 * path for next month button.
	 */
	@FindBy(xpath = "//*[@id = 'example-0']//*[@class = 'react-datepicker__navigation react-datepicker__navigation--next']")
	private WebElement nextMonth;
	/**
	 * Page constructor that initializes elements in page.
	 * @param driver of browser
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * Clicks on the date provided.
	 * @param requestedDate date that uses wants to navigate
	 */
	public void datePicker(String requestedDate) {
		picker.click();
		String currentDate = picker.getAttribute("value");
		int currentMonth = Integer.parseInt(currentDate.substring(0, 2));
		int currentYear = Integer.parseInt(currentDate.substring(6));
		int requestedMonth = Integer.parseInt(requestedDate.substring(0, 2));
		int requestedYear = Integer.parseInt(requestedDate.substring(6));
		int yearClicks = (requestedYear - currentYear);
		int monthClicks = (requestedMonth - currentMonth);
		int requestedDay = Integer.parseInt(requestedDate.substring(3, 5));
		clickYears(yearClicks,monthClicks,requestedDay);
	}
	/**
	 * navigates to the requested year.
	 * @param yearClicks difference in current and requested years
	 * @param monthClicks difference in current and requested Months
	 * @param day that is requested
	 */
	private void clickYears(int yearClicks,int monthClicks, int day) {
		if(yearClicks >= 0) {
			int clicks = yearClicks * 12;
			while(clicks != 0) {
				nextMonth.click();
				clicks--;
			}
			clickMonths(monthClicks,day);
		} else {
			int clicks = yearClicks * 12;
			while(clicks != 0) {
				previousMonth.click();
				clicks++;
			}
			clickMonths(monthClicks,day);
		}
	}
	/**
	 * Navigates to the current month.
	 * @param monthClicks difference in current and requested Months
	 * @param day that is requested
	 */
	private void clickMonths(int monthClicks, int day) {
		if(monthClicks >= 0) {
			while(monthClicks != 0) {
				nextMonth.click();
				monthClicks--;
			}
			clickDate(day);
		} else {
			while(monthClicks != 0) {
				previousMonth.click();
				monthClicks++;
			}
			clickDate(day);
		}
	}
	/**
	 * clicks on requested date.
	 * @param day requested day by user
	 */
	private void clickDate(int day) {
		WebElement date = driver.findElement(By.xpath("//*[@id='example-0']/div/div/div/div/div/div/div/div/div[text() = '"+day+"']"));
		date.click();
	}
}
