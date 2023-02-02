package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/compte.feature",glue= {"DefinitionSteps"},tags="@passInvalid")

public class Runner {
	

}
