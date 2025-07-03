package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * 1. Filter the location. 
 * 2. Extract the popular car models and store in a list.
 */

public class UsedCarsPage {
	WebDriver driver;
	
	//Constructor
	public UsedCarsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='gs_input5']")
	WebElement ucp_SearchBox;
	
	@FindBy(xpath="//*[@id=\"ui-id-16\"]")
	WebElement ucp_CityResultOption;
	
	@FindBy(xpath="//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//li//label")
	List<WebElement> ucp_PopularModelList;
	
	//Action Methods
	public void enterCity(String city) {
		ucp_SearchBox.sendKeys(city);
	}
	
	public void selectCity() {
		ucp_CityResultOption.click();
	}
}
