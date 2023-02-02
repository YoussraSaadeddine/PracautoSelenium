package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComptePage {
 WebDriver driver;
  public String url = "https://practice.automationtesting.in/my-account/edit-account/";
  private By cur_path = By.xpath("//input[@id='password_current']");
  private By new_path = By.xpath("//input[@id='password_1']");
  private By cof_path = By.xpath("//input[@id='password_2']");
  private By save = By.xpath("//input[@name='save_account_details']");
  private By succes_path = By.xpath("//div[contains(text(),'Account details changed successfully.')]");
  private By fail_path = By.xpath("//li[contains(text(),'Your current password is incorrect.')]");
  
  
  public ComptePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl() {
		driver.get(url);
	}
	public void enter_information(String curpass,String newpass,String confpass) {
		
		driver.findElement(cur_path).sendKeys(curpass);
		driver.findElement(new_path).sendKeys(newpass);
		driver.findElement(cof_path).sendKeys(confpass);
		driver.findElement(save).click();
	}
	public void succes_message() {
		
		boolean flag = driver.findElements(succes_path).size()!=0;
		if(flag) {
			
			System.out.println("message of succes displayed");
		}else {
			System.out.println("message of succes don't display");
		}	
	}
	public void fail_message() {
		
		boolean flag = driver.findElements(fail_path).size()!=0;
		if(flag) {
			
			System.out.println("message of fail displayed");
		}else {
			System.out.println("message of fail don't display");
		}	
	}
  
}
