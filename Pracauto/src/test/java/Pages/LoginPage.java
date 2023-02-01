package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	private By username_path = By.xpath("//input[@id='username']");
	private By password_path = By.xpath("//input[@id='password']");
	private By login_button = By.xpath("//input[@name='login']");
	private By dashboard = By.xpath("//a[contains(text(),'Dashboard')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enter_username_password(String username,String password) {
		driver.findElement(username_path).sendKeys(username);
		driver.findElement(password_path).sendKeys(password);
	}
	public void click_login() {
		driver.findElement(login_button).click();
		
	}
	public void verify_dashboard() {
		boolean flag = driver.findElements(dashboard).size()!=0;
		if(flag) {
			
			System.out.println("test ok");
		}else {
			System.out.println("test down");
		}
		
	}

}
