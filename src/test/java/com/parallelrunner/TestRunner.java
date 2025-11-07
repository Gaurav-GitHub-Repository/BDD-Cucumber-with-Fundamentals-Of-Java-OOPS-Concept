package com.parallelrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\BDDCucumber\\com.parallelfeature",
		glue = {"com.stepdefination"},
		monochrome = true,
		tags = "@FunctionalTest",
		plugin = {"pretty","html:target/Cucumber-Report.html"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
 
	@DataProvider(parallel = true)
	public Object [][] scenarios()
	{		
		return super.scenarios();	
	}
} 
