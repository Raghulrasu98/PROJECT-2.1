package test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.SignupPage;

public class SignupTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(SignupTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="signup Test";
		testdescription="Testing the signup functionality with valid and invalid details";
		testcategory="Smoke Testing";
		testauthour="Raghul";
		
		}
	
	@Test(dataProvider="xlsignup")
	public void signupValidation(String username,
	                             String password,
	                             String TestType,
	                             String Expected) {

	    SignupPage sp = new SignupPage(driver);

	    logger.info("Starting signup test: " + TestType);

	    sp.signup();
	    sp.username(username);
	    sp.password(password);
	    sp.signupbutton();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    String alertText = alert.getText();

	    logger.info("Alert message: " + alertText);

	    if(TestType.equalsIgnoreCase("ValidSignup")) {

	        Assert.assertEquals(alertText, Expected);
	        logger.info("PASS: Valid signup successful");

	    } else if(TestType.equalsIgnoreCase("ExistingUser")) {

	        Assert.assertEquals(alertText, Expected);
	        logger.info("PASS: Existing user validation successful");

	    } else if(TestType.equalsIgnoreCase("EmptyFields")) {

	        Assert.assertEquals(alertText, Expected);
	        logger.info("PASS: Empty field validation successful");

	    } else {
	        Assert.fail("Unknown TestType");
	    }

	    alert.accept();
	}

}
