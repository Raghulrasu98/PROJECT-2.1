package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	        By placeorder=By.xpath("//button[text()='Place Order']");
	        By name=By.xpath("//input[@id='name']");
			By country=By.xpath("//input[@id='country']");
	        By city=By.xpath("//input[@id='city']");
	        By creditcard=By.xpath("//input[@id='card']");
	        By month=By.xpath("//input[@id='month']");
	        By year=By.xpath("//input[@id='year']");
	        By purchase=By.xpath("//button[text()='Purchase']");
	        By thankyou = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");
	        By orderdetails=By.xpath("//p[contains(@class,'lead text-muted')]");
	        By ok=By.xpath("//button[normalize-space()='OK']");
	        
	        public OrderPage(WebDriver driver) {
				this.driver=driver;
				 this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			}

			public void oderbutton() {
	        	driver.findElement(placeorder).click();
	        }
	        
	        public void fillorderdetails(String na,String co,String ci,String ca,String mo,String ye) {
	        	driver.findElement(name).sendKeys(na);
	        	driver.findElement(country).sendKeys(co);
	        	driver.findElement(city).sendKeys(ci);
	        	driver.findElement(creditcard).sendKeys(ca);
	        	driver.findElement(month).sendKeys(mo);
	        	driver.findElement(year).sendKeys(ye);
	        	

	        }
	        public void name(String na) {
	        	driver.findElement(name).sendKeys(na);
	        }
	        
	        public void country(String co) {
	        	driver.findElement(country).sendKeys(co);
	        }
	        
	        public void city(String ci) {
	        	driver.findElement(city).sendKeys(ci);
	        }
	        
	        public void card(String ca) {
	        	driver.findElement(creditcard).sendKeys(ca);
	        }
	        
	        public void month(String mo) {
	        	driver.findElement(month).sendKeys(mo);
	        }
	        
	        public void year(String ye) {
	        	WebElement inputyear=wait.until(ExpectedConditions.visibilityOfElementLocated(year));
	        	inputyear.sendKeys(ye);
	        }
	        
	        public void purchasebutton() {
	        	
	        	 wait.until(ExpectedConditions.elementToBeClickable(purchase)).click();
	        
	        }
	        
	        public void confirmationmessage() {
	        	
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(thankyou));
	        	
	        }	
	        
	        public String thankyoutext() {
	        	return driver.findElement(thankyou).getText();
	        }
	        
	        
	        public String getorderdetails() {
	        	return driver.findElement(orderdetails).getText();
	        }
	        
	        public void okButton() {
	        	
	        	wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
	        	//driver.findElement(ok).click();
	        }

			
}
