package test;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.CartPage;
import pages.FontPage;
import pages.LoginPage;
import pages.NavbarPage;
import pages.ProductPage;
import pages.SignupPage;

public class UiAndUxTest extends Projectspecificmethods {
	
private static final Logger logger = LogManager.getLogger(UiAndUxTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="UI and UX functionality Test";
		testdescription="test to check the UI and UX funtonality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
				
		}
	
	@Test
	public void verifyProductAlignment() {

		NavbarPage nb = new NavbarPage(driver);

	    List<WebElement> products = nb.getProductCards();

	    for (int i = 0; i < products.size() - 1; i++) {

	        Point p1 = products.get(i).getLocation();
	        Point p2 = products.get(i + 1).getLocation();

	        logger.info("Product " + i + " position: " + p1);
	        logger.info("Product " + (i + 1) + " position: " + p2);

	        logger.info("Checking if alignment is consistent");
	        Assert.assertTrue(Math.abs(p1.getY() - p2.getY()) < 10,"Products are misaligned");
	    }
	}

	@Test
	public void actionbutn() {
		
		ProductPage pp=new ProductPage(driver);
		LoginPage lp=new LoginPage(driver);
		SignupPage sp=new SignupPage(driver);
		CartPage cp=new CartPage(driver);
		
		Assert.assertTrue(lp.loginbutn().isDisplayed());
		Assert.assertTrue(lp.loginbutn().isEnabled());
		 logger.info("Login button is visible and clickable");
		 
		 
		 Assert.assertTrue(sp.signupbutn().isDisplayed());
		 Assert.assertTrue(sp.signupbutn().isEnabled());
		 logger.info("Signup button is visible and clickable");
		 
		 pp.clickFirstProduct();
		 
		// wait.until(ExpectedConditions.visibilityOf(cp.addtocarlbutn()));
		 
		 Assert.assertTrue(cp.clickAddCart().isDisplayed());
		 Assert.assertTrue(cp.clickAddCart().isEnabled());
		 
		  logger.info("Add to Cart button is visible and clickable");
		 
	}
	
	
	@Test
	public void verifyFontConsistency() {

	    FontPage fp = new FontPage(driver);

	    WebElement homeTitle = fp.getHomeProductTitle();

	    String homeFont = fp.getFontFamily(homeTitle);
	    String homeSize = fp.getFontSize(homeTitle);

	    logger.info("Home font family: " + homeFont);
	    logger.info("Home font size: " + homeSize);

	    fp.clickFirstProduct();

	    WebElement productTitle = fp.getProductName();

	    String productFont = fp.getFontFamily(productTitle);
	    String productSize = fp.getFontSize(productTitle);

	    logger.info("Product page font family: " + productFont);
	    logger.info("Product page font size: " + productSize);

	    Assert.assertEquals(homeFont, productFont);
	    Assert.assertEquals(homeSize, productSize);
	}
	
	@Test
	public void verifyAlertPopup() {

		ProductPage pp = new ProductPage(driver);
		CartPage cp=new CartPage(driver);
		
		

	    pp.clickFirstProduct();
	    logger.info("Product page opened");

	    cp.clickAddToCart();
	    logger.info("Add to cart clicked");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();

	    String alertMessage = alert.getText();

	    logger.info("Alert message: " + alertMessage);

	    Assert.assertTrue(alertMessage.length() > 0);

	    alert.accept();
	}
	
	@Test
	public void verifyHorizontalScrolling() {

	    logger.info("Simulate mobile screen"); 
	    driver.manage().window().setSize(new Dimension(375, 812));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    long pageWidth = (Long) js.executeScript("return document.body.scrollWidth");
	    long windowWidth = (Long) js.executeScript("return window.innerWidth");

	    logger.info("Page width: " + pageWidth);
	    logger.info("Window width: " + windowWidth);

	    Assert.assertTrue(pageWidth <= windowWidth,
	            "Horizontal scrolling detected");
	}




}
