package test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.CartPage;
import pages.LoginPage;
import pages.OrderPage;

public class OrderFunctionTest extends Projectspecificmethods{
	
private static final Logger logger = LogManager.getLogger(OrderFunctionTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="order functionality Test";
		testdescription="test to check the order funtonality by placing orders";
		testcategory="Smoke Testing";
		testauthour="Raghul";
				
		}

	@Test(dataProvider="xlcart")
	public void validorder(String username,String password,String product1,String product2) {
		 LoginPage lp = new LoginPage(driver);
		 CartPage cp = new CartPage(driver);
		 OrderPage op=new OrderPage(driver);
		 
		
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
		    
		    
		    op.oderbutton();
		    logger.info("order button is clicked");
		    
		    
		    op.fillorderdetails("raj", "India", "tup", "8888", "jan", "2026");
		    logger.info("details are given");
		    
		    
		    op.purchasebutton();
		    
		    op.confirmationmessage();
		    
		    String orderinfo=op.getorderdetails();
		    logger.info(orderinfo);
		    
		    op.okButton();
		    logger.info("ok button is clicked");
		 
		 }
	
	
	@Test(dataProvider="xlcart")
	public void emptydetails(String username,String password,String product1,String product2) {
		LoginPage lp = new LoginPage(driver);
		 CartPage cp = new CartPage(driver);
		 OrderPage op=new OrderPage(driver);
		 
		
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
		    
		    
		    op.oderbutton();
		    logger.info("order button is clicked");
		    
		    
		    op.fillorderdetails("", "", "", "", "", "");
		    logger.info("details are given");
		    
		    
		    op.purchasebutton();
		    
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert1=driver.switchTo().alert();
		    //alert1.getText();
		    
		    logger.info( alert1.getText());
		    
		    String alert_text=alert1.getText();
		    String exp_text="Please fill out Name and Creditcard.";
		    
		    		    
		    if (alert_text.equals(exp_text)) {
		    		   
		    logger.info("alert is shown");
		    alert1.accept();
		    
		    }else {
		    	logger.info("alert is not showed");
		    }
	}
	
	@Test(dataProvider="xlcart")
	public void ConformationPopup(String username,String password,String product1,String product2) {
		 LoginPage lp = new LoginPage(driver);
		 CartPage cp = new CartPage(driver);
		 OrderPage op=new OrderPage(driver);
		 
		
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
		    
		    
		    op.oderbutton();
		    logger.info("order button is clicked");
		    
		    
		    op.fillorderdetails("raj", "India", "tup", "8888", "jan", "2026");
		    logger.info("details are given");
		    
		    
		    op.purchasebutton();
		    
		    op.confirmationmessage();
		    
		    String exp_thankutext="Thank you for your purchase!";
		    String thankutext=op.thankyoutext();
		    logger.info(thankutext);
		    
		    String orderinfo=op.getorderdetails();
		    logger.info(orderinfo);
		    
		    if(exp_thankutext.equals(thankutext)) {
		    
		    op.okButton();
		    logger.info("PASS :succefull order id and thankyou is displayed");
		    }else {
		    	logger.info("FAIL: no conformation is shown");
		    }
      }
	
}
