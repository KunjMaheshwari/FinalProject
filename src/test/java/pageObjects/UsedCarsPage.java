package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
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
	@FindBy(xpath= "//a[@data-url='chennai']")
	WebElement ucp_ChennaiOption;

	//@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	@FindBy(xpath = "//ul[contains(@class, 'usedCarMakeModelList')]/li/label")
	List<WebElement> ucp_PopularModelList;

	@FindBy(xpath ="//a[@title='Home']")
	WebElement ucp_MainPage;
	
	//Action Methods
	public void clickCity(){
		ucp_ChennaiOption.click();
	}
	public void list_popularModel() throws IOException {
		List<String> carNames = new ArrayList<>();
		for(int i=0;i<ucp_PopularModelList.size();i++){
			carNames.add(ucp_PopularModelList.get(i).getText());
		}
		String filePath = System.getProperty("user.dir") + "/test-output/PopularCarModels.xlsx";
		ExcelUtility.writeOrUpdateCarDataToExcel(filePath, carNames);
		System.out.println("Excel file written successfully for popular model: " + filePath);
	}
	public void return_MainPage(){
		ucp_MainPage.click();
	}
}
