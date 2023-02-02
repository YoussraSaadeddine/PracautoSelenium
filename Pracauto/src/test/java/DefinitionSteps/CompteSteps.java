package DefinitionSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.ComptePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompteSteps {
	WebDriver driver = SetUp.driver;
	LoginPage login = null;
	ComptePage cpt = null;
	
	@Given("User in my account page")
	public void user_in_my_account_page() {
		login = new LoginPage(driver);
		login.getUrl();
		login.enter_username_password("youssra.saadeedine@gmail.com","Yn212121@");
		login.click_login();
	    System.out.println("I am in my account page");
	}
	@When("User clicks account details")
	public void user_clicks_account_aetails() throws InterruptedException {
		login.clicks_details();
		System.out.println("Now we click on account details");
		Thread.sleep(2000);
	}
	@Then("User is navigated to account details")
	public void user_is_navigated_to_account_details() {
		cpt = new ComptePage(driver);
		System.out.println(driver.getCurrentUrl());
		System.out.println(cpt.url);
	    Assert.assertEquals(cpt.url, driver.getCurrentUrl());
	    System.out.println("User is navigated");
	}
	
	@Given("User in account details")
	public void user_in_account_details() throws InterruptedException {
		login = new LoginPage(driver);
		login.getUrl();
		login.enter_username_password("youssra.saadeedine@gmail.com","Yn212121@");
		login.click_login();
		login.clicks_details();
	    System.out.println("I am in my account details");
	    Thread.sleep(2000);
	}
	@When("detail enters (.*) and (.*) and confirm with (.*)$")
	public void user_enters_username_and_password(String curpass,String newpass,String confpass) {
	    cpt = new ComptePage(driver);
	    cpt.enter_information(curpass,newpass,confpass);
	}
	
	@Then("message of succes is displayed")
	public void message_of_succes_is_displayed() {
	    cpt.succes_message();
	}
	@Then("message of error is displayed")
	public void message_of_error_is_displayed() {
	    cpt.fail_message();
	}


}
