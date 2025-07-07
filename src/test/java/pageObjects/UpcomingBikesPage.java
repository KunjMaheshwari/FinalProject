package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 1. Upcoming new Bikes
 * 2. Filter by manufacture HONDA
 * 3. Get the Prices. 
 * 4. Extract the bike name, price and expected Launch date.
 */

public class UpcomingBikesPage extends BasePage {

	// Constructor
	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}

	// Actions
	@FindBy(xpath = "//div[@class='gsc_ta_scroll']//li[4]")
	WebElement txtUpcoming;

//	@FindBy(linkText="All Upcoming Bikes")
//	private WebElement txtAllUpcomingBikes;
	
	@FindBy(xpath="//a[@title='All Upcoming Bikes']")
	private WebElement txtAllUpcomingBikes;

	@FindBy(xpath = "//a[text()='Honda']")
	WebElement txtHonda;

	@FindBy(xpath = "//ul[@id='modelList']//a//strong")
	List<WebElement> listBikeNames;

	@FindBy(xpath = "//div[@class='clr-try fnt-14']")
	List<WebElement> listExpectedLaunch;

	@FindBy(xpath = "//div[@class='b fnt-15']")
	List<WebElement> listBikePrices;

	// Methods
	public void clickUpcoming() {
		txtUpcoming.click();
	}

	public void clickUpcomingBikes() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the element is visible and clickable
	    wait.until(ExpectedConditions.elementToBeClickable(txtAllUpcomingBikes));

	    // Scroll into view and click using JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtAllUpcomingBikes);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txtAllUpcomingBikes);
	}


	public void clickHonda() throws InterruptedException {
		Thread.sleep(2000);
        WebElement hondaLink = txtHonda;
 
        // Scroll the page to bring Honda link into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hondaLink);
        Thread.sleep(1000); // Brief pause after scrolling
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hondaLink);
	}


	public void printBikesName() {
		for (WebElement bike : listBikeNames) {
			System.out.println(bike.getText());
		}
	}

	public void printExpectedLaunchDate() {
		for (WebElement launchDate : listExpectedLaunch) {
			System.out.println(launchDate.getText());
		}
	}

	public double extractPrice(String priceText) {
		priceText = priceText.replace("Rs.", "").trim();

		if (priceText.contains("Lakh")) {
			priceText = priceText.replace("Lakh", "").trim();
			return Double.parseDouble(priceText) * 100000;
		} else {
			return Double.parseDouble(priceText.replace(",", ""));
		}
	}

	public List<String> getAffordableBikeNames() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < listBikeNames.size(); i++) {
			double price = extractPrice(listBikePrices.get(i).getText());
			if (price < 400000) {
				names.add(listBikeNames.get(i).getText());
			}
		}
		return names;
	}

	public List<String> getAffordableBikePrices() {
		List<String> prices = new ArrayList<>();
		for (int i = 0; i < listBikePrices.size(); i++) {
			double price = extractPrice(listBikePrices.get(i).getText());
			if (price < 400000) {
				prices.add("₹" + price);
			}
		}
		return prices;
	}

	public List<String> getAffordableBikeLaunchDates() {
		List<String> dates = new ArrayList<>();
		for (int i = 0; i < listExpectedLaunch.size(); i++) {
			double price = extractPrice(listBikePrices.get(i).getText());
			if (price < 400000) {
				dates.add(listExpectedLaunch.get(i).getText());
			}
		}
		return dates;
	}

}
