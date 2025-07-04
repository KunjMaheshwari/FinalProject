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
	
	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}

    @FindBy(xpath="//a[text()='NEW BIKES']")
    WebElement NewBikes;

    @FindBy(xpath="//div[@class='gsc_ta_scroll']//ul//li[4]")
    WebElement Upcoming_Bikes;

    @FindBy(xpath="//div[@class='txt-c pt-15 clr']//a[@href='/upcoming-bikes']")
    WebElement All_Upcoming_Bikes;

    @FindBy(xpath="//a[text()='Honda']")
    WebElement Honda_Bikes;

    @FindBy(xpath="//a[@data-track-label='model-name']")
    List<WebElement>All_Honda_Models;

    @FindBy(xpath="//div[@class='b fnt-15']")
    List<WebElement>All_Bike_Prices;

    @FindBy(xpath="//div[@class='clr-try fnt-14']")
    List<WebElement>Expected_Dates;


    public void click_NewBikes(){
        NewBikes.click();
    }
    
    public void click_UpcomingBikes() {
    	Upcoming_Bikes.click();
    }
    
    public void click_All_UpcomingBikes() {
    	All_Upcoming_Bikes.click();
    }
    
    public void click_Honda() {
    	Honda_Bikes.click();
    }
    
    public void Bike_Models(){
    	for(WebElement bike:All_Honda_Models) {
    		System.out.println(bike.getText());
    	}
    }
    
    public void  Lauch_Dates(){
    	for(WebElement date:Expected_Dates) {
    		System.out.println(date.getText());
    	}
    }
    
    public double extract_price(String priceText) {
    	priceText = priceText.replace("Rs.", "").trim();

		if (priceText.contains("Lakh")) {
			priceText = priceText.replace("Lakh", "").trim();
			return Double.parseDouble(priceText) * 100000;
		} else {
			return Double.parseDouble(priceText.replace(",", ""));
		}
    }
   
    public List<String> BikeNames_Under_Price(){
    	List<String> bikenames = new ArrayList<>();
    	for(int i=0;i<All_Honda_Models.size();i++) {
    		double price = extract_price(All_Bike_Prices.get(i).getText());
    		
    		if(price < 400000) {
    			bikenames.add(All_Honda_Models.get(i).getText());
    		}
    	}
    	return bikenames;
    }
    
    public List<String> BikePrices_Under_Price(){
    	List<String> prices = new ArrayList<>();
    	for(int i=0;i<All_Bike_Prices.size();i++) {
    	double price = extract_price(All_Bike_Prices.get(i).getText());
    		
    		if(price < 400000) {
    			prices.add("₹ " + price);
    		}
    	}
    	return prices;
    	}
    
    public List<String> getAffordableBikeLaunchDates() {
		List<String> dates = new ArrayList<>();
		for (int i = 0; i < Expected_Dates.size(); i++) {
			double price = extract_price(All_Bike_Prices.get(i).getText());
			if (price < 400000) {
				dates.add(Expected_Dates.get(i).getText());
			}
		}
		return dates;
	}
   
    }
   

