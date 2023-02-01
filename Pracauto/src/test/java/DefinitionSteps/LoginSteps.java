package DefinitionSteps;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver = SetUp.driver;
	LoginPage login = null;
	
	
	@Given("User in login page")
	public void user_in_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://practice.automationtesting.in/my-account/");
	    System.out.println("I am in login Page");
	}

	@When("User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		System.out.println(username);
	    login = new LoginPage(driver);
	    login.enter_username_password(username, password);
	}

	@When("User clicks on login")
	public void user_clicks_on_login() {
	    login.click_login();
	}

	@Then("Dashbord page should appear")
	public void dashbord_page_should_appear() {
	    login.verify_dashboard();
	}
}
