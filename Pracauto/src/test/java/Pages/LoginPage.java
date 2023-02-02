package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public String url = "https://practice.automationtesting.in/my-account/";
	private By username_path = By.xpath("//input[@id='username']");
	private By password_path = By.xpath("//input[@id='password']");
	private By login_button = By.xpath("//input[@name='login']");
	private By dashboard = By.xpath("//a[contains(text(),'Dashboard')]");
	private By error = By.xpath("//strong[contains(text(),'Error')]");
	private By details = By.xpath("//a[contains(text(),'Account Details')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl() {
		driver.get(url);
	}
	
	public void enter_username_password(String username,String password) {
		driver.findElement(username_path).sendKeys(username);
		driver.findElement(password_path).sendKeys(password);
	}
	public void click_login() {
		driver.findElement(login_button).click();
		
	}
	//same for others
	public void verify_dashboard() {
		boolean flag = driver.findElements(dashboard).size()!=0;
		if(flag) {
			
			System.out.println("dashboard displayed");
		}else {
			System.out.println("Dashboard don't display");
		}	
		
	}
	public void verify_error() {
		boolean flag = driver.findElements(error).size()!=0;
		if(flag) {
			
			System.out.println("Error OK");
		}else {
			System.out.println("Error Down");
		}	
		
	}
	public void clicks_details() {
		driver.findElement(details).click();
	}

}
