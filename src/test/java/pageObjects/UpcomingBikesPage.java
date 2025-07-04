package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(xpath = "//a[text()='NEW BIKES']")
	WebElement txtUpcoming;

	@FindBy(xpath = "//a[@class='lnk-c' and @title='All Upcoming Bikes']")
	WebElement txtAllUpcomingBikes;

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
		txtAllUpcomingBikes.click();
	}

	public void clickHonda() {
		txtHonda.click();
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
