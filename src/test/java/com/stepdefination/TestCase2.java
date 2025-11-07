package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase2 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase2.class);

    @Given("Launch browser and navigate to Application")
    public void launch_browser_and_navigate_to_Application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter valid Username")
    public void enter_valid_Username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
		  String username = row.get("Username");
		  Login login = new Login(driver);
	      login.verifyUsername(username);
		  Assert.assertTrue(login.flag);
		}
    }
    @When("Enter invalid Password")
    public void enter_invalid_Password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
		  String password = row.get("Password");
		  Login login = new Login(driver);
		  login.verifyPassword(password);	
		  Assert.assertTrue(login.flag);
		}
    }
    @When("Click on login Button")
    public void click_on_login_button() throws IOException {
		  Login login = new Login(driver);
		  login.verifyLoginButton();
		  Assert.assertTrue(login.flag);
    }
    @Then("Verify error message <{string}>")
    public void verify_error_message(String expectedErrorMessage) throws IOException {
    	  Login login = new Login(driver);
          login.verifyPopup();
    	  Assert.assertTrue(login.flag);
    	  BrowserConfiguration config =  new BrowserConfiguration();
    	  config.close();
    }
}
