package testCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC003_Login extends BaseClass{
	
	@Test(dataProvider="dp",dataProviderClass = utilities.DataProviders.class)
	public void loginTest(String email,String pass) throws InterruptedException {
		  driver.get("https://www.zigwheels.com/");
		  driver.findElement(By.id("des_lIcon")).click();
		  driver.findElement(By.cssSelector(".lgn-sc.c-p.txt-l.pl-30.pr-30.googleSignIn")).click();
		  
		  Set<String>set = driver.getWindowHandles();
		  List<String>list = new ArrayList<>(set);
		  System.out.println(list);
		  driver.switchTo().window(list.get(list.size()-1));
		
		  LoginPage lp = new LoginPage(driver);
		 // String email = "ujjwal.bodkhe@gmail.com";
		  checkEmail(lp,email);
		  //String pass="";
		  checkPassword(lp,pass);
		  driver.switchTo().window(list.get(0));
		  
	}
	
	
	
	public void checkEmail(LoginPage lp,String email) {
		try {
			String error = "";
			lp.setEmail(email);
			error = driver.findElement(By.xpath("//*[@id='i8']/div")).getText();
			System.out.println(error);
			if(email.isEmpty()|| email.length()==0) {
				Assert.assertEquals(error,"Enter an email or phone number");
			}else {
				Assert.assertEquals(error,"Couldn’t find your Google Account");
			}
			
			}catch(Exception e) {
				System.out.println("Email is correct.");
			}
	}
	
	public void checkPassword(LoginPage lp,String pass) {
		try {
			String error = "";
			lp.setPassword(pass);
			error = driver.findElement(By.xpath("//*[@id='c0']/div[2]")).getText();
			System.out.println(error);
			if(pass.isEmpty()|| pass.length()==0) {
				Assert.assertEquals(error,"Enter a password.");
			}else {
				Assert.assertEquals(error,"Wrong password. Try again or click Forgot password to reset it.");
			}
			}catch(Exception e) {
				System.out.println("Password is correct.");
			}
	}
}
