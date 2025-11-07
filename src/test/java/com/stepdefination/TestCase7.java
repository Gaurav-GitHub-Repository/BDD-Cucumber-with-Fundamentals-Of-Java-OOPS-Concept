package com.stepdefination;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.pages.Login;
import com.setup.BrowserConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase7 {

	private WebDriver driver;
	static Logger log = Logger.getLogger(TestCase7.class);

    @Given("Launch Browser and Navigate to Application")
    public void Launch_Browser_and_Navigate_to_Application() {
		BrowserConfiguration config =  new BrowserConfiguration();
		config.setup();	
		driver = config.driver;
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @When("Enter Valid Password")
    public void Enter_Valid_Password(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class, String.class);
		for(Map<String,String> row : credentials)
		{
			String password = row.get("Password");
			Login login = new Login(driver);
			login.verifyUsername(password);
			Assert.assertTrue(login.flag);
		}
    }
    @When("Enter Special Characters in username")
    public void Enter_Special_Characters_in_username(DataTable dataTable) throws IOException {
		List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> row : credentials)
		{
			String username = row.get("Username");
			Login login = new Login(driver);
			login.verifyPassword(username);	
			Assert.assertTrue(login.flag);
		}    
    }
    @When("Click On Login button")
    public void Click_On_Login_button() throws IOException {
		Login login = new Login(driver);
		login.verifyLoginButton();
		Assert.assertTrue(login.flag);
    }
    @Then("Verify error message1 <{string}>")
    public void verify_error_message1(String expectedErrorMessage) throws IOException {
		Login login = new Login(driver);
		login.verifyPopup();
		Assert.assertTrue(login.flag);
		BrowserConfiguration config =  new BrowserConfiguration();
		config.close();
    } 
}
