package test;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.CartPage;
import pages.CategoryPage;
import pages.LoginPage;
import pages.NavbarPage;
import pages.ProductPage;

public class BrowsingAndNavigationTest extends Projectspecificmethods{
	
private static final Logger logger = LogManager.getLogger(BrowsingAndNavigationTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Browsing And Navigation functionality Test";
		testdescription="test to check the Browsing and Navigation funtonality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
				
		}
	
	@Test
	public void browsecatagory() throws InterruptedException {
		CategoryPage cp=new CategoryPage(driver);
		
		cp.clickPhones();
		logger.info("phone catagory is clicked");
		
		Thread.sleep(7000);
		
		//wait.until(ExpectedConditions.visibilityOfAllElements(cp.getproducts()));
		
		List<WebElement> products=cp.getproducts();
		
		
		for(WebElement product:products) {
			
			
			
			String productName= product.getText();
			
			logger.info("products displayed =" +productName);
			
			
			if (productName.contains("Samsung") ||
		            productName.contains("Nokia") ||
		            productName.contains("Nexus") ||
		            productName.contains("Iphone 6 32gb")||
		            productName.contains("Sony xperia z5")||
		            productName.contains("HTC One M9")) {

		            logger.info("Valid phone product: " + productName);

		        } else {

		            logger.error("Invalid product found: " + productName);
		            Assert.fail("Invalid product found: " + productName);
		        }
		}
	}
	
	@Test
	public void viewProductDetails() {

	    ProductPage pp = new ProductPage(driver);

	    pp.clickFirstProduct();
	    logger.info("Product clicked");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));

	    String name = pp.getProductName();
	    String price = pp.getProductPrice();
	    String description = pp.getProductDescription();

	    logger.info("Product Name: " + name);
	    logger.info("Product Price: " + price);
	    logger.info("Product Description: " + description);

	    Assert.assertTrue(name.length() > 0);
	    Assert.assertTrue(price.length() > 0);
	    Assert.assertTrue(description.length() > 0);
	}

    @Test
	public void clickhome() {
		CategoryPage cp = new CategoryPage(driver);
	    CartPage hp = new CartPage(driver);

	    cp.clickPhones();
	    logger.info("Phone category clicked");

	    hp.goHome();
	    logger.info("Home button clicked");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(hp.getproducts()));

	    List<WebElement> products = hp.getproducts();

	    logger.info("Total products displayed: " + products.size());

	    Assert.assertTrue(products.size() > 0);
	}
	
	
	@Test
	public void verifyNavbarNavigation() {

	    NavbarPage np = new NavbarPage(driver);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    logger.info("Home navigation"); 
	    np.clickHome();
	    wait.until(ExpectedConditions.visibilityOfAllElements(np.getProducts()));
	    logger.info("Home page loaded");

	    logger.info("Cart navigation");
	    np.clickCart();
	    wait.until(ExpectedConditions.visibilityOf(np.getCartPage()));
	    logger.info("Cart page opened");

	    logger.info("Contact navigation"); 
	    np.clickContact();
	    wait.until(ExpectedConditions.visibilityOf(np.getContactModal()));
	    logger.info("Contact modal displayed");

	}
	

	@Test(dataProvider="xllogindetails")
	public void logout(String username, String password) {
		
		LoginPage lp=new LoginPage(driver) ;
			
		lp.validlogin(username , password);
		
		lp.logoutbutton();
		
		// wait.until(ExpectedConditions.visibilityOf(lp.loginbutn()));

		    Assert.assertTrue(lp.loginbutn().isDisplayed());

		    logger.info("User successfully logged out");
		
	}
}
	
	
	

