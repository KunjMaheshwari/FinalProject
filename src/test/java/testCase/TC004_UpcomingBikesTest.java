package testCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.UpcomingBikesPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC004_UpcomingBikesTest extends BaseClass {
	
	@Test(priority=1)
	public void verify_clicking_AllBikes() throws InterruptedException {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.click_NewBikes();
		ubp.click_UpcomingBikes();
		
		ubp.click_All_UpcomingBikes();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void scrollAndClickHonda() throws InterruptedException {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		ubp.click_Honda();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void writeAffordableBikesToExcel() throws IOException {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		List<String> names = ubp.BikeNames_Under_Price();
		List<String> prices = ubp.BikePrices_Under_Price();
		List<String> launchDates = ubp.getAffordableBikeLaunchDates();
		String filePath = System.getProperty("user.dir") + "/test-output/UpcomingHondaBikes.xlsx";
		ExcelUtility.writeBikeDataToExcel(filePath, names, prices, launchDates);
		System.out.println("Excel file written successfully to: " + filePath);
	}
	
	
	
}
