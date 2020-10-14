package MyRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "D:\\SeleniumProjects\\NCucumberSelenium\\src\\test\\java\\Features\\dealsmap.feature", //the path of the feature files
			glue={"stepDefinitions"}, //the path of the step definition files
			//to generate different types of report  ing
			monochrome = true, //display the console output in a proper readable format
			strict = true, 
			dryRun = false 	

			)
@Test	
public class TestRunner{
	 
	}
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

