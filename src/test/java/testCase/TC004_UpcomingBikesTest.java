package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.UpcomingBikesPage;
import testBase.BaseClass;

public class TC004_UpcomingBikesTest extends BaseClass {
	
	@Test
	public void verify_clicking_AllBikes() {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.click_NewBikes();
		ubp.click_All_UpcomingBikes();
		
	}
	
	@Test
	public void scrollAndClickHonda() {
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		ubp.click_Honda();
	}
	
	
	
}
