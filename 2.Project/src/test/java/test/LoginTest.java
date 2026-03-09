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
import pages.LoginPage;

public class LoginTest extends Projectspecificmethods{
	
private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Login Test";
		testdescription="Testing the login up functionality with valid and invalid details";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	@Test(dataProvider = "xllogin")
	public void loginValidation(String username,String password,String Testtype,String Expected) {

	    LoginPage lp = new LoginPage(driver);
	    
	    lp.validlogin(username, password);

	    logger.info("Login test started with TestType: " + Testtype);

	   

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    if (Testtype.equalsIgnoreCase("Validinput")) {

	    
	        String welcomeText = lp.getWelcomeText();
	        Assert.assertTrue(welcomeText.contains(username));
	        logger.info("PASS: Valid login successful");

	    } else if (Testtype.equalsIgnoreCase("Invalidinput") ||
	               Testtype.equalsIgnoreCase("Emptyfields") ||
	               Testtype.equalsIgnoreCase("Invalidusername")) {

	      
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();

	        logger.info("Alert message displayed: " + alertText);

	        Assert.assertEquals(alertText, Expected);
	        alert.accept();

	        logger.info("PASS: Alert validated successfully");

	    } else if (Testtype.equalsIgnoreCase("Passwordmask")) {

	       
	        String fieldType = lp.getPasswordFieldType();
	        Assert.assertEquals(fieldType, "password");
	        logger.info("PASS: Password field is masked correctly");

	    } else {

	        Assert.fail("Unknown TestType: " + Testtype);
	    }
	}

}
