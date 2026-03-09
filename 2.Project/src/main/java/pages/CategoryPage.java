package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import base.Projectspecificmethods;

public class CategoryPage extends Projectspecificmethods{

	WebDriver driver;
	
	By phones=By.xpath("//div[@id='contcont']//a[2]");
	By laptops=By.xpath("//div[@id='contcont']//a[3]");
	By monitors=By.xpath("//div[@id='contcont']//a[4]");
	By productnames =By.xpath("//div[@class='card-block']//h4/a");
	
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
	}
	public void clickPhones() {
		driver.findElement(phones).click();
		
	}
	public void clickLaptops() {
		driver.findElement(laptops).click();
		
	}
	public void clickMonitors() {
		driver.findElement(monitors).click();
		
	}
	
	public List<WebElement> getproducts(){
		return driver.findElements(productnames);
		
	}
	
	
	
	
	
	
	
}
