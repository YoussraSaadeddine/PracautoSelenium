package DefinitionSteps;

import org.openqa.selenium.WebDriver;

import Pages.ShopPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopSteps {
	WebDriver driver = SetUp.driver;
	ShopPage shop = null;
	int[] tab = new int[2];
	int min,max;
    
	
	@Given("User in shop page")
	public void user_in_shop_page() {
		shop = new ShopPage(driver);
		shop.getUrl();
	    System.out.println("I am in Shop Page");
	}
	
	@When("User clicks add to basket")
	public void user_clicks_add_to_basket() throws InterruptedException {
	    shop.add_to_basket();
	    System.out.println("L'utilisateur a choisi un article");
	}
	@Then("the article should appear in cart page")
	public void the_article_should_appear_in_cart_page() {
	    shop.verify_cart();
	}
	@Then("view basket button should appear")
	public void view_basket_button_should_appear() {
	    shop.view_basket();
	}
	@When("User filter by topic")
	public void user_filter_by_topic() throws InterruptedException {
	    shop.choose_topic("HTML");
	}
	@Then("only articles of that topic should appear")
	public void only_articles_of_that_topic_should_appear() {
	    shop.verify_topic("HTML");
	}
	@When("User filter by price")
	public void user_filter_by_price() throws InterruptedException {
	    tab = shop.choose_price();
	    min = tab[0];
	    max = tab[1];
	}
	@Then("only articles of that price should appear")
	public void only_articles_of_that_price_should_appear() {
	    shop.verify_price(min, max);
	}


}
