package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_UsedCars extends BaseClass{
	
	@Test(priority=1)
	public void nav_more()
	{
		try
		{
		HomePage hp=new HomePage(driver);
		hp.navigateToUsedCars();
		driver.findElement(By.linkText("Chennai")).click();
		
		}
		catch (Exception e)
		{
			//logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		//logger.info("Finished TC001_ClickNewBikes");
		}
	}
	
	@Test(priority=2)
	public void usedCars_Displayed()
	{
		if(driver.findElement(By.linkText("Used Cars")).isDisplayed())
		{
			Assert.assertTrue(true, "Used Cars are displayed");
		}
		else
		{
			Assert.fail("Used Cars not Displayed");
		}
	}
}