package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath= "//span[@class='c-p icon-down-arrow']")
	WebElement more_option;

	@FindBy(xpath= "//a[@data-track-label='nav-used-car']")
	WebElement car_option;
	@FindBy(xpath= "//a[@data-url='chennai']")
	WebElement chennai_option;

//	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	@FindBy(xpath = "//ul[contains(@class, 'usedCarMakeModelList')]/li/label")
	List<WebElement> popularModelList;

	@FindBy(xpath="//input[@id='gs_input5']")
	WebElement city_searchBox;
	
	@FindBy(xpath="//*[@id='ui-id-16']")
	WebElement ucp_CityResultOption;
	
	//Action Methods
	public void hoverMore(){
		Actions actions = new Actions(driver);
		actions.moveToElement(more_option).perform();
	}
	public void click_carOption(){
		car_option.click();
	}
	public void clickCity(){
		chennai_option.click();
	}
	public void list_popularModel(){
		List<String> carNames = new ArrayList<>();
		for(int i=0;i<popularModelList.size();i++){
			carNames.add(popularModelList.get(i).getText());
		}
		//Printing in console for check
		for(int i=0;i<popularModelList.size();i++){
			System.out.println(carNames.get(i));
		}

	}

	public void enterCity(String city) {
		city_searchBox.sendKeys(city);
	}
	
	public void selectCity() {
		ucp_CityResultOption.click();
	}
}
