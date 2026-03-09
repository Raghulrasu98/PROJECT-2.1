package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver;
	
	By firstProduct = By.xpath("//div[@class='card-block']//a");

	By productName = By.xpath("//h2[@class='name']");
	By productPrice = By.xpath("//h3[@class='price-container']");
	By productDescription = By.xpath("//div[@id='more-information']");

	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}

	public void clickFirstProduct() {
	    driver.findElement(firstProduct).click();
	}

	public String getProductName() {
	    return driver.findElement(productName).getText();
	}

	public String getProductPrice() {
	    return driver.findElement(productPrice).getText();
	}

	public String getProductDescription() {
	    return driver.findElement(productDescription).getText();
	}


}
