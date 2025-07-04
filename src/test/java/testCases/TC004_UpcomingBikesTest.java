package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.UpcomingBikesPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC004_UpcomingBikesTest extends BaseClass {

	@Test
	public void verifyClickAllBikes() {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.clickUpcoming();
		ubp.clickUpcomingBikes();
	}

	@Test
	public void scrollAndClickHonda() {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		ubp.clickHonda();
	}

	@Test
	public void writeAffordableBikesToExcel() throws IOException {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		List<String> names = ubp.getAffordableBikeNames();
		List<String> prices = ubp.getAffordableBikePrices();
		List<String> launchDates = ubp.getAffordableBikeLaunchDates();
		String filePath = System.getProperty("user.dir") + "/test-output/UpcomingHondaBikes.xlsx";
		ExcelUtility.writeBikeDataToExcel(filePath, names, prices, launchDates);
		System.out.println("Excel file written successfully to: " + filePath);
	}

}
