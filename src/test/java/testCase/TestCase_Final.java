package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UpcomingBikesPage;
import pageObjects.UsedCarsPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;
import utilities.ScreenShot;

public class TestCase_Final extends BaseClass {


	@Test(priority = 0)
	public void nav_new_bikes() {
		logger.info("******* Starting the Test Cases  ***********");
		logger.info("Test Case 1 started.");
		logger.info("Clicking on the New Bikes Section.");
		
		HomePage hp = new HomePage(driver);
		hp.clickNewBike();
		
		logger.info("Test Case 1 completed.");
	}

	@Test(priority = 1)
	public void verify_clicking_AllBikes() throws InterruptedException {
		
		logger.info("Test Case 2 started.");
		
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		ubp.click_NewBikes();
		ubp.click_UpcomingBikes();

		ubp.click_All_UpcomingBikes();
		Thread.sleep(3000);
		
		logger.info("Test Case 2 completed.");
	}

	@Test(priority = 2)
	public void scrollAndClickHonda() throws InterruptedException {
		
		logger.info("Test Case 3 started.");
		
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		ubp.click_Honda();
		Thread.sleep(3000);
		
		logger.info("Test Case 3 completed.");
	}

	@Test(priority = 3)
	public void writeAffordableBikesToExcel() throws IOException {
		
		logger.info("Test Case 4 started.");
		
		UpcomingBikesPage ubp = new UpcomingBikesPage(driver);
		
		List<String> names = ubp.BikeNames_Under_Price();
		List<String> prices = ubp.BikePrices_Under_Price();
		List<String> launchDates = ubp.getAffordableBikeLaunchDates();
		
		String filePath = System.getProperty("user.dir") + "/test-output/UpcomingHondaBikes.xlsx";
		ExcelUtility.writeBikeDataToExcel(filePath, names, prices, launchDates);
		System.out.println("Excel file written successfully to: " + filePath);
		
		logger.info("Test Case 4 completed.");
	}

	@Test(priority = 4)
	public void clickUsedCar() {
		
		logger.info("Test Case 5 started.");
		
		HomePage hp = new HomePage(driver);
		hp.hoverOverMoreMenu();
		hp.clickUsedCarsLink();
		
		logger.info("Test Case 5 completed.");
	}

	@Test(dependsOnMethods = { "clickUsedCar" })
	public void verifyClickCity() {
		
		logger.info("Test Case 6 started.");
		
		UsedCarsPage uc = new UsedCarsPage(driver);
		uc.clickCity();
		
		logger.info("Test Case 6 completed.");
	}

	@Test(dependsOnMethods = { "verifyClickCity" })
	public void getPopularModels() throws IOException {
		
		logger.info("Test Case 7 started.");
		
		UsedCarsPage uc = new UsedCarsPage(driver);
		uc.list_popularModel();
		
		logger.info("Test Case 7 completed.");
	}

	@Test(dependsOnMethods = { "getPopularModels" })
	public void return_ZigWheel() {
		
		logger.info("Test Case 8 started.");
		
		UsedCarsPage uc = new UsedCarsPage(driver);
		uc.return_MainPage();
		
		logger.info("Test Case 8 completed.");
	}

	public static int screenShotCounter = 0;

	@Test(priority = 5, dataProvider = "dp", dataProviderClass = utilities.DataProviders.class)
	public void loginTest(String rowNum, String email, String pass) {
		
		logger.info("Test Case 9 started.");
		
		driver.get("https://www.zigwheels.com/");
		driver.findElement(By.id("des_lIcon")).click();
		driver.findElement(By.cssSelector(".lgn-sc.c-p.txt-l.pl-30.pr-30.googleSignIn")).click();
		
		int roeNum = Integer.parseInt(rowNum);
		
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<>(set);
		System.out.println(list);
		
		driver.switchTo().window(list.get(list.size() - 1));

		LoginPage lp = new LoginPage(driver);
		checkEmail(lp, email, roeNum);
		checkPassword(lp, pass, roeNum);
		
		driver.switchTo().window(list.get(0));
		
		logger.info("Test Case 9 completed.");
	}
	
	public void checkEmail(LoginPage lp, String email, int rowNum) {
		
		logger.info("Test Case 10 started.");
		
		try {
			String error = "";
			lp.setEmail(email);
			error = driver.findElement(By.xpath("//*[@id='i8']/div")).getText();
			System.out.println(error);
			if (email.isEmpty() || email.length() == 0) {
				Assert.assertEquals(error, "Enter an email or phone number");
				DataProviders.setCellData("passed", rowNum, 3);
			} else {
				Assert.assertEquals(error, "Couldn’t find your Google Account");
				DataProviders.setCellData("passed", rowNum, 3);
			}
			ScreenShot.takeElementScreenshot(driver,
					System.getProperty("user.dir") + "/src/test/resources/screenshot" + screenShotCounter + ".png");
			screenShotCounter++;

		} catch (Exception e) {
			// System.out.println("Email is correct.");
		}
		
		logger.info("Test Case 10 completed.");
	}


	public void checkPassword(LoginPage lp, String pass, int rowNum) {
		
		logger.info("Test Case 11 completed.");
		
		try {
			String error = "";
			lp.setPassword(pass);
			error = driver.findElement(By.xpath("//*[@id='c0']/div[2]")).getText();
			System.out.println(error);
			if (pass.isEmpty() || pass.length() == 0) {
				Assert.assertEquals(error, "Enter a password.");
				DataProviders.setCellData("passed", rowNum, 3);
			} else {
				Assert.assertEquals(error, "Wrong password. Try again or click Forgot password to reset it.");
				DataProviders.setCellData("passed", rowNum, 3);
			}
			ScreenShot.takeElementScreenshot(driver,
					System.getProperty("user.dir") + "/src/test/resources/screenshot" + screenShotCounter + ".png");
			screenShotCounter++;
		} catch (Exception e) {
			// System.out.println("Password is correct.");
		}
		
		logger.info("Test Case 11 completed.");
		logger.info("******* Ending the Test Cases  ***********");
	}

}
