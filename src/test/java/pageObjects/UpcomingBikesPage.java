package pageObjects;

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

public class UpcomingBikesPage extends BasePage{
	
	// Constructor
	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}
	
	// Actions 
	@FindBy(xpath="//ul[@class='tabbing-list tajax_1']//li[4]")
	WebElement txtUpcoming;
	
	@FindBy(xpath="//a[@class='lnk-c' and @title='All Upcoming Bikes']")
	WebElement txtAllUpcomingBikes;
	
	@FindBy(xpath="//a[text()='Honda']")
	WebElement txtHonda;
	
	@FindBy(xpath="//ul[@id='modelList']//a//strong")
	List<WebElement> listBikeNames;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> listExpectedLaunch;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
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
	
	
	
	
}
