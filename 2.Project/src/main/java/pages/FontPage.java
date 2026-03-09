package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FontPage {
	

	    WebDriver driver;
	    

	    By homeProductTitle = By.xpath("//div[@class='card-block']//a");
	    By productName = By.xpath("//h2[@class='name']");


	    public FontPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement getHomeProductTitle() {
	        return driver.findElement(homeProductTitle);
	    }

	    public WebElement getProductName() {
	        return driver.findElement(productName);
	    }

	    public String getFontFamily(WebElement element) {
	        return element.getCssValue("font-family");
	    }

	    public String getFontSize(WebElement element) {
	        return element.getCssValue("font-size");
	    }

	    public void clickFirstProduct() {
	        driver.findElement(homeProductTitle).click();
	    }
	}



