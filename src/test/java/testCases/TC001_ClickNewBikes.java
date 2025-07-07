package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_ClickNewBikes extends BaseClass{
	
	@Test
	public void nav_new_bikes()
	{
		logger.info("Starting TC001_ClickNewBikes");
		logger.debug("This is a debug log message");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickNewBike();
		}
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("Finished TC001_ClickNewBikes");
		}
	}

}