package test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.CartPage;
import pages.LoginPage;

public class CartFunctionTest extends Projectspecificmethods {
	
private static final Logger logger = LogManager.getLogger(CartFunctionTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="cart functionality Test";
		testdescription="test to check the functionality of cart by adding deleting and checking totals";
		testcategory="Smoke Testing";
		testauthour="Raghul";
		
		}
	
	@Test(dataProvider="xlcart", priority=1)
	public void addProductToCart(String username,
	                             String password,
	                             String product1,
	                             String product2) {

	    LoginPage lp = new LoginPage(driver);
	    CartPage cp = new CartPage(driver);

	    lp.validlogin(username, password);

	    cp.selectProduct(product1);
	    cp.clickAddToCart();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals(alert.getText(), "Product added.");
	    alert.accept();

	    logger.info("PASS: Product added -> " + product1);
	}
	
	
	@Test(dataProvider="xlcart", priority=2)
	public void viewCartWithProduct(String username,
	                                String password,
	                                String product1,
	                                String product2) {

	    LoginPage lp = new LoginPage(driver);
	    CartPage cp = new CartPage(driver);
	    
	    logger.info("website open");
	    lp.validlogin(username, password);
	    logger.info("account loggedin");

	    cp.selectProduct(product1);
	    logger.info("product is selected");
	    
	    cp.clickAddToCart();
	    logger.info("addedtocart is clicked");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    logger.info("alert is selected ok");
	    
	    
	    cp.openingCart();
	    logger.info("cart is opened");
	  
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[@id='totalp']")));
	    

	    Assert.assertTrue(cp.isProductPresent(product1));
	    logger.info("PASS: Product visible -> " + product1);
	}

	 	    
	@Test(dataProvider="xlcart", priority=3)
	public void removeProductFromCart(String username,
	                                  String password,
	                                  String product1,
	                                  String product2) {

	    LoginPage lp = new LoginPage(driver);
	    CartPage cp = new CartPage(driver);
	    
	    logger.info("website open");
	    lp.validlogin(username, password);
	    logger.info("account loggedin");

	    cp.selectProduct(product2);
	    logger.info("product is selected");
	    
	    cp.clickAddToCart();
	    logger.info("addedtocart is clicked");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    logger.info("alert is selected ok");
	    
	    
	    cp.openingCart();
	    logger.info("cart is opened");
	  
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[@id='totalp']")));

	    String before_del=cp.productdel();
	    logger.info(before_del);
	    
	    cp.deleteProduct();
	    logger.info("product is deleted");
	    
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr[1]/td[2]")));

	   String after_del=cp.productdel();
	   
	   logger.info(after_del);
	   
	    if(before_del.equals(after_del)) {
	    	logger.info("FAIL : product is not deleted");
	    }else {
	    logger.info("PASS: Product removed -> " + product2);
	    }
	    
	    lp.logoutbutton();

	   
	}
	
	@Test(dataProvider="xlcart")
	public void addMultipleProducts(String username,
	                                String password,
	                                String product1,
	                                String product2) {

	    LoginPage lp = new LoginPage(driver);
	    CartPage cp = new CartPage(driver);

	    lp.validlogin(username, password);
	    
	    cp.openingCart();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[@id='totalp']")));
	    
	    int before_adds= cp.getTotalPrice();
	    
	    cp.goHome();

	    logger.info("Add First Product");
	    cp.selectProduct(product1);

	    int price1 = cp.getProductPrice();
	    logger.info("Price of " + product1 + " = " + price1);

	    cp.clickAddToCart();

	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();

	    cp.goHome();

	    logger.info("Add Second Product"); 
	    cp.selectProduct(product2);

	    int price2 = cp.getProductPrice();
	    logger.info("Price of " + product2 + " = " + price2);

	    cp.clickAddToCart();
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    
	    cp.openingCart();
	    
	    logger.info("Open Cart"); 
	    
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[@id='totalp']")));

	    logger.info("Validate Products Present");
	    Assert.assertTrue(cp.isProductPresent(product1));
	    Assert.assertTrue(cp.isProductPresent(product2));

	    logger.info("Validating Total");
	    int product_Total = price1 + price2;
	    int after_adds = cp.getTotalPrice();

	    logger.info("before adding products = "+ before_adds);
	    logger.info("product Total = " + product_Total );
	    logger.info("after adding products = " + after_adds);
	    
	    int total_diff= after_adds-product_Total;
	    
	    
	    if(total_diff==before_adds) {
	    	logger.info("PASS: Multiple products added with correct total");
	    }else {
	    	logger.info("FAIL: error in mutiple adds");
	    }
	 }
	
	
	
	
	    
	}


