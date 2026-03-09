package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Projectspecificmethods;

public class LoginPage extends Projectspecificmethods{
	
	WebDriver driver;
	
	    By login =By.xpath("//a[@id='login2']");
	    By loginusername=By.xpath("//input[@id='loginusername']");
	    By loginpassword=By.xpath("//input[@id='loginpassword']");
	    By userlogin= By.xpath("//button[@onclick='logIn()']");
	    By welcomeusername=By.xpath("//a[@id='nameofuser']");
	    By logout=By.xpath("//a[@id='logout2']");
	
	    
	    
	public LoginPage(WebDriver driver) {
			this.driver=driver;
		}

	public void login() {
		driver.findElement(login).click();
	}
	    	
	public void enterusername(String un) {
		driver.findElement(loginusername).sendKeys(un);
	}
	    
	public void enterpassword(String pass) {
		driver.findElement(loginpassword).sendKeys(pass);
	}
	
	public void loginbutton() {
		driver.findElement(userlogin).click();
		}
	    
	public void logoutbutton() {
		driver.findElement(logout).click();
	}
	
	public String getWelcomeText() {
	    return driver.findElement(welcomeusername).getText();
	}

	public String getPasswordFieldType() {
	    return driver.findElement(loginpassword)
	                 .getAttribute("type");
	}
	
	public void validlogin(String un,String pass) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(login).click();
		driver.findElement(loginusername).sendKeys(un);
		driver.findElement(loginpassword).sendKeys(pass);
		driver.findElement(userlogin).click();
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeusername));
	
	}
	
	public WebElement loginbutn() {
		return driver.findElement(login);
		
	}
	

}
