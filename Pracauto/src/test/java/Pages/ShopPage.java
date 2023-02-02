package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShopPage {
	WebDriver driver;
	public String url = "https://practice.automationtesting.in/shop/";
	private By article_path = By.xpath("//a[contains(text(),'Add to basket')]");
	private By view_path = By.xpath("//a[contains(text(),'View Basket')]");
	private By cart_path = By.xpath("//a[@title='View your shopping cart']");
	private By product_name = By.xpath("//td[@class='product-name']");
	private By filtre_page = By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li");
	private By price_slid = By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/aside[@id='sidebar']/div[@id='woocommerce_price_filter-2']/form[1]/div[1]/div[1]/span[1]");
	private By from = By.xpath("//span[@class='from']");
	private By to = By.xpath("//span[@class='to']");
	private By filtre = By.xpath("//button[contains(text(),'Filter')]");
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl() {
		driver.get(url);
	}
	
	public void add_to_basket() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
		driver.findElement(article_path).click();
		Thread.sleep(2000);
		
		
	}
	public void view_basket() {
		boolean flag = driver.findElements(view_path).size()!=0;
		if(flag) {
			
			System.out.println("view basket displayed");
		}else {
			System.out.println("view basket don't display");
		}
		
	}
	public void verify_cart() {
		driver.findElement(cart_path).click();
		boolean flag = driver.findElements(product_name).size()!=0;
		if(flag) {
			
			System.out.println("cart displayed");
		}else {
			System.out.println("cart don't display");
		}
		
	}
	public void choose_topic(String theme) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//a[contains(text(),'"+theme+"')]")).click();
		System.out.println("l'utilisateur a filtré par "+theme);
		Thread.sleep(2000);
	}
	
	public void verify_topic(String theme) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		List<WebElement> elements = driver.findElements(filtre_page);
	    System.out.println("Number of elements:" +elements.size());

	    for (int i=1; i<= elements.size();i++){
	     WebElement e = driver.findElement(By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li["+i+"]/a/h3"));
	     if(e.getText().contains(theme)) {
	    	 System.out.println(e.getText());
	    	 }else {
	    		 System.out.println("filtre down");
	    	 }
	     }}
	    
		public int[] choose_price() throws InterruptedException {
			int[] tab = new int[2];
			WebElement slider = driver.findElement(price_slid);
			WebElement min_value = driver.findElement(from);
			WebElement max_value = driver.findElement(to);
			Actions action = new Actions(driver);
			action.dragAndDropBy(slider, 100, 0).perform();
			tab[0]= Integer.parseInt(min_value.getText().substring(1));
			tab[1]= Integer.parseInt(max_value.getText().substring(1));
			driver.findElement(filtre).click();
			Thread.sleep(2000);
			return tab;
		}
		
		public void verify_price(int min,int max) {

			List<WebElement> elements = driver.findElements(filtre_page);
		    System.out.println("Number of elements:" +elements.size());
		    System.out.println("I am here");
		    for (int i=1; i<= elements.size();i++){
		     WebElement e = driver.findElement(By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li["+i+"]/a/span[@class='price']"));
		    System.out.println(e.getText());
		     int price = Integer.parseInt(e.getText().substring(1,4));
		     
		     if(price<=max & price>=min) {
		    	 System.out.println(e.getText());
		    	 }else {
		    		 System.out.println("filtre down");
		    	 }
		     }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
