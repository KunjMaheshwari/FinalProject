package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.UsedCarsPage;
import testBase.BaseClass;

import java.util.List;

public class TC005_UsedCarsTest extends BaseClass {
    @Test(priority=0)
    public void clickUsedCar(){
        HomePage hp=new HomePage(driver);
        hp.hoverOverMoreMenu();
        hp.clickUsedCarsLink();
    }
    @Test(dependsOnMethods = {"clickUsedCar"})
    public void verifyClickCity(){
        UsedCarsPage uc = new UsedCarsPage(driver);
        uc.clickCity();
    }
    @Test(dependsOnMethods = {"verifyClickCity"})
    public void getPopularModels(){
        UsedCarsPage uc = new UsedCarsPage(driver);
        uc.list_popularModel();
    }




}
