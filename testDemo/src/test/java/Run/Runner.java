package Run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="",
features="src/test/features/Sprint1/Orangeauthentification.feature",
glue="sprint1",
publish=true ,
plugin= {"pretty","html:target/cucmber_rapport.html","json:target/cucmber_rapport"})

public class Runner {

}
 