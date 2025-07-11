package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"headerNewVNavWrap\"]/nav/ul/li[3]/a")
    private WebElement newBike;

    @FindBy(xpath = "//ul[@class='h-d-nav fnt-14 pl-0 txt-c b ']//li[5]")
    private WebElement moreMenu;

    @FindBy(xpath = "//ul[@class='h-d-nav fnt-14 pl-0 txt-c b ']//li[5]/ul/li[1]/a")
    private WebElement usedCarsLink;

    public void clickNewBike() {
        newBike.click();
    }

    public void hoverOverMoreMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenu).perform();
    }

    public void clickUsedCarsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usedCarsLink)).click();
    }

    public void navigateToUsedCars() {
        hoverOverMoreMenu();
        clickUsedCarsLink();
    }
}