package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/shop.feature",glue= {"DefinitionSteps"},tags="@price",plugin= {"pretty","html:target/rapport.html","json:target/cucumber.json"})

public class Runner {
	

}
