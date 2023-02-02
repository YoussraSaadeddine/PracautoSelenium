package DefinitionSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetUp {
	static WebDriver driver;

	
	@Before
	public void Setup() {
		System.getProperty("webdriver.chrome.driver","C:/Users/ysaadedd/eclipse-workspace/Pracauto/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	/*
	 * @After public void teardown() { driver.quit(); }
	 */
}
