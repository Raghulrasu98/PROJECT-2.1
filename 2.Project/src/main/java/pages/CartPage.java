package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Projectspecificmethods;

public class CartPage extends Projectspecificmethods{
	
	WebDriver driver;
	
	By addtocart=By.xpath("//a[normalize-space()='Add to cart']");
	By opencart=By.xpath("//a[@id='cartur']");
	By totalprice=By.xpath("//h3[@id='totalp']");
	By home =By.xpath("//a[@id='nava']");
	By productnames =By.xpath("//div[@class='card-block']//h4/a");
	
	
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	
	}

	public void selectProduct(String productName) {
	    driver.findElement(By.linkText(productName)).click();
	       }

	public void clickAddToCart() {
	    driver.findElement(addtocart).click();
	}
	
	public WebElement clickAddCart() {
		return driver.findElement(addtocart);
		 
	}

	public WebElement openCart() {
	    driver.findElement(opencart);
		return null;
	}
	
	public void openingCart() {
	    driver.findElement(opencart).click();
	}

	public boolean isProductPresent(String productName) {
	    return driver.getPageSource().contains(productName);
	}

	public void deleteProduct() {
	    driver.findElement(By.xpath("//body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]")).click();
	}

	public int getTotalPrice() {
	    String total = driver.findElement(totalprice).getText();
	    return Integer.parseInt(total);
	}

	public void goHome() {
	    driver.findElement(home).click();
	}
	
	public String productdel() {
		return driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
	}
	
	public int getProductPrice() {
	    String priceText = driver.findElement(By.cssSelector(".price-container")).getText();
	    String price = priceText.replaceAll("[^0-9]", "");
	    return Integer.parseInt(price);
	}
	
	public List<WebElement> getproducts() {
		
		return driver.findElements(productnames);
		
	}
			
			
			
}
