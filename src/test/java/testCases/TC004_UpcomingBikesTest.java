package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UpcomingBikesPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC004_UpcomingBikesTest extends BaseClass {
	
	@Test(priority=0)
	public void clickNewBikesSection() {
		HomePage hp=new HomePage(driver);
		hp.clickNewBike();
	}

	@Test(priority=1)
	public void verifyClickAllBikes(){
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.clickUpcoming();
		ubp.clickUpcomingBikes();
	}

	@Test(priority=2)
	public void scrollAndClickHonda() throws InterruptedException {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.clickHonda();
	}

	@Test(priority=3)
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
