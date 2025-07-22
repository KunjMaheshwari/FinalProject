package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/*
 * 1. Handle google button 
 * 2. Switching to google login window
 * 3. Entering the invalid credentials
 * 4. Capturing the error messages
 * 5. Switching back to the main (parent) window.
 */

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// locating Elements

	@FindBy(xpath = "//*[@type='email']")
	WebElement email;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;

	// Actions

	public void setEmail(String Email) {
		Actions action = new Actions(driver);
		email.sendKeys(Email);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}

	public void setPassword(String Password) {
		Actions action = new Actions(driver);
		password.sendKeys(Password);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}
}