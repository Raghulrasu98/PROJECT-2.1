package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
	
	WebDriver driver;
	
	By signup=By.xpath("//a[@id='signin2']");
	By signupusername=By.xpath("//input[@id='sign-username']");
	By signuppassword=By.xpath("//input[@id='sign-password']");
	By signupbutton = By.xpath("//button[normalize-space()='Sign up']");
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
	}

	public void signup() {
		driver.findElement(signup).click();
	}
	
	public WebElement signupbutn() {
		return driver.findElement(signup);
	}
	
	public void username(String su) {
		driver.findElement(signupusername).sendKeys(su);
	}
	
	public void password(String pass) {
		driver.findElement(signuppassword).sendKeys(pass);
	}
	
	public void signupbutton() {
		driver.findElement(signupbutton).click();		
	}
	
	

}
