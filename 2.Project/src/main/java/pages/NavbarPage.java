package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavbarPage {
	WebDriver driver;
	
	By home = By.id("nava");
	By cart = By.id("cartur");
	By contact = By.xpath("//a[text()='Contact']");

	By products = By.xpath("//div[@class='card-block']//h4/a");
	By cartPage = By.xpath("//h2[normalize-space()='Total']");
	By contactModal = By.id("exampleModal");
	
	By productCards = By.xpath("//div[@class='card h-100']");


	
	public NavbarPage(WebDriver driver) {
		this.driver=driver;
	}

	public void clickHome() {
	    driver.findElement(home).click();
	}

	public void clickCart() {
	    driver.findElement(cart).click();
	}

	public void clickContact() {
	    driver.findElement(contact).click();
	}

	public List<WebElement> getProducts() {
	    return driver.findElements(products);
	}

	public WebElement getCartPage() {
	    return driver.findElement(cartPage);
	}

	public WebElement getContactModal() {
	    return driver.findElement(contactModal);
	}
	
	public List<WebElement> getProductCards() {
	    return driver.findElements(productCards);
	}



}
